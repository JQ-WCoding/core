package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 하위 패키지 검색 (base package 지정)
        basePackages = "hello.core",
        // 해당 아래부터 시작
        // default 경로 -> package hello.core 이기 때문에 해당 클래스의 패키지 모두
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// 관용상 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 둘 것
public class AutoAppConfig {

}
