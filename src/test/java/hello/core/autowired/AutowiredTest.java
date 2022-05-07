package hello.core.autowired;

import hello.core.member.Member;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    public void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( TestBean.class );
    }

    static class TestBean {

        // 호출 자체가 되지 않는다
        @Autowired ( required = false )
        public void setNoBean1(Member noBean1) {
            System.out.println( "noBean1 = " + noBean1 );
        }

        // @Nullable을 통해 null인 경우 null이 입력되어 들어온다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println( "noBean2 = " + noBean2 );
        }

        // Optional을 사용하여 null인 경우를 방지한다
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println( "noBean3 = " + noBean3 );
        }
    }
}
