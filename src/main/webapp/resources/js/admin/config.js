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
            .on("pjax:complete",function(){
                setTimeout(function(){NProgress.done();}, 500);
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