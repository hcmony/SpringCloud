package com.hcmony.test;

import com.hcmony.model.User;

/**
 * @FileName package com.hcmony.test.InvokeTest.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-09-21 15:27:00
 * @Modifier hcmony
 * @Updated 2017-09-21 15:27:00
 * @Description
 * @Version BUILD1001
 */
public class InvokeTest {

	public static void main(String[] args)throws Exception {
		User user = new User();
		user.setId(1);
		user.setName("张三");


		String sortName = "getId";

		Object id =user.getClass().getMethod(sortName, null).invoke(user,null);
		System.out.println(id.toString());
		Class ss =user.getClass().getMethod(sortName, null).getGenericReturnType().toString().getClass();
		 sortName = "setId";
		user.getClass().getMethod(sortName, ss).invoke(user,22);
		System.out.println(user.getId());
	}
}
