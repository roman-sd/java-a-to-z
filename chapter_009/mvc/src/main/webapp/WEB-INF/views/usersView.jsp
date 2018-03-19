<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users servlet</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>email</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.email}"/></td>
        <form>
            <input type="hidden" name="name" value="${user.name}">
            <input type="hidden" name="login" value="${user.login}">
            <input type="hidden" name="email" value="${user.email}">
            <td> <button formaction="./update" formmethod="GET">update</button> </td>
            <td> <button formaction="./delete" formmethod="POST">delete</button> </td>
        </form>
    </tr>
    </c:forEach>
</table>
<br>
<b> <a href="${pageContext.servletContext.contextPath}/create">Add new user</a> </b>
</body>
</html>

