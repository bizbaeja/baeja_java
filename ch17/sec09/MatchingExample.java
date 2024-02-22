package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {
	public static void main(String[] args) {
		//Predicate는 함수형 인터페이스로, 하나의 입력값에 대해 boolean 값을 반환하는 함수
		int[] intArr = { 2, 4 ,6 };
		//주어진 조건을 만족하는지 여부
		boolean result = Arrays.stream(intArr)
				//a -> a%2==0는 Predicate 매개변수
			.allMatch(a -> a%2==0);
//and 연산자로 모든 요소가 주어진 조건을 만족하는지를 표현하는
//스트림을 이용하면 심플해짐

//		boolean result2 = false;
//		for(int v : intArr ){
//			if(v % 2 == 0){
//				result2 = true;
//				break;
//			}
//		}
//		if(result2) {
//			System.out.println("모든 값은 짝수 입니다.");
//		}else {
//			System.out.println("모든 값은 짝수가 아닙니다.");
//		}
//
//boolean result2 = false;
//for(int v: intArr){
//	if(v % 3 == 0 ){
//		result2 = true;
//		break;
//	}
//}
		System.out.println("모두 2의 배수인가? " + result);
		//요소 중 적어도 하나가 주어진 조건을 만족
		result = Arrays.stream(intArr)
			.anyMatch(a -> a%3==0);
		System.out.println("하나라도 3의 배수가 있는가? " + result);
		//모든 요소들이 주어진 조건을 만족하지 않는지
		result = Arrays.stream(intArr)
			.noneMatch(a -> a%3==0);
		System.out.println("3의 배수가 없는가?  " + result);
	}
}
