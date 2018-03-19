<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Users servlet</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/update" method="POST">
            <table>
                <tr>
                    <th>Name</th>
                    <td>${param.name}</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Login</th>
                    <td>${param.login}</td>
                    <td>${param.login}</td>
                </tr>
                <tr>
                    <th>email</th>
                    <td>${param.email}</td>
                    <td><input type="text" name="email"></td>
                </tr>
            </table>
            <input type="hidden" name="login" value="${param.login}">
            <input type="submit" value="update">
        </form>
    </body>
</html>
