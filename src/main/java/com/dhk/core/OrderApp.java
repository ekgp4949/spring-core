package com.dhk.core;

import com.dhk.core.member.Grade;
import com.dhk.core.member.Member;
import com.dhk.core.member.MemberService;
import com.dhk.core.order.Order;
import com.dhk.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //OrderService orderService = appConfig.orderService();
        //MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        memberService.join(new Member(memberId, "memberA", Grade.VIP));

        Order itemA = orderService.createOrder(memberId, "itemA", 2000);

        System.out.println(itemA.calculatePrice());
    }
}
