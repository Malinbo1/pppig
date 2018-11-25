package com.qixin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qixin.entity.Goods;
import com.qixin.entity.Order;
import com.qixin.entity.User;
import com.qixin.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(User user,Model model,HttpSession session) {
		List<User> list = userService.login(user);
		if(list.size()==0) {
			model.addAttribute("result", "1");//登录失败
		}else {
			model.addAttribute("result", "2");//登录成功
			session.setAttribute("user", list.get(0));
		}
		return "index";
	}
	
	@RequestMapping("/list")
	public String getList(HttpSession session,HttpServletRequest request) {
		User user = (User)session.getAttribute("user");
		String yue = userService.getYue(user);//调用第三方接口获取余额
		user.setU_yue(Double.valueOf(yue));
		userService.updYue(user);//修改本地数据库用户余额
		List<Goods> list = userService.getList();
		request.setAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/getGood")
	public String getGood(Integer id,HttpServletRequest request) {
		Goods good = userService.getGood(id);
		request.setAttribute("good", good);
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddhhmmss");
		String string = String.valueOf((int)((Math.random()*9+1)*100000));
		String oid = sim.format(new Date()) + string;//生成订单号
		request.setAttribute("oid", oid);
		request.setAttribute("good", good);
		return "good";
	}
	
	@RequestMapping("/addOrder")
	public synchronized String addOrder(Model model,Order order,HttpSession session,HttpServletRequest request) {
		User user = (User)session.getAttribute("user");//获取session里的用户数据
		Goods good = userService.getGood(order.getGid());//获取标的对象
		String yue = userService.getYue(user);//重新调用第三方接口获取余额
		user.setU_yue(Double.valueOf(yue));
		userService.updYue(user);//修改余额到本地数据库
		if(Double.valueOf(yue) >= order.getOmoney() && order.getOmoney() <= order.getGmoney()) {//判断余额是否合理
			model.addAttribute("result", "1");//提交成功
			order.setUid(user.getUid());
			userService.addOrder(order,user);//添加本地数据库订单数据
			userService.sendOrder(order, user, good);//调用第三方接口
		}else if(Double.valueOf(yue) <= order.getOmoney()) {
			model.addAttribute("result", "2");//余额不足
		}else if(order.getOmoney() >= order.getGmoney()) {
			model.addAttribute("result", "3");//剩余可投金额不足
		}
		return "good";
	}

}
