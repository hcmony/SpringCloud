package com.hcmony.service;

import com.hcmony.model.User;

/**
 * Created by hcmony on 2017/9/1.
 */

public interface UserService {
	public Integer saveUser(User user)throws Exception;
	public User findUser(Integer id);
}
