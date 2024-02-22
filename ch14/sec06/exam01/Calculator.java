package ch14.sec06.exam01;
//코드를 설명하면?
//메모리에 값을 저장하고 읽는 메소드를 가지고 있는 클래스이다.
//메모리에 값을 저장하는 메소드는 synchronized로 동기화 되어있다.
//메모리에 값을 읽는 메소드는 synchronized로 동기화 되어있지 않다.
//메모리에 값을 저장하는 메소드는 synchronized로 동기화 되어있기 때문에 한 스레드가 메모리에 값을 저장하는 동안 다른 스레드는 대기하게 된다.
//동기화 블럭이란?
//동기화 블럭은 여러 스레드가 동시에 실행할 수 없도록 동기화하는 방법이다.
//여기서는 메모리에 값을 저장하는 메소드가 동기화 블럭이다.
//메모리에 값을 저장하는 메소드가 동기화 블럭이기 때문에 한 스레드가 메모리에 값을 저장하는 동안 다른 스레드는 대기하게 된다.
public class Calculator {
	// memory 필드는 메모리를 나타낸다.
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory1(int memory) {
		//동기화 블럭
		// 함수 자체에 락을 거는 방법은 synchronized 키워드를 사용하는 것이다.
		// 멈출 때 객체 자체에 락을 걸어버리는 것이다.전부 다 멈추게 된다.
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}

	public void setMemory2(int memory) {
		System.out.println("동기화 영역이 아님");
synchronized (this) {//대기
    // this는 Calculator 객체를 가리킨다.

	try {
		this.memory = memory;
		Thread.sleep(2000);
	} catch (InterruptedException e) {
	}
	System.out.println(Thread.currentThread().getName() + ": " + this.memory);
}//대기해제
	}
}