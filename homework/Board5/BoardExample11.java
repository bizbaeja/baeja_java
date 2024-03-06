package homework.Board5;

import java.sql.*;
import java.util.Scanner;


//1. 메소드의 위치 :  create, read, update, delete, clear, exit 등의 메소드들은, main 메소드 밖에 위치해야 한다.
//2. connection 공유 문제 : static 으로 선언하면 안되고, 멤버 변수로 선언해야한다.
//3. PreparedStatement 재사용 문제 :  create  메소드에서 pstmt1 을 사용하여 데이터를 삽입하는데 이 객체는 한번만 초기화되고있었다. create 호출시에
//새로운 쿼리를 준비해야 한다.
//4. try-catch  블록은 메소드 안에 위치해야 한다.
//5. close() 호출 문제 :  close() 메소드는 finally 블록에서 호출되어야 한다.
public class BoardExample11 {
    //객체를 생성하지 않고 접근할 수 있도록, static 으로 선언
    //캡슐화를 위해 private 으로 선언
    private static Connection conn ;
    private static PreparedStatement pstmt ;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "bituser", "1004");
            System.out.println("연결 성공");
            conn.setAutoCommit(false);
            while (true) {
                System.out.println("1. create 2. read 3. update 4. delete 5. clear 6. exit");
                System.out.print("메뉴 선택: ");
                int menuNo = Integer.parseInt(scanner.nextLine());

                switch (menuNo) {
                    case 1:
                        create();
                        break;
                    case 2:
                        read();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        clear();
                        break;
                    case 6:
                        exit();
                        return;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("연결 끊기");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create() throws SQLException {
        System.out.println("제목: ");
        String btitle = scanner.nextLine();
        System.out.println("내용: ");
        String bcontent = scanner.nextLine();
        System.out.println("작성자: ");
        String bwriter = scanner.nextLine();

        String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate) VALUES (seq_bno.nextval, ?, ?, ?, sysdate)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, btitle);
        pstmt.setString(2, bcontent);
        pstmt.setString(3, bwriter);
        // rowsAffected 는 변경된 행의 수를 리턴한다.
        // 변경된 행의 수가 0보다 크면 commit() 메소드를 호출하여 변경사항을 저장한다.
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            conn.commit();
            System.out.println("게시글이 성공적으로 생성되었습니다.");
        } else {
            conn.rollback();
            System.out.println("게시글 생성에 실패했습니다.");
        }
    }

    public static void read() throws SQLException {
        System.out.println("게시물 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());
        String sql = "SELECT * FROM boards WHERE bno = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bno);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("번호: " + rs.getInt("bno"));
            System.out.println("제목: " + rs.getString("btitle"));
            System.out.println("내용: " + rs.getString("bcontent"));
            System.out.println("작성자: " + rs.getString("bwriter"));
            System.out.println("작성일: " + rs.getDate("bdate"));
        } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }
    }

    public static void update() throws SQLException {
        System.out.println("게시물 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());
        System.out.println("제목: ");
        String btitle = scanner.nextLine();
        System.out.println("내용: ");
        String bcontent = scanner.nextLine();

        String sql = "UPDATE boards SET btitle = ?, bcontent = ? WHERE bno = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, btitle);
        pstmt.setString(2, bcontent);
        pstmt.setInt(3, bno);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            conn.commit();
            System.out.println("게시글이 성공적으로 수정되었습니다.");
        } else {
            conn.rollback();
            System.out.println("게시글 수정에 실패했습니다.");
        }
    }

    public static void delete() throws SQLException {
        System.out.println("게시물 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM boards WHERE bno = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bno);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            conn.commit();
            System.out.println("게시글이 성공적으로 삭제되었습니다.");
        } else {
            conn.rollback();
            System.out.println("게시글 삭제에 실패했습니다.");
        }
    }

    public static void clear() throws SQLException {
        String sql = "DELETE FROM boards";
        pstmt = conn.prepareStatement(sql);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            conn.commit();
            System.out.println("모든 게시글이 성공적으로 삭제되었습니다.");
        } else {
            conn.rollback();
            System.out.println("게시글 삭제에 실패했습니다.");
        }
    }

    public static void exit() {
        System.out.println("프로그램을 종료합니다.");
    }
}