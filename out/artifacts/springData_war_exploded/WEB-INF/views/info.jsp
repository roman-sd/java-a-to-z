<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Order Info</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>User Detail</h2>
        <br />

        <div class="row">
            <label class="col-lg-2">ID</label>
            <div class="col-lg-10">${order.id}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Model</label>
            <div class="col-lg-10">${order.car.brand.name}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Year</label>
            <div class="col-lg-10">${order.car.year}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Price</label>
            <div class="col-lg-10">${order.price}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Body</label>
            <div class="col-lg-10">${order.car.body.name}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Drivetype</label>
            <div class="col-lg-10">${order.car.driveType.name}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Engine</label>
            <div class="col-lg-10">${order.car.engine.name}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Transmission</label>
            <div class="col-sm-10">${order.car.transmission.name}</div>
        </div>

        <div class="row">
            <label class="col-lg-2">Description</label>
            <div class="col-lg-10">${order.description}</div>
        </div>
    </div>
</body>
</html>
