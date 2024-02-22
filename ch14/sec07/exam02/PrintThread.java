package ch14.sec07.exam02;

public class PrintThread extends Thread {
	public void run() {
		try {
			while(true) {
				System.out.println("실행 중");
				//만약 sleep()이 없다면? -> interrupt() 호출해도 종료되지 않는다.
				Thread.sleep(1);
			}
		} catch(InterruptedException e) {
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}