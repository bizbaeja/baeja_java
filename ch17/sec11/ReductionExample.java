package ch17.sec11;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("감자바", 88)
		);		
		//방법1
		//이 부분은 Student 객체의 스트림을 int 스트림으로 변환합니다. mapToInt는 각 Student 객체를 받아 그 객체의 점수(getScore 메서드의 결과)를 int 값으로 매핑합니다.
		//매핑된 int 스트림에 대해 sum 연산을 수행하여 모든 점수의 합을 계산합니다. sum은 스트림 API의 최종 연산으로, 모든 int 값들을 더한 결과를 반환합니다.
		int sum1 = studentList.stream()
				.mapToInt(Student :: getScore)
				.sum();		
		//방법2
		//이 부분은 각 Student 객체를 그 객체의 점수로 변환합니다. 여기서 map 메서드는 객체 스트림을 다른 형태의 객체 스트림으로 변환합니다.
		// 결과적으로, 이 연산은 Student 객체의 스트림을 Integer 객체의 스트림으로 변환합니다.
		//reduce 연산은 스트림의 모든 요소를 하나의 결과로 결합합니다. 여기서 제공된 초기 값은 0이고, 람다 표현식 (a, b) -> a+b는 두 점수를 더하는 방법을 정의합니다.
		// 즉, 스트림의 모든 요소(점수들)를 순차적으로 더합니다.

		int sum2 = studentList.stream()
						.map(Student :: getScore)
						.reduce(0, (a, b) -> a+b);

		int [] arr = {10,30,20,50};
		int sum = 0;//초기식
		for(int v: arr){
			sum = sum +v;
		}
		
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
	}
}