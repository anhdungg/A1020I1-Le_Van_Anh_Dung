<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%
    Map<String, String> map = new HashMap<>();
%>

<%
    map.put("hello", "Xin chào");
    map.put("how", "Thế nào");
    map.put("book", "Quyển vở");
    map.put("computer", "Máy tính");

    String search = request.getParameter("input");

    String result = map.get(search);

    if (result != null){
        out.println("Word: " + search);
        out.println("\n");
        out.println("Result: " + result);
    }else {
        out.println("Not found");
    }
%>
</body>
</html>
