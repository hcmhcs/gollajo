package com.gollajo.domain.exception.handler;

import com.gollajo.domain.member.dto.CreateMemberRequest;
import com.gollajo.domain.member.entity.Member;
import com.gollajo.domain.member.repository.MemberRepository;
import com.gollajo.domain.exception.CustomException;
import com.gollajo.domain.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberExceptionHandler {

    private final MemberRepository memberRepository;

    public void signUpException(CreateMemberRequest request){
        if (request.email() == null) {
            throw new CustomException(ErrorCode.NO_EMAIL);
        }
        if (request.nickname() == null) {
            throw new CustomException(ErrorCode.NO_USERNAME);
        }
        if(memberRepository.existsByEmail(request.email())){
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }
    }

    public void findByIdException(Long memberId){
        if(!memberRepository.existsById(memberId)){
            throw new CustomException(ErrorCode.NO_MEMBER_BY_MEMBER_ID);
        }
    }

    public void findByEmailException(String email){

        if(!memberRepository.existsByEmail(email)){
            throw new CustomException(ErrorCode.NO_MEMBER);
        }

    }

}
