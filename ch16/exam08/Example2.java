package ch16.exam08;

import ch16.exam07.Operator;
import java.util.function.Function;
class Student{
    private String name;
    private int englishScore;
    private int mathScore;

    public Student(String name, int englishScore, int mathScore) {
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }
}
public class Example2 {
    private static Student [] students = {
            new Student("홍길동", 90,96),
            new Student("신용권",95,93),
    };

static <T> double avg(Function<Student, Integer> fun){
    double sum = 0;
    for (Student s: students){
        sum += fun.apply(s);
    }
    return sum/students.length;
}
    public static void main(String[] args) {
        double englishAvg = avg(Student::getEnglishScore);
// avg(a -> s.getMathScore);
        double mathAvg = avg(Student::getMathScore);
        System.out.println("수학평균점수:"+mathAvg);
    }
}
