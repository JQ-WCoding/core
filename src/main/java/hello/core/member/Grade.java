package hello.core.member;

// enum 클래스는 따로 초기 값을 설정하지 않으면 정수의 값이 임의로 저장되어 있다.
// 하지만 클래스 상 고유의 값이 있는 형태로 인식해도 무방하다
// enum 클래스에 BASIC, VIP와 같이 직관적으로 표현할 수 있는 방법으로 고유 값을 지정하여 사용할 수 있다
public enum Grade {
    BASIC, VIP
}
