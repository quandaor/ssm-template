package com.ssm.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author quandaoran
 * @date 2020-02-25
 * @description
 */
@Data
public class ArticleDO {
    private Integer id;
    private String title;
    private ArticleTypeEnum type;
    private AuthorDO author;
    private String content;
    private Date createTime;
}
