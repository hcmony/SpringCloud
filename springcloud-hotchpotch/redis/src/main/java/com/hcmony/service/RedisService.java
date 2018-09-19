package com.hcmony.service;

import com.hcmony.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @FileName package com.hcmony.service.RedisService.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-09-13 19:18:00
 * @Modifier hcmony
 * @Updated 2017-09-13 19:18:00
 * @Description
 * @Version BUILD1001
 */
@Service
public class RedisService {

	@Autowired
	private RedisClient redisClient;

	/**
	 * 方法描述:设置对象
	 *
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
		redisClient.set(key,value);
	}

	/**
	 * 方法描述:设置key过期时间
	 * @param key
	 * @param seconds
	 */
	public void setExpire(String key, int seconds) {
		redisClient.setExpire(key,seconds);
	}

	/**
	 * 方法描述:Redis INCR命令用于将键的整数值递增1。如果键不存在，则在执行操作之前将其设置为0。 如果键包含错误类型的值或包含无法表示为整数的字符串，则会返回错误。此操作限于64位有符号整数
	 * @param key
	 */
	public void incr(String key) {
		redisClient.incr(key);
	}

	/**
	 * 方法描述:查找所有匹配给定的模式的键
	 * @param redisKey pattern 的表达式,*表示多个，？表示一个
	 * @return
	 */
	public Map<String, Object> getByKeys(String redisKey) {
		return redisClient.getByKeys(redisKey);
	}

	/**
	 * 方法描述:删除所有匹配给定的模式的键
	 * @param redisKey pattern 的表达式,*表示多个，？表示一个
	 * @return
	 */
	public void delByKeys(String redisKey) {
		 redisClient.delByKeys(redisKey);
	}

	/**
	 * 方法描述:设置key的有效期
	 * @param key
	 * @param seconds
	 */
	public void expire(String key, int seconds) {
		redisClient.expire( key,seconds);
	}

	/**
	 * 方法描述:设置对象
	 *
	 * @param key 键
	 * @param seconds 缓存秒数
	 * @param value 值
	 */
	public void set(String key, int seconds, String value) {
		redisClient.set( key,  seconds,  value);
	}

	/**
	 * 方法描述:获取对象
	 * @param key 键
	 * @return
	 * @throws Exception
	 */
	public String get(String key) {
		return redisClient.get( key);
	}

	/**
	 * 方法描述:设置对象
	 * @param key
	 * @param value
	 */
	public void setObject(String key, Object value) {
		redisClient.setObject( key, value);
	}

	/**
	 * 方法描述:设置对象
	 *
	 * @param key 键
	 * @param seconds 缓存秒数
	 * @param value 值
	 */
	public void setObject(String key, int seconds, Object value) {
		redisClient.setObject( key, seconds,value);
	}

	/**
	 * 方法描述:删除元素
	 * @param key
	 * @throws Exception
	 */
	@Async
	public boolean delObject(String key) {
		return redisClient.delObject( key);
	}

	/**
	 * 方法描述:redis HyperLogLog输入元素
	 * @param key
	 * @param value
	 */
	public void pfadd(String key, String value) {
		redisClient.pfadd(key,value);
	}

	/**
	 * 方法描述:统计key在HyperLogLog中的基数 </br>
	 * 基数：集合中不同元素的数量。比如 {‘apple’, ‘banana’, ‘cherry’, ‘banana’, ‘apple’} 的基数就是 3</br>
	 * 估算值：算法给出的基数并不是精确的，可能会比实际稍微多一些或者稍微少一些，但会控制在合理的范围之内
	 * @param key
	 * @return
	 */
	public long pfcount(String key) {
		return redisClient.pfcount(key);
	}

	/**
	 * 方法描述:模糊查询指定的键，返回键的集合
	 * @param redisKey pattern 的表达式,*表示多个，？表示一个
	 * @return
	 */
	public Set<String> getKeysByKeywords(String redisKey) {
		return redisClient.getKeysByKeywords(redisKey);
	}

	/**
	 * 方法描述:查找所有匹配给定的模式的键并统计所有键的基数
	 * @param redisKey
	 * @return
	 */
	public Map<String, Object> getPfcountByKeys(String redisKey) {
		return redisClient.getPfcountByKeys(redisKey);
	}

	//--------------------------------------------------------------------------------------------------------------

	public Set<String> getKeysSet(String redisKey,Integer dbIndex){
		return  redisClient.getKeysSet(redisKey,dbIndex);
	}

	public Set<String> smembers(String key,Integer dbIndex){
		return  redisClient.smembers(key,dbIndex);
	}
	public void sadd(String key,String value,Integer dbIndex){
		redisClient.sadd(key,value,dbIndex);
	}
	public void setByDbIndex(String key, Integer dbIndex, String value){
		redisClient.setByDbIndex(key,dbIndex,value);
	}
	public String getByDbIndex(String key, Integer dbIndex){
		return redisClient.getByDbIndex(key,dbIndex);
	}
}
