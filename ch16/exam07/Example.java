package ch16.exam07;

public class Example {
    private static int[] scores = {10,50,3};
    public static int maxOrMin(Operator operator) {
        // [0] 과 [1] 비교해서 큰 값을 result 에 대입
        int result = scores[0];
        for (int score : scores){
            result = operator.apply(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        //int max = maxOrMin((x, y )->Math.max(x, y));
        int max = maxOrMin(Math::max);
        int min = maxOrMin(Math::min);

        System.out.println("max ="+max);
        System.out.println("min ="+min);
    }
}
