package com.dhk.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletoneTest {
    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletoneBean.class);
        SingletoneBean bean = ac.getBean(SingletoneBean.class);
        SingletoneBean bean2 = ac.getBean(SingletoneBean.class);

        Assertions.assertThat(bean).isSameAs(bean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletoneBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletoneBean.init");
        }

        @PreDestroy
        void destroy() {
            System.out.println("SingletoneBean.destroy");
        }
    }
}
