package ch14.sec09.exam04;

public class ThreadExample2 {
    public static void main(String[] args) {
        Thread thread2 = new MovieThread();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
}
