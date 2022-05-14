package com.dhk.core;

import com.dhk.core.member.Grade;
import com.dhk.core.member.Member;
import com.dhk.core.member.MemberService;
import com.dhk.core.order.Order;
import com.dhk.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();
        Long memberId = 1L;
        memberService.join(new Member(memberId, "memberA", Grade.VIP));

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(itemA.calculatePrice());
    }
}
