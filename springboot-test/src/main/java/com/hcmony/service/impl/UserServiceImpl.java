package com.hcmony.service.impl;

import com.hcmony.mapper.UserMapper;
import com.hcmony.model.User;
import com.hcmony.service.UserService;
import com.hcmony.utils.ExceptionRuntime;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;

/**
 * Created by hcmony on 2017/9/1.
 */
@Service()
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserImpl userImpl;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer saveUser(User user) throws Exception{
		try {
			logger.info("保存用户:"+user.getName());
			//userImpl.saveUser(user);

			new Thread(new Runnable()  {
				@Override
				public void run() {
					try {
						userImpl.saveUser(user);
					}catch (Exception e){

					}
				}
			}).start();

			user.setId(27);
			Integer num = userMapper.save(user);
			user.setName("失败前的"+user.getName());
			System.out.println("saveUser--------------");
			return num;
		}catch(RuntimeException e) {
			logger.error("保存用户失败");
			throw new ExceptionRuntime();
		}catch(Exception e){
			logger.error("保存用户失败");
			throw new Exception();
		}
	}
	@Transactional(propagation = Propagation.NESTED)
	public void saveUserTwo(){
		System.out.println("saveUserTwo--------------");
		try {
			User user = new User();
			user.setId(22);
			user.setName("失败的");
			userMapper.save(user);
		}catch (ExceptionRuntime e){
			logger.error("saveUserTwo 保存用户失败");
			throw new ExceptionRuntime();
		}

	}
	@Override
	public User findUser(Integer id) {
		try {
			return userMapper.findById(id);
		}catch (Exception e){
			logger.error("查询用户失败",e);
		}
		return null;
	}
}
