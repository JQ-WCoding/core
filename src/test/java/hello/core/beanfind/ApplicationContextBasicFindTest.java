package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    // ApplicationContext를 주로 사용한다
    // BeanFactory는 잘 사용하지 않는다
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class );

    @Test
    @DisplayName ( "빈 이름으로 조회" )
    void findBeanByName() {
        MemberService memberService = ac.getBean( "memberService", MemberService.class );
        // System.out.println( "memberService = " + memberService );
        // System.out.println( "memberService.getClass() = " + memberService.getClass() );

        // memberService가 MemberServiceImpl 클래스와 상속관계인지
        assertThat( memberService ).isInstanceOf( MemberServiceImpl.class );
    }

    @Test
    @DisplayName ( "이름 없이 타입으로만 조회" )
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class );
        assertThat( memberService ).isInstanceOf( MemberServiceImpl.class );
    }

    @Test
    @DisplayName ( "구체 이름으로 조회" )
    void findBeanByName2() {
        MemberService memberService = ac.getBean( "memberService", MemberServiceImpl.class );
        assertThat( memberService ).isInstanceOf( MemberServiceImpl.class );
    }


    // NoSuchBeanDefinitionException
    @Test
    @DisplayName ( "빈 이름으로 조회 X" )
    void findBeanByNameX() {
        //ac.getBean("XXXX", MemberService.class);
        // MemberService xxxx = ac.getBean( "XXXX", MemberService.class );
        assertThrows( NoSuchBeanDefinitionException.class, () -> ac.getBean( "XXXX", MemberService.class ) );
    }
}
