$(function () {
    var app = {
        initialize: function () {
            $.ajax({
                url: "./sessionUser",
                method: "get",
                success: function (data) {
                    app.initTable(data);
                    app.setListeners(data);
                }
            });
        },

        initTable: function (curUser) {
            if (curUser == null) {
                $("#addOrder").find("button[type='submit']").attr("disabled", "disabled");
            }
            $.ajax({
                url: "./orders",
                method: "get",
                success: function (data) {
                    var $table = $("#table"),
                        img;
                    $table.bootstrapTable({data: data});
                    $.each(data, function (index, val) {
                        img = val.photoListSize != 0 ? val.photoListSize + " photos" : "-";
                        $table.bootstrapTable("updateRow", {
                            index: index,
                            row: {
                                carModel: val.car.model,
                                userLogin: val.user.login,
                                year: val.car.year,
                                photos: img
                            }
                        });
                    });
                }
            });
        },

        setListeners: function (curUser) {
            $("#table").on('click-cell.bs.table', function (e, value, row, $element) {
                if (value == "photos") {
                    app.showPhoto($element.id, curUser);
                } else {
                    app.showModalTable($element);
                    app.showModalOptions($element, curUser);
                }
            });
        },

        showModalTable: function (data) {
            var $modalBox = $('#myModalBox'),
                htmlData = '<label><li>id: ' + data.car.id + '</li>'
                    + '<li>model: ' + data.car.model + '</li>'
                    + '<li>body: ' + data.car.body + '</li>'
                    + '<li>engine: ' + data.car.engine + '</li>'
                    + '<li>drive type: ' + data.car.driveType + '</li>'
                    + '<li>transmission: ' + data.car.transmission + '</li>'
                    + '<li>year: ' + data.car.year + '</li>'
                    + '<li>description: ' + data.description + '</li>'
                    + '<label><input type="checkbox" id="sold" name="done" value="1"> sold</label>'
                    + '</ul>';

            $modalBox.find(".modal-title").html(data.car.model);
            $modalBox.find('.modal-body').html(htmlData);
            $modalBox.modal('show');
        },

        showModalOptions: function (data, curUser) {
            var $modalBox = $('#myModalBox'),
                $saveBtn = $modalBox.find("input[type='submit']"),
                $checkbox = $modalBox.find("input[type='checkbox']");

            $saveBtn.show();
            if (data.sold == true) {
                $checkbox.prop('checked', true);
            }
            if (curUser == null || curUser != null && data.user.login != curUser.login) {
                $checkbox.parent().hide();
                $saveBtn.hide();
            }
            $saveBtn.on("click", function () {
                data.sold = !!$checkbox.is(':checked');
                $.ajax({
                    url: "./update",
                    method: "post",
                    data: {"id": data.id, "sold": data.sold},
                    success: function () {
                        console.log('success');
                    }
                });
                location.reload();
            });
        },

        showPhoto: function (orderId) {
            $.ajax({
                url: "./photo",
                method: "get",
                data: {'orderId': orderId},
                complete: function (data) {
                    var images = JSON.parse(data.responseText);
                    if (images != "") {
                        var slide,
                            indicator;
                        $.each(images, function (i, value) {
                            if (i == 0) {
                                slide = "<div class='item active'>";
                                indicator = "<li data-target='#myCarousel' data-slide-to='0' class='active'></li>";
                            } else {
                                slide += "<div class='item'>";
                                indicator += "<li data-target='#myCarousel' data-slide-to='" + i + "'></li>";
                            }
                            slide += "<img src='" + value + "' style='width:60%; margin: auto;'>";
                            slide += "</div>";
                        });
                        $(".carousel-inner").html(slide);
                        $(".carousel-indicators").html(indicator);
                        $("#modalWindow").modal("show");
                    }
                }
            });
        }
    };
    app.initialize();
});