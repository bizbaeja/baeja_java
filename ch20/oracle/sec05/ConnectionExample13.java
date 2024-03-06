package ch20.oracle.sec05;


import java.sql.*;
import java.util.Scanner;

/**
 * 간단하게 update 만 확인
 */
public class ConnectionExample13 {
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
            // CallableStatement 객체 생성
            // 함수 호출
            // 함수 호출시에는 ? 를 사용하여 값을 설정
            // 함수 호출시에는 리턴값을 받을 수 있다
            CallableStatement cstmt = conn.prepareCall("{ ? = call user_login(?,?) }");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("아이디 : ");
                String userid = scanner.nextLine();
                //scanner.nextLine(); 은 왜 사용하는가?
                //nextLine() 메소드는 개행문자를 기준으로 입력을 받기 때문에
                //next() 메소드로 입력을 받은 후에 개행문자를 제거하기 위해서 사용한다.
                if (userid.equals("q")) break;

                System.out.print("비밀번호 : ");
                String userpassword = scanner.nextLine();

                // 리턴값 위치 및 자료형 설정
                // 리턴값을 받기 위해서는 registerOutParameter() 메소드를 사용한다
                // 첫번째 인자는 리턴값의 위치, 두번째 인자는 리턴값의 자료형
                cstmt.registerOutParameter(1, Types.INTEGER);
                //인자값 설정
                //첫번째 인자는 인자의 위치, 두번째 인자는 인자의 값
                //인자의 위치는 함수의 인자의 위치와 동일하다
                cstmt.setString(2, userid);
                cstmt.setString(3, userpassword);

                //SQL 함수 실행
                cstmt.execute();

                //결과값 얻기

                int result = cstmt.getInt(1);
                switch(result) {
                    case 0:
                        System.out.println("로그인 성공");
                        break;
                        // case 1, 2 는 어떤 경우에 발생하는가?
                        // case 1, 2 는 함수의 리턴값이 1, 2 일때 발생한다
                        // 연달아 쓰는 이유는, case 1, 2 는 동일한 처리를 하기 때문이다
                    case 1:
                    case 2:
                        System.out.println("아이디 또는 비밀번호가 잘못되었습니다");
                        break;
                }
            }
            cstmt.close();

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