package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamPipeLineExample2 {
	// 상수형 배열 asList 데이터 변경이 안된다.
	public static void main(String[] args) {
//		List<Student> list = Arrays.asList(
//				new Student("홍길동", 10),
//				new Student("신용권", 20),
//				new Student("유미선", 30)
//				);
	//list.add(new Student("홍길동",10));
		//방법1
		/*
 		Stream<Student> studentStream = list.stream();
 		//중간 처리(학생 객체를 점수로 매핑)반환하는 값도 정수형 스트림 형이다.
 		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
		//최종 처리(평균 점수) 안에있는 데이터가 무었인지 모르기 때문에 더블형 데이터로 뽑는것임
 		double avg = scoreStream.average().getAsDouble();
		*/

//		//방법2
//		double avg = list.stream()
//				.mapToInt(student -> student.getScore())
//				.average()
//				.getAsDouble();
//
//		System.out.println("평균 점수: " + avg);


		// 함수에 인자로 넘길때는 반드시 뉴 객체로 넘겨야한다.
		IntStream stream = Arrays.stream(new int []{10,20,30,40,50});
// 이때 forEach 는 최종이다
		stream.forEach(System.out::println);
	}
}