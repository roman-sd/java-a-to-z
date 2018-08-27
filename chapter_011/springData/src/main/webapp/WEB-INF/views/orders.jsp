<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Car store</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>#</th>
                    <th>car</th>
                    <th>sold</th>
                    <th>price</th>
                    <th>year</th>
                </tr>
            </thead>

            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><c:out value="${order.id}"/></td>
                    <td><c:out value="${order.car.brand.name}"/></td>
                    <td><c:out value="${order.sold}"/></td>
                    <td><c:out value="${order.price}"/></td>
                    <td><c:out value="${order.car.year}"/></td>
                    <td><a href="<spring:url value= "/order?id=${order.id}" /> " class="btn btn-primary">
                        <span class="glyphicon-info-sign glyphicon"></span> Details</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>