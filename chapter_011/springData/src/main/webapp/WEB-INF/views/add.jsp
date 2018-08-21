<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Order</title>
</head>
<body>
    <jsp:include page="header.jsp"/>

    <div class="container">
        <form:form modelAttribute="newOrder" class="form-horizontal" method="post"
                   action="${pageContext.servletContext.contextPath}/add">

            <div class="form-group">
                <label class="col-sm-2 control-label" for="model">Car model:</label>
                <div class="col-sm-7">
                    <form:select path="modelId" id="model" cssClass="form-control">
                        <form:options items="${model}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="engine">Car engine:</label>
                <div class="col-sm-7">
                    <form:select path="engineId" id="engine" cssClass="form-control">
                        <form:options items="${engine}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="driveType">Car driveType:</label>
                <div class="col-sm-7">
                    <form:select path="driveTypeId" id="driveType" cssClass="form-control">
                        <form:options items="${driveType}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="body">Car body:</label>
                <div class="col-sm-7">
                    <form:select path="bodyId" id="body" cssClass="form-control">
                        <form:options items="${body}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="transmission">Car transmission:</label>
                <div class="col-sm-7">
                    <form:select path="transmissionId" id="transmission" cssClass="form-control">
                        <form:options items="${transmission}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="year">year</label>
                <div class="col-sm-7">
                    <form:input path="year" type="text" class="form-control" id="year" placeholder="year"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="price">Car price</label>
                <div class="col-sm-7">
                    <form:input path="price" type="number" class="form-control" id="price"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="description">Description</label>
                <div class="col-sm-7">
                    <form:textarea path="description" rows="5" class="form-control" id="description"
                                   placeholder="description"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" id="btnAdd" class="btn-lg btn-primary pull-right" value="Add"/>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
