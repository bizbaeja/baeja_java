package AbstractClass;

public class Dog extends Animal{
    //Dog 클래스는 추상클래스 Animal 을 상속받고 있으므로 반드시 추상클래스를 오버라이딩해야한다.

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
