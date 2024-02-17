package ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyExample {
    public static void main(String[] args) {
        //배열에 요소 삽입
        List<Product> mylist = new ArrayList<>();

        for(int i=1;i<=5;i++){
            mylist.add(new Product(i, "립밤"+i,"키엘",(int)(1000*Math.random())));
        }

        // 배열을 스트림에서 얻어서 화면에 출력하기
        for(var product : mylist){
            System.out.println(product);
        }

        //객체 스트림 얻기
        Stream<Product> stream = mylist.stream();
        stream.forEach(s->System.out.println(s));
    }
}
