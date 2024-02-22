package ch14.sec05.exam03;

public class YieldExample {
	public static void main(String[] args) {
		//yield()메소드는 실행중인 스레드를 실행대기상태로 만든다.
		//실행대기상태로 만들어서 다른 스레드에게 실행기회를 주는것이다.
		//notify() 메소드란? notify() 메소드는 wait() 메소드에 의해 일시정지 상태에 있는 스레드를 실행대기 상태로 만든다.
		WorkThread workThreadA = new WorkThread("workThreadA");
		WorkThread workThreadB = new WorkThread("workThreadB");
		workThreadA.start();
		workThreadB.start();
		//자바스크립트의 setTimeout()메소드와 비슷한것같다.
		//그러나 다른 점은 setTimeout()메소드는 일정시간이 지나면 실행되는것이고
		//Thread.sleep()메소드는 일정시간동안 실행대기상태로 만드는것이다.
		try { Thread.sleep(5000); } catch (InterruptedException e) {}
		workThreadA.work = false;

		try { Thread.sleep(10000); } catch (InterruptedException e) {}
		workThreadA.work = true;
		workThreadB.work = false;
		System.out.println("프로그램 종료");

	}
}