package com.qixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qixin.entity.User;
import com.qixin.mapper.JXMapper;

@Service
@Transactional
public class JXService {

	@Autowired
	private JXMapper mapper;

	public User getYue(User user) {
		return mapper.getYue(user);
	}

	public void delMoney(double omoney) {
		mapper.delMoney(omoney);
	}
}
