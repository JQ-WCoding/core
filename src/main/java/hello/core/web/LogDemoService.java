package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    // ObjectProvider를 사용하여 객체를 제공받아 사용하는 형식
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String testID) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log( "service ID : " + testID );
    }
}
