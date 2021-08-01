package com.dhk.core.order;

import com.dhk.core.discount.DiscountPolicy;
import com.dhk.core.discount.FixDiscountPolicy;
import com.dhk.core.member.Member;
import com.dhk.core.member.MemberRepository;
import com.dhk.core.member.MemberRepositoryImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemberRepositoryImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
