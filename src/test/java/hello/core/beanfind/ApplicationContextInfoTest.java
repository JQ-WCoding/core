package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class );

    @Test
    @DisplayName ( "모든 빈 출력" )
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for ( String beanDefinitionName : beanDefinitionNames ) {
            Object bean = ac.getBean( beanDefinitionName );
            // spring이 등록한 것과 내가 등록한 것을 모두 출력
            System.out.println( "name = " + beanDefinitionName + " object = " + bean );
        }
    }
    @Test
    @DisplayName ( "어플리케이션 빈 출력" )
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // 향상 for문
        for ( String beanDefinitionName : beanDefinitionNames ) {
            // bean 에 등록되어 있는 명칭 중에 정의 된 bean 찾기
            BeanDefinition beanDefinition = ac.getBeanDefinition( beanDefinitionName );

            // 빈이 역할을 하는지 여부를 물어보기
            // ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
            // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            // 빈의 역할이 직접 등록인지 스프링 내부에서 관리하는 형식인지 enum 으로 등록되어 있는 값을 이용해 찾는다
            if ( beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                // bean 에 정의된 이름으로 객체 생성하기
                Object bean = ac.getBean( beanDefinitionName );
                // 객체 반환 및 이름 확인하기
                // 내가 등록한 Bean만 보기
                System.out.println( "name = " + beanDefinitionName + " object = " + bean );
            }
        }
    }
}
