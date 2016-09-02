/**
 * Created by hxpeng on 2016/8/31.
 */

define(['bootstrapSelect', 'bootstrapDatetimepicker', 'icheck', 'pjax', 'baseutil'], function () {

    var publicUtil = PublicUtil;

    var binding = function () {
        $('table input[type=checkbox]').on('ifChecked', function () {
            var len = $(".list-content-box input[type='checkbox']:checked").length;
            if (len == 1) {
                $("#edit-one-article").removeAttr("disabled");
            } else if (len > 1) {
                $("#edit-one-article").attr("disabled", "disabled");
            }
        });
        $('table input[type=checkbox]').on('ifUnchecked', function () {
            var len = $(".list-content-box input[type='checkbox']:checked").length;
            if (len <= 0) {
                $("#edit-one-article").attr("disabled", "disabled");
            }
            if (len < 2 && len > 0) {
                $("#edit-one-article").removeAttr("disabled");
            }
        });

        $('.list-content-box .i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green'
        });
    }

    var init = function () {

        binding();

        var srearchCondition = '';//文章查询条件
        var paginationCondition = '';//分页查询条件

        $('.selectpicker').selectpicker({
            showIcon: true,
            showTick: true,
            style: 'select-btn'
        });
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

        $("#delete-some").on("click", function () {
            if (!$('table input[type=checkbox]').is(':checked')) {
                tips("请选择要删除的标签！");
                return;
            }
            confimTips({
                'title': '确认提示',
                'message': '是否确认删除标签？',
                'buttons': {
                    'Yes': {
                        'class': 'btn btn-default pull-right',
                        'action': function () {
                            var tagIds = '';
                            var tagArray = new Array();
                            $('table input[type=checkbox]:checked').each(function () {
                                tagIds += $(this).val() + ';';
                                tagArray.push($(this).closest("tr"));
                            });
                            deleteTag(tagIds, tagArray);
                        }
                    },
                    'No': {
                        'class': 'btn btn-default pull-right',
                        'action': function () {
                        }
                    }
                }
            });
        })

        $("#refresh-all").on("click", function () {
            assembling("refresh");
        })

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
            $.each($("#searchTagParam").serializeArray(), function (k, v) {
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
            if(type == "refresh"){
                submitSearchForm(srearchCondition + paginationCondition, "search");
            }else{
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
                url: ctx + "/admin/tags/tagsList.json",
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
                        resultHtml += '<td><input type="checkbox" class="i-checks" value="' + v.id + '"></td>';
                        resultHtml += '<td><a href="javascript:;" class="title-common">' + v.tagName + '</a></td>';
                        resultHtml += '<td><label class="label label-biji">' + changeArticleTag(v.tagType) + '</label></td>';
                        resultHtml += '<td>' + new Date(v.createDate).format("yyyy-MM-dd") + '</td>';
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
                        if(pagination.currentPage == 1){
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
                    $("#edit-one-article").attr("disabled", "disabled");//除去edit按钮的禁用元素
                },
                error: function () {
                    setTimeout(function () {
                        $(".pagination-loading").hide();
                    }, 500);
                    alert('error');
                }
            });
        }

        var deleteTag = function (tagIds, articleArray) {
            $.ajax({
                type: "POST",
                url: ctx + "/admin/tags/deleteTagByIds.json",
                dataType: "json",
                data: {"tagIds": tagIds},
                success: function (data) {
                    if (data == 'success') {
                        $.each(articleArray, function () {
                            $(this).addClass("animated").addClass("fadeOutRight");
                            setTimeout(function () {
                                $("table").find(".animated").remove();
                            }, 500);
                        })
                    } else if (data == 'null') {
                        tips("请选择要删除的标签！");
                        return;
                    } else if (data == 'err') {
                        tips("请正确选择标签进行删除！");
                        return;
                    }
                }
            })
        }
    }


    return {
        init: init,
    }
})