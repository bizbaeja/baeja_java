<%-- page language="java" --%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Connection conn = null;
PreparedStatement pstmt = null;
int rowsAffected = 0;

try {
    // MariaDB JDBC Driver 등록
    Class.forName("oracle.jdbc.OracleDriver");
   
    
    // 연결하기
   conn = DriverManager.getConnection(
      "jdbc:oracle:thin:@localhost:1521/xe", 
      "bituser", 
      "1004"
   );
    
    String sql = "DELETE FROM users WHERE userid = ?";
    pstmt = conn.prepareStatement(sql);
    
    // TODO: id 매개변수 설정
    pstmt.setString(1, request.getParameter("userid"));
    
    // 쿼리 실행
    rowsAffected = pstmt.executeUpdate();
} catch (ClassNotFoundException e) {
    // JDBC 드라이버 클래스를 찾을 수 없을 때의 예외 처리
    e.printStackTrace();
} catch (SQLException e) {
    // SQL 관련 예외 처리
    e.printStackTrace();
} finally {
    // 리소스 해제
    if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
    if (conn != null) try { conn.close(); } catch (SQLException e) {}
}

// 결과 확인
if (rowsAffected > 0) {
    // 성공적으로 삭제된 경우
    %><p>사용자가 성공적으로 삭제되었습니다.</p><%
} else {
    // 삭제할 사용자를 찾지 못한 경우
    %><p>해당 사용자를 찾을 수 없습니다.</p><%
}
%>
   

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>
</head>
<body>
    <h1>회원정보가 삭제되었습니다.</h1>