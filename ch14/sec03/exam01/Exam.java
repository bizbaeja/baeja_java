package ch14.sec03.exam01;


//class WorkTread1 implements Runnable {
//    @Override
//    public void run() {
//        for(int i=0;i<10000;i++){
//            System.out.println("네트워크 실행");
//        }
//    }
//}
class WorkTread2 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            System.out.println("드로잉 실행");
        }
    }
}

public class Exam {
    public static void main(String[] args) {
        //추상메소드 run() 만 하나 선언 -> 스레드임. run 이라는 함수로 구현하세요 라는 뜻
        //Tread 클래스 만든 뒤 실행도 해줘야 함.
        //ctrl + f11 키는 실행키다.
        // cmd에서 엔터를 칠 때도 스레드가 만들어짐


        Thread t1 = new Thread(()-> {
                        for(int i=0;i<10000;i++){
                            System.out.println("네트워크 실행");
                        }

        });
        Thread t2 = new Thread(new WorkTread2());

        t1.start();
        t2.start();
        for(int i=0;i<10000;i++){
            System.out.println("메인스레드 실행");
        }


    }
}
