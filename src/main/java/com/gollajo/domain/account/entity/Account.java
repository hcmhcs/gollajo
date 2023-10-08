package com.gollajo.domain.account.entity;

import com.gollajo.domain.member.entity.Member;
import com.gollajo.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_member")
    private Member targetMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_post")
    private Post targetPost;

    @Embedded
    private AccountBody accountBody;

    //포인트 충전 혹은 이벤트시 생성자
    @Builder
    private Account(
            final Member member,
            final AccountBody accountBody
    ) {
        this.targetMember = member;
        this.accountBody = accountBody;
    }

    //투표글 생성 혹은 투표시 생성자
    @Builder
    private Account(
            final Member member,
            final Post post,
            final AccountBody accountBody
    ) {
        this.targetMember = member;
        this.targetPost = post;
        this.accountBody = accountBody;
    }
}
