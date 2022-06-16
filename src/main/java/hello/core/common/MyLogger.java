package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
// proxyMode 추가 -> 클래스면 TARGET_CLASS, 인터페이스면 TARGET_INDTERFACE => 가짜 프록시를 만들어 주입해준다
@Scope ( value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println( "[" + uuid + "]" + "[" + requestURL + "]" + message );
    }

    // 생성
    @PostConstruct
    public void init() {
        // UUID 클래스의 랜덤한 UUID를 생성하는 방법
        uuid = UUID.randomUUID()
                .toString();
        System.out.println("[" + uuid + "] request scope bean created: " + this);
    }

    // 소멸
    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
