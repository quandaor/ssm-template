package com.ssm.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author quandaoran
 * @date 2020-03-18
 * @description
 */
@Data
public class User1 {
    private Integer id;
    private String name;

    //get和set方法省略...
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
    }
}
