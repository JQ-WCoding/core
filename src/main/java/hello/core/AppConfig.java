package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 의존성 주입을 담당하는 역할
    // 역할 분담을 확실하게 정한다.
    // 나머지 Impl 클래스들은 인터페이스만 고려해서 기능을 이용하면 원하는대로 인터페이스로부터 구현된 객체를 교체하여 사용할 수 있다.
    // 단지 우린 인터페이스만 확인하면서 개발하면 된다

    // DIP, SRP 원칙을 준수하여 구현된 ServiceImpl 내에서는 외부에서의 변경에 전혀 신경쓰지 않고 작업이 가능하도록 한다

    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl( getMemberRepository() );
    }

    // 더 상세하게 나누어 생성자의 중복코드를 제거하고 메소드만 가지고 계속해서 변경할 수 있도록 한다.
    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl( getMemberRepository(), getDiscountPolicy() );
    }

    private DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        // 단순 할인정책만 바꾸기 위해서 생성자만 변경해주면 된다
        return new RateDiscountPolicy();
    }

}
