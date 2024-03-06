package ch20.oracle.sec05;

import java.sql.*;
import java.util.Scanner;

public class InstatseExample {
    // 인스턴스 변수로 선언
    private Connection conn;
    private PreparedStatement pstmt;
    private Scanner scanner;

    public InstatseExample() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "bituser", "1004");
        this.scanner = new Scanner(System.in);
    }

    public void menu() throws SQLException {
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
    }

    public void create() throws SQLException {
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
        pstmt.executeUpdate();
    }

    // read, update, delete, clear 메소드 구현
    public void read() throws SQLException{
        String sql = "SELECT * FROM boards";
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("bno") + " | " + rs.getString("btitle") + " | " + rs.getString("bcontent") + " | " + rs.getString("bwriter") + " | " + rs.getDate("bdate"));
        }
    }
    public  void update() throws SQLException {
        System.out.println("수정할 글 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());
        System.out.println("수정할 제목: ");
        String btitle = scanner.nextLine();
        System.out.println("수정할 내용: ");
        String bcontent = scanner.nextLine();
        String sql = "UPDATE boards SET btitle = ?, bcontent = ? WHERE bno = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, btitle);
        pstmt.setString(2, bcontent);
        pstmt.setInt(3, bno);
        pstmt.executeUpdate();
    }
    public void delete() throws SQLException {
        System.out.println("삭제할 글 번호: ");
        int bno = Integer.parseInt(scanner.nextLine());
        String sql = "DELETE FROM boards WHERE bno = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bno);
        pstmt.executeUpdate();
    }
    public void clear() throws SQLException {
        String sql = "DELETE FROM boards";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }
    public void exit() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public static void main(String[] args) {
        try {
            InstatseExample board = new InstatseExample();
            board.menu();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}