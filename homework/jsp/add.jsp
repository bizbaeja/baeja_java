<%
String snack = request.getParameter("snack");
String drink = request.getParameter("drink");
String chocolate = request.getParameter("chocolate");
String cookie = request.getParameter("cookie");
String candy = request.getParameter("candy");

System.out.println("snack = " + snack);
System.out.println("drink = " + drink);
System.out.println("chocolate = " + chocolate);
System.out.println("cookie = " + cookie);
System.out.println("candy = " + candy);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <=snack%> + <=drink%> = <=snack+drink%> <br>
    chocolate = <=chocolate%>
    cookie = <=cookie%>
    candy = <=candy%>
</body>
</html>