$(function () {
    var app = {
        initialize: function () {
            this.setListeners();
            this.loadData();
        },

        setListeners: function () {
            $("#country").on("change", function () {
                app.getCities();
            });
            $("form").on("submit", app.submitForm);
        },

        loadData: function () {
            $.ajax({
                url: "./sessionData",
                method: "get",
                success: function (data) {
                    if (data.updateUser != null) {
                        app.getRoles(data.updateUser.role, data.curUser.role);
                        app.getCountries(data.updateUser);

                        $("#login").val(data.updateUser.login);
                        $("#name").val(data.updateUser.name);
                        $("#password").val(data.updateUser.password);
                        $("#email").val(data.updateUser.email);
                    } else {
                        app.getRoles();
                        app.getCountries();
                    }
                }
            })
        },

        submitForm: function () {
            var form = $("form"),
                submitBtn = form.find("button[type='submit']");
            if (app.validateInput(form) === false) {
                return false;
            }
            submitBtn.attr("disabled", "disabled");
        },

        validateInput: function (form) {
            var inputs = form.find("input"),
                valid = true;
            $.each(inputs, function (index, val) {
                var input = $(val),
                    value = input.val(),
                    formGroup = input.parent(),
                    label = formGroup.find("label").text().toLowerCase(),
                    textError = "Enter " + label;

                if(value.length === 0){
                    formGroup.addClass("has-error").removeClass("has-success");
                    input.tooltip({
                        trigger: "manual",
                        placement: "bottom",
                        title: textError
                    }).tooltip("show");
                    valid = false;
                } else {
                    formGroup.addClass("has-success").removeClass("has-error");
                }
            });
            return valid;
        },

        getRoles: function (defaultRole, currentRole) {
            $.ajax({
                url: "./roles",
                method: "get",
                success: function (data) {
                    var role = $("#role");
                    $.each(data, function (i, value) {
                        role.append($("<option></option>").val(value).html(value));
                    });
                    if (defaultRole != null) {
                        role.find("option[value='" + defaultRole +"']").attr("selected", "selected");
                        if (currentRole != "ADMIN") {
                            role.find('option').attr("disabled", true);
                            role.find("option:contains('" + currentRole + "')").attr("disabled", false);
                        }
                    }
                    role.selectpicker("refresh");
                }
            });
        },

        getCities: function (defaultCity) {
            $("#city").empty();
            $.ajax({
                url: "./city",
                data: {country : $("#country").val()},
                method: "get",
                success: function (data) {
                    var city = $("#city");
                    $.each(data, function (i, value) {
                        city.append($("<option></option>").val(value.name).html(value.name));
                    });
                    if (defaultCity != null) {
                        city.find("option[value='" + defaultCity +"']").attr("selected", "selected");
                    }
                    city.selectpicker("refresh");
                }
            });
        },

        getCountries: function (defaultUser) {
            $.ajax ({
                url: "./country",
                type: "get",
                success: function (data) {
                    var country = $("#country");
                    $.each(data, function (i, value) {
                        country.append($("<option></option>").val(value.name).html(value.name));
                    });
                    if (defaultUser != null) {
                        country.find("option[value='" + defaultUser.country +"']").attr("selected", "selected");
                        app.getCities(defaultUser.city);
                    }
                    country.selectpicker("refresh");
                }
            });
        }
    };
    app.initialize();
});
