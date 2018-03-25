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
            <th>Login</th>
            <td>${param.login}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${param.name}</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Password</th>
            <td>${param.password}</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <th>email</th>
            <td>${param.email}</td>
            <td><input type="text" name="email"></td>
        </tr>
        <c:if test="${sessionScope.userRole == 'ADMIN'}">
            <tr>
                <th>Role</th>
                <td>
                    <select name="role">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </c:if>
    </table>
    <input type="hidden" name="login" value="${param.login}">
    <input type="hidden" name="role" value="${sessionScope.userRole}">
    <input type="submit" value="update">
</form>
</body>
</html>
