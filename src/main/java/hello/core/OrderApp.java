package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //        MemberService memberService = new MemberServiceImpl( null );
        //        OrderService orderService = new OrderServiceImpl( null, null );

        // AppConfig appConfig = new AppConfig();
        // // 메소드를 이용해 객체를 생성하고 클래스에 메소드를 주입한다.
        // // 인터페이스를 이용해 주입하기 때문에 다형성을 그대로 유지하면서 인터페이스를 상속받은 어떤 객체도 사용가능하다.
        // MemberService memberService = appConfig.memberService();
        // OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( AppConfig.class );

        MemberService memberService = applicationContext.getBean( "memberService", MemberService.class );
        OrderService orderService = applicationContext.getBean( "orderService", OrderService.class );

        Long memberId = 1L;
        Member member = new Member( memberId, "memberA", Grade.VIP );
        memberService.join( member );

        Order order = orderService.createOrder( memberId, "itemA", 20000 );

        System.out.println( "order = " + order );
        System.out.println( "orderCalculate = " + order.calculatePrice() );
    }
}
