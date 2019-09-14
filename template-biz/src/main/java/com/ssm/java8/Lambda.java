package com.ssm.java8;

import com.google.common.collect.Lists;
import org.springframework.cglib.core.CollectionUtils;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author quandaoran
 * @date 2019-09-02
 * @description stream 常用操作
 */
public class Lambda {

    public static String chars = "*";

    public static void main(String[] args) {


        List<Person> people = Lists.newArrayList();
        Person person = new Person();
        person.setAge(12);
        person.setName("MeiJu");

        Person person1 = new Person();
        person1.setAge(12);
        person1.setName("MeiXue");

        Person person2 = new Person();
        person2.setAge(16);
        person2.setName("MeiLi");

        people.add(person);
        people.add(person1);
        people.add(null);
        people.add(person2);

//        todo list --> map  不运行有重复key
//        Map<String, Person> list2map = people.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
//        System.out.println(list2map);

//         todo list --> map 重复替换
//        Map<Integer, Person> list2map2 = people.stream().collect(Collectors.toMap(Person::getAge, Function.identity(), (key1, key2) -> key2));
//        System.out.println(list2map2);

//         todo 分组  根据属性分组
//        Map<Integer, List<Person>> groupByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
//        System.out.println(groupByAge);

//        todo 过滤属性  过滤年龄为12的
//        List<Person> collect = people.stream().filter(p -> p.getAge().equals(12)).collect(Collectors.toList());
//        System.out.println(collect);

//         todo 过滤null
//        Optional<Person> first = people.stream().filter(Objects::nonNull).filter(p -> p.getAge().equals(12)).findFirst();
//        System.out.println(first);


    }
}
