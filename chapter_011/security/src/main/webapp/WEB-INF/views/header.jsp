<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Car Store</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/add" var="urlAddOrder" />
<spring:url value="/login" var="urlLogin" />
<spring:url value="/logout" var="urlLogout"/>

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

        <div id="navbarlogout">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlLogout}">Logout</a></li>
            </ul>
        </div>

        <div id="navbarlogin">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlLogin}">Login</a></li>
            </ul>
        </div>
    </div>
</nav>