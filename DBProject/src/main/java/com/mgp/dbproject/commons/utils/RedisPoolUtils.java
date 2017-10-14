package com.mgp.dbproject.commons.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtils {
    private static volatile JedisPool jedisPools=null;
    
	private RedisPoolUtils(){}
    
	public static JedisPool getJedisPoolInstance(){
		if(jedisPools == null){
			synchronized (RedisPoolUtils.class) {
				if(jedisPools == null){
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxIdle(1000);
					poolConfig.setMinIdle(50);
					poolConfig.setMaxWaitMillis(100*1000);
					poolConfig.setTestOnBorrow(true);
					jedisPools = new JedisPool(poolConfig, "127.0.0.1", 6379);
				}
			}
		}
		return jedisPools;		
	}
	
	public static void release(JedisPool jedisPools,Jedis jedis){
		if(jedis != null){
			jedisPools.returnResourceObject(jedis);
		}
	}
	
}
