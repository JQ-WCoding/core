package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    // ObjectProvider를 사용하여 객체를 호출하는 시점에도 Bean 생성을 추적하고 지연할 수 있음
    // private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping ( "log-demo" )
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestUrl = request.getRequestURL()
                .toString();
        // 현 타이밍에 getObject()를 호출하여 주입
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL( requestUrl );

        myLogger.log( "Controller Test" );
        Thread.sleep( 100 );
        logDemoService.logic("testID");
        return "OK";
    }
}
