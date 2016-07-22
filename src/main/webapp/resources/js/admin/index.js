/**
 * Created by hxpeng on 2016/7/9.
 */

define(['highcharts'], function() {

    setInterval(function(){$('#nowTime').html(currentTime)},1000);
    $('#bar-chart-container').highcharts({
        chart: {
            backgroundColor: '#f5f5f5'
        },
        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Article',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }, {
            name: 'Comments',
            data: [0, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
        }, {
            name: 'Leave Message',
            data: [0, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
        }, {
            name: 'Watch',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });


    function closeCharBox(){
        $(".content-char-info").attr("av-animation","bounceOutRight");
        $(".content-char-info").removeClass("fadeInRight").addClass("fadeOutRight");
        setTimeout(function(){$(".content-char-info").css("height","0px");},1000);
    }

    function currentTime(){
        var d = new Date(),str = '';
        str += d.getFullYear()+'-';
        str += (d.getMonth()+1>9?d.getMonth()+1:'0'+(d.getMonth()+1))+'-';
        str += (d.getDate()>9?d.getDate():'0'+d.getDate())+'&nbsp;';
        str += (d.getHours()>9?d.getHours():'0'+d.getHours())+':';
        str += (d.getMinutes()>9?d.getMinutes():'0'+d.getMinutes())+':';
        str += d.getSeconds()>9?d.getSeconds():'0'+d.getSeconds();
        return str;
    }
    function saveArticle(){

        var tipsDiv = $("#resultTips");
        var checkTxt = tipsDiv.find("p").html("错误：");
        if($("input[name='articleRange']:checked").length < 1){
            checkTxt.append("请选择笔记范围！");
            tipsDiv.addClass("tips-show");
            return false;
        }
        if($("input[name='articleTags']:checked").length < 1){
            checkTxt.append("请为笔记选择标签！");
            tipsDiv.addClass("tips-show");
            return false;
        }
        if($("input[name='articleTitle']").val() == ""){
            checkTxt.append("请输入笔记标题！！");
            tipsDiv.addClass("tips-show");
            return false;
        }
        if($("textarea[name='articleTitle']").val() == ""){
            checkTxt.append("请输入笔记简介！！");
            tipsDiv.addClass("tips-show");
            return false;
        }
        if($("textarea[name='articleContent']").val() == ""){
            checkTxt.append("请输入博客正文！");
            tipsDiv.addClass("tips-show");
            return false;
        }
        $("#articleForm").submit();
    }
    function closeTipsBox(){
        $(".tips-div").removeClass("tips-show");
    }
});

//$(function () {
//    setInterval(function(){$('#nowTime').html(currentTime)},1000);
//    $('#side-menu').metisMenu();
//
//
//    $(document).pjax("a", "#content", {fragment:'#content'})
//        .on("pjax:timeout", function (event) {
//            event.preventDefault()
//        })
//        .on("click",".nav-second-level li",function(event){
//            var aactive = $(".nav-second-level .active");
//            if(aactive){
//                var activeobj = aactive.find("a");
//                activeobj.attr("href",activeobj.attr("data-a-href"));
//                aactive.removeClass("active");
//            }
//            if(!$(this).hasClass("active")){
//                var aobj = $(this).find("a");
//                $(this).addClass("active");
//                aobj.attr("data-a-href",aobj.attr("href"));
//                aobj.attr("href","javascript:;");
//            }
//        })
//        .on("click",function(){
//
//        })
//        .on("pjax:end",function(){
//        })
//
//    $('#bar-chart-container').highcharts({
//        chart: {
//            backgroundColor: '#f5f5f5'
//        },
//        title: {
//            text: '',
//            x: -20 //center
//        },
//        subtitle: {
//            text: '',
//            x: -20
//        },
//        xAxis: {
//            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
//                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
//        },
//        yAxis: {
//            title: {
//                text: ''
//            },
//            plotLines: [{
//                value: 0,
//                width: 1,
//                color: '#808080'
//            }]
//        },
//        tooltip: {
//            valueSuffix: '°C'
//        },
//        legend: {
//            layout: 'vertical',
//            align: 'right',
//            verticalAlign: 'middle',
//            borderWidth: 0
//        },
//        series: [{
//            name: 'Article',
//            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
//        }, {
//            name: 'Comments',
//            data: [0, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
//        }, {
//            name: 'Leave Message',
//            data: [0, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
//        }, {
//            name: 'Watch',
//            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
//        }]
//    });
//});
//function closeCharBox(){
//    $(".content-char-info").attr("av-animation","bounceOutRight");
//    $(".content-char-info").removeClass("fadeInRight").addClass("fadeOutRight");
//    setTimeout(function(){$(".content-char-info").css("height","0px");},1000);
//}
//
//function currentTime(){
//    var d = new Date(),str = '';
//    str += d.getFullYear()+'-';
//    str += (d.getMonth()+1>9?d.getMonth()+1:'0'+(d.getMonth()+1))+'-';
//    str += (d.getDate()>9?d.getDate():'0'+d.getDate())+'&nbsp;';
//    str += (d.getHours()>9?d.getHours():'0'+d.getHours())+':';
//    str += (d.getMinutes()>9?d.getMinutes():'0'+d.getMinutes())+':';
//    str += d.getSeconds()>9?d.getSeconds():'0'+d.getSeconds();
//    return str;
//}
//function saveArticle(){
//
//    var tipsDiv = $("#resultTips");
//    var checkTxt = tipsDiv.find("p").html("错误：");
//    if($("input[name='articleRange']:checked").length < 1){
//        checkTxt.append("请选择笔记范围！");
//        tipsDiv.addClass("tips-show");
//        return false;
//    }
//    if($("input[name='articleTags']:checked").length < 1){
//        checkTxt.append("请为笔记选择标签！");
//        tipsDiv.addClass("tips-show");
//        return false;
//    }
//    if($("input[name='articleTitle']").val() == ""){
//        checkTxt.append("请输入笔记标题！！");
//        tipsDiv.addClass("tips-show");
//        return false;
//    }
//    if($("textarea[name='articleTitle']").val() == ""){
//        checkTxt.append("请输入笔记简介！！");
//        tipsDiv.addClass("tips-show");
//        return false;
//    }
//    if($("textarea[name='articleContent']").val() == ""){
//        checkTxt.append("请输入博客正文！");
//        tipsDiv.addClass("tips-show");
//        return false;
//    }
//    $("#articleForm").submit();
//}
//function closeTipsBox(){
//    $(".tips-div").removeClass("tips-show");
//}