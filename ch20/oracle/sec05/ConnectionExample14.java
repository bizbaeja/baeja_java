package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ConnectionExample14 {
    public static void main(String[] args) {
        Connection conn = null;
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

            PreparedStatement pstmt1 = conn.prepareStatement("update ACCOUNT set BALANCE = BALANCE - ? where ano='111-11-1111'");
            PreparedStatement pstmt2 = conn.prepareStatement("update ACCOUNT set BALANCE = BALANCE + ? where ano='111-11-1112'");

            conn.setAutoCommit(false);
            //출금 값을 설정 한다
            pstmt1.setInt(1, 1000);
            //SQL 구문 실행
            int r = pstmt1.executeUpdate();
            System.out.println("1 r = " + r);

            //이부분 오류 발생시
//         if (true) {
//            conn.rollback();
//            System.exit(0);
//         }
            //입력 값을 설정 한다
            pstmt2.setInt(1, 1000);
            //SQL 구문 실행
            // executeUpdate() 메소드는 변경된 건수를 리턴한다
            r = pstmt2.executeUpdate();
            System.out.println("2 r = " + r);

            //작업을 완료한다
            conn.commit();

            pstmt1.close();
            pstmt2.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }
    }
}      