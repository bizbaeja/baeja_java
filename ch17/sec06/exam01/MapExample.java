package ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
	//mapXXx 는 Type 을 말함.
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 85));
		studentList.add(new Student("홍길동", 92));
		studentList.add(new Student("홍길동", 87));

		//아래와 같은 루틴
		for(var student: studentList){
			System.out.println(student.getScore());
		}
		//Student를 score 스트림으로 변환
		studentList.stream()
						.mapToInt(s-> s.getScore())
						.forEach(s-> System.out.println(s));

		studentList.stream()
			.mapToInt(Student::getScore)
			.forEach(System.out::println);
	}
}