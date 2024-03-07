package homework.setp1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
 * java, jdbc를 분리하려고 함
 *
 */
public class BoardExam10 {
    // Field
    private Scanner scanner = new Scanner(System.in);
    //참조 변수 선언
    //boardDao 객체를 생성하지 않고, 외부에서 주입받는다.
    BoardDAO boardDAO;


    // Constructor
    public BoardExam10(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
//        this.mainMenu();
    }

    // Method
    public void list() {

        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------------------");

        List<Board> list = boardDAO.list();
        for (Board board : list) {
            board.print();
        }

        if (list.size() == 0) {
            System.out.println("게시물의 자료가 존재하지 않습니다");
        }

        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    public void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        // 할일 : 제목 입력
        String title = scanner.nextLine();
        System.out.print("내용: ");
        // 할일 : 내용 입력
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        // 할일 : 작성자 입력
        String writer = scanner.nextLine();

        // 할일 : 보조 메뉴 출력
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            int updated = boardDAO.insert(new Board(title, content, writer));
            // 변경된 건 수
            System.out.println("변경 건수  : " + updated);
        }

        // 게시물 목록 출력
        list();
    }

    public void read() {

        // 게시물 번호 입력
        int bno = Integer.parseInt(scanner.nextLine());
        // 할일 : 입력된 게시물 번호를 이용하여 게시물 목록에서 자료를 찾아 출력한다

        Board b = boardDAO.read(bno);

        System.out.println(b.getBno());
        System.out.println(b.getBtitle());
        System.out.println(b.getBcontent());
        // 아래 구문이 동작할 수 있게 기능 추가
        // select * from boards where bno = ?id


        if (bno != -1) {
            // 보조 메뉴 출력
            System.out.println("-------------------------------------------------------------------");
            System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
            System.out.print("메뉴 선택: ");
            String menuNo = scanner.nextLine();
            System.out.println();

            switch (menuNo) {
                case "1" -> update(bno);
                case "2" -> delete(bno);
                case "3" -> list();
            }
        }

    }

    public void update(int bno) {

        // bno 를 통해 게시물을 찾아서 출력
        // 수정할 내용을 입력 받는다
        Board updateBoard = boardDAO.read(bno);
        if (updateBoard == null) {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
            return;
        }
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        // 할일 : 제목 입력
        String title = scanner.nextLine();
        System.out.print("내용: ");
        // 할일 : 내용 입력
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        // 할일 : 작성자 입력
        String writer = scanner.nextLine();

        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        // 아래 구문이 동작할 수 있게 기능 추가
        // update 구문 완성해서 구현 해주세요

        // 게시물 목록 출력
       list();
    }

    public void delete(int bno) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요
        System.out.println("삭제 번호  : " );


        String menuNo = scanner.nextLine();

            int deleted = boardDAO.delete(bno);
            // 변경된 건 수
            System.out.println("삭제 내용  : " + deleted);


        // 게시물 목록 출력
        list();
    }

    public void clear() {
        System.out.println("[게시물 전체 삭제]");
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요

        int clearBoard = boardDAO.clear();
        System.out.println("삭제 건수  : " + clearBoard);
        // 게시물 목록 출력
        list();
    }

    public void exit() {
        System.out.println("프로그램 종료");

        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExam10 boardExample = new BoardExam10(new BoardDAO());
        boardExample.list();
    }
}
