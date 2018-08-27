<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<body>
<div class="container">
    <form action="${pageContext.servletContext.contextPath}/" method="post">
        <input type="text" name="name"><br/>
        <input type="submit"><br/>
    </form>
    <table>
        <tr>Name</tr>
        <c:forEach items="${users}" var="u" varStatus="status">
            <tr>
                <td>${u.login}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>