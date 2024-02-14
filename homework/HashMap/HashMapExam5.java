package homework.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 배열에서 자료를 찾는 방법
 */
public class HashMapExam5 {

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

    public boolean findName(String name) {
        for (Map<String, String> student : array) {
            if (name.equals(student.get("name"))) {
                //원하는 자료 찾음
                System.out.println(student);
                return true;
            }
        }
        return false;
    }

    public boolean findId(String id) {
        for (Map<String, String> student : array) {
            if (id.equals(student.get("id"))) {
                //원하는 자료 찾음
                System.out.println(student);
                return true;
            }
        }
        return false;
    }
    //한사람의 객체를 map으로 생성하여 List에 추가하여 관리함
    public static void main(String[] args) {

        HashMapExam5 exam = new HashMapExam5();

        for (int i=0;i<10000;i++) {
            //exam.addStudent("" + i, "홍길동", "010-1234-1234");
            //exam.addStudent(String.valueOf(i), "홍길동" + i, "010-1234-1234");
            exam.addStudent(String.valueOf(i), "홍길동" + String.valueOf(i), "010-1234-1234");
        }

//      exam.output();
        //찾을 자료
        //String name = "홍길동9000";//, "홍길동10";
        String id = "9000";

        //이름을 이용하여 배열에서 자료를 찾는 코드
        //검색 시간을 출력할 것
        //System.currentTimeMillis(),System.nanoTime()
        long tick = System.nanoTime();
        exam.findName("홍길동9000");
        tick = System.nanoTime() - tick;
        System.out.println("실행 시간 : " + tick);

        tick = System.nanoTime();
        exam.findName("홍길동10");
        tick = System.nanoTime() - tick;
        System.out.println("실행 시간 : " + tick);

        tick = System.nanoTime();
        exam.findId("9000");
        tick = System.nanoTime() - tick;
        System.out.println("실행 시간 : " + tick);

        tick = System.nanoTime();
        exam.findId("10");
        tick = System.nanoTime() - tick;
        System.out.println("실행 시간 : " + tick);
    }

}