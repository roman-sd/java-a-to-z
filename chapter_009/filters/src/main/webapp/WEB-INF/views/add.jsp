<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users servlet</title>
</head>
<body>
<h3>Add new user</h3>
<form action="${pageContext.servletContext.contextPath}/create" method="POST">
    <table>
        <tr>
            <th>Name</th>
            <td><label>
                <input type="text" name="name">
            </label></td>
        </tr>
        <tr>
            <th>Login</th>
            <td><label>
                <input type="text" name="login">
            </label></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><label>
                <input type="text" name="password">
            </label></td>
        </tr>
        <tr>
            <th>email</th>
            <td><label>
                <input type="text" name="email">
            </label></td>
        </tr>
        <tr>
            <th>Role</th>
            <td>
                <label>
                    <select name="role">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
    </table>
    <input type="submit" value="Add">
</form>
</body>
</html>
