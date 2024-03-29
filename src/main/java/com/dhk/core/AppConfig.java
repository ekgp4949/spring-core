package com.dhk.core;

import com.dhk.core.discount.DiscountPolicy;
import com.dhk.core.discount.RateDiscountPolicy;
import com.dhk.core.member.MemberRepository;
import com.dhk.core.member.MemberService;
import com.dhk.core.member.MemberServiceImpl;
import com.dhk.core.member.MemoryMemberRepository;
import com.dhk.core.order.OrderService;
import com.dhk.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
