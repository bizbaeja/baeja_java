package src.LinkedListSet;

import java.util.ArrayList;
import java.util.*;
import java.util.zip.ZipFile;

public class ArrayListExample {
    public static void main(String[] args) {

        // (1) ArrayList 컬렉션 생성을 하고 import 를 한다.
        List<Board> list = new ArrayList<>();

        // (2) 객체를 추가
        list.add(new Board(1, "제목1","내용1","글쓴이1"));
        list.add(new Board(2, "제목2","내용2","글쓴이2"));
        list.add(new Board(3, "제목3","내용3","글쓴이3"));
        list.add(new Board(4, "제목4","내용4","글쓴이4"));
        list.add(new Board(5, "제목5","내용5","글쓴이5"));

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수:" + size);
        System.out.println();

        //특정 인덱스의 객체 가져오기
        //가져오려면 toString 을 Board에 설정해줘야한다.
        Board board = list.get(2);
        System.out.println(board);
        System.out.println();

        // 모든 객체를 하나씩 가져오기
        for(int i=0; i<list.size(); i++){
            Board b = list.get(i);
            System.out.println(b);
        }
        System.out.println();
        // 모든 객체는 생성자로 처음 만들어 졌을 때는 null로 초기화된다.
//        Board{writer='null'}
//        Board{writer='null'}
//        Board{writer='null'}
//        Board{writer='null'}
//        Board{writer='null'}

        // 위에 식을 좀 더 우아하게 만듬
        for(Board b : list){
            System.out.println(b);
        }

        // 타입을 모를 떄는 전역변수  var 를 사용하면 된다.
        for(var b: list){
            System.out.println(b);
        }

        //게시물의 id를 부여했을 때,id의 인덱스가 2인 자료를 찾자
        for(Board b:list) {
            if (b.getId() == 2) {
                break;
            }
        }

        Board board2 = new Board(3);

        if(list.contains(3)){
            int idx = list.indexOf(3);
            if(idx != -1){
                board2 = list.get(idx);
                System.out.println("찾은 자료 ==== ");
                System.out.println(board2);
            }
            System.out.println("아이디가 "+board2.getId()+" 인 자료의 위치 = " + idx);

        } else {
            System.out.println("찾고자 하는 아이디가 존재하지 않습니다. ");
        }

        // 객체 삭제 (권장하지 않음)
        list.remove(2);
            System.out.println("총 객체 수 :"+list.size());
            System.out.println();


        list.remove(2);
            System.out.println("총 객체 수 :"+list.size());
            System.out.println();

        // 향상된 for문으로 모든 객체를 하나씩 가져오기
        for(Board b : list ){
            System.out.println(b);
        }
        System.out.println();

        list.add(new Board(6, "제목6", "내용6","글쓴이6"));
        for(Board b: list){
            System.out.println(b);
        }
        System.out.println();
    }






}
