package ch14.sec06.exam01;

public class User2Thread extends Thread {
	private Calculator calculator;
	
	public User2Thread() {
		setName("User2Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	// setMemory2 메소드를 호출하여 memory 필드에 50을 저장하고 2초간 일시 정지시킨다.
	public void run() {
		calculator.setMemory2(50);
	}
}