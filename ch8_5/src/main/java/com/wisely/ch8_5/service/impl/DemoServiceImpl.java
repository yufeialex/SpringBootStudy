package com.wisely.ch8_5.service.impl;

import com.wisely.ch8_5.domain.Person;
import com.wisely.ch8_5.service.DemoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements DemoService {

//    /*@Autowired
//    PersonRepository personRepository;*/

    @Override
    // 缓存名称为people，数据的key是person的id
    // 每次都执行，然后放到缓存
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
//        Person p = personRepository.save(person);
        System.out.println("为id、key为:" + person.getId() + "数据做了缓存");
        return person;
    }

    @Override
    @CacheEvict(value = "people")//2
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
//        Person p = personRepository.findOne(person.getId());
        System.out.println("为id、key为:" + person.getId() + "数据做了缓存");
        return person;
    }

}
