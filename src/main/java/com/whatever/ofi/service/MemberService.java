package com.whatever.ofi.service;

import com.whatever.ofi.domain.Member;
import com.whatever.ofi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(Member member) {
        memberRepository.save(member);
    }
}
