package Constructor;

public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    //다른 생성자 호출
    Car(String model){
        this(model,"은색",250);
    }

    Car(String model,String color){
        this(model,"빨강", 250);
    }
    // 실행됨
    Car(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
