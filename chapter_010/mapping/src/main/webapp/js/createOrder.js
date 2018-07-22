$(function () {
    var app = {
        initialize: function () {
            app.setListeners();
            app.getModel();
            app.getBody();
            app.getEngine();
            app.getDrivetype();
            app.getTransmission();
            app.getYears();
        },

        setListeners: function () {
            $("#file-btn-load").on("click", function () {
                var data = new FormData();
                $.each($("#file-image")[0].files, function (i, f) {
                    data.append("file-" + i, f);
                });
                $.ajax({
                    url: "./photo",
                    method: "post",
                    processData: false,
                    contentType: false,
                    enctype: "multipart/form-data",
                    data: data,
                    complete: function () {
                        alert("success");
                    }
                });
            });
        },

        getModel: function () {
            $.ajax({
                url: "./model",
                method: "get",
                success: function (data) {
                    var model = $("#model");
                    $.each(data, function (i, value) {
                        model.append($("<option></option>").val(value.name).html(value.name));
                    });
                    model.selectpicker("refresh");
                }
            });
        },

        getBody: function () {
            $.ajax({
                url: "./engine",
                method: "get",
                success: function (data) {
                    var engine = $("#engine");
                    $.each(data, function (i, value) {
                        engine.append($("<option></option>").val(value.name).html(value.name));
                    });
                    engine.selectpicker("refresh");
                }
            });
        },

        getDrivetype: function () {
            $.ajax({
                url: "./drivetype",
                method: "get",
                success: function (data) {
                    var $drivetype = $("#drivetype");
                    $.each(data, function (i, value) {
                        $drivetype.append($("<option></option>").val(value.name).html(value.name));
                    });
                    $drivetype.selectpicker("refresh");
                }
            });
        },

        getEngine: function () {
            $.ajax({
                url: "./body",
                method: "get",
                success: function (data) {
                    var $body = $("#body");
                    $.each(data, function (i, value) {
                        $body.append($("<option></option>").val(value.name).html(value.name));
                    });
                    $body.selectpicker("refresh");
                }
            });
        },

        getTransmission: function () {
            $.ajax({
                url: "./transmission",
                method: "get",
                success: function (data) {
                    var $transmission = $("#transmission");
                    $.each(data, function (index, value) {
                        $transmission.append($("<option></option>").val(value.name).html(value.name));
                    });
                    $transmission.selectpicker("refresh");
                }
            });
        },

        getYears: function () {
            $('#year').datepicker({
                minViewMode: 2,
                format: "yyyy"
            });
        }
    };
    app.initialize();
});