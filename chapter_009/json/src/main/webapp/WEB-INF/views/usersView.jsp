<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/view.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/view.css">
    </head>
    <body>
        <div class="container">
            <h2>Users</h2>
            <div class="table-responsive">
            <table id="table" data-classes="table table-hover table-condensed" data-striped="true">
                <thead>
                <tr>
                    <th data-field="name">Name</th>
                    <th data-field="login" data-sortable="true">Login</th>
                    <th data-field="password">Password</th>
                    <th data-field="email">Email</th>
                    <th data-field="createDate">Create Date</th>
                    <th data-field="role" data-sortable="true">Role</th>
                    <th data-field="city" data-sortable="true">City</th>
                    <th data-field="country" data-sortable="true">Country</th>
                </tr>
                </thead>
            </table>
            </div>
            <div>
                <a href="./create" style="padding-right:50px">
                    <input type="button" class='btn btn-info' id="add" value="Add User"/></a>

                <a href="./logout" style="padding-left: 50px">
                    <input type="button" class='btn btn-info' value="Log Out"/></a>
            </div>
        </div>
    </body>
</html>
