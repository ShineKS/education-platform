package com.little.edu.appweb;

import com.little.edu.appweb.common.utils.RedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void timeoutTest() throws InterruptedException {
        String key = "session_1";
        String value = "open1";
        redisUtils.set(key, value, 3);
        String s = redisUtils.get(key);
        Assert.assertEquals(value, s);
        Thread.sleep(4000);
        s = redisUtils.get(key);
        Assert.assertEquals(null,s);
    }
}
