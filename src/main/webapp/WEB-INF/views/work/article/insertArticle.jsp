<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/7/6
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" type="image/png" href="${_adminImagesUrl}/myweb.png">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/bootstrap/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/bootstrap/bootstrap-select.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/animate.min.css">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/bootstrap/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/index.css">
    <script src="${_jsUrl}/jquery-1.11.3.js"></script>
    <script src="${_adminJsUrl}/plugins.js"></script>
    <script src="${_adminJsUrl}/bootstrap/bootstrap.js"></script>
    <script src="${_adminJsUrl}/highcharts.js"></script>
    <script src="${_adminJsUrl}/bootstrap/bootstrap-datetimepicker.min.js"></script>
    <script src="${_adminJsUrl}/jquery.twbsPagination.js"></script>
    <script src="${_adminJsUrl}/index.js"></script>
    <script src="${_adminJsUrl}/wysiwyg/wysiwyg-editor.js"></script>
    <script src="${_adminJsUrl}/wysiwyg/wysiwyg.js"></script>
    <title>MyBolg</title>
</head>
<body>
<div id="myWorld">
    <nav class="left-menu">
        <div class="sidebar-collapse animated fadeInLeft">
            <div class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="${_adminImagesUrl}/head.png"></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear" style="display: block;overflow: hidden;">
                            <span class="block m-t-xs">
                                <strong class="font-bold">干锅加鲁鲁</strong>
                            </span>
                        </span>
                    </a>
                </div>
            </div>
            <ul class="nav metismenu" id="side-menu">
                <li class="">
                    <a href="layouts.html"><i class="fa fa-book"></i> <span class="nav-label">Article</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="articleList.html">笔记列表<span class="label label-warning pull-right">24</span></a>
                        </li>
                        <li><a href="javascript:;">写笔记</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-comments"></i> <span class="nav-label">Comments</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="javascript:;">评论管理<span class="label label-warning pull-right">30</span></a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-pencil-square-o"></i> <span class="nav-label">Leave Message</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="javascript:;">留言管理<span class="label label-warning pull-right">10</span></a></li>
                    </ul>
                </li>
                <li>
                    <a href="mailbox.html"><i class="fa fa-bar-chart"></i> <span
                            class="nav-label">Statistics</span><span class="fa arrow"></span></a>
                    <!--<a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">统计报表</span><span class="label label-warning pull-right">16/24</span></a>-->
                    <ul class="nav nav-second-level collapse">
                        <li><a href="javascript:;">评论统计</a></li>
                        <li><a href="javascript:;">点赞统计</a></li>
                        <li><a href="javascript:;">留言统计</a></li>
                        <li><a href="javascript:;">访问统计</a></li>
                    </ul>
                </li>
                <li>
                    <a href="metrics.html"><i class="fa fa-cog"></i> <span class="nav-label">System</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="javascript:;">菜单管理</a></li>
                        <li><a href="javascript:;">标签管理</a></li>
                        <li><a href="javascript:;">权限管理</a></li>
                        <li><a href="javascript:;">操作日志</a></li>
                        <li><a href="javascript:;">用户管理</a></li>
                        <li><a href="javascript:;">其他</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top animated fadeInDown" style="margin-bottom: 0;">
                <div class="navbar-header">
                    <!--<a class="btn btn-primary minimalize-styl-2" href="#"><i class="fa fa-bars"></i> </a>-->
                    <span class="m-r-sm text-muted system-version">HXPENG Admin Version1.0</span>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <!--<span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>-->
                    </li>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="true">
                            <!--<a class="dropdown-toggle count-info" aria-expanded="true" href="#">-->
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts animated fadeInUp m-t-xs">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="grid_options.html">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>See All Alerts</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="breadcrumb-box">
            <ol class="breadcrumb">
                <li><a href="javascript:;">Home</a></li>
                <li><a HREF="javascript:;">笔记列表</a></li>
                <!--<li class="active"><strong>Flot Charts</strong></li>-->
            </ol>
        </div>
        <div id="content" class="content-container">
            <form action="${_Weburl}/admin/article/saveArticle" method="post" id="">
                <div>
                    <div class="row">
                        <div class="col-lg-3">
                            <div id="left-box" class="animated fadeInUp">
                                <div class="left-box-content">
                                    <div class="file-manager">
                                        <h5>所属分类</h5>
                                        <div class="type-confition form-group">
                                            <input type="radio" name="articleRange" value="diary" class="i-checks"><label class="">日记</label>
                                            <input type="radio" name="articleRange" value="note" class="i-checks"><label class="">笔记</label>
                                            <input type="radio" name="articleRange" value="other" class="i-checks"><label class="">其他</label>
                                        </div>
                                        <h5>关键字设置<label class="label label-gray">用&nbsp;|&nbsp;字符隔开&nbsp;;&nbsp;最多设置四个关键字</label></h5>
                                        <div class="key-words form-group">
                                            <input type='text' name="keyWords" class="form-control key-words-input"/>
                                        </div>
                                        <h5>标签设置</h5>
                                        <ul class="tags-list">
                                            <li><label class=""><input type="checkbox" value="work" name="articleTags" class="i-checks">Work</label></li>
                                            <li><label class=""><input type="checkbox" value="1" name="articleTags" class="i-checks">Documents</label></li>
                                            <li><label class=""><input type="checkbox" value="2" name="articleTags" class="i-checks">Social</label></li>
                                            <li><label class=""><input type="checkbox" value="3" name="articleTags" class="i-checks">Advertising</label></li>
                                            <li><label class=""><input type="checkbox" value="4" name="articleTags" class="i-checks">Clients</label></li>
                                            <li><label class=""><input type="checkbox" value="5" name="articleTags" class="i-checks">Work</label></li>
                                            <li><label class=""><input type="checkbox" value="6" name="articleTags" class="i-checks">Documents</label></li>
                                            <li><label class=""><input type="checkbox" value="7" name="articleTags" class="i-checks">Social</label></li>
                                            <li><label class=""><input type="checkbox" value="8" name="articleTags" class="i-checks">Advertising</label></li>
                                            <li><label class=""><input type="checkbox" value="9" name="articleTags" class="i-checks">Clients</label></li>
                                        </ul>
                                        <h5>其他设置</h5>
                                        <div class="other-condition form-group">
                                            <label class=""><input type="checkbox" class="i-checks" checked>公开</label>
                                            <label class=""><input type="checkbox" class="i-checks">置顶</label>
                                            <label class=""><input type="checkbox" class="i-checks">限制评论</label>
                                        </div>
                                        <div class="save-as-draft-box">
                                            <a href="javascript:;" id="save-as-draft">保存为草稿</a>
                                        </div>
                                        <div class="view-article-box">
                                            <a href="insert.html" id="view-article">预览</a>
                                        </div>
                                        <div class="save-article-box">
                                            <a href="javascript:;" onclick="" id="save-article">保存</a>
                                            <button name="submit" type="submit" id="submit">保存评论</button>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="right-main-box animated fadeInRight">
                                <div class="article-info-box">
                                    <h3> Compose A New Article </h3>
                                    <div class="article-title-box">
                                        <h5>choose the type of article and enter the title</h5>
                                        <div class="row">
                                            <div class="col-lg-2">
                                                <select class="selectpicker">
                                                    <option value="1">Mustard</option>
                                                    <option value="11">Ketchup</option>
                                                    <option value="12">Relish</option>
                                                    <option value="13">Mustard</option>
                                                    <option value="1124">Ketchup</option>
                                                </select>
                                            </div>
                                            <div class="col-lg-10">
                                                <input placeholder="请输入标题.." type="text" class="" name="articleTitle">
                                            </div>
                                        </div>
                                        <h5>enter the introduce of article</h5>
                                        <div class="title-introduce-box">
                                            <textarea id="summary" name="articleIntroduced" style="">测试！！测试！！测试！！测试！！</textarea>
                                        </div>
                                    </div>
                                </div>
                                <div id="article-content-box" class="article-content-box">
                                    <textarea id="article-content" name="articleContent">在此输入正文...</textarea>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <script>
                $(function() {

                    $('.selectpicker').selectpicker({
                        size: 4,
                        showIcon: true,
                        showTick: true,
                        style: 'select-btn'
                    });

                    $('.other-condition .i-checks').iCheck({
                        checkboxClass: 'icheckbox_flat-orange'
                    });
                    $('.tags-list .i-checks').iCheck({
                        checkboxClass: 'icheckbox_flat-blue'
                    });
                    $('.type-confition .i-checks').each(function(){
                        var self = $(this),
                                label = self.next(),
                                label_text = label.text();

                        label.remove();
                        self.iCheck({
                            radioClass: 'icheckbox_line-blue',
                            insert: '<div class="icheck_line-icon"></div>' + label_text
                        });
                    });




                    $('#article-content').each(function(index, element) {
                        $(element).wysiwyg({
                            classes: 'some-more-classes',
                            // 'selection'|'top'|'top-selection'|'bottom'|'bottom-selection'
                            toolbar: index == 0 ? 'top-selection': (index == 1 ? 'bottom': 'selection'),
                            buttons: {
                                //insertimage: {
                                //    title: '插入图片',
                                //    image: '<i class="fa fa-photo"></i>',
                                //    //showstatic: true,    // wanted on the toolbar
                                //    showselection: false // wanted on selection
                                //},
                                insertlink: {
                                    title: '插入链接',
                                    image: '<i id="font_link" class="fa fa-link"></i>',
                                    showselection: false
                                },
                                // Fontsize plugin
                                fontsize: index == 1 ? false: {
                                    title: '字体大小',
                                    image: '\uf034',
                                    popup: function($popup, $button) {
                                        var list_fontsizes = {
                                            // Name : Size
                                            'Huge': 7,
                                            'Larger': 6,
                                            'Large': 5,
                                            'Normal': 4,
                                            'Small': 3,
                                            'Smaller': 2,
                                            'Tiny': 1
                                        };
                                        var $list = $('<div/>').addClass('wysiwyg-toolbar-list').attr('unselectable', 'on');
                                        $.each(list_fontsizes,
                                                function(name, size) {
                                                    var $link = $('<a/>').attr('href', '#').css('font-size', (8 + (size * 3)) + 'px').html(name).click(function(event) {
                                                        $(element).wysiwyg('shell').fontSize(size).closePopup();
                                                        // prevent link-href-#
                                                        event.stopPropagation();
                                                        event.preventDefault();
                                                        return false;
                                                    });
                                                    $list.append($link);
                                                });
                                        $popup.append($list);
                                    }
                                    //showstatic: true,    // wanted on the toolbar
                                    //showselection: true    // wanted on selection
                                },
                                bold: {
                                    title: '字体加粗(Ctrl+B)',
                                    image: '<i id="font_bold" class="fa fa-bold"></i>',
                                    hotkey: 'b'
                                },
                                italic: {
                                    title: '字体斜体(Ctrl+I)',
                                    image: '<i id="font_italic" class="fa fa-italic"></i>',
                                    hotkey: 'i'
                                },
                                underline: {
                                    title: '下划线 (Ctrl+U)',
                                    image: '<i id="font_underline" class="fa fa-underline"></i>',
                                    hotkey: 'u'
                                },
                                strikethrough: {
                                    title: '中线 (Ctrl+S)',
                                    image: '<i id="font_strikethrough" class="fa fa-strikethrough"></i>',
                                    hotkey: 's'
                                },
                                forecolor: {
                                    title: '字体颜色',
                                    image: '\uf1fc'
                                },
                                alignleft: index != 0 ? false: {
                                    title: '居左',
                                    image: '<i id="font_align_left" class="fa fa-align-left"></i>',
                                    //showstatic: true,    // wanted on the toolbar
                                    showselection: false // wanted on selection
                                },
                                aligncenter: index != 0 ? false: {
                                    title: '居中',
                                    image: '<i id="font_align_center" class="fa fa-align-center"></i>',
                                    //showstatic: true,    // wanted on the toolbar
                                    showselection: false // wanted on selection
                                },
                                alignright: index != 0 ? false: {
                                    title: '居右',
                                    image: '<i id="font_align_right" class="fa fa-align-right"></i>',
                                    //showstatic: true,    // wanted on the toolbar
                                    showselection: false // wanted on selection
                                },
                                orderedList: index != 0 ? false: {
                                    title: '有序列表',
                                    image: '<i id="font_list_ol" class="fa fa-list-ol"></i>',
                                    //showstatic: true,    // wanted on the toolbar
                                    showselection: false // wanted on selection
                                },
                                unorderedList: index != 0 ? false: {
                                    title: '无序列表',
                                    image: '<i id="font_list_ul" class="fa fa-list-ul"></i>',
                                    //showstatic: true,    // wanted on the toolbar
                                    showselection: false // wanted on selection
                                },
                                indent: {
                                    title: '左缩进',
                                    image: '<i id="font_list_ul" class="fa fa-indent"></i>'
                                },
                                outdent: {
                                    title: '右缩进',
                                    image: '<i id="font_list_ul" class="fa fa-dedent"></i>'
                                }
                            },
                            // Submit-Button
                            submit: {
                                title: 'Submit',
                                image: '\uf00c'
                            },
                            // Other properties
                            dropfileclick: ' 插入图片 ',
                            placeholderUrl: 'www.xxxxxx.com',
                            maxImageSize: [600, 200]
                        });
                    });

                    $(".wysiwyg-editor").blur();
                    // 加入自定义功能   【全屏/插入代码/插入图片】
                    var orderBtn = "<a onclick='insertCode()' href='javascript:;' class='wysiwyg-toolbar-icon' title='插入代码'><i class='fa fa-code'></i></a>";
                    //orderBtn += "<a onclick='changeStyle(this)' href='javascript:;' class='wysiwyg-toolbar-icon' title='全屏' style='float:right;'><i class='fa fa-expand'></i></a>";
                    $(".wysiwyg-toolbar").append(orderBtn);
                    $(".wysiwyg-toolbar").prepend("<a id='showUploadBox' href='javascript:showUploadBox()' class='wysiwyg-toolbar-icon' title='插入图片'><i class='fa fa-photo'></i></a>");

                    ////////////////////////////////////上面是初始化富文本编辑框///////////////////////////////////////////////

                })
            </script>
        </div>
    </div>
</div>
<script>
</script>
</body>
</html>
