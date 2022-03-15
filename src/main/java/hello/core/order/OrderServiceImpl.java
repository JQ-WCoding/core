package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    /* 프로세스 -> 주문을 내리기 위해서는 해당 회원의 등급을 확인하고, 등급에 맞는 회원의 할인정책을 적용한 주문내역을 내린다 */
    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy = new fixDiscountPolicy();
    // 비율할인 정책으로 변경되어 다른 구현 객체를 입력한다
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 인터페이스에만 의존하도록 변경 -> 구현체는 의존하지 않는다
    // DIP는 지켰다 -> 의존성 주입에 대한건 지켰음
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl( MemberRepository memberRepository, DiscountPolicy discountPolicy ) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder( Long memberId, String itemName, int itemPrice ) {
        // 멤버를 저장소에서 ID값으로 찾아 할인정책을 확인하고 새로운 주문을 생성한다.
        Member member = memberRepository.findById( memberId );
        int discountPrice = discountPolicy.discount( member, itemPrice );
        // 새로운 주문 생성하여 반환
        return new Order( memberId, itemName, itemPrice, discountPrice );
    }
}
