package com.kilogod.code.redis;

import java.util.List;
import java.util.Map;

/**
 * [简要描述]:Redis服务接口
 * [详细描述]:<br/>
 */
public interface Redis
{
    String get(String key);

    void set(String key, String value);

    void delete(String key);

    /**
     * @author NEo
     *
     * @desc 取出有序集合的指定序列的内容
     * @param key
     * @param start
     * @param end
     * @return java.util.List
     */
    List zrange(String key, long start, long end);

    /**
     * @author NEo
     *
     * @desc 添加到有序集合
     * @param key
     * @param val
     * @param score
     * @return void
     */
    void zadd(String key, String val, Long score);

    /**
     * @author NEo
     *
     * @desc 设置顶级key过期时间
     * @param key
     * @param time
     * @return boolean
     */
    boolean expire(String key, long time);

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @author Json
     * @param key   键
     * @param item  项
     * @param value 值
     * @return void
     */
    void hset(String key, String item, String value);

    /**
     * 删除hash表中的值
     * @author Json
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     * @return void
     */
    void hdel(String key, Object... item);

    /**
     * 获取hash表中的值
     * @author Json
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return Object
     */
    Object hget(String key, String item);
    
    /**
     * 判断key是否存在
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author Jerry[周昭泽]
     * @param key
     * @return
     */
    boolean exist(String key);

    /**
     * 存map
     * @author Anding[朱旺求]
     * @param key
     * @param map
     */
    void map(String key, Map map);

    /**
     * 取map值
     * @author Anding[朱旺求]
     * @param key
     * @return
     */
    Map getMap(String key);
}
