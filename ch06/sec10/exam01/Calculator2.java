package ch06.sec10.exam01;

public class Calculator2 {
	static double pi = 3.14159;
	String name;
	
	static int plus(int x, int y) {
		//멤버 변수 또는 멤버 메소드를 사용하지 않는 경우
		//static 메소드에서는 this 키워드를 사용할 수 없다
		Math.random();
		return (int)((x + y) * pi);
	}
	
	int minus(int x, int y) {
		return x - y;
	}
}