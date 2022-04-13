package hello.core.singleton;

public class StatefulService {
    // stateless 하게 설계해야 중복이 없다

    // private int price; // 상태를 유지하는 필드

    // public void order(String name, int price) {
    //     System.out.println( "name = " + name + " price = " + price );
    //     this.price = price;
    // }

    public int order(String name, int price) {
        System.out.println( "name = " + name + " price = " + price );
        return price;
    }

    // public int getPrice() {
    //     return price;
    // }
}
