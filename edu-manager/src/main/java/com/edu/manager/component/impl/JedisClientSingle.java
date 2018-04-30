package com.edu.manager.component.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.manager.component.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis单机版实现类
 * @Description TODO
 * @ClassName JedisClientSingle
 * @author Tao
 * @date 2018年1月24日
 */
/**
 * Redis单机版实现类
 * @Description TODO
 * @ClassName JedisClientSingle
 * @author Tao
 * @date 2018年1月24日
 */
public class JedisClientSingle implements JedisClient{
	
	@Autowired
	private JedisPool jedisPool;
	
	private String auth;
	
	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = null;
		try {
			jedis.auth(auth);
			result = jedis.set(key, value);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String get(String key) {
		
		Jedis jedis = jedisPool.getResource();
		String result = null;
		try {
			jedis.auth(auth);
			result = jedis.get(key);
		} finally {
			jedis.close();
		}
		
		return result;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.hset(key, item, value);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		String result = null;
		try {
			jedis.auth(auth);
			
			result = jedis.hget(key, item);
		} finally {
			jedis.close();
		}
		
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.incr(key);
		} finally {
			jedis.close();
		}
		
		return result;
	}

	@Override
	public Long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.decr(key);
		} finally {
			jedis.close();
		}
		
		return result;
	}

	@Override
	public Long expire(String key, int seconds) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.expire(key, seconds);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.ttl(key);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public Long hdel(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.hdel(key, item);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = -1l;
		try {
			jedis.auth(auth);
			result = jedis.del(key);
		} finally {
			jedis.close();
		}
		return result;
	}
	
}
