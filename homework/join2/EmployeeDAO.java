package homework.join2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAO {

    private static Connection conn = null;
    private static PreparedStatement employeeListPstmt;
    private  static PreparedStatement employeeInsertPstmt;
    private static PreparedStatement employeeUpdatePstmt;
    private static PreparedStatement employeeDetailPstmt;
    private static PreparedStatement employeeDeletePstmt;
    private  static PreparedStatement employeeDeleteAllPstmt;
    private static PreparedStatement employeeValidationDeptnoPstmt;
    private static PreparedStatement employeeValidationPasswordPstmt;

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "1004"
            );
            System.out.println("연결 성공");
            conn.setAutoCommit(false);

            employeeListPstmt = conn.prepareStatement("SELECT * FROM emp");
            employeeDetailPstmt = conn.prepareStatement("SELECT * FROM emp WHERE empno = ?");
            employeeInsertPstmt = conn.prepareStatement("INSERT INTO emp (ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, NOW(), ?, ?, ?)");
            employeeUpdatePstmt = conn.prepareStatement("UPDATE emp SET ename = ?, job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? WHERE empno = ?");
            employeeDeletePstmt = conn.prepareStatement("DELETE FROM emp WHERE empno = ?");
            employeeDeleteAllPstmt = conn.prepareStatement("DELETE FROM emp");
            employeeValidationDeptnoPstmt = conn.prepareStatement("SELECT empno FROM emp WHERE empno = ?");
            employeeValidationPasswordPstmt = conn.prepareStatement("SELECT ename FROM emp WHERE ename = ?");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> list() {
        List<Employee> list = new ArrayList<>();
        try {
            ResultSet rs = employeeListPstmt.executeQuery();
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getInt("sal"),
                        rs.getInt("comm"),
                        rs.getInt("deptno")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Employee read(int empno) {
        try {
            employeeDetailPstmt.setInt(1, empno); // 문자열 ID를 사용
            ResultSet rs = employeeDetailPstmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getInt("sal"),
                        rs.getInt("comm"),
                        rs.getInt("deptno")
                );
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int update(Employee employee) {
        int updated = 0;
        try {
            employeeUpdatePstmt.setString(1, employee.getEmpno());
            // ... 나머지 파라미터 설정 ...
            updated = employeeUpdatePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
        return updated;
    }

    public int insert(Employee employee) {
        int updated = 0;
        try {
            // ... 파라미터 설정 ...
            updated = employeeInsertPstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
        return updated;
    }

    private void rollback() {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public int delete(int empno) {
        try {
            employeeDeletePstmt.setInt(1, empno);
            employeeDeletePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int clear() {
        try {
            employeeDeleteAllPstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void close() {
        try {
            if (employeeListPstmt != null) employeeListPstmt.close();
            if (employeeInsertPstmt != null) employeeInsertPstmt.close();
            if (employeeUpdatePstmt != null) employeeUpdatePstmt.close();
            if (employeeDetailPstmt != null) employeeDetailPstmt.close();
            if (employeeDeletePstmt != null) employeeDeletePstmt.close();
            if (employeeDeleteAllPstmt != null) employeeDeleteAllPstmt.close();
            if (employeeValidationDeptnoPstmt != null) employeeValidationDeptnoPstmt.close();
            if (employeeValidationPasswordPstmt != null) employeeValidationPasswordPstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee read(String id) {
        return null;
    }
}