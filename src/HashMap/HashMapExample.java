package src.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("map이 비었는지:"+ map.isEmpty());

        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("Map이 비엇는지 : " + map.isEmpty());
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
        //키로 값 얻기
        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key+ ":"+ value);

        if(map.containsKey("홍길동1")){
            value = map.get("홍길동1");
            System.out.println(key+ ":"+ value);

        }else{
            System.out.println(key+"이 존재하지 않습니다.");
        }
//키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<String> KeySet = map.keySet();
        Iterator<String> KeyIterator = KeySet.iterator();
        while (KeyIterator.hasNext()){
            String k = KeyIterator.next();
            int v = map.get(k);
            System.out.println(k + ":" + v);
        }
 // 많이 사용하는 코드

    }

}
