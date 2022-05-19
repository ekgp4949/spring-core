package com.dhk.core.singletonTest;

import com.dhk.core.AppConfig;
import com.dhk.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 요청마다 객체를 생성하게 됨.. -> 매모리 낭비가 심함
        // -> 싱글톤 패턴 사용하면 됨
        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();
        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }
}
