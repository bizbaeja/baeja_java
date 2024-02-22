package ch14.sec05.exam02;

public class JoinEx {
    public static void main(String[] args) {
        SumThread sumThread2 = new SumThread();
        sumThread2.start();

        try {
            sumThread2.join();
        } catch (InterruptedException e) {
        }
        System.out.println("1~100 합: " + sumThread2.getSum());
    }
}
