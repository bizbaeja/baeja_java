package homework.join3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeptManager {
    private Connection conn;
    private Scanner scanner;

    public DeptManager() {
        this.conn = DBManager.getConnection();
        this.scanner = new Scanner(System.in);
    }

    public void addDepartment() {
        System.out.println("부서 정보를 입력하세요. (부서번호 부서명 위치)");
        int deptno = scanner.nextInt();
        String dname = scanner.next();
        String loc = scanner.next();

        String sql = "INSERT INTO dept (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, deptno);
            pstmt.setString(2, dname);
            pstmt.setString(3, loc);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("부서가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("부서 추가에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewDepartmentDetails() {
        System.out.println("조회할 부서 번호를 입력하세요.");
        int deptno = scanner.nextInt();

        String sql = "SELECT * FROM dept WHERE DEPTNO = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, deptno);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("부서번호: " + rs.getInt("DEPTNO"));
                    System.out.println("부서명: " + rs.getString("DNAME"));
                    System.out.println("위치: " + rs.getString("LOC"));
                } else {
                    System.out.println("해당 부서를 찾을 수 없습니다.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllDepartments() {
        String sql = "DELETE FROM dept";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("모든 부서가 삭제되었습니다.");
            } else {
                System.out.println("부서 삭제에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}