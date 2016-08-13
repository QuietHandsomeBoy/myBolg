/**
 * Created by hxpeng on 2016/7/20.
 */

require.config({
    baseUrl: "/" + document.URL.split("/")[3] + "/resources",
    paths: {
        "jQuery": "js/common/jquery",
        "highcharts": "js/admin/highchart/highcharts",
        "jqueryAniview": "js/admin/aniview/jquery.aniview.min",
        "jqueryMetisMenu": "js/admin/metismenu/jquery.metisMenu",
        "jqueryTwbsPagination": "js/admin/pagination/jquery.pagination",
        "wysiwyg": "js/admin/wysiwyg/wysiwyg",
        "wysiwygEditor": "js/admin/wysiwyg/wysiwyg-editor",
        "bootstrap": "js/admin/bootstrap/bootstrap",
        "bootstrapDatetimepicker": "js/admin/bootstrap/bootstrap-datetimepicker.min",
        "bootstrapSelect": "js/admin/bootstrap/bootstrap-select",
        "pjax": "js/common/pjax",
        "nprogress": "js/common/nprogress",
        "jqueryCookie": "js/common/jquery.cookie",
        "metismenu": "js/admin/metismenu/jquery.metisMenu",
        "icheck": "js/common/icheck",
        "index": "js/admin/index",
        "articleList": "js/admin/articleList",
        "insertArticle": 'js/admin/insertArticle'
    },
    shim: {
        "bootstrap": ['jQuery'],
        "highcharts": ['jQuery'],
        "jqueryAniview": ['jQuery'],
        "jqueryMetisMenu": ['jQuery'],
        "jqueryTwbsPagination": ['jQuery'],
        "wysiwyg": ['jQuery'],
        "wysiwygEditor": ['jQuery'],
        "bootstrapDatetimepicker": ['jQuery', 'bootstrap'],
        "pjax": ['jQuery'],
        "nprogress": ['jQuery'],
        "jqueryCookie": ['jQuery'],
        "metismenu": ['jQuery'],
        "bootstrapSelect": ['jQuery', 'bootstrap'],
        "icheck": ['jQuery']
    },
    urlArgs: "bust=" + (new Date()).getTime()
});


require(['nprogress'], function (NProgress) {
    require(['jQuery', 'jqueryAniview', 'jqueryMetisMenu', 'bootstrap', 'pjax'], function () {

        $('#side-menu').metisMenu();
        $(document).pjax("a", "#content", {fragment: '#content'})
            .on("pjax:timeout", function (event) {
                event.preventDefault()
            })
            .on("pjax:send", function () {
                NProgress.start();
            })
            .on("click", ".nav-second-level li", function (event) {
                var aactive = $(".nav-second-level .active");
                if (aactive) {
                    var activeobj = aactive.find("a");
                    activeobj.attr("href", activeobj.attr("data-a-href"));
                    aactive.removeClass("active");
                }
                if (!$(this).hasClass("active")) {
                    var aobj = $(this).find("a");
                    $(this).addClass("active");
                    aobj.attr("data-a-href", aobj.attr("href"));
                    aobj.attr("href", "javascript:;");
                }
            })
            .on("submit", "#searchArticleParam", function () {

            })
            .on("click", function () {

            })
            .on("pjax:complete", function () {
                setTimeout(function () {
                    NProgress.done();
                }, 500);
            })
            .on("pjax:end", function () {
            })
    });
})


Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

//普通提示弹出框
var tips = function (msg) {
    var html = '<div class="tips-div" id="resultTips">';
    html += '<div class="tips-content">';
    html += '<h3>提示</h3>';
    html += '<div>';
    html += '<p>' + msg + '</p>';
    html += '<button class="btn btn-default pull-right" onclick="closeTips()">Close me!</button>';
    html += '</div>';
    html += '</div>';
    html += '</div>';
    html += '<div class="tips-background-div"></div>';
    $("body").append(html);
    setTimeout(function () {
        $("#resultTips").addClass("tips-show");
    }, 100);
}

//关闭弹出框
var closeTips = function (objName) {
    if(objName != null && objName != ''){
        $("#"+objName).removeClass("tips-show");
    }else{
        $("#resultTips").removeClass("tips-show");
    }
    setTimeout(function () {
        if(objName != null && objName != ''){
            $("#"+objName).remove();
        }else{
            $("#resultTips").remove();
        }
        $(".tips-background-div").remove();
    }, 100);
}

//确认提示弹出框
var confimTips = function (params) {
    if ($('#confimTips').length) {
        return false;
    }
    var buttonHTML = '';
    $.each(params.buttons, function (name, obj) {
        // Generating the markup for the buttons:
        buttonHTML += '<button class="' + obj['class'] + '">' + name + '</button>';
        //buttonHTML += '<a href="#" class="button ' + obj['class'] + '">' + name + '<span></span></a>';
        if (!obj.action) {
            obj.action = function () {
            };
        }
    });
    var html = '<div class="tips-div" id="confimTips">';
    html += '<div class="tips-content">';
    html += '<h3>'+params.title+'</h3>';
    html += '<div>';
    html += '<p>' + params.message + '</p>';
    //html += '<button class="btn btn-default pull-right">NO</button>';
    //html += '<button class="btn btn-default pull-right">Yes</button>';
    html += buttonHTML;
    html += '</div>';
    html += '</div>';
    html += '</div>';
    html += '<div class="tips-background-div"></div>';
    $("body").append(html);
    setTimeout(function () {$("#confimTips").addClass("tips-show");}, 100);

    var buttons = $('#confimTips .btn'), i = 0;
    $.each(params.buttons, function (name, obj) {
        buttons.eq(i++).click(function () {
            // Calling the action attribute when a
            // click occurs, and hiding the confirm.
            obj.action();
            closeTips("confimTips");
            return false;
        });
    });
}

//文章类型枚举
var changeArticleTag = function(articleRange){
    switch (articleRange)
    {
        case "note":
            return "笔记";
        case "diary":
            return "日记";
        case "tabloid":
            return "文摘";
        case "other":
            return "其他";
    }
    return "文章"
}