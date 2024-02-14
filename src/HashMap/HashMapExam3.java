package src.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DTO -> Map으로 대신하여 구현하는 방법
public class HashMapExam3 {

    List<Map<String, String>> array = new ArrayList<Map<String,String>>();

    public void addStudent(String id, String name, String phone) {
        Map<String, String>  map = new HashMap<>();

        map.put("id", id);
        map.put("name", name);
        map.put("phone", phone);

        //배열에 map 객체를 추가한다
        array.add(map);
    }

    public void output() {
        for (var map : array) {
            System.out.println(map);
        }
    }
    //한사람의 객체를 map으로 생성하여 List에 추가하여 관리함
    public static void main(String[] args) {

        HashMapExam3 exam = new HashMapExam3();

        exam.addStudent("1", "강연규", "010-1234-1234");
        exam.addStudent("2", "김혜진", "010-1234-1235");

        exam.output();
    }

}