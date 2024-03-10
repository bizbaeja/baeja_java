package homework.join;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * jdbc에 대한 작업만 한다
 */
public class BoardDAO {
    // Field
    private static Connection conn = null;
    private static PreparedStatement boardListPstmt = null;
    private static PreparedStatement boardInsertPstmt = null;
    private static PreparedStatement boardUpdatePstmt = null;
    private static PreparedStatement boardDetailPstmt = null;
    private static PreparedStatement boardDeletePstmt = null;
    private static PreparedStatement boardDeleteAllPstmt = null;

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

            boardListPstmt = conn.prepareStatement("select bno, btitle, bcontent, bwriter, bdate bdate from boards");
            boardInsertPstmt = conn.prepareStatement("insert into boards (btitle, bcontent, bwriter) values (?, ?, ?)");
            boardUpdatePstmt = conn.prepareStatement("update boards set btitle=?, bcontent=?, bwriter=? where bno=?");
            boardDetailPstmt = conn.prepareStatement("select * from boards where bno=?");
            boardDeletePstmt = conn.prepareStatement("delete from boards where bno=?");
            boardDeleteAllPstmt = conn.prepareStatement("delete from boards");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method
    public List<Board> list() {
        // 아래 구문이 동작할 수 있게 기능 추가
        // select * from boards
        List<Board> list = new ArrayList<>();
        try {
            ResultSet rs = boardListPstmt.executeQuery();
            while (rs.next()) {
                // 찾고자 하는 자료가 있음
                Board board = new Board(rs.getInt("bno")
                        ,rs.getString("btitle")
                        ,rs.getString("bcontent")
                        ,rs.getString("bwriter")
                        ,rs.getString("bdate"));
                //배열에 객체를 추가한다
                list.add(board);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insert(Board board) {
        int updated = 0;
        try {
            // 입력 값을 설정 한다
            boardInsertPstmt.setString(1, board.getBtitle());
            boardInsertPstmt.setString(2, board.getBcontent());
            boardInsertPstmt.setString(3, board.getBwriter());

            updated = boardInsertPstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public Board read(int bno) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // select * from boards where bno = ?
        Board board = null;
        try {
            // 입력 값을 설정 한다
            boardDetailPstmt.setInt(1, bno);

            ResultSet rs = boardDetailPstmt.executeQuery();
            if (rs.next()) {
                // 찾고자 하는 자료가 있음
                board = new Board(rs.getInt("bno")
                        ,rs.getString("btitle")
                        ,rs.getString("bcontent")
                        ,rs.getString("bwriter")
                        ,rs.getString("bdate"));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return board;
    }

    public int update(Board board) {
        try {
            // 입력 값을 설정 한다
            boardUpdatePstmt.setString(1, board.getBtitle());
            boardUpdatePstmt.setString(2, board.getBcontent());
            boardUpdatePstmt.setString(3, board.getBwriter());
            boardUpdatePstmt.setInt(4, board.getBno());

            int updated = boardUpdatePstmt.executeUpdate();
            conn.commit();

            return updated;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int bno) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // delete 구문 완성해서 구현 해주세요
        int updated = 0;
        try {
            // 입력 값을 설정 한다
            boardDeletePstmt.setInt(1, bno);

            updated = boardDeletePstmt.executeUpdate();
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
            updated = boardDeleteAllPstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }
}