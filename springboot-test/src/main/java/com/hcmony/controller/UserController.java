package com.hcmony.controller;

import com.hcmony.model.User;
import com.hcmony.service.UserService;
import com.hcmony.utils.CodeIdEnum;
import com.hcmony.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by hcmony on 2017/9/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/findUser")
	public ResponseData findUser(Integer id){
		System.out.println("-----------------");
		User user = userService.findUser(id);
		System.out.println("user的id是："+user.getId());
		System.out.println("user的名字是："+user.getName());
		return new ResponseData(CodeIdEnum.Success,user);
	}

	@RequestMapping("/saveUser")
	public void saveUser(User user) throws Exception{
		System.out.println("-----------------");
		Integer num = userService.saveUser(user);
		if(num!=null&&num>0){
			System.out.println("保存成功了！");
		}else {
			System.out.println("保存失败了！");
		}
	}

}
