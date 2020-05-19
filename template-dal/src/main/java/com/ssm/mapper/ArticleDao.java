package com.ssm.mapper;

import com.ssm.entity.ArticleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author quandaoran
 * @date 2020-02-25
 * @description
 */
public interface ArticleDao {

    List<ArticleDO> findByAuthorAndCreateTime(@Param("author") String author, @Param("createTime") String createTime);

}
