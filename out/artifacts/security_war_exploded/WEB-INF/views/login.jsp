<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>LogIn</title>
</head>
<body>

<div class="contanier">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <c:if test="${not empty error}">
                <span style="color: #ff443c;">
                    Your login attempt was not successful due to <br/><br/>
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                </span>
        </c:if>
        <h3 class="header" style="margin-top:100px; text-align:center">Login</h3>
        <div class="jumbotron">
            <form:form modelAttribute="loginUser" class="form-horizontal"
                       action="${pageContext.servletContext.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="username" class="col-lg-3 control-label">Login</label>
                    <div class="col-lg-7">
                        <input type="text" class="form-control" name="username" id="username" placeholder="Login" value="root">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-lg-3 control-label">Password</label>
                    <div class="col-lg-7">
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="root">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-lg-3">
                        <button type="submit" class="btn btn-info">Sign in</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
