package ch17.sec01.exam01;

import java.util.*;
import java.util.stream.Stream;

public class Streamex {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();

        array.add("아이브");
        array.add("블랙핑크");
        array.add("여자아이들");
        array.add("르세라핌");
        array.add("뉴진스");

        for (int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }

        for (String name : array){
            System.out.println(name);
        }

        Set<String> idol = new HashSet<>();
        idol.add("전소미");
        idol.add("에스파");
        idol.add("BTS");

        Iterator<String> it = idol.iterator();
        while (it.hasNext()){
            String name = it.next();
            System.out.println(name);

        }
//클래스 이름과 java.util.stream.Stream 인터페이스 이름이 충돌하기 때문입니다.
// 여기서 사용한 Stream은 java.util.stream.Stream 인터페이스를 가리키려고 했지만,
        //1. 패키지를 import 해야함
        //2. 인터페이스와 타입이 일치해야함
// 같은 이름의 현재 클래스(Stream)를 가리키게 되어서 발생하는 문제입니다.
        // -> 파일명 고침
       // java.util.stream.Stream<String> stream = idol.stream();
        Stream<String> stream = idol.stream();
        stream.forEach(s -> System.out.println(s));

    }



}
