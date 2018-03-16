<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users servlet</title>
</head>
<body>
<h3>Add new user</h3>
<form action="./create" method="POST">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Login</th>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="text" name="email"></td>
        </tr>
    </table>
    <input type="submit" value="Add">
</form>
</body>
</html>
