/**
 * Created by hxpeng on 2016/7/22.
 */


define(['bootstrapDatetimepicker', 'icheck','jqueryTwbsPagination'], function() {

    var first = function(){

        $(".form-group .date").datetimepicker({
            autoclose: true,
            todayBtn: true
        });
        $('table input[type=checkbox]').on('ifChecked', function () {
            $("#edit-one-article").attr("disabled", "disabled");
        });
        $('table input[type=checkbox]').on('ifUnchecked', function () {
            $("#edit-one-article").removeAttr("disabled");
        });

        $('.category-list .i-checks').iCheck({
            checkboxClass: 'icheckbox_flat-blue'
        });
        $('.other-condition .i-checks').iCheck({
            checkboxClass: 'icheckbox_flat-orange'
        });
        $('.folder-list .i-checks').each(function () {
            var self = $(this),
                label = self.next(),
                label_text = label.text();

            label.remove();
            self.iCheck({
                checkboxClass: 'icheckbox_line-blue',
                radioClass: 'icheckbox_line-blue',
                insert: '<div class="icheck_line-icon"></div>' + label_text
            });
        });
        $('.folder-list .i-checks').iCheck('check');

        $('.list-content-box .i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green'
        });

        $("#navigation").find("li").on("click",function(){
            $(this).addClass("active").siblings().removeClass("active");
            $("#articleRange").val($(this).attr("data-range-name"));
        })

        $("#toggle-all").click(function () {
            if ($(this).find("input[type=hidden]").val() == "0") {
                $(".list-content-box table tr").each(function (i, z) {
                    $(z).find("input[type=checkbox]").iCheck('check');
                })
                $(this).find("input[type=hidden]").val(1)
            } else {
                $(".list-content-box table tr").each(function (i, z) {
                    $(z).find("input[type=checkbox]").iCheck('uncheck');
                })
                $(this).find("input[type=hidden]").val(0)
            }
        })



    }

    var initPageList = function(totalPages){

        $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            visiblePages: 5,
            onPageClick: function (event, page) {

            }
        });

    }


    return {
        first : first,
        initPageList : initPageList
    }

})
