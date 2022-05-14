package com.dhk.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepositoryImpl implements MemberRepository {

    // 메모리 저장소
    // HashMap은 동시성 이슈가 있어서 ConcurrentHashMap 써야함
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
