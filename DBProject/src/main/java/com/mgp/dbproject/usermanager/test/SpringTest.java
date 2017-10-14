package com.mgp.dbproject.usermanager.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.mgp.dbproject.commons.utils.RedisPoolUtils;
import com.mgp.dbproject.usermanager.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
//@ContextConfiguration( {"classpath:applicationContext.xml"} )
public class SpringTest {
    
	@Autowired
	private UserService userService;
	
	@Test
	public void test(){
		//userService.removeUser();
		/*Jedis jedis=new Jedis("127.0.0.1",6379);
		jedis.auth("redis");
		jedis.set("c1", "cc1");
		jedis.set("c2", "cc2");		
		Set<String> sets=jedis.keys("*");
		System.out.println(sets.size());
		System.out.println(jedis.get("c1"));*/
		/*JedisPool redis1 = RedisPoolUtils.getJedisPoolInstance();
		Jedis jedis = redis1.getResource();
		jedis.auth("redis");
		jedis.set("kk2", "vv2");
		jedis.get("kk1");*/
		List<? extends Object> l1 = new ArrayList<String>();
		l1.add(null);
		Object o = l1.get(0);
		System.out.println(o.getClass());
	}
}
