package com.qixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qixin.entity.Goods;
import com.qixin.entity.Order;
import com.qixin.entity.User;

public interface UserMapper {
	
	@Select("SELECT * FROM t_user WHERE username=#{username} and password=#{password}")
	public List<User> login(User user);
	
	@Update("UPDATE t_user SET u_yue=#{u_yue} WHERE uid=#{uid}")
	public void updYue(User user);
	
	@Select("SELECT * FROM t_goods")
	public List<Goods> getList();
	
	@Select("SELECT * FROM t_goods WHERE gid=#{id}")
	public Goods getGood(Integer id);
	
	@Insert("INSERT INTO t_order (oid,uid,omoney,gid,gname) VALUES (#{oid},#{uid},#{omoney},#{gid},#{gname})")
	public void addOrder(Order order);
	
	@Update("UPDATE t_order SET ostatus=#{ostatus} WHERE oid=#{oid}")
	public void update(Order order);
	
	@Update("UPDATE t_goods SET gmoney=#{gmoney} WHERE gid=#{gid}")
	public void updMoney(Goods good);

}
