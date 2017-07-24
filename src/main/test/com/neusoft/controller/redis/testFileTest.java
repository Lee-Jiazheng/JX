package com.neusoft.controller.redis;

import com.neusoft.config.ModuleConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.Assert.*;

/**
 * Created by Bruce Lee on 2017/7/23.
 */
public class testFileTest {
    private ApplicationContext context = null;
    private RedisUtils redisUtils;
    @Before
    public void before() {
        System.out.println("初始化spring容器");
        //context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //redisUtil = (RedisUtil) context.getBean("redisUtil");
    }

    @Test
    public void main() throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ModuleConfig.class);
        RedisTemplate<String, Object> redisTemplate = ctx.getBean("redisTemplate",RedisTemplate.class);
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        redisUtils.set("dd", "dd");
        redisUtils.get("dd");

        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        value.set("lp", "hello word");
        //获取 这个 key 的值
        System.out.println(value.get("lp"));

        /*boolean isset = redisUtils.set("test", "hh");
        System.out.println(isset);
        Object value = redisUtils.get("test");
        System.out.println(value);*/
    }

}