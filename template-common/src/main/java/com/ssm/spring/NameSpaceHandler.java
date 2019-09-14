package com.ssm.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author quandaoran
 * @date 2019-06-24
 * @description
 */
public class NameSpaceHandler extends NamespaceHandlerSupport {
    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after
     * construction but before any custom elements are parsed.
     *
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     */
    @Override
    public void init() {

    }


}
