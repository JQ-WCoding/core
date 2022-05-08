package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 정보
// @Bean 이 스프링 컨테이너에 등록된다
// @Configuration이 없으면 Singleton을 보장받지 못하여 인스턴스를 계속해서 생성한다.
@Configuration
public class AppConfig {

    // 의존성 주입을 담당하는 역할
    // 역할 분담을 확실하게 정한다.
    // 나머지 Impl 클래스들은 인터페이스만 고려해서 기능을 이용하면 원하는대로 인터페이스로부터 구현된 객체를 교체하여 사용할 수 있다.
    // 단지 우린 인터페이스만 확인하면서 개발하면 된다

    // DIP, SRP 원칙을 준수하여 구현된 ServiceImpl 내에서는 외부에서의 변경에 전혀 신경쓰지 않고 작업이 가능하도록 한다

    // 생성자 주입
    // memberService로 MemberServiceImpl@x01 빈객체가 생성

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new RateDiscountPolicy()

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository
    // 호출 순서는 보장되지 않지만 결론적으로 5가지 모두 호출될 것이라 추정 -> 하지만 3가지만 호출된다

    // call AppConfig.orderService
    // call AppConfig.memberRepository
    // call AppConfig.memberService

    // Configuration 이 꼭 필요함

    // 결과
    @Bean
    public MemberService memberService() {
        // System.out.println( "call AppConfig.memberService" );
        return new MemberServiceImpl( memberRepository() );
    }

    // 더 상세하게 나누어 생성자의 중복코드를 제거하고 메소드만 가지고 계속해서 변경할 수 있도록 한다.
    // memberRepository로 MemoryMemberRepositry@x03 빈객체가 생성
    @Bean
    public MemberRepository memberRepository() {
        // System.out.println( "call AppConfig.memberRepository" );
        return new MemoryMemberRepository();
    }

    // orderServiceImpl로 OrderServiceImpl@x02 빈객체가 생성
    @Bean
    public OrderService orderService() {
        System.out.println( "call AppConfig.orderService" );
        return new OrderServiceImpl( memberRepository(), discountPolicy() );
    }

    // discountPolicy로 RateDiscountPolicy@x04 빈객체가 생성
    @Bean
    public DiscountPolicy discountPolicy() {
        //        return new FixDiscountPolicy();
        // 단순 할인정책만 바꾸기 위해서 생성자만 변경해주면 된다
        return new RateDiscountPolicy();
    }

}
