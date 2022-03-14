package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.fixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    /* 프로세스 -> 주문을 내리기 위해서는 해당 회원의 등급을 확인하고, 등급에 맞는 회원의 할인정책을 적용한 주문내역을 내린다 */
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new fixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 멤버를 저장소에서 ID값으로 찾아 할인정책을 확인하고 새로운 주문을 생성한다.
        Member member = memberRepository.findById( memberId );
        int discountPrice = discountPolicy.discount( member, itemPrice );
        // 새로운 주문 생성하여 반환
        return new Order( memberId, itemName, itemPrice, discountPrice );
    }
}
