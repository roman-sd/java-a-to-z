<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Car Store</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/add" var="urlAddOrder" />

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Car Store</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddOrder}">Add Order</a></li>
            </ul>
        </div>
    </div>
</nav>