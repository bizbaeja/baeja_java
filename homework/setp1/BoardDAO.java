package homework.setp1;

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
    private Scanner scanner = new Scanner(System.in);
    private static Connection conn = null;
    private static PreparedStatement boardListPstmt = null;
    private static PreparedStatement boardInsertPstmt = null;
    private static PreparedStatement boardDetailPstmt = null;
    private static PreparedStatement boardDeletePstmt = null;

    private  static PreparedStatement boardUpdatePstmt = null;
    private static PreparedStatement boardDeleteAllPstmt = null;

    static {
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
            conn.setAutoCommit(false);

            boardListPstmt = conn.prepareStatement("select * from boards");
            boardInsertPstmt = conn.prepareStatement("insert into boards (bno, btitle, bcontent, bwriter, bdate) values (seq_bno.nextval, ?, ?, ?, sysdate)");
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
            // setString(1, board.getBtitle());인 이유는, ?에 들어갈 값을 설정하기 위해서이다
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

    // Board board 객체를 받아와서 update 하게 구현해야 한다.

    public int update(Board board) {
        // 아래 구문이 동작할 수 있게 기능 추가
        // update boards set btitle = ?, bcontent = ? where bno = ?
     // int update 를 초기화한다.
     int updated = 0 ;
        try{
            boardUpdatePstmt.setInt(1, board.getBno());
            boardUpdatePstmt.setString(2, board.getBtitle());
            boardUpdatePstmt.setString(3, board.getBcontent());
            boardUpdatePstmt.setString(4, board.getBwriter());
            //executeUpdate() 메소드는 변경된 행의 수를 리턴한다.
            updated = boardUpdatePstmt.executeUpdate();
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
        }


        return updated;
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
