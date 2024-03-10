package homework.join2;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * jdbc에 대한 작업만 한다
 */
public class DepartDAO {
    // Field
    private static Connection conn = null;

    private  static PreparedStatement departListPstmt = null;
    private  static PreparedStatement departInsertPstmt = null;
    private  static PreparedStatement departUpdatePstmt = null;
    private  static PreparedStatement departDetailPstmt = null;
    private  static PreparedStatement departDeletePstmt = null;
    private  static PreparedStatement departDeleteAllPstmt = null;

    static {
        try {
            //JDBC Driver 등록
            Class.forName("org.mariadb.jdbc.Driver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8",
                    "root", //계정이름
                    "1004" //계정비밀번호
            );

            System.out.println("연결 성공");

            conn.setAutoCommit(false);

            departListPstmt = conn.prepareStatement("select deptno , dname, loc from dept");
            departInsertPstmt = conn.prepareStatement("insert into dept (dname, loc) values ( ?, ?)");
            departUpdatePstmt = conn.prepareStatement("update dept set dname=?, loc=? where deptno=?");
            departDetailPstmt = conn.prepareStatement("select * from dept where deptno=?");
            departDeletePstmt = conn.prepareStatement("delete from dept where deptno=?");
            departDeleteAllPstmt = conn.prepareStatement("delete from dept");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method
    public List<Depart> list() {
        // 아래 구문이 동작할 수 있게 기능 추가
        // select * from boards
        List<Depart> list = new ArrayList<>();
        try {
            ResultSet rs = departListPstmt.executeQuery();
            while (rs.next()) {

                Depart depart = new Depart(rs.getInt("deptno")
                        ,rs.getString("dname")
                        ,rs.getString("loc"));
                // 찾고자 하는 자료가 있음
                //배열에 객체를 추가한다
                list.add(depart);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insert(Depart depart) {
        int updated = 0;
        try {
            departInsertPstmt.setString(1, depart.getDname());
            departInsertPstmt.setString(2, depart.getLoc());
            updated = departInsertPstmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public Depart read(int deptno) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // select * from boards where bno = ?
        Depart depart = null;
        try {

            departDetailPstmt.setInt(1, deptno);
            ResultSet rs = departDetailPstmt.executeQuery();
            if (rs.next()) {
                // 찾고자 하는 자료가 있음

                depart = new Depart(rs.getInt("deptno")
                        ,rs.getString("dname")
                        ,rs.getString("loc"));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depart;
    }

    public int update(Depart depart) {
        try {
            // 입력 값을 설정 한다
            departUpdatePstmt.setString(1, depart.getDname());
            departUpdatePstmt.setString(2, depart.getLoc());
            departUpdatePstmt.setInt(3, depart.getDeptno());


            int updated = departUpdatePstmt.executeUpdate();
            conn.commit();

            return updated;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int deptno) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요
        int updated = 0;
        try {
            // 입력 값을 설정 한다
            departDeletePstmt.setInt(1, deptno);

            updated = departDeletePstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    public int clear() {
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요
        int updated = 0;
        try {
            updated = departDeleteAllPstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }
}