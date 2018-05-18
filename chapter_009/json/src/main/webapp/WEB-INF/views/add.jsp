<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/form.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/form.js"></script>
    </head>
    <body class="bg-light">
        <div class="countanier">
            <div class="col-md-8 col-md-offset-2">
                <h4 class="mb-3">Add user</h4>
                <form action="./create" method="post">
                    <div class="row">
                        <div class="col-md-12">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="name">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label for="login">Login</label>
                            <input type="text" class="form-control" name="login" id="login" placeholder="login">
                        </div>
                        <div class="col-md-6">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="password">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <label for="name">Email</label>
                            <input type="email" class="form-control" name="email" id="email" placeholder="email">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-3">
                            <label for="role">Role</label>
                            <select class="selectpicker" name="role" id="role" data-width="100px" required>
                                <option value="">Choose...</option>
                            </select>
                        </div>
                        <div class="col-md-5">
                            <label for="country">Country</label>
                            <select class="selectpicker" name="country" id="country" required>
                                <option value="">Choose...</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label for="city">City</label>
                            <select class="selectpicker" name="city" id="city" required>
                                <option value="">Choose...</option>
                            </select>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Continue</button>
                </form>
            </div>
        </div>
    </body>
</html>

