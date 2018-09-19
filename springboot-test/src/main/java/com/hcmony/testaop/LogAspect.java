package com.hcmony.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @FileName package com.hcmony.testaop.LogAspect.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-11-13 14:55:00
 * @Modifier hcmony
 * @Updated 2017-11-13 14:55:00
 * @Description
 * @Version BUILD1001
 */
@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(com.hcmony.testaop.Action)")
	public  void  annotationPoinCut(){}

	@After("annotationPoinCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		String[] s = signature.getParameterNames();

		/**
		 * System.out.println("classname:" + targetMethod.getDeclaringClass().getName());
		 System.out.println("superclass:" + targetMethod.getDeclaringClass().getSuperclass().getName());
		 System.out.println("isinterface:" + targetMethod.getDeclaringClass().isInterface());
		 System.out.println("target:" + pjp.getTarget().getClass().getName());
		 System.out.println("proxy:" + pjp.getThis().getClass().getName());
		 System.out.println("method:" + targetMethod.getName());
		 */
		Object[] parames = joinPoint.getArgs();//获取目标方法体参数
		//String params = parseParames(parames); //解析目标方法体的参数
		String className = joinPoint.getTarget().getClass().toString();//获取目标类名
		className = className.substring(className.indexOf("com"));
		System.out.println(signature.getClass());
		System.out.println("注解方式拦截"+action.name());
		System.out.println(method.getName());
		System.out.println(method.getDeclaringClass().getName());
		System.out.println(method.getDeclaringClass().getSuperclass().getName());
		System.out.println(joinPoint.getTarget().getClass().getName());
		System.out.println(joinPoint.getThis().getClass().getName());
	}

	/**
	 * 解析方法参数
	 * @param parames 方法参数
	 * @return 解析后的方法参数
	 */
	/*private String parseParames(Object[] parames) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<parames.length; i++){
			if(parames[i] instanceof Object[] || parames[i] instanceof Collection){
				JSONArray json = JSONArray.fromObject(parames[i]);
				if(i==parames.length-1){
					sb.append(json.toString());
				}else{
					sb.append(json.toString() + ",");
				}
			}else{
				JSONObject json = JSONObject.fromObject(parames[i]);
				if(i==parames.length-1){
					sb.append(json.toString());
				}else{
					sb.append(json.toString() + ",");
				}
			}
		}
		String params = sb.toString();
		params = params.replaceAll("(\"\\w+\":\"\",)", "");
		params = params.replaceAll("(,\"\\w+\":\"\")", "");
		return params;
	}
*/
	/*@Before("execution(com.hcmony.testaop.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方式规则式拦截"+method.getName());
	}*/
}
