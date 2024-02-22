package ch14.sec09.exam04;

// 동영상과 음악을 재생하기 위해 두 가지 스레드를 실행하는 예제
public class ThreadExample {
    public static void main(String[] args) {
        MovieThread movieThread = new MovieThread();
        movieThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        movieThread.interrupt();
    }
//    public static void main(String[] args) {
//        Thread thread1 = new MovieThread();
//        thread1.start();
//
//        Thread thread2 = new Thread(new MusicRunnable());
//        thread2.start();
//    }
}
