package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    // 테스트 실행전 무조건 실행 -> MemberService 주입
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given -> member 객체를 새로 생성한다
        Member member = new Member( 1L, "memberA", Grade.VIP );

        // when -> 해당 회원을 memberService를 통해 회원가입 시키고 찾는다
        memberService.join( member );
        Member findMember = memberService.findMember( 1L );

        // then -> 생성한 멤버와 찾은 멤버가 동일한가?
        Assertions.assertThat( member )
                .isEqualTo( findMember );
    }
}
