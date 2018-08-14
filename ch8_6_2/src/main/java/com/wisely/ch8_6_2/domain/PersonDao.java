package com.wisely.ch8_6_2.domain;

import com.wisely.ch8_6_2.dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //1 boot已经配置过

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr; //3  boot已经配置过；基于字符串


    @Autowired
    RedisTemplate<Object, Object> redisTemplate; //2 boot已经配置过

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps; //4 boot已经配置过；基于对象

    public void stringRedisTemplateDemo() {
        valOpsStr.set("xx", "yy");
    }

    public void save(Person person) {
        valOps.set(person.getId(), person);
    }

    public String getString() {
        return valOpsStr.get("xx");
    }

    public Person getPerson() {
        return (Person) valOps.get("1");
    }

}
