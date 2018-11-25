package com.qixin.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qixin.entity.User;

public interface JXMapper {
	
	@Select("SELECT * from jx_user WHERE username=#{username}")
	public User getYue(User user);
	
	@Update("UPDATE jx_user SET u_yue=u_yue-#{omoney} WHERE uid=1")
	public void delMoney(double omoney);
	
}
