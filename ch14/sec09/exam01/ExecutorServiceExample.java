package ch14.sec09.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
	
public class ExecutorServiceExample {
	public static void main(String[] args) {
		//스레드풀 생성
		//newCachedThreadPool() 메소드는 초기 스레드 개수가 0개이며, 스레드가 필요하면 새로 생성한다.
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		//작업 생성과 처리 요청
		//스레드풀 종료
		//shutdown() 메소드는 현재 진행 중인 작업을 마무리하고 스레드풀을 종료한다.
		executorService.shutdownNow();
	}
}