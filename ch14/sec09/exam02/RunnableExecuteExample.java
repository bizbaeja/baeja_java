package ch14.sec09.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {

	public static void main(String[] args) {
		//1000개의 메일 생성
		String[][] mails = new String[1000][3];
		for(int i=0; i<mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member"+i+"@my.com";
			mails[i][2] = "신상품 입고";
		}
		
		//ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//이메일을 보내는 작업 생성 및 처리 요청
		// 1000초
		// 앞에서 학습한 일반 스레드 생성 방식으로 작업을 처리하면 1000개의 메일을 보내는 작업을 모두 완료하는 데 1000초가 걸린다.
		// ExecutorService를 이용하면 1000개의 작업을 5개의 스레드로 처리하므로 200초가 걸린다.
		for(int i=0; i<1000; i++) {
			final int idx = i;
			// 스레드 안에서는 지역변수를 사용할 수 없다. 그래서 final을 붙여서 지역변수를 전역변수로 만들어준다.
			new Thread(()-> {
				String from = mails[idx][0];
				String to = mails[idx][1];
				String content = mails[idx][2];
				//mail send--> network 시간 , cpu 시간 사용안됨.
				//메일을 보내는 작업을 시뮬레이션하기 위해 1초
				System.out.println("[ 메일발송 ] " + from + " ==> " + to + ": " + content);
			}).start();


			for(int j=0; j<1000; j++){
				final int idx2 = j;


			}
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Thread thread = Thread.currentThread();

				}
			});
		}
			
		//ExecutorService 종료
		executorService.shutdown();
	}
}