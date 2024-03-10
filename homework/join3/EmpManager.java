package homework.join3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpManager {
    private Scanner scanner = new Scanner(System.in);
    private Connection conn;

    public EmpManager() {
        this.conn = DBManager.getConnection();
    }

    public void viewAllEmployees() {
        String sql = "SELECT e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.COMM, d.DNAME, d.LOC " +
                "FROM emp e " +
                "INNER JOIN dept d ON e.DEPTNO = d.DEPTNO";

        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("사원번호: " + rs.getInt("EMPNO"));
                System.out.println("이름: " + rs.getString("ENAME"));
                System.out.println("직책: " + rs.getString("JOB"));
                System.out.println("매니저: " + rs.getInt("MGR"));
                System.out.println("입사일: " + rs.getDate("HIREDATE"));
                System.out.println("급여: " + rs.getInt("SAL"));
                System.out.println("커미션: " + rs.getInt("COMM"));
                System.out.println("부서명: " + rs.getString("DNAME"));
                System.out.println("위치: " + rs.getString("LOC"));
                System.out.println("-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee() {
        System.out.println("사원 정보를 입력하세요. (사원번호, 이름, 직책, 매니저번호, 입사일[yyyy-mm-dd], 급여, 커미션, 부서번호)");
        int empno = scanner.nextInt();
        String ename = scanner.next();
        String job = scanner.next();
        int mgr = scanner.nextInt();
        String hiredate = scanner.next();
        int sal = scanner.nextInt();
        int comm = scanner.nextInt();
        int deptno = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 클리어

        String sql = "INSERT INTO emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empno);
            pstmt.setString(2, ename);
            pstmt.setString(3, job);
            pstmt.setInt(4, mgr);
            pstmt.setDate(5, java.sql.Date.valueOf(hiredate));
            pstmt.setInt(6, sal);
            pstmt.setInt(7, comm);
            pstmt.setInt(8, deptno);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("사원 추가가 완료되었습니다.");
            } else {
                System.out.println("사원 추가에 실패하였습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee() {
        System.out.println("수정할 사원의 번호를 입력하세요:");
        int empno = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 클리어

        System.out.println("새로운 직책을 입력하세요:");
        String newJob = scanner.nextLine();

        String sql = "UPDATE emp SET JOB = ? WHERE EMPNO = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newJob);
            pstmt.setInt(2, empno);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("사원의 직책이 업데이트되었습니다.");
            } else {
                System.out.println("사원 직책 업데이트에 실패하였습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        System.out.println("삭제할 사원의 번호를 입력하세요:");
        int empno = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 클리어

        String sql = "DELETE FROM emp WHERE EMPNO = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empno);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("사원이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("사원 삭제에 실패하였습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}