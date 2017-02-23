package com.cn.store.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.store.dao.IUserDao;
import com.cn.store.pojo.User;
import com.cn.store.service.IUserService;


@Service("userService")  
public class UserServiceImpl  implements IUserService {  
	@Resource  
	private IUserDao userDao;  
	@Override  
	public User getUserById(int userId) {  
		// TODO Auto-generated method stub  
		System.out.println(userDao.toString()+"   "+userId);
		User user= this.userDao.selectByPrimaryKey(userId);
		System.out.println("22222");
		return user;
	}
}

