package ch14.sec05.exam03;

public class WorkThread extends Thread {
	//필드
	public boolean work = true;
	public  boolean run = true;
	//생성자
	public WorkThread(String name) {
		setName(name);
	}
	//메소드
	@Override
	//코드리뷰
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName() + ": 작업처리");
			} else {
				//코드리뷰: yield()메소드는 실행중인 스레드를 실행대기상태로 만든다.
				System.out.println("다른 스레드에게 양보");
				Thread.yield();
			}
		}
	}
}