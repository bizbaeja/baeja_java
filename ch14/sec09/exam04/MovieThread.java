package ch14.sec09.exam04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MovieThread extends Thread {


    @Override
    public void run() {
       while (true){
           System.out.println("동영상을 재생합니다.");
           if(this.isInterrupted()){
               break;
           }
       }

    }
}

//        for(int i=0; i<3; i++) {
//            System.out.println("동영상을 재생합니다.");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {}
//        }
//    }

