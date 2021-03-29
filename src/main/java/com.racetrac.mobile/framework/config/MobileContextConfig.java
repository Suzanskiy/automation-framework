package com.racetrac.mobile.framework.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.retry.annotation.EnableRetry;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@EnableRetry
@Configuration
@ComponentScan(basePackages = {
        "com.racetrac.mobile"})
public class MobileContextConfig {

    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public BeanFactoryResolver getBeanFactoryResolver() {
        return new BeanFactoryResolver(beanFactory);
    }

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public StandardEvaluationContext getEvaluationContext() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(getBeanFactoryResolver());
        return context;
    }

}