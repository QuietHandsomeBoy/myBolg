/**
 * Created by hxpeng on 2016/7/22.
 */


define(['bootstrapDatetimepicker', 'icheck','jqueryTwbsPagination'], function() {

    $(".form-group .date").datetimepicker({
        autoclose: true,
        todayBtn: true
    });
    $('table input[type=checkbox]').on('ifChecked', function(){
        $("#edit-one-article").attr("disabled","disabled");
    });
    $('table input[type=checkbox]').on('ifUnchecked', function(){
        $("#edit-one-article").removeAttr("disabled");
    });
    $("#toggle-all").click(function(){
        if($(this).find("input[type=hidden]").val()=="0"){
            $(".list-content-box table tr").each(function(i,z){
                $(z).find("input[type=checkbox]").iCheck('check');
            })
            $(this).find("input[type=hidden]").val(1)
        }else{
            $(".list-content-box table tr").each(function(i,z){
                $(z).find("input[type=checkbox]").iCheck('uncheck');
            })
            $(this).find("input[type=hidden]").val(0)
        }
    })
    $('.category-list .i-checks').iCheck({
        checkboxClass: 'icheckbox_flat-blue'
    });
    $('.other-condition .i-checks').iCheck({
        checkboxClass: 'icheckbox_flat-orange'
    });
    $('.folder-list .i-checks').each(function(){
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
    $(function(){
        $("#navigation li a").click(function(){
            $("#navigation li a").each(function(){
                $(this).removeClass("active");
            })
            $(this).addClass("active");
        })

        $('#pagination-demo').twbsPagination({
            totalPages: 5,
            visiblePages: 3,
            onPageClick: function (event, page) {
                $('#page-content').text('Page ' + page);
            }
        });
    })

})
