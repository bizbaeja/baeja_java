package src.HashMap;

import jdk.jfr.DataAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//1 Student 클래스 만들기
class Student {
    private static int nextId = 1;

    private int id;
    private String name;
    private String phone;
    private int score;
    //생성자 로직 추가

    public Student(String name, String phone){
        super();
        this.id = nextId++;
        this.name = name;
        this.phone = phone;
        this.score = 0;
    }
    // id 에 대한 유일성을 보장하기 위해 equals 함수와 hashCode 검증 추가
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
@DataAmount
public class HashMapExam {
    public void listExam(){
        List<Student> array = new ArrayList<>();

        array.add(new Student("강연규","010-1234-1234"));
        array.add(new Student("김혜진","010-1234-1235"));
        array.add(new Student("박경덕","010-1234-1236"));
        array.add(new Student("박상훈","010-1234-1237"));
        array.add(new Student("박상훈","010-1234-1237"));
    }
}
