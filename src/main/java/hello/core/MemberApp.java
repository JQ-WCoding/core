package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        // 테스트 목표 : 멤버를 저장하고 찾아왔을 때, 두 선언한 객체의 값인 find member와 new member가 값이 같아야한다
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member( 1L, "memberA", Grade.VIP );
        memberService.join( member );

        Member findMember = memberService.findMember( 1L );

        System.out.println( "new member = " + member.getName() );
        System.out.println( "find Member = " + findMember.getName() );
    }
}
