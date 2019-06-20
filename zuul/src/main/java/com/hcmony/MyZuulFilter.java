package com.hcmony;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2019/03/05 10:04
 */
@Component
public class MyZuulFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyZuulFilter.class);
	/**
	 * pre：路由之前
	 routing：路由之时
	 post： 路由之后
	 error：发送错误调用
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String  token = request.getParameter("token");
		LOGGER.info("token is {}",token);
		if (StringUtils.isNotBlank(token)&&"token".equals(token)){
			return null;
		}
		try {
			currentContext.getResponse().sendRedirect("/notoken");
		}catch (Exception e){

		}
		return null;
	}

}
