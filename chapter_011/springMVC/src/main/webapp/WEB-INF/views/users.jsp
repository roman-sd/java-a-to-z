<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Car store</title>
</head>
<body>

<div class="container">
    <h2>User List</h2>
    <form action="${pageContext.servletContext.contextPath}/users.do" method="post">
        name: <input type="text" name="name">
        <br/>
    </form>
    <table border="1">
        <tr>Name</tr>
        <c:forEach items="${users}" var="user" varStatus="stayus">
            <tr valign="top">
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>