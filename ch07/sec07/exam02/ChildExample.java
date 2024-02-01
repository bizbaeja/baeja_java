package ch07.sec07.exam02;

public class ChildExample {
	public static void main(String[] args) {
		//자식 객체 생성
		Child child = new Child();
		child.method2();

		//자동 타입 변환
		Parent parent = new Parent();
		parent.method2();
//
		parent = child;
		parent.method1(); // 부모 
		parent.method2(); // 자식 
		//parent.method3();  //호출 안됨 
		
//		//메소드 호출
//		parent.method1();
//		parent.method2();
//		//parent.method3(); (호출 불가능)
	}
}