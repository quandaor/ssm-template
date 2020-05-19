package com.ssm.entity;

import java.util.List;

/**
 * @author quandaoran
 * @date 2020-02-25
 * @description
 */
public class AuthorDO {

    private Integer id;
    private String name;
    private Integer age;
    private SexEnum sex;
    private String email;
    private List<ArticleDO> articles;
}
