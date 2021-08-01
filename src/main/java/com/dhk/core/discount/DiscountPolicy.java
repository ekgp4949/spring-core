package com.dhk.core.discount;

import com.dhk.core.member.Member;

public interface DiscountPolicy {

    /**
     * @retun 할인 대상 금액
     * */
    int discount(Member member, int price);
}
