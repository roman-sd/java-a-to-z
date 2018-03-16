<%@ page import="sdroman.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Users servlet</title>
    </head>
    <body>
        <form action="./update" method="POST">
            <table>
                <tr>
                    <th>Name</th>
                    <td><%=request.getParameter("name")%></td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Login</th>
                    <td><%=request.getParameter("login")%></td>
                    <td><%=request.getParameter("login")%></td>
                </tr>
                <tr>
                    <th>email</th>
                    <td><%=request.getParameter("email")%></td>
                    <td><input type="text" name="email"></td>
                </tr>
            </table>
            <input type="hidden" name="login" value="<%=request.getParameter("login")%>">
            <input type="submit" value="update">
        </form>
    </body>
</html>
