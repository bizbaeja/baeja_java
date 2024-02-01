package ch06.sec10.exam03;

public class Car {
	//인스턴스 필드 선언
	int speed;
	
	static int cnt = 0; 

	//인스턴스 메소드 선언
	void run() {
		System.out.println(cnt);
		System.out.println(speed + "으로 달립니다.");
	}

	static void simulate() {

		System.out.println(cnt);
		
//		speed = 10;
//		run();
		
		//객체 생성
		Car myCar = new Car();
		//인스턴스 멤버 사용
		myCar.speed = 200;
		myCar.run();
	}

	static void simulate(Car myCar) {
		//인스턴스 멤버 사용
		myCar.speed = 200;
		myCar.run();
		
		simulate();
	}
	
	public static void main(String[] args) {
		//정적 메소드 호출
		Car.simulate();
		simulate();
		
		simulate(new Car());
		
		//객체 생성
		Car myCar = new Car();
		//인스턴스 멤버 사용
		myCar.speed = 60;
		myCar.run();
	}
}