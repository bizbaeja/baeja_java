package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
	public static int sum;

	//
	public static void main(String[] args) {
		//람다구문안에서 사용하는 변수들은 반드시 final이다. 그래서 전역변수를 만들어주는게 제일 좋은 방법이다.
		IntStream stream = IntStream.range(1, 100);
		stream.forEach(a -> System.out.println(a));



	//	IntStream stream = IntStream.rangeClosed(1, 100);
	//	stream.forEach(a -> sum += a);
	//	System.out.println("총합: " + sum);
	}
}