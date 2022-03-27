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

        // ApplicationContext 를 사용해 스프링에 @Bean에 등록된 것을 스프링 컨테이너에서부터 불러온다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( AppConfig.class );

        // 메소드와 같은 명칭의 memberService, orderService 로 작성하여 key, vlaue 와 같이 가지고 오는 형식
        // @Bean(name = "")을 이용해 Name에 명칭을 작성할 순 있지만 관례상 기본값 그대로 사용한다
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
