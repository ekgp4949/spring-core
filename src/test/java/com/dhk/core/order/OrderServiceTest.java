package com.dhk.core.order;

import com.dhk.core.AppConfig;
import com.dhk.core.member.Grade;
import com.dhk.core.member.Member;
import com.dhk.core.member.MemberService;
import com.dhk.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order itemA = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(itemA.calculatePrice()).isEqualTo(9000);
    }
}
