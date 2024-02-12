package ParentsMethodCall;

public class Calculator {
    public double areaCircle(double r){
        //Case1 : 100줄 이 있고 아래의 두 줄만 '변경' 하고 싶을 때,
        //Case2 : 100줄이 있고 새로 두 줄을 '추가' 하고 싶을 때,
        System.out.println("Calculator 객체의 areaCircle() 실행");
        return 3.14159 * r * r;
    }

}
