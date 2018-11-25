package com.qixin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.client.RestTemplate;

import com.qixin.entity.Goods;
import com.qixin.entity.Order;
import com.qixin.entity.User;
import com.qixin.mapper.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper mapper;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<User> login(User user) {
		return mapper.login(user);
	}
	
	public String getYue(User user) {
		return restTemplate.getForObject("http://127.0.0.1:8080/getYue?username=" + user.getUsername(), String.class);
	}
	
	public String pay(Order order) {
		return restTemplate.getForObject("http://127.0.0.1:8080/pay?oid=" + order.getOid()+"&omoney="+order.getOmoney(), String.class);
	}

	public void updYue(User user) {
		mapper.updYue(user);
	}

	public List<Goods> getList() {
		return mapper.getList();
	}

	public Goods getGood(Integer id) {
		return mapper.getGood(id);
	}

	public void addOrder(Order order,User user) {
		mapper.addOrder(order);
		/*Goods good = getGood(order.getGid());
		sendOrder(order, user,good);*/
	}
	
	public void updMoney(Goods good) {
		mapper.updMoney(good);
	}
	
	//调用编程式事务
	@Autowired
	private TransactionTemplate template;
	
	//Propagation.NEVER官方注释:该方法绝对不能在事务范围内执行。如果在就抛例外。只有该方法没有关联到任何事务，才正常执行
	@Transactional(propagation = Propagation.NEVER)//表示此事务单独隔离开
	public String sendOrder(Order order,User user,Goods good) {
		String oid = order.getOid();//获取本次订单号
		//Goods good = getGood(order.getGid());
		template.execute(new TransactionCallback<Object>() {//事务回调方法，表示此方法是有回调的
			
			//此方法是重写过来的，方法里的事务都是本地数据库的事务，这样可以保证调用第三方接口挂掉的时候我们本地数据库不受影响
			@Override
			public Object doInTransaction(TransactionStatus status) {
				//Order order = new Order();
				order.setOid(oid);
				order.setOstatus("002");//status代表状态,002是正在支付状态,001失败,000成功
				mapper.update(order);//先在本地
				double money = good.getGmoney()-order.getOmoney();
				good.setGmoney(money);
				//System.err.println(good);
				mapper.updMoney(good);//先在本地减去标的可投金额
				user.setU_yue(user.getU_yue()-order.getOmoney());
				mapper.updYue(user);//先把本地用户的余额减掉,此时江西银行里的钱还没有扣掉
				return null;
			}
		});
		
		String flag = pay(order);//调用第三方支付接口,在doInTransaction方法外边写就代表这个事务如果失败了，本地事务也不会受到影响
		template.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				//Order order2 = new Order();
				order.setOid(oid);
				order.setOstatus(flag);//获得接口返回的状态码
				if(flag != null && "000".equals(flag)) {
					mapper.update(order);//代表支付成功,直接把状态码改了就可以
				}else {
					//System.err.println(good.getGmoney());
					mapper.update(order);
					double money = good.getGmoney()+order.getOmoney();
					good.setGmoney(money);
					mapper.updMoney(good);
					user.setU_yue(user.getU_yue()+order.getOmoney());
					mapper.updYue(user);//支付失败,直接把刚才扣掉的钱再加上
				}
				return null;
			}
		});
		return flag;
	}
		
}
