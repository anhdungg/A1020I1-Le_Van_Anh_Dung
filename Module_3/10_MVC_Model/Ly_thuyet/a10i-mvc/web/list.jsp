<%@ page import="model.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student</title>
</head>
<body>

    <h2>List student</h2>
    <%
        List<Student> studentListJSP = (List<Student>) request.getAttribute("studentListServlet");
    %>
    <table>
        <tr>
            <th>No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
        </tr>
        <%
            for (int i = 0; i < studentListJSP.size(); i++) {
        %>
            <tr>
                <td><%=i + 1%></td>
                <td><%=studentListJSP.get(i).getId()%></td>
                <td><%=studentListJSP.get(i).getName()%></td>
                <td><%=studentListJSP.get(i).getDateOfBirth()%></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
