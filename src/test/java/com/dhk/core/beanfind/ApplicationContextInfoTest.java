package com.dhk.core.beanfind;

import com.dhk.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 스프링 빈 출력")
    void findBeanAll() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + ", object" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력(사용자 등록 빈)")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // Role ROLE_APPLICATION: 사용자가 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() != BeanDefinition.ROLE_APPLICATION) {
                continue;
            }
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + ", object" + bean);
        }
    }
}
