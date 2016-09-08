/**
 * Created by hxpeng on 2016/9/8.
 */

define(['bootstrapSelect', 'bootstrapDatetimepicker', 'icheck', 'pjax', 'baseutil'], function () {

    var publicUtil = PublicUtil;

    var binding = function () {

        $('.list-content-box .i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green'
        });
    }

    var init = function () {

        binding();

        $(".datetimepicker").remove();
        if ($(".datetimepicker").length < 1) {
            $(".group").find(".date").datetimepicker({
                autoclose: true,
                todayBtn: true
            });
        }

        var srearchCondition = '';//文章查询条件
        var paginationCondition = '';//分页查询条件

        $("#searchBtn").on("click", function () {
            assembling();
        })

        var totalPages = Number($("#totalPages").val());
        var currentPage = Number($("#page").val());
        var lastBtn = $("#lastBtn");
        var nextBtn = $("#nextBtn");
        $("#articlePagination").on("click", "li", function () {
            paginationFun($(this));
        })

        var assembling = function (type) {
            srearchCondition = "";
            $.each($("#searchLogsParam").serializeArray(), function (k, v) {
                if ($("input[name='" + v.name + "']").attr("type") == 'text' && publicUtil.isNotEmpty($("input[name='" + v.name + "']").val())) {
                    srearchCondition += v.name + "=" + $("input[name='" + v.name + "']").val() + "&";
                }
                if ($("input[name='" + v.name + "']").attr("type") == 'checkbox' && $("input[name='" + v.name + "']:checked")) {
                    srearchCondition += v.name + "=" + $("input[name='" + v.name + "']").val() + "&";
                }
                if ($("select[name='" + v.name + "']").length == 1 && $("select[name='" + v.name + "']").val() != "") {
                    srearchCondition += v.name + "=" + $("select[name='" + v.name + "']").val() + "&";
                }
            })
            if (type == "refresh") {
                submitSearchForm(srearchCondition + paginationCondition, "search");
            } else {
                srearchCondition = srearchCondition.substring(0, srearchCondition.length - 1);
                submitSearchForm(srearchCondition, "search");
            }
        }


        var paginationFun = function (obj) {
            var page = $(obj);
            var pageBtn = page.find("button");
            var pageBtnText = pageBtn.html();
            var activeBtn = $("#articlePagination").find(".active");
            if (!isNaN(pageBtnText)) {
                if (pageBtnText == currentPage) {
                    return;
                }
                $("#page").val(pageBtnText);
                currentPage = pageBtnText;
                page.addClass("active").siblings().removeClass("active");
                resetBtnStat(currentPage, totalPages);
            } else if (pageBtn.attr("id") == 'lastBtn') {
                if (currentPage == 1) {
                    return;
                }
                currentPage--;
                $("#page").val(currentPage);
                resetBtnStat(currentPage, totalPages);
                activeBtn.prev().addClass("active").siblings().removeClass("active");
            } else if (pageBtn.attr("id") == 'nextBtn') {
                if (currentPage == totalPages) {
                    return;
                }
                currentPage++;
                $("#page").val(currentPage);
                resetBtnStat(currentPage, totalPages);
                activeBtn.next().addClass("active").siblings().removeClass("active");
            }

            paginationCondition = "";
            $.each($(".right-tags-box").find("input"), function (k, v) {
                if ($("input[name='" + v.name + "']").attr("type") == 'hidden') {
                    paginationCondition += v.name + "=" + $("input[name='" + v.name + "']").val() + "&";
                }
            })
            paginationCondition = paginationCondition.substring(0, paginationCondition.length - 1);
            submitSearchForm(srearchCondition + '&' + paginationCondition, "pagination");
        }

        var resetBtnStat = function (currentPage, totalPages) {
            if (currentPage == 1) {
                lastBtn.attr("disabled", "true");
            }
            if (currentPage > 1 && currentPage <= totalPages) {
                lastBtn.removeAttr("disabled");
            }
            if (currentPage == totalPages) {
                nextBtn.attr("disabled", "true");
            }
            if (currentPage < totalPages) {
                nextBtn.removeAttr("disabled");
            }
        }


        var submitSearchForm = function (condition, type) {
            $(".pagination-loading").show();
            var contextBox = $(".list-content-box").find("table tbody");
            contextBox.css("opacity", "0");
            $.ajax({
                type: "POST",
                url: ctx + "/admin/logs/logsList.json",
                dataType: "json",
                data: condition,
                async: false,
                success: function (data) {
                    setTimeout(function () {
                        $(".pagination-loading").hide();
                    }, 500);
                    var resultObj = JSON.parse(data);
                    var articleList = resultObj.tagsList;
                    var pagination = resultObj.pagination;
                    var resultHtml = '';
                    if (articleList.length <= 0) {
                        resultHtml += '<tr>';
                        resultHtml += '<td style="text-align: center;" colspan="8">暂无数据.......</td>';
                        resultHtml += "</tr>";
                    }

                    $.each(articleList, function (k, v) {
                        resultHtml += '<tr>';
                        resultHtml += '<td class="log-user-name">' + v.operationUserName + '</td>';
                        resultHtml += '<td><label class="label label-biji">' + changeOperationType(v.logType) + '</label></td>';
                        resultHtml += '<td>' + v.operationMethod + '</td>';
                        resultHtml += '<td><a href="javascript:;" class="title-common log-content">' + v.operationContent + '</a></td>';
                        resultHtml += '<td>' + v.operationIp + '</td>';
                        resultHtml += '<td>' + new Date(v.operationDate).format("yyyy-MM-dd mm:dd:ss") + '</td>';
                        resultHtml += "</tr>";
                    })
                    setTimeout(function () {
                        contextBox.html(resultHtml);
                        //重新绑定
                        binding();
                        contextBox.css("opacity", "1");
                    }, 300);

                    if (type == 'search') {
                        $("#articlePagination").html("");//清空分页div，重新添加
                        var paginationHtml = '<li><button id="lastBtn">&laquo;</button></li>';
                        if (pagination.currentPage == 1) {
                            paginationHtml = '<li><button id="lastBtn" disabled="true">&laquo;</button></li>';
                        }
                        for (var i = 1; i < pagination.totalPages + 1; i++) {
                            if (pagination.currentPage == i) {
                                paginationHtml += '<li class="active"><button class="paginationNum">' + i + '</button></li>';
                            } else {
                                paginationHtml += '<li><button class="paginationNum">' + i + '</button></li>';
                            }
                        }
                        paginationHtml += '<li><button id="nextBtn"';
                        if (pagination.totalPages == pagination.currentPage) {
                            paginationHtml += 'disabled="true"';
                        }
                        paginationHtml += '>&raquo;</button></li>';

                        $("#articlePagination").append(paginationHtml);
                        currentPage = pagination.currentPage;
                        totalPages = pagination.totalPages;
                        $("#totalRecordsSpan").html(pagination.totalRecords);
                        lastBtn = $("#lastBtn");
                        nextBtn = $("#nextBtn");
                    }
                },
                error: function () {
                    setTimeout(function () {
                        $(".pagination-loading").hide();
                    }, 500);
                    alert('error');
                }
            });
        }
    }


    return {
        init: init,
    }
})