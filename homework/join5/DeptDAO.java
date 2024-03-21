package homework.join5;

import homework.join4.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DeptDAO {
    private static Connection conn = DBConnection.getConnection();
    private static PreparedStatement DeptListPstmt = null;
    private static PreparedStatement DeptInsertPstmt = null;
    private static PreparedStatement DeptDeletePstmt = null;
    private static PreparedStatement DeptDetailPstmt = null;
    private static PreparedStatement DeptDeptnoPstmt = null;
    private static PreparedStatement DeptUpdatePstmt = null;
    private static PreparedStatement DeptClearPstmt = null;

    static {
        try
        {
            DeptListPstmt = conn.prepareStatement("select * from dept order by deptno");
            DeptInsertPstmt = conn.prepareStatement("insert into dept (deptno, dname, loc) values (?,?,?)");
            DeptDetailPstmt = conn.prepareStatement("select * from dept where deptno = ?");
            DeptDeptnoPstmt = conn.prepareStatement("select count(*) from dept where deptno = ? ");
            DeptUpdatePstmt = conn.prepareStatement("update dept set dname = ?, loc = ? where deptno = ?");
            DeptDeletePstmt = conn.prepareStatement("delete from dept where deptno = ?");
            DeptClearPstmt = conn.prepareStatement("delete from dept");
    }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Dept> deptList(){
        List<Dept> deptList = new ArrayList<>();
        try {
            ResultSet rs  = DeptListPstmt.executeQuery();

            while(rs.next()){
                Dept dept = new Dept(
                        rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")
                );
                deptList.add(dept);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptList;
    }

    public void deptInsert(Dept dept){
        try{
            DeptInsertPstmt.setInt(1, dept.getDeptno());
            DeptInsertPstmt.setString(2, dept.getName());
            DeptInsertPstmt.setString(3, dept.getLoc());
            DeptInsertPstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deptDelete(int deptno){
        try{
            DeptDeletePstmt.setInt(1, deptno);
            DeptDeletePstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isExistDeptno(int deptno) {
        boolean existDetpno = false;

        try {
            DeptDeptnoPstmt.setInt(1, deptno);
            ResultSet rs = DeptDeptnoPstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            existDetpno = count > 0;
            rs.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existDetpno;
    }

    public void deptClear() {
        try {
            DeptClearPstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

