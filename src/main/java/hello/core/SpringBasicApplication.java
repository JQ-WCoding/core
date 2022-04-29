package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 해당 Annotation 안에 Component 스캔이 사용되고 있다
@SpringBootApplication
public class SpringBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringBasicApplication.class, args );
    }

}
