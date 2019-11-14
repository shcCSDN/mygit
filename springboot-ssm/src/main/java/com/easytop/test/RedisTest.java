package com.easytop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easytop.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(RedisTest.class);
	@Autowired
	private RedisTemplate< String, Object> redisTemplate;
	@Test
	public void testSet() {
		logger.info("testSet start");
		try {
			this.redisTemplate.opsForValue().set("key", "深圳");
			Object data = this.redisTemplate.opsForValue().get("key");
			logger.info("testSet key={},data={}","key",data);
		}catch(Exception e) {
			logger.error("testSet error={}",e);
		}
		logger.info("testSet end");
		
	}
}
