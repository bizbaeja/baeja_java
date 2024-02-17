package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5};
		//Integer 는 Object 타입
		//참조계수 refCnt
		Integer num = 10;
		String str1 = "hello"; //refCnt :1
		String str2 = str1; // refCnt :2
		String str3 = str1; // refCnt :3

		str3 = null ; // refCnt :2 감소
		str2 = null ; //  refCnt :1 감소
		str1 = null ; //  refCnt :0 감소 잠시 후 가비지 컬렉터에 의해 메모리 해제됨

		System.out.println(str1);

		IntStream intStream = Arrays.stream(intArray);
		intStream
			.asDoubleStream() //정수를 실수로 매핑
			.forEach(d -> System.out.println(d));
			
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		intStream
			.boxed()
			.forEach(obj -> System.out.println(obj.intValue()));
	}
}