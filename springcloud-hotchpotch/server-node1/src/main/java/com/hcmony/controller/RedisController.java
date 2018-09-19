package com.hcmony.controller;

import com.hcmony.service.RedisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @FileName package com.hcmony.controller.RedisController.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-09-13 19:13:00
 * @Modifier hcmony
 * @Updated 2017-09-13 19:13:00
 * @Description
 * @Version BUILD1001
 */
@EnableAutoConfiguration
@RefreshScope
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;

	@ApiOperation(value = "设置key的有效期", notes = "")
	@RequestMapping(value = "/expire",method = RequestMethod.POST)
	public void expire(@ApiParam(required = true, name = "key", value = "123456")
						   @RequestParam(required = true, name = "key") String key,
					@ApiParam(required = true, name = "seconds", value = "126")
							@RequestParam(required = true, name = "seconds") Integer seconds) {
		redisService.expire( key,seconds);
	}

	@ApiOperation(value = "设置String对象，缓存时间", notes = "")
	@RequestMapping(value = "/setSecondsValue",method = RequestMethod.POST)
	public void set(@ApiParam(required = true, name = "key", value = "123456")
						@RequestParam(required = true, name = "key") String key,
					@ApiParam(required = true, name = "seconds", value = "126")
						@RequestParam(required = true, name = "seconds") Integer seconds,
					@ApiParam(required = true, name = "value", value = "126")
						@RequestParam(required = true, name = "value") String value) {
		redisService.set( key,  seconds,  value);
	}

	@ApiOperation(value = "获取对象", notes = "")
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public String get(@ApiParam(required = true, name = "key", value = "123456")
						  @RequestParam(required = true, name = "key") String key) {
		return redisService.get( key);
	}

	@ApiOperation(value = "设置对象", notes = "")
	@RequestMapping(value = "/setObject",method = RequestMethod.POST)
	public void setObject(@ApiParam(required = true, name = "key", value = "123456")
							  @RequestParam(required = true, name = "key") String key,
						  @ApiParam(required = true, name = "value", value = "126")
							  @RequestParam(required = true, name = "value") Object value) {
		redisService.setObject( key, value);
	}



	@ApiOperation(value = "设置String对象，不指定缓存时间", notes = "")
	@RequestMapping(value = "/set",method = RequestMethod.POST)
	public void set(@ApiParam(required = true, name = "key", value = "123456")
						@RequestParam(required = true, name = "key") String key,
					@ApiParam(required = true, name = "value", value = "126")
						@RequestParam(required = true, name = "value") String value) {
		redisService.set(key,value);
	}

	@ApiOperation(value = "设置key的有效期", notes = "")
	@RequestMapping(value = "/setExpire",method = RequestMethod.POST)
	public void setExpire(@ApiParam(required = true, name = "key", value = "123456")
						  @RequestParam(required = true, name = "key") String key,
						  @ApiParam(required = true, name = "seconds", value = "126")
						  @RequestParam(required = true, name = "seconds") Integer seconds) {
		redisService.setExpire(key,seconds);
	}

	/**
	 * 方法描述:Redis INCR命令用于将键的整数值递增1。如果键不存在，则在执行操作之前将其设置为0。 如果键包含错误类型的值或包含无法表示为整数的字符串，则会返回错误。此操作限于64位有符号整数
	 * @param key
	 */
	@ApiOperation(value = "INCR命令用于将键的整数值递增1", notes = "")
	@RequestMapping(value = "/incr",method = RequestMethod.POST)
	public void incr(@ApiParam(required = true, name = "key", value = "123456")
					 @RequestParam(required = true, name = "key") String key) {
		redisService.incr(key);
	}

	/**
	 * 方法描述:查找所有匹配给定的模式的键
	 * @param redisKey pattern 的表达式,*表示多个，？表示一个
	 * @return
	 */
	@ApiOperation(value = "查找所有匹配给定的模式的键", notes = "")
	@RequestMapping(value = "/getByKeys",method = RequestMethod.GET)
	public Map<String, Object> getByKeys(@ApiParam(required = true, name = "redisKey", value = "123456")
											 @RequestParam(required = true, name = "redisKey") String redisKey) {
		return redisService.getByKeys(redisKey);
	}

	/**
	 * 方法描述:删除所有匹配给定的模式的键
	 * @param redisKey pattern 的表达式,*表示多个，？表示一个
	 * @return
	 */
	@ApiOperation(value = "删除所有匹配给定的模式的键", notes = "")
	@RequestMapping(value = "/delByKeys",method = RequestMethod.DELETE)
	public void delByKeys(@ApiParam(required = true, name = "redisKey", value = "123456")
							  @RequestParam(required = true, name = "redisKey") String redisKey) {
		redisService.delByKeys(redisKey);
	}


	/**
	 * 方法描述:redis HyperLogLog输入元素
	 * @param key
	 * @param value
	 */
	@ApiOperation(value = "redis HyperLogLog输入元素", notes = "")
	@RequestMapping(value = "/pfadd",method = RequestMethod.PUT)
	public void pfadd(@ApiParam(required = true, name = "key", value = "123456")
						  @RequestParam(required = true, name = "key") String key,
					  @ApiParam(required = true, name = "value", value = "126")
						  @RequestParam(required = true, name = "value") String value) {
		redisService.pfadd(key,value);
	}

	/**
	 * 方法描述:统计key在HyperLogLog中的基数 </br>
	 * 基数：集合中不同元素的数量。比如 {‘apple’, ‘banana’, ‘cherry’, ‘banana’, ‘apple’} 的基数就是 3</br>
	 * 估算值：算法给出的基数并不是精确的，可能会比实际稍微多一些或者稍微少一些，但会控制在合理的范围之内
	 * @param key
	 * @return
	 */
	@ApiOperation(value = "统计key在HyperLogLog中的基数", notes = "")
	@RequestMapping(value = "/pfcount",method = RequestMethod.PUT)
	public long pfcount(@ApiParam(required = true, name = "key", value = "123456")
							@RequestParam(required = true, name = "key") String key) {
		return redisService.pfcount(key);
	}

	/**
	 * 方法描述:模糊查询指定的键，返回键的集合
	 * @param redisKey pattern 的表达式,*表示多个，？表示一个
	 * @return
	 */
	@ApiOperation(value = "模糊查询指定的键，返回键的集合", notes = "")
	@RequestMapping(value = "/getKeysByKeywords",method = RequestMethod.GET)
	public Set<String> getKeysByKeywords(@ApiParam(required = true, name = "redisKey", value = "123456")
										 @RequestParam(required = true, name = "redisKey") String redisKey) {
		return redisService.getKeysByKeywords(redisKey);
	}

	/**
	 * 方法描述:查找所有匹配给定的模式的键并统计所有键的基数
	 * @param redisKey
	 * @return
	 */
	@ApiOperation(value = "模糊查询指定的键，返回键的集合", notes = "")
	@RequestMapping(value = "/getPfcountByKeys",method = RequestMethod.GET)
	public Map<String, Object> getPfcountByKeys(@ApiParam(required = true, name = "redisKey", value = "123456")
													@RequestParam(required = true, name = "redisKey") String redisKey) {
		return redisService.getPfcountByKeys(redisKey);
	}



	/**
	 * 方法描述:设置对象
	 *
	 * @param key 键
	 * @param seconds 缓存秒数
	 * @param value 值
	 */
	public void setObject(String key, int seconds, Object value) {
		redisService.setObject( key, seconds,value);
	}

	/**
	 * 方法描述:删除元素
	 * @param key
	 * @throws Exception
	 */
	@Async
	public boolean delObject(String key) {
		return redisService.delObject( key);
	}


}
