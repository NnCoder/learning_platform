package com.edu.rest.component;

/**
 * Redis操作接口
 * @Description TODO
 * @ClassName JedisClient
 * @author Tao
 * @date 2018年1月24日
 */
public interface JedisClient {
	
	String set(String key, String value);
	String get(String key);
	Long del(String key);
	Long hset(String key, String item, String value);
	String hget(String key, String item);
	Long hdel(String key, String item);
	Long incr(String key);
	Long decr(String key);
	Long expire(String key, int seconds);
	Long ttl(String key);
	
}
