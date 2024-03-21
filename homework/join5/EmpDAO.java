package homework.join5;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmpDAO {
    private static Connection conn = DBConnection.getConnection();
    private static PreparedStatement EmpListPstmt = null;
    private static PreparedStatement EmpInsertPstmt = null;
    private static PreparedStatement EmpDetailPstmt = null;
    private static PreparedStatement EmpUpdatePstmt = null;
    private static PreparedStatement EmpDeletePstmt = null;
    private static PreparedStatement EmpClearPstmt = null;
    static {
        try {
            EmpListPstmt = conn.prepareStatement("SELECT EMPNO ,ENAME, JOB ,MGR ,to_char(HIREDATE, 'YYYY-MM-DD') HIREDATE ,SAL ,d.dname ,d.loc ,s.GRADE FROM emp e join DEPT d on e.deptno = d.deptno JOIN SALGRADE s ON e.SAL BETWEEN s.LOSAL AND s.HISAL ORDER BY EMPNO");
            EmpInsertPstmt = conn.prepareStatement("INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, sysdate, ?, ?, ?)");
            EmpDetailPstmt = conn.prepareStatement("SELECT EMPNO ,ENAME, JOB ,MGR ,to_char(HIREDATE, 'YYYY-MM-DD') HIREDATE ,SAL ,d.dname ,d.loc ,s.GRADE FROM emp e join DEPT d on e.deptno = d.deptno JOIN SALGRADE s ON e.SAL BETWEEN s.LOSAL AND s.HISAL WHERE EMPNO = ?");
            EmpUpdatePstmt = conn.prepareStatement("UPDATE EMP SET ENAME = ?, JOB = ?, MGR = ?, HIREDATE = ?, SAL = ?, COMM = ?, DEPTNO = ? WHERE EMPNO = ?");
            EmpDeletePstmt = conn.prepareStatement("DELETE FROM EMP WHERE EMPNO = ?");
            EmpClearPstmt = conn.prepareStatement("DELETE FROM EMP");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Emp> empList(){
        List<Emp> empList = new ArrayList<>();
        try{
            ResultSet rs = EmpListPstmt.executeQuery();

            while (rs.next()) {
                Emp emp = new Emp(
                        rs.getInt("EMPNO"),
                        rs.getString("ENAME"),
                        rs.getString("JOB"),
                        rs.getInt("MGR"),
                        rs.getString("HIREDATE"),
                        rs.getInt("SAL"),
                        rs.getString("DNAME"),
                        rs.getString("LOC"),
                        rs.getInt("GRADE")
                );
                empList.add(emp);
            }

            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return empList;
    };
    public void empInsert(Emp emp){
        try {
            EmpInsertPstmt.setInt(1, emp.getEmpno());
            EmpInsertPstmt.setString(2, emp.getEname());
            EmpInsertPstmt.setString(3, emp.getJob());
            EmpInsertPstmt.setInt(4, emp.getMgr());
            EmpInsertPstmt.setInt(5, emp.getSal());
            EmpInsertPstmt.setInt(6, emp.getComm());
            EmpInsertPstmt.setInt(7, emp.getDeptno());

            EmpInsertPstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public Emp empDetail(int empno){
        Emp emp = null;
        try {
            EmpDetailPstmt.setInt(1, empno);
            ResultSet rs = EmpDetailPstmt.executeQuery();

            if (rs.next()) {
                emp = new Emp(
                        rs.getInt("EMPNO"),
                        rs.getString("ENAME"),
                        rs.getString("JOB"),
                        rs.getInt("MGR"),
                        rs.getString("HIREDATE"),
                        rs.getInt("SAL"),
                        rs.getString("DNAME"),
                        rs.getString("LOC"),
                        rs.getInt("GRADE")
                );
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    };
    public void empUpdate(Emp emp){
        try {
            EmpUpdatePstmt.setString(1, emp.getEname());
            EmpUpdatePstmt.setString(2, emp.getJob());
            EmpUpdatePstmt.setInt(3, emp.getMgr());
            EmpUpdatePstmt.setString(4, emp.getHiredate());
            EmpUpdatePstmt.setInt(5, emp.getSal());
            EmpUpdatePstmt.setInt(6, emp.getComm());
            EmpUpdatePstmt.setInt(7, emp.getDeptno());
            EmpUpdatePstmt.setInt(8, emp.getEmpno());

            EmpUpdatePstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public void empDelete(int empno){
        try {
            EmpDeletePstmt.setInt(1, empno);
            EmpDeletePstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public void empClear(){
        try {
            EmpClearPstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    };


}
