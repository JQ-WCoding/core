package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 1000원 할인 (고정 금액 할인)
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // VIP 이면 정책상 할인 1000원을 해주고 아닌경우 0원 할인(할인 없음)
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }
}
