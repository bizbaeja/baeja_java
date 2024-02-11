package Method;

public class ComputerExample {
    public static void main(String[] args) {
        // Computer 객체 생성
        Computer myCom = new Computer();

        int result1 = myCom.sum(1, 2, 3);
        System.out.println("result1:" + result1);

        int result2 = myCom.sum(1, 2, 3, 4, 5);
        System.out.println("result2:" + result2);

        //sum() 메소드 호출 시 배열을 제공하고 합산 결과를 리턴 받아 result3 변수에 대입
        int[] values = {1,2, 3, 4, 5};
        int result3 = myCom.sum(values);
        System.out.println("result3:"+result3);

        //sum() 메소드 호출 시 new int[]{} 를 인자에 대입가능한 이유는
        // Computer 의 파라미터에 values 변수가 선언되어있기 때문이다.
        int result4 = myCom.sum(new int[]{1,2,3,4,5});
        System.out.println("result4:"+result4);

    }
}
