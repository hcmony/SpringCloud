package com.hcmony.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h3>异常信息控制类</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2019/03/05 10:52
 */
@RestController
public class MyErrorController  implements ErrorController{
	/**
	 * Returns the path of the error page.
	 *
	 * @return the error path
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/error")
	public String error(HttpServletResponse resp, HttpServletRequest req) {
		return "参数异常或者是其它未知异常";
	}

	@RequestMapping(value = "/notoken")
	public String notoken(HttpServletResponse resp, HttpServletRequest req) {
		return "notoken";
	}
}
