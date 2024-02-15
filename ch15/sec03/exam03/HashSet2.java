package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSet2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 객체 추가
        set.add("태양");
        set.add("수성");
        set.add("금성");
        set.add("지구");
        set.add("화성");

        // 객체를 하나씩 가져와서 처리
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("금성")){
                iterator.remove();
            }
        }
        set.size();

        for (String element : set){
            System.out.println(element);
        }
    }
}
