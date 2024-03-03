package homework.Board2;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardExample10 {
    //Field
    private Scanner scanner = new Scanner(System.in);
    //할일 : 게시물 정보를 저장 할 수 있는 배열을 선언한다
    private ArrayList<Board> boardList = new ArrayList<>();
    private int boardCount = 0;
    //Constructor

    //Method
    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------------------");

        for (Board board : boardList) {
            System.out.printf("%-6d%-12s%-16s%-40s\n",
                    board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
        }

        mainMenu();
    }

    public void mainMenu() {
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Delete | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch(menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> delete(); // 메뉴에 delete 추가
            case "4" -> exit();
        }
    }

    public void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        String writer = scanner.nextLine();

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
           System.out.println();
        if(menuNo.equals("1")) {
            boardCount++; // 게시물 번호 증가
            Board newBoard = new Board(boardCount, title, content, writer);
            boardList.add(newBoard);
        }
        // 게시물 목록 출력
        list();
    }

    public void read() {
        int bno = 0;
        while (true) {
            System.out.println("[게시물 읽기]");
            System.out.print("bno: ");
            String input = scanner.nextLine();

            try {
                bno = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                if (input.isEmpty()) {
                    System.out.println("게시물 번호가 입력되지 않았습니다. 다시 입력해주세요.");
                } else {
                    System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
                }
            }
        }

        Board foundBoard = null;
        for (Board board : boardList) {
            if (board.getBno() == bno) {
                foundBoard = board;
                break;
            }
        }

        if (foundBoard != null) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("번호: " + foundBoard.getBno());
            System.out.println("제목: " + foundBoard.getBtitle());
            System.out.println("내용: " + foundBoard.getBcontent());
            System.out.println("작성자: " + foundBoard.getBwriter());
            System.out.println("작성일: " + foundBoard.getBdate());
            System.out.println("-----------------------------------------------------------------------");
        } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }
        mainMenu(); // 게시물을 읽고 나서 메인 메뉴로 돌아갑니다.
    }

    public void update() {
        //수정 내용 입력 받기
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        //할일 : 제목 입력
        scanner.nextLine();
        System.out.print("내용: ");
        //할일 : 내용 입력
        scanner.nextLine();
        System.out.print("작성자: ");
        //할일 : 작성자 입력
        scanner.nextLine();

        //보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        //할일 : 입력된 정보를 기준으로 게시물 정보 수정한다
        System.out.println("[게시물 수정]");
        System.out.print("수정할 게시물 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());

        Board foundBoard = null;
        for (Board board : boardList) {
            if (board.getBno() == bno) {
                foundBoard = board;
                break;
            }
        }

        if (foundBoard != null) {
            System.out.print("새 제목: ");
            foundBoard.setBtitle(scanner.nextLine());
            System.out.print("새 내용: ");
            foundBoard.setBcontent(scanner.nextLine());
            System.out.println("게시물이 수정되었습니다.");
        } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }

        list();
        mainMenu();
    }

    public void delete() {
        System.out.println("[게시물 삭제]");
        System.out.print("삭제할 게시물 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());

        Board foundBoard = null;
        int foundIndex = -1;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBno() == bno) {
                foundBoard = boardList.get(i);
                foundIndex = i;
                break;
            }
        }

        if (foundBoard != null) {
            boardList.remove(foundIndex);
            System.out.println("게시물이 삭제되었습니다.");
        } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }

        list();
        mainMenu();
    }
    public void clear() {
        //할일 : 게시물 전체 삭제 기능 구현
        System.out.println("[게시물 전체 삭제]");
        boardList.clear();
        System.out.println("모든 게시물이 삭제되었습니다.");
        list();

        //게시물 목록 출력
        list();
        mainMenu();
    }
    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample10 boardExample = new BoardExample10();
        boardExample.list();
    }
}