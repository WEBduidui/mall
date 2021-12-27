package com.kilogod.code.redis.impl;

import com.kilogod.code.redis.Redis;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * [简要描述]:Redis服务实现类
 * [详细描述]:<br/>
 */
@Service
public class RedisImpl implements Redis {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public List zrange(String key, long start, long end) {
        Set<String> set = stringRedisTemplate.opsForZSet().range(key, start, end);
        assert set != null;
        return new ArrayList<>(set);
    }

    @Override
    public void zadd(String key, String val, Long score) {
        if (val == null) {
            return;
        }
        stringRedisTemplate.opsForZSet().add(key,val, score);
    }

    @Override
    public boolean expire(String key, long time) {
        try {
            if(time>0){
                stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void hset(String key, String item, String value){
        try{
            stringRedisTemplate.opsForHash().put(key,item,value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object hget(String key, String item){
        return stringRedisTemplate.opsForHash().get(key,item);
    }

    @Override
    public void hdel(String key, Object... item){
        stringRedisTemplate.opsForHash().delete(key, item);
    }

    @Override
    public boolean exist(String key)
    {
        
        return stringRedisTemplate.hasKey(key);
    }

    @Override
    public void map(String key, Map map) {
        stringRedisTemplate.opsForHash().putAll(key,map);
    }

    @Override
    public Map getMap(String key) {
        return stringRedisTemplate.opsForHash().entries(key);
    }


}