package com.hcmony.mapper;

import com.hcmony.model.User;

/**
 * Created by hcmony on 2017/9/1.
 */
public interface UserMapper {
	public Integer save(User user);
	public User findById(Integer id);
}
