package com.hcmony.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisCacheConfiguration extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int    port;

    @Value("${spring.redis.timeout}")
    private int    timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int    minIdle;

    @Value("${spring.redis.pool.max-idle}")
    private int    maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long   maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private int    database;

    @Value("${spring.redis.isrds}")
    private int    isrds;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // spring.redis.isrds：是否rds线上，线上1需要密码，线下0不需要密码

        return new JedisPool(jedisPoolConfig, host, port, timeout, password, database);

    }

}
