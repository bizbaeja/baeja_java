package ch14.sec05.exam02;

public class JoinExample {
	public static void main(String[] args) {
		//계산스레드
		SumThread sumThread = new SumThread();
		sumThread.start();
		//javascript로 말할것같으면 이부분이 비동기 처리하는 부분이다.
		//join()메소드는 sumThread가 종료될때까지 기다리게 하는 메소드이다.
		try {
			sumThread.join();
		} catch (InterruptedException e) {
		}
		//메인스레드
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}