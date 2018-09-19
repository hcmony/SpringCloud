
package com.hcmony.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 类RedisClient.java的实现描述：TODO 类实现描述
 *
 * @author hcmony 2017年5月3日 上午11:41:12
 */
@Component
public class RedisClient {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 方法描述:设置对象
     *
     * @param key
     * @param value
     * @throws Exception
     * @author hcmony 2017年5月3日 上午11:58:35
     */
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:设置key过期时间
     * 
     * @author hcmony 2017年8月28日 上午10:30:34
     * @param key
     * @param seconds
     */
    public void setExpire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:Redis INCR命令用于将键的整数值递增1。如果键不存在，则在执行操作之前将其设置为0。 如果键包含错误类型的值或包含无法表示为整数的字符串，则会返回错误。此操作限于64位有符号整数
     * 
     * @author hcmony 2017年7月18日 下午2:28:42
     * @param key
     */
    public void incr(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.incr(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:查找所有匹配给定的模式的键
     * 
     * @author hcmony 2017年7月18日 下午2:32:52
     * @param redisKey pattern 的表达式,*表示多个，？表示一个
     * @return
     */
    public Map<String, Object> getByKeys(String redisKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> keys = jedis.keys(redisKey);
            Map<String, Object> map = new HashMap<>();
            if (keys != null && keys.size() > 0) {
                for (String key : keys) {
                    map.put(key, jedis.get(key));
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:删除所有匹配给定的模式的键
     * 
     * @author hcmony 2017年7月18日 下午2:32:52
     * @param redisKey pattern 的表达式,*表示多个，？表示一个
     * @return
     */
    public void delByKeys(String redisKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> keys = jedis.keys(redisKey);
            if (keys != null && keys.size() > 0) {
                for (String key : keys) {
                    jedis.del(key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:设置key的有效期
     * 
     * @author hcmony 2017年7月18日 下午2:30:27
     * @param key
     * @param seconds
     */
    public void expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:设置对象
     *
     * @param key 键
     * @param seconds 缓存秒数
     * @param value 值
     * @throws Exception
     * @author hcmony 2017年5月3日 下午2:40:32
     */
    public void set(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:获取对象
     *
     * @param key 键
     * @return
     * @throws Exception
     * @author hcmony 2017年5月3日 上午11:58:47
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:设置对象
     *
     * @param key
     * @param value
     * @throws Exception
     * @author hcmony 2017年5月3日 上午11:58:35
     */
    public void setObject(String key, Object value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key.getBytes(), SerializableUtil.toByteArray(value));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池

            if (jedis != null) {
                jedis.close();
            }
        }
    }



    /**
     * 方法描述:删除元素
     * 
     * @author hcmony 2017年6月10日 下午5:51:04
     * @param key
     * @throws Exception
     */
    @Async
    public boolean delObject(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                return jedis.del(key) > 0;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:redis HyperLogLog输入元素
     * 
     * @author hcmony 2017年8月28日 下午2:39:17
     * @param key
     * @param value
     */
    public void pfadd(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.pfadd(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:统计key在HyperLogLog中的基数 </br>
     * 基数：集合中不同元素的数量。比如 {‘apple’, ‘banana’, ‘cherry’, ‘banana’, ‘apple’} 的基数就是 3</br>
     * 估算值：算法给出的基数并不是精确的，可能会比实际稍微多一些或者稍微少一些，但会控制在合理的范围之内
     * 
     * @author hcmony 2017年8月28日 下午2:40:16
     * @param key
     * @return
     */
    public long pfcount(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.pfcount(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

    /**
     * 方法描述:模糊查询指定的键，返回键的集合
     * 
     * @author hcmony 2017年7月18日 下午2:32:52
     * @param redisKey pattern 的表达式,*表示多个，？表示一个
     * @return
     */
    public Set<String> getKeysByKeywords(String redisKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.keys(redisKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 方法描述:查找所有匹配给定的模式的键并统计所有键的基数
     * 
     * @author hcmony 2017年8月28日 下午3:35:19
     * @param redisKey
     * @return
     */
    public Map<String, Object> getPfcountByKeys(String redisKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> keys = jedis.keys(redisKey);
            Map<String, Object> map = new HashMap<>();
            if (keys != null && keys.size() > 0) {
                for (String key : keys) {
                    map.put(key, jedis.pfcount(key));
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }



    /**
     * 方法描述:设置对象
     *
     * @param key 键
     * @param value 值
     * @throws Exception
     * @author hcmony 2017年5月3日 下午2:40:32
     */
    public void setObject(String key, int dbIndex, Object value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key.getBytes(), dbIndex, SerializableUtil.toByteArray(value));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池

            if (jedis != null) {
                jedis.close();
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------



    /**
     * @description
     * @author hcmony
     * @time 2017/11/24
     * @param redisKey
     * @param dbIndex
     * @return java.util.Set<java.lang.String>
     */
    public Set<String> getKeysSet(String redisKey,Integer dbIndex){

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (dbIndex != null) {
                jedis.select(dbIndex);
            }
            Set<String> keys = jedis.keys(redisKey);
            return keys;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @description
     * @author hcmony
     * @time 2017/11/24
     * @param key
     * @param value
     * @param dbIndex
     * @return void
     */
    public void sadd(String key,String value,Integer dbIndex){

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (dbIndex != null) {
                jedis.select(dbIndex);
            }
            jedis.sadd(key,value);
        } finally {
            // 返还到连接池
            jedis.close();
        }
    }

    /**
     * @description
     * @author hcmony
     * @time 2017/11/24
     * @param key
     * @param dbIndex
     * @return java.util.Set<java.lang.String>
     */
    public Set<String> smembers(String key,Integer dbIndex){

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (dbIndex != null) {
                jedis.select(dbIndex);
            }
            return jedis.smembers(key);
        } finally {
            // 返还到连接池
            jedis.close();
        }
    }

    /**
     * @description 根据db设置对象
     * @author hcmony
     * @time 2017/11/24
     * @param key
     * @param dbIndex
     * @param value
     * @return void
     */
    public void setByDbIndex(String key, Integer dbIndex, String value) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if(dbIndex!=null){
                jedis.select(dbIndex);
            }
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * @description 根据db获取对象
     * @author hcmony
     * @time 2017/11/24
     * @param key
     * @param dbIndex
     * @return java.lang.String
     */
    public String getByDbIndex(String key, Integer dbIndex) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if(dbIndex!=null){
                jedis.select(dbIndex);
            }
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
