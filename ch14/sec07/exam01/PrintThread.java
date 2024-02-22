package ch14.sec07.exam01;

public class PrintThread extends Thread {
	private boolean stop;
 // 정상 종료하고 싶을 땐 stop 필드를 true로 변경하면 된다.
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while(!stop) {
			System.out.println("실행 중");
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}