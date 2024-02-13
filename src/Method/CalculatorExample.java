package Method;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();

        myCalc.powerOn();
// return 값이 있어야 하기 때문에 우측의 값을 왼쪽의 참조변수에 대입한 것이 된다.
        int result1 = myCalc.plus(3,5);
        System.out.println("result1:" + result1);
    }
}
