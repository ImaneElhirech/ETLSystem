package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.services.UserService;
import com.bo.User;
import com.bo.WordPolarity;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	
	public User getUserById(Long pId) {
		
	
		return userDao.findById(pId);	}
	
//	private double getWordPolarity(String pWord) {
//
//		List<User> users = userDao.getAll();
//
//		for (User it : users) {
//
//			if (it.getLogin().equals(pWord)&&it.getPassword().equals(pWord)) {
//				//return it.getPolarity();
//			}
//		}
//
//		return 0;
//	}
	
		
	}

