package com.qixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qixin.entity.Order;
import com.qixin.entity.User;
import com.qixin.service.JXService;

@Controller
public class JXController {

	@Autowired
	private JXService service;
	
	@RequestMapping("/getYue")
	@ResponseBody
	public String getYue(User user) {
		System.out.println("收到用户:"+user.getUsername()+",开始处理....");
		User Auser = service.getYue(user);
		System.out.println("处理完毕....");
		return String.valueOf(Auser.getU_yue());
	}
	
	@RequestMapping("/pay")
	@ResponseBody
	public String pay(String oid,double omoney) {
		System.out.println("已经收到订单:"+oid+",正在处理....");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("处理失败");
		}
		service.delMoney(omoney);
		System.out.println("处理成功....");
		return "000";
	}
}
