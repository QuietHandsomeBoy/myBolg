/**
 * Created by hxpeng on 2016/7/20.
 */

require.config({
    baseUrl : "/" + document.URL.split("/")[3] + "/resources",
    paths:{
        "jQuery":"js/common/jquery",
        "highcharts":"js/admin/highchart/highcharts",
        "jqueryAniview":"js/admin/aniview/jquery.aniview.min",
        "jqueryMetisMenu":"js/admin/metismenu/jquery.metisMenu",
        "jqueryTwbsPagination":"js/admin/pagination/jquery.pagination",
        "wysiwyg":"js/admin/wysiwyg/wysiwyg",
        "wysiwygEditor":"js/admin/wysiwyg/wysiwyg-editor",
        "bootstrap":"js/admin/bootstrap/bootstrap",
        "bootstrapDatetimepicker":"js/admin/bootstrap/bootstrap-datetimepicker.min",
        "bootstrapSelect":"js/admin/bootstrap/bootstrap-select",
        "pjax":"js/common/pjax",
        "nprogress":"js/common/nprogress",
        "jqueryCookie":"js/common/jquery.cookie",
        "metismenu":"js/admin/metismenu/jquery.metisMenu",
        "icheck":"js/common/icheck",
        "index":"js/admin/index",
        "articleList":"js/admin/articleList",
        "insertArticle":'js/admin/insertArticle'
    },
    shim : {
        "bootstrap":['jQuery'],
        "highcharts":['jQuery'],
        "jqueryAniview":['jQuery'],
        "jqueryMetisMenu":['jQuery'],
        "jqueryTwbsPagination":['jQuery'],
        "wysiwyg":['jQuery'],
        "wysiwygEditor":['jQuery'],
        "bootstrapDatetimepicker":['jQuery','bootstrap'],
        "pjax":['jQuery'],
        "nprogress":['jQuery'],
        "jqueryCookie":['jQuery'],
        "metismenu":['jQuery'],
        "bootstrapSelect":['jQuery','bootstrap'],
        "icheck":['jQuery']
    },
    urlArgs: "bust=" +  (new Date()).getTime()
});



require(['jQuery', 'jqueryAniview', 'jqueryMetisMenu', 'bootstrap', 'pjax'], function() {

    $('#side-menu').metisMenu();
    $(document).pjax("a", "#content", {fragment:'#content'})
        .on("pjax:timeout", function (event) {
            event.preventDefault()
        })
        .on("click",".nav-second-level li",function(event){
            var aactive = $(".nav-second-level .active");
            if(aactive){
                var activeobj = aactive.find("a");
                activeobj.attr("href",activeobj.attr("data-a-href"));
                aactive.removeClass("active");
            }
            if(!$(this).hasClass("active")){
                var aobj = $(this).find("a");
                $(this).addClass("active");
                aobj.attr("data-a-href",aobj.attr("href"));
                aobj.attr("href","javascript:;");
            }
        })
        .on("click",function(){

        })
        .on("pjax:end",function(){
        })
});