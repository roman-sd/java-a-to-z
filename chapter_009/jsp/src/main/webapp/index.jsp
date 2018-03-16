<%@ page import="sdroman.model.User" %>
<%@ page import="sdroman.database.UserStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users servlet</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>email</th>
        <th>Action</th>
    </tr>
    <% for (User user : new UserStore().getUsers()) {%>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getEmail()%></td>
        <form>
            <input type="hidden" name="name" value=<%=user.getName()%>>
            <input type="hidden" name="login" value=<%=user.getLogin()%>>
            <input type="hidden" name="email" value=<%=user.getEmail()%>>
            <td> <button formaction="./update" formmethod="GET">update</button> </td>
            <td> <button formaction="./delete" formmethod="POST">delete</button> </td>
        </form>
    </tr>
    <% } %>
</table>
<br>
<b> <a href="./create">Add new user</a> </b>
</body>
</html>
