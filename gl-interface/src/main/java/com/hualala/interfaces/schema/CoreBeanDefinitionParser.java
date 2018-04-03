package com.hualala.interfaces.schema;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;


public class CoreBeanDefinitionParser implements BeanDefinitionParser {

    private Class<?> className;
    public CoreBeanDefinitionParser(Class<?> className) {
        this.className = className;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        if (className.equals(FilterBean.class)) {
            RootBeanDefinition filterDef = new RootBeanDefinition();
            filterDef.setBeanClass(this.className);
            filterDef.setLazyInit(false);
            String id = element.getAttribute(FilterBean.ATTR_ID);
            if (element.hasAttribute(FilterBean.ATTR_SERVICE)) {
                filterDef.getPropertyValues().addPropertyValue(FilterBean.ATTR_SERVICE, element.getAttribute(FilterBean.ATTR_SERVICE));
            }
            if (element.hasAttribute(FilterBean.ATTR_METHOD)) {
                filterDef.getPropertyValues().addPropertyValue(FilterBean.ATTR_METHOD, element.getAttribute(FilterBean.ATTR_METHOD));
            }

            if (element.hasAttribute(FilterBean.ATTR_IMPL_NAME)) {
                filterDef.getPropertyValues().addPropertyValue(FilterBean.ATTR_IMPL_NAME, element.getAttribute(FilterBean.ATTR_IMPL_NAME));
            }
            parserContext.getRegistry().registerBeanDefinition(id, filterDef);

            return filterDef;
        }
        return null;
    }

	protected Class getBeanClass(Element element) {  
        return FilterBean.class;  
    } 
}
