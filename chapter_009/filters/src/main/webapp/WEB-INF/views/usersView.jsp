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
        <th>Role</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <form>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.role}"/></td>
                <input type="hidden" name="login" value="${user.login}">
                <td>
                    <c:if test="${sessionScope.userRole == 'ADMIN'}">
                        <button formaction="${pageContext.servletContext.contextPath}/update" formmethod="GET">edit</button>
                        <button formaction="${pageContext.servletContext.contextPath}/delete" formmethod="POST">delete</button>
                    </c:if>
                </td>
                <td>
                    <c:if test="${sessionScope.login == user.login && sessionScope.userRole == 'USER'}">
                        <button formaction="${pageContext.servletContext.contextPath}/update" formmethod="GET">edit</button>
                    </c:if>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
<br>
<c:if test="${sessionScope.userRole == 'ADMIN'}">
    <b> <a href="${pageContext.servletContext.contextPath}/create">Add new user</a> </b>
</c:if>
<br><br>
<form>
    <button formaction="${pageContext.servletContext.contextPath}/logout" formmethod="GET">logout</button>
</form>
</body>
</html>

