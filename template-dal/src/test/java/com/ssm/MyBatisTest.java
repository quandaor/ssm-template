package com.ssm;

import com.ssm.entity.ArticleDO;
import com.ssm.mapper.ArticleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class MyBatisTest {
    /**
     * Rigorous Test :-)
     */


    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void prepare() throws IOException {
        String resource = "mybatis/mapper/configuration.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMyBatis() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            List<ArticleDO> articles = articleDao.findByAuthorAndCreateTime("coolblog.xyz", "2020-02-25");
            System.out.println(articles);
        } finally {
            session.commit();
            session.close();
        }
    }
}
