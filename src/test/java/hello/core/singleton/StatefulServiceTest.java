package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    // @Test
    // void statefulService() {
    //     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( TestConfig.class );
    //     StatefulService statefulService1 = ac.getBean( StatefulService.class );
    //     StatefulService statefulService2 = ac.getBean( StatefulService.class );
    //
    //     // ThreadA : A 사용자 10000원 주문
    //     statefulService1.order( "userA", 10000 );
    //     // ThreadB : B 사용자 20000원 주문
    //     statefulService2.order( "userB", 20000 );
    //
    //     // ThreaA : 사용자 A 주문 금액조회 -> 중간에 B사용자가 주문을 하는게 getPrice를 가져오는 것보다 먼저 주문이 들어왔다
    //     int price = statefulService1.getPrice();
    //     System.out.println( "price = " + price );
    //
    //     Assertions.assertThat( statefulService1.getPrice() ).isEqualTo( 20000 );
    // }

    @Test
    void statefulService() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( TestConfig.class );
        StatefulService statefulService1 = ac.getBean( StatefulService.class );
        StatefulService statefulService2 = ac.getBean( StatefulService.class );

        // ThreadA : A 사용자 10000원 주문
        int userA = statefulService1.order( "userA", 10000 );
        // ThreadB : B 사용자 20000원 주문
        int userB = statefulService2.order( "userB", 20000 );

        // ThreaA : 사용자 A 주문 금액조회 -> 중간에 B사용자가 주문을 하는게 getPrice를 가져오는 것보다 먼저 주문이 들어왔다
        System.out.println( "price = " + userA );

        // Assertions.assertThat( userB ).isEqualTo( 20000 );
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}