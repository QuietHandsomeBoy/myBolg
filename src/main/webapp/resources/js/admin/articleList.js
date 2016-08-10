/**
 * Created by hxpeng on 2016/7/22.
 */


define(['bootstrapDatetimepicker', 'icheck'], function () {

    var first = function () {

        var srearchCondition = '';//文章查询条件
        var paginationCondition = '';//分页查询条件

        $(".form-group .date").datetimepicker({
            autoclose: true,
            todayBtn: true
        });
        $('table input[type=checkbox]').on('ifChecked', function () {
            $("#edit-one-article").attr("disabled", "disabled");
        });
        $('table input[type=checkbox]').on('ifUnchecked', function () {
            if ($('table input[type=checkbox]').is(':checked')) {
                return;
            }
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

        $("#navigation").find("li").on("click", function () {
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

        $("#searchBtn").on("click", function () {
            srearchCondition = "";
            $.each($("#searchArticleParam").serializeArray(), function (k, v) {
                if ($("input[name='" + v.name + "']").attr("type") == 'text') {
                    srearchCondition += v.name + "=" + $("input[name='" + v.name + "']").val() + "&";
                }
            })
            srearchCondition = srearchCondition.substring(0, srearchCondition.length - 1);
            submitSearchForm(srearchCondition, "search");
        })

        var totalPages = Number($("#totalPages").val());
        var currentPage = Number($("#page").val());
        var lastBtn = $("#lastBtn");
        var nextBtn = $("#nextBtn");
        $("#articlePagination").on("click", ".page", function () {
            paginationFun($(this));
        })

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
            $.each($("#searchArticleParam").serializeArray(), function (k, v) {
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
        $(".list-main-box").addClass("animated").addClass("fadeInRight");


        var submitSearchForm = function (condition, type) {
            var contextBox = $(".list-content-box").find("table tbody");
            contextBox.css("opacity", "0");
            $.ajax({
                type: "POST",
                url: ctx + "/admin/article/articleList.json",
                dataType: "json",
                data: condition,
                success: function (data) {
                    var resultObj = JSON.parse(data);
                    var articleList = resultObj.articleList;
                    var pagination = resultObj.pagination;
                    var resultHtml = '';
                    if (articleList.length <= 0) {
                        resultHtml += '<tr>';
                        resultHtml += '<td style="text-align: center;" colspan="8">未找到相关文章！</td>';
                        resultHtml += "</tr>";
                    }
                    $.each(articleList, function (k, v) {
                        resultHtml += '<tr>';
                        resultHtml += '<td><input type="checkbox" class="i-checks"></td>';
                        resultHtml += '<td><a href="javascript:;" class="article-title">' + v.articleTitle + '</a></td>';
                        resultHtml += '<td><label class="label label-biji">' + v.articleRange + '</label></td>';
                        resultHtml += '<td>' + v.likesCount + '</td>';
                        resultHtml += '<td>' + v.readCount + '</td>';
                        resultHtml += '<td>' + v.commentCount + '</td>';
                        resultHtml += '<td>' + v.articleAuthorName + '</td>';
                        resultHtml += '<td>' + new Date(v.createDate).format("yyyy-MM-dd") + '</td>';
                        resultHtml += "</tr>";
                    })
                    setTimeout(function () {
                        contextBox.html(resultHtml);
                        //重新绑定
                        $('.list-content-box .i-checks').iCheck({
                            checkboxClass: 'icheckbox_square-green'
                        });
                        $('table input[type=checkbox]').on('ifChecked', function () {
                            $("#edit-one-article").attr("disabled", "disabled");
                        });
                        contextBox.css("opacity", "1");
                    }, 300);

                    if (type == 'search') {
                        $("#articlePagination").html("");//清空分页div，重新添加
                        var paginationHtml = '<li class="page"><button id="lastBtn" disabled="true">&laquo;</button></li>';
                        for (var i = 1; i < pagination.totalPages + 1; i++) {
                            if (pagination.currentPage == i) {
                                paginationHtml += '<li class="active page"><button class="paginationNum">' + i + '</button></li>';
                            } else {
                                paginationHtml += '<li class="page"><button class="paginationNum">' + i + '</button></li>';
                            }
                        }
                        paginationHtml += '<li class="page"><button id="nextBtn"';
                        if(pagination.totalPages == pagination.currentPage){
                            paginationHtml += 'disabled="true"';
                        }
                        paginationHtml += '>&raquo;</button></li>';

                        $("#articlePagination").append(paginationHtml);
                        currentPage = 1;
                        totalPages = pagination.totalPages;
                        lastBtn = $("#lastBtn");
                        nextBtn = $("#nextBtn");
                    }
                },
                error: function () {
                    alert('error');
                }
            });
        }

    }

    var deleteArticle = function (articleIds) {

        var tipsDiv = $("#resultTips");

    }

    return {
        first: first,
    }

})
