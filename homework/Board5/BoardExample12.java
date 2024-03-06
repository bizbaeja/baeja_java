package homework.Board5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample12 {
    //Field
    private Scanner scanner = new Scanner(System.in);

    //Constructor

    //Method
    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------------------");
        // 아래 구문이 동작할 수 있게 기능 추가
        // select * from boards

        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );

            System.out.println("연결 성공");

            PreparedStatement pstmt = conn.prepareStatement("select * from boards");
            ResultSet rs = pstmt.executeQuery();
            boolean bExistData = false;

            while(rs.next()) {
                bExistData = true;

                //찾고자 하는 자료가 있음
                String bno = rs.getString("bno");
                String btitle = rs.getString("btitle");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getString("bdate");

                System.out.println("bno : " + bno);
                System.out.println("btitle : " + btitle);
                System.out.println("bcontent : " + bcontent);
                System.out.println("bwriter : " + bwriter);
                System.out.println("bdate : " + bdate);
                System.out.println("====================\n");
            }

            if (!bExistData) {
                System.out.println("게시물의 자료가 존재하지 않습니다");
            }

            rs.close();
            pstmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
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

        switch(menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    public void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        //할일 : 제목 입력
        String title = scanner.nextLine();
        System.out.print("내용: ");
        //할일 : 내용 입력
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        //할일 : 작성자 입력
        String writer = scanner.nextLine();

        //할일 : 보조 메뉴 출력
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if(menuNo.equals("1")) {

            // 아래 구문이 동작할 수 있게 기능 추가
            //  insert into boards (
            //    bno, btitle, bcontent, bwriter, bdate
            //  ) values (
            //    seq_bno.nextval, ?, ?, ?, sysdate
            //  )

            Connection conn = null;
            try {
                //JDBC Driver 등록
                Class.forName("oracle.jdbc.OracleDriver");

                //연결하기
                conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521/xe",
                        "bituser", //계정이름
                        "1004" //계정비밀번호
                );

                System.out.println("연결 성공");

                PreparedStatement pstmt = conn.prepareStatement("insert into boards (bno, btitle, bcontent, bwriter, bdate) values (seq_bno.nextval, ?, ?, ?, sysdate)");

                //입력 값을 설정 한다
                pstmt.setString(1, title);
                pstmt.setString(2, content);
                pstmt.setString(3, writer);

                int updated = pstmt.executeUpdate();
                //변경된 건 수
                System.out.println("변경 건수  : " + updated);

                pstmt.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(conn != null) {
                    try {
                        //연결 끊기
                        conn.close();
                        System.out.println("연결 끊기");
                    } catch (SQLException e) {}
                }
            }

        }

        //게시물 목록 출력
        list();
    }

    public void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        //게시물 번호 입력
        int bno = Integer.parseInt(scanner.nextLine());

        // 아래 구문이 동작할 수 있게 기능 추가
        //select * from boards where bno = ?

        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );

            System.out.println("연결 성공");

            PreparedStatement pstmt = conn.prepareStatement("select * from boards where bno=?");

            //입력 값을 설정 한다
            pstmt.setInt(1, bno);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                //찾고자 하는 자료가 있음
                bno = rs.getInt(1);
                String btitle = rs.getString(2);
                String bcontent = rs.getString(3);
                String bwriter = rs.getString(4);
                String bdate = rs.getString(5);

                System.out.println("bno : " + bno);
                System.out.println("btitle : " + btitle);
                System.out.println("bcontent : " + bcontent);
                System.out.println("bwriter : " + bwriter);
                System.out.println("bdate : " + bdate);
                System.out.println("====================\n");

            } else {
                //찾고자 하는 자료가 없음
                System.out.println("[" + bno + "] 에 대한 자료가 존재하지않습니다 ");
                bno = -1;
            }
            rs.close();
            pstmt.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }

        if (bno != -1) {
            //보조 메뉴 출력
            System.out.println("-------------------------------------------------------------------");
            System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
            System.out.print("메뉴 선택: ");
            String menuNo = scanner.nextLine();
            System.out.println();

            switch(menuNo) {
                case "1" -> update(bno);
                case "2" -> delete(bno);
                case "3" -> list();
            }
        }


//      if (findBoard != null) {
//         System.out.printf("%-6s%-12s%-16s%-40s \n"
//         , board.getBno()
//         , board.getBtitle()
//         , board.getBdate()
//         , board.getBcontent());
//         findBoard.printDetail();

//         //보조 메뉴 출력
//         System.out.println("-------------------------------------------------------------------");
//         System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
//         System.out.print("메뉴 선택: ");
//         String menuNo = scanner.nextLine();
//         System.out.println();
//
//         switch(menuNo) {
////         case "1" -> update(findBoard);
////         case "2" -> delete(findBoard);
//         case "3" -> list();
//         }
//      }
    }

    public void update(int bno) {
        //수정 내용 입력 받기
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        //할일 : 제목 입력
        String title = scanner.nextLine();
        System.out.print("내용: ");
        //할일 : 내용 입력
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        //할일 : 작성자 입력
        String writer = scanner.nextLine();

        //보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        // 아래 구문이 동작할 수 있게 기능 추가
        // update 구문 완성해서 구현 해주세요


        //게시물 목록 출력
        list();
    }

    public void delete(int bno) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );

            PreparedStatement pstmt = conn.prepareStatement("delete from boards where bno=?");

            //입력 값을 설정 한다
            pstmt.setInt(1, bno);

            int updated = pstmt.executeUpdate();

            pstmt.close();
            //변경된 건 수
            System.out.println("삭제 건수  : " + updated);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }

        //게시물 목록 출력
        list();
    }

    public void clear() {
        System.out.println("[게시물 전체 삭제]");
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );

            PreparedStatement pstmt = conn.prepareStatement("delete from boards");

            int updated = pstmt.executeUpdate();

            pstmt.close();
            //변경된 건 수
            System.out.println("삭제 건수  : " + updated);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }

        //게시물 목록 출력
        list();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample12 boardExample = new BoardExample12();
        boardExample.list();
    }

}
