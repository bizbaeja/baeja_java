package ch15.sec03.exam02;

import java.util.HashSet;
import java.util.Set;

public class ExerciseHashSet {
    public static void main(String[] args) {
        //1 HashSet 컬렉션 생성
        Set<Member> set = new HashSet<>();

        //Member 객체 저장
        set.add(new Member("배자현",28));
        set.add(new Member("배땃쥐",15));

        System.out.println("총 객체 수 :" +set.size());
    }

}
