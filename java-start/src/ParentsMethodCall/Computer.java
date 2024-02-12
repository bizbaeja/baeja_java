package ParentsMethodCall;

public class Computer extends Calculator {
    @Override
    // 접근제한자 public 을 강화해서는 안된다.
    // 부모의 메소드 재정의
    //Case1 : Calculator 를 상속받는 Computer 쪽에서는 100 줄을 다시 쓰고 , 그 바꾸고 싶은 두 줄을 재정의 해야함.
    //Case2 : super.method() 를 써주고 추가하면 됨.
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}
