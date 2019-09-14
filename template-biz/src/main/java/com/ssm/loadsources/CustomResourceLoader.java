package com.ssm.loadsources;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author quandaoran
 * @date 2019-06-19
 * @description
 */
public class CustomResourceLoader implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void getResourceData(String location) throws IOException {
        Resource resource = resourceLoader.getResource(location);
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("biz-context.xml");
        CustomResourceLoader bean = context.getBean(CustomResourceLoader.class);
//        从应用程序根文件夹加载资源
//        bean.getResourceData("file:README.MD");
//        从类路径加载资源
//        bean.getResourceData("classpath:biz-context.xml");
//        从文件系统加载资源
//        bean.getResourceData("file:/Users/quandaoran/IdeaProjects/apollo/apollo.iml");
//        从URL加载资源
        bean.getResourceData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560966767885&di=98b7ab0ccbc658d88fe6545066255977&imgtype=0&src=http%3A%2F%2Fpic2.52pk.com%2Ffiles%2Fallimg%2F090626%2F1553504U2-2.jpg");
    }
}
