package com.dhk.core;

import com.dhk.core.discount.FixDiscountPolicy;
import com.dhk.core.member.MemoryMemberRepository;
import com.dhk.core.member.MemberService;
import com.dhk.core.member.MemberServiceImpl;
import com.dhk.core.order.OrderService;
import com.dhk.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
