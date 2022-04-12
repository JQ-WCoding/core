package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName ( "스프링 없는 순수한 DI 컨테이너" )
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인 -> 계속해서 객체를 생성하는 것은 비효율적이다
        // 두개의 객체는 서로 다른 주소를 가진 다른 객체이다.
        // 호출이 될때마다 계속 생성하는 것은 비효율적이며 또한, 값이 전혀 다른 것을 조회해올 수 있기 때문에 단일성을 유지할 필요가 있다면 싱글톤 패턴을 사용한다
        System.out.println( "memberService1 = " + memberService1 );
        System.out.println( "memberService1 = " + memberService2 );

        // memberSerivce1 != memberService2
        assertThat( memberService1 ).isNotSameAs( memberService2 );
    }

    @Test
    @DisplayName ( "싱글톤 패턴을 적용한 객체 사용" )
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 같은 주소의 객체를 호출한다 -> 동일한 객체다
        System.out.println( "singletonService1 = " + singletonService1 );
        System.out.println( "singletonService2 = " + singletonService2 );

        assertThat( singletonService1 ).isSameAs( singletonService2 );
        // same == 인스턴스 비교
        // equal -> 값 비교
    }

    @Test
    @DisplayName ( "스프링 컨테이너와 싱글톤" )
    void springContainer() {
        // AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class );
        MemberService memberService1 = ac.getBean( "memberService", MemberService.class );
        MemberService memberService2 = ac.getBean( "memberService", MemberService.class );

        System.out.println( "memberService1 = " + memberService1 );
        System.out.println( "memberService1 = " + memberService2 );

        assertThat( memberService1 ).isSameAs( memberService2 );
    }
}