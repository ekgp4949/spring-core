package com.dhk.core.singletonTest;

import com.dhk.core.AppConfig;
import com.dhk.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 요청마다 객체를 생성하게 됨.. -> 매모리 낭비가 심함
        // -> 싱글톤 패턴 사용하면 됨
        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();
        assertThat(memberService).isNotSameAs(memberService1);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        assertThat(singletonService1).isSameAs(singletonService2);
        //same : == 비교
        //equals : 오버라이딩된 equals 비교
    }

    @Test
    @DisplayName("스프링 컨테이너 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isSameAs(memberService1);
    }

}
