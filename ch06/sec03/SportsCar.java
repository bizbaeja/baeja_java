package ch06.sec03;

//클래스 정의 
class 사람 {
	//속성 : 필드 
	String 이름;
	int    나이;
	//동작 : 메소드, 함수 
	void 웃다() {
		System.out.println(이름 + "이 웃는다");
	}
	
	void 먹다() {
		System.out.println(이름 + "이 ~~~ 먹는다");
	}
}

class 자동차 {
	//속성 : 필드 
	String 색깔;
	int    속도;
	//동작 : 메소드, 함수 
	void 달린다() {
		System.out.println(색깔 + "의 차가 달린다");
	}
	
	void 멈춘다() {
		System.out.println(색깔 + "의 차가 멈춘다");
	}
}

public class SportsCar {
	public static void main(String [] ar) {
		//객체 생성 
		사람 홍길동 = new 사람();
		자동차 a = new 자동차();
		
		사람.class.getName();//클래스의 이름
		자동차.class.getName();//클래스의 이름
		
		//속성을 설정 
		홍길동.이름 = "홍길동";
		홍길동.나이 = 10;
		a.색깔 = "빨간색";
		a.속도 = 100;
		
		//동작, 메소드를 호출 
		홍길동.웃다();
		
		a.달린다();
		a.멈춘다();
	}
	
}

class Tire {
}