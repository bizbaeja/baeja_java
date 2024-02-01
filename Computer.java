
import java.util.Scanner;

public class Computer {
    public static void main(String[] args) {
        String[] students = {"강연규", "김세현", "김혜진", "박경덕", "박상훈", "박시은", "박종성", "박주영", "백승찬", "안아영", "이민영", "이채은", "임소연", "정혜림", "조성희", "최정민", "황원재", "배자현"};

//        Scanner sc = new Scanner(System.in);
//
//        for(int i = 0; i < students.length; ++i){
//            String name = sc.next();
//            students[i] = name;
//        }

        String[] result = new String[students.length];

        for (int i = 0; i < result.length; ++i) {
            int index = (int)(Math.random() * (students.length - i));
            result[i] = students[index];

            String temp = students[index];
            students[index] = students[students.length - 1 - i];
            students[students.length - 1 - i] = temp;
        }

        for(int i = 0; i< result.length; ++i){
            System.out.println((i + 1) + "번 : " + result[i]);
        }
    }
}
