package ParentsMethodCall;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;

        Calculator calculator = new Calculator();
        // Q: 아래 호출된 calculator.areaCirCle(r)은 누구의 메소드일까요?
        // A: 정답은 새로 오버라이딩 된 new Calculator() 의 메소드입니다.
        System.out.println(calculator.areaCircle(r));

        // 그럼 여기서 오버라이딩 된 computer.areaCircle(r) 는 어떤 클래스에서 호출된걸까요
        // 정답은 Computer 의 메소드입니다.
        // 무조건 재상속된 메소드걸로 ~!
        Computer computer = new Computer();
        System.out.println(computer.areaCircle(r));
    }
}
