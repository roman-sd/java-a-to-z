$(function () {
    var app = {
        initialize: function () {
            this.initParam();
        },

        setListeners: function (role, login) {
            $.ajax({
                url: "./json",
                method: "get",
                success: function (data) {
                    var btnVisible = true;
                    if (role == "GUEST") {
                        btnVisible = false;
                    }
                    $("#table").bootstrapTable({
                        data: data,
                        columns: [{}, {}, {}, {}, {}, {}, {}, {},
                            {
                                title: 'Update',
                                align: 'center',
                                visible: btnVisible,
                                clickToSelect: false,
                                formatter: function (value, row) {
                                    if (role == "ADMIN" || role == 'USER' && login == row.login) {
                                        return app.getForm("./update", "get", "updateLogin", row.login, "Edit");
                                    }
                                }
                            },
                            {
                                title: 'Delete',
                                align: 'center',
                                visible: btnVisible,
                                clickToSelect: false,
                                formatter: function (value, row) {
                                    if (role == "ADMIN" || role == 'USER' && login == row.login) {
                                        return app.getForm("./delete", "post", "login", row.login, "Delete");
                                    }
                                }
                            }
                        ]
                    });
                }
            });
        },

        initParam: function () {
            $.ajax({
                url: "./sessionData",
                method: "get",
                success: function (data) {
                    if (data.curUser.role != "ADMIN") {
                        $("#add").addClass("hidden");
                    }
                    app.setListeners(data.curUser.role, data.curUser.login);

                }
            });
        },

        getForm: function (action, method, paramName, paramValue, name) {
            var form = "<form action='" + action + "' method='" + method +"'>";
            form += "<input type='hidden' name='" + paramName + "' value='" + paramValue + "'>";
            form += "<input data-field='test' type='submit' class='btn btn-info' value='" + name + "'></form>";
            return form;
        }
    };
    app.initialize();
});