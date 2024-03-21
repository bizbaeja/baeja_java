
<%-- page language="java" --%>
<%
int a = Integer.parseInt(request.getParameter("a"));
int b = Integer.parseInt(request.getParameter("b"));
String fav_language = request.getParameter("fav_language");
String gender = request.getParameter("gender");
String vehicle1 = request.getParameter("vehicle1");
String vehicle2 = request.getParameter("vehicle2");
String vehicle3 = request.getParameter("vehicle3");


System.out.println("a = " + a);
System.out.println("b = " + b);
System.out.println("fav_language = " + fav_language);
System.out.println("gender =" + gender);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%=a%> + <%=b%> = <%=a+b%> <br>
    fav_language = <%=fav_language%>
    gender = <%=gender%>
</body>
</html>