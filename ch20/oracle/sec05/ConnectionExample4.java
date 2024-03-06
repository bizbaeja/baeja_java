package ch20.oracle.sec05;


import java.sql.*;
import java.util.Scanner;

/**
 * delete 만 확인
 */
public class ConnectionExample4 {
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

            PreparedStatement pstmt = conn.prepareStatement("select  userid , username, userpassword,userage, useremail from  users where userid=?");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("자료를 찾기 위한 아이디 입력" +
                        " : ");
                String userid = scanner.nextLine();
                if (userid.equals("q")) break;
                //입력 값을 설정 한다
                pstmt.setString(1, userid);

                //조회할 떄는 executeQuery()를 사용한다
                //dbeaver 에서나 sqldeveloper에서 먼저 실행시켜서 결과를 확인하자
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    String useerid = rs.getString("userid");
                    String username = rs.getString("username");
                    int userage = rs.getInt("userage");
                    String userpassword = rs.getString("userpassword");
                    String useremail = rs.getString("useremail");

                    System.out.println("아이디 : " + useerid);
                    System.out.println("이름 : " + username);
                    System.out.println("나이 : " + userage);
                    System.out.println("비밀번호 : " + userpassword);
                    System.out.println("이메일 : " + useremail);
                } else {
                    System.out.println("[userid=" + userid + "]에 해당하는 데이터가 없습니다.");
                }

            }




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