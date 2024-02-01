package ch07.sec10.exam01;

/*
 * 1. 추상클래스를 이용하여 객체를 생성할 수 없다 
 * 2. 추상클래스를 상속받은 클래스로는 객체를 생성할 수 있다  
 * */
public class PhoneExample {
	public static void main(String[] args) {
//		Phone phone = new Phone();

//		SmartPhone smartPhone = new SmartPhone("홍길동");
		Phone smartPhone = new SmartPhone("홍길동");

		smartPhone.turnOn();
		//smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}