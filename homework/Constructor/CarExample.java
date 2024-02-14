package Constructor;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car("자가용");
        System.out.println("car1.company:" + car1.company);
        System.out.println("car1.model:" + car1.model);
        System.out.println();
// 제대로 파라미터를 전부 써주지 않으면 sout 입력된 파라미터가 호출되지 않고 기존의 생성자 함수가 호출된다.
        Car car2 = new Car("스포츠","초록",300);
        System.out.println("car1.company:" + car2.company);
        System.out.println("car1.color:" + car2.color);
        System.out.println("car1.model:" + car2.model);
        System.out.println();

        Car car3 = new Car("택시", "검정", 200);
        System.out.println("car1.company:" + car3.company);
        System.out.println("car1.color:" + car3.color);
        System.out.println("car1.maxSpeed:" + car3.maxSpeed);
        System.out.println();
    }
}
