package com.dhk.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        Member findMember2 = memberService.findMember(2L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        Assertions.assertThat(member).isNotEqualTo(findMember2);

    }
}
