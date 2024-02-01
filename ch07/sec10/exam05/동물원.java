package ch07.sec10.exam05;

/*
class Dog  {
	public void 강아지울다() {
		System.out.println("멍멍");
	}
}

class Cat {
	public void 고양이울다() {
		System.out.println("야옹");
	}
}
*/

/*
class 사자 {
	public void 사자가운다() {
		System.out.println("어흥~~~");
	}
}
*/
//의존성 역전 원칙
//다형성, 상속성을 사용하여 구현함 


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


public class 동물원 {
//	private 동물 멍멍이 = new Dog();
//	private 동물 야옹이 = new Cat();
	private 동물 [] 배열 = new 동물 [100];  
	private int count = 0;
	
//	private 사자 라이언 = new 사자();// 추가됨 -> OCP 위배
	
	public void 동물추가(동물 obj) {
		if (count < 100) {
			배열[count++] = obj;
		}
	}

	public void 동물들이모두운다() {
//		멍멍이.운다();
//		야옹이.운다();
		for (int i=0;i<count;++i) {
			배열[i].운다();
		}
//		라이언.사자가운다();// 추가됨 -> OCP 위배 
	}
}


//기능 추가 : 동물원에 사자 추가시 결과 코드 : ch07.sec10.exam06
