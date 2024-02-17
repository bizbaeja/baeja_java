package ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//문자 배열일때, Arrays.stream 을 사용
		String[] strArray = { "홍길동", "신용권", "김미나"};
		Stream<String> strStream = Arrays.stream(strArray);
		// 함수로 인해 변화가 일어났기 때문에 다시 다용할 수 없다.
		strStream.forEach(item -> System.out.print(item + ","));
		System.out.println();

		// 정수 배열일 때, 스트림으로 변환하고 싶을 때,
		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		//forEach 는 스트림에서 최종.
		intStream.forEach(item -> System.out.print(item + ","));
		System.out.println();
	}
}