package ch14.sec06.exam01;

public class User1Thread extends Thread {
	private Calculator calculator;

	public User1Thread() {
		setName("User1Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	// setMemory1 메소드를 호출하여 memory 필드에 100을 저장하고 2초간 일시 정지시킨다.
	public void run() {
		calculator.setMemory1(100);
	}
}