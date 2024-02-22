package ch14.sec06.exam02;

public class WorkObject {
	//syncronized 키워드를 사용하면 해당 메소드를 사용하는 스레드가 하나씩만 실행된다.
	//notify()와 wait()를 사용하면 스레드가 실행되고 대기하는 것을 반복할 수 있다.
	public synchronized void methodA() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodA 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}

	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodB 작업 실행");
		notify();
		try {
			//시간을 주지 않으면 무한대기가 된다.
			wait();
		} catch (InterruptedException e) {
		}
	}
}