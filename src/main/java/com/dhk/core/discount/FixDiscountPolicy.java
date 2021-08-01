package com.dhk.core.discount;

import com.dhk.core.member.Grade;
import com.dhk.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountfixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountfixAmount;
        } else {
            return 0;
        }
    }
}
