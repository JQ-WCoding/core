package hello.core.discount;

import hello.core.annotation.MainDisocountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
// @Qualifier ( "mainDiscountPolicy" )
@MainDisocountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if ( member.getGrade() == Grade.VIP ) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
