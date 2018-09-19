package com.hcmony.service.impl;

import com.hcmony.mapper.UserMapper;
import com.hcmony.model.User;
import com.hcmony.service.UserService;
import com.hcmony.service.UserService1;
import com.hcmony.utils.ExceptionRuntime;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hcmony on 2017/9/5.
 */
@Service
public class UserImpl implements UserService1 {

	private static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;

	@Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
	@Override
	public Integer saveUser(User user) throws Exception {
		System.out.println("saveUserTwo--------------");
		try {
			user.setId(30);
			user.setName("失败的");
			userMapper.save(user);
		}catch (Exception e){
			logger.error("saveUserTwo 保存用户失败");
			throw new Exception();
		}
		return null;
	}

	@Override
	public User findUser(Integer id) {
		return null;
	}
}
