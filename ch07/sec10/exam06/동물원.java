package ch07.sec10.exam06;

class 동물 {
	public void 운다() {
		
	}
}

class Dog extends 동물 {
	private void 강아지울다() {
		System.out.println("멍멍");
	}
	public void 운다() {
		강아지울다();
	}
}

class Cat extends 동물 {
	private void 고양이울다() {
		System.out.println("야옹");
	}
	public void 운다() {
		고양이울다();
	}
}

//OCP : Open : 새로운 기능, Close : 기존 코드 수정 없음  
//동물원에 사자 추가 하기위해 사자 클래스 생성 : Open  

//Open : 새로운 기능
class 사자 extends 동물 {
	public void 운다() {
		System.out.println("어흥~~~ ");
	}
}

public class 동물원 {
	private 동물 [] 배열 = new 동물 [100];  
	private int count = 0;
	
//	private 사자 라이언 = new 사자();// 추가됨 -> OCP 위배
	
	public void 동물추가(동물 obj) {
		if (count < 100) {
			배열[count++] = obj;
		}
	}

	public void 동물들이모두운다() {
		for (int i=0;i<count;++i) {
			배열[i].운다();
		}
//		라이언.사자가운다();// 추가됨 -> OCP 위배 
	}
}


//기능 추가 : 동물원에 사자 추가시 결과 코드 : ch07.sec10.exam06
