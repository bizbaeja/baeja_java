package ch20.oracle.sec05;


import java.sql.*;
import java.util.Scanner;

/**
 * delete 만 확인
 */
public class ConnectionExample5 {
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
            PreparedStatement v_update = conn.prepareStatement("update users set username=?, userpassword=?, userage=? where userid=?");
            PreparedStatement v_delete = conn.prepareStatement("delete from  users where userid=?");
            PreparedStatement v_select = conn.prepareStatement("select  userid , username, userpassword,userage, useremail from  users where userid=?");
            Scanner scanner = new Scanner(System.in);
            //scanner 에서 1,2,3,4 중 하나를 입력 받아서 처리한다

            System.out.println("1. 조회");
            System.out.println("2. 변경");
            System.out.println("3. 삭제");
            System.out.println("4. 종료");
            switch (scanner.nextLine()){
                case "1" -> {
                    while(true) {
                        System.out.print("자료를 찾기 위한 아이디 입력" +
                                " : ");
                        String userid = scanner.nextLine();
                        if (userid.equals("q")) break;
                        //입력 값을 설정 한다
                        v_select.setString(1, userid);

                        //조회할 떄는 executeQuery()를 사용한다
                        //dbeaver 에서나 sqldeveloper에서 먼저 실행시켜서 결과를 확인하자
                        ResultSet rs = v_select.executeQuery();
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

                        break;
                    }

                }
                case "2" -> {
                    while(true) {
                        System.out.print("변경 자료를 찾기 위한 아이디 입력 : ");
                        String userid = scanner.nextLine();
                        if (userid.equals("q")) break;

                        System.out.print("이름 : ");
                        String username = scanner.nextLine();
                        System.out.print("비밀번호 : ");
                        String userpassword = scanner.nextLine();
                        System.out.print("나이 : ");
                        int userage = scanner.nextInt();
                        //enter key를 입력 받아 버리기 위함
                        scanner.nextLine();

                        //입력 값을 설정 한다
                        v_update.setString(1, username);
                        v_update.setString(2, userpassword);
                        v_update.setInt(3, userage);
                        v_update.setString(4, userid);

                        int updated = v_update.executeUpdate();
                        //변경된 건 수
                        System.out.println("변경 건수  : " + updated);
                        break;
                    }

                }
                case "3"->{
                    while(true) {
                        System.out.print("삭제 자료를 찾기 위한 아이디 입력 : ");
                        String userid = scanner.nextLine();
                        if (userid.equals("q")) break;
                        //입력 값을 설정 한다
                        v_delete.setString(1, userid);

                        int updated = v_delete.executeUpdate();
                        //변경된 건 수
                        System.out.println("삭제 건수  : " + updated);
                        break;
                    }
                }
                case "4"->{
                    System.exit(0);
                }
            }
            while(true) {
                System.out.print("자료를 찾기 위한 아이디 입력" +
                        " : ");
                String userid = scanner.nextLine();
                if (userid.equals("q")) break;
                //입력 값을 설정 한다
                v_select.setString(1, userid);

                //조회할 떄는 executeQuery()를 사용한다
                //dbeaver 에서나 sqldeveloper에서 먼저 실행시켜서 결과를 확인하자
                ResultSet rs = v_select.executeQuery();
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
                    break;
                } else {
                    System.out.println("[userid=" + userid + "]에 해당하는 데이터가 없습니다.");
                    break;
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