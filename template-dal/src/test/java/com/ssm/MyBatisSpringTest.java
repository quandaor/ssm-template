package com.ssm;

import com.ssm.entity.ArticleDO;
import com.ssm.entity.User1;
import com.ssm.mapper.ArticleDao;
import com.ssm.mapper.User1Dao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author quandaoran
 * @date 2020-02-25
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mybatis-db.xml")
public class MyBatisSpringTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private User1Dao user1Dao;

    @Before
    public void setUp() {
        articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        user1Dao = (User1Dao) applicationContext.getBean("user1Dao");
    }

    @Test
    public void test() {
        List<ArticleDO> articles = articleDao.findByAuthorAndCreateTime("coolblog.xyz", "2020-02-25");
        System.out.println(articles);
    }

    @Test
    public void test1() {
        List<ArticleDO> articles = articleDao.findByAuthorAndCreateTime("coolblog.xyz", "2020-02-25");
        System.out.println(articles);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private String propagation_required;

    private String propagation_supports;

    private String propagation_mandatory;
}
