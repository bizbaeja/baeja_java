package Polymorphism;

public class Driver {
    //매개변수 다형성
    // 매개변수로 오는 클래스의 형태는 자식객체라면 다 올 수 있다.
    public void drive(Vehicle vehicle){
        vehicle.run();
    }
}
