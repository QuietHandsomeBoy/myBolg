/**
 * Created by hxpeng on 2016/7/15.
 */


define(['bootstrapSelect', 'icheck', 'wysiwyg', "wysiwygEditor"], function () {


    var init = function () {

        $('.selectpicker').selectpicker({
            showIcon: true,
            showTick: true,
            style: 'select-btn'
        });

        $('.other-condition .i-checks').iCheck({
            checkboxClass: 'icheckbox_flat-orange'
        });

        $('.other-condition').find("input[type='checkbox']").on({
            "ifChecked":function(){
                $(this).val(1);
            },
            "ifUnchecked":function(){
                $(this).val(0);
            }
        })

        $('.tags-list .i-checks').iCheck({
            checkboxClass: 'icheckbox_flat-blue'
        });
        $('.type-confition .i-checks').each(function () {
            var self = $(this),
                label = self.next(),
                label_text = label.text();

            label.remove();
            self.iCheck({
                radioClass: 'icheckbox_line-blue',
                insert: '<div class="icheck_line-icon"></div>' + label_text
            });
        });

        $('#article-content').each(function (index, element) {
            $(element).wysiwyg({
                classes: 'some-more-classes',
                // 'selection'|'top'|'top-selection'|'bottom'|'bottom-selection'
                toolbar: index == 0 ? 'top-selection' : (index == 1 ? 'bottom' : 'selection'),
                buttons: {
                    insertimage: {
                        title: '插入图片',
                        image: '<i class="fa fa-photo"></i>',
                        //showstatic: true,    // wanted on the toolbar
                        showselection: false // wanted on selection
                    },
                    insertlink: {
                        title: '插入链接',
                        image: '<i id="font_link" class="fa fa-link"></i>',
                        showselection: false
                    },
                    // Fontsize plugin
                    fontsize: index == 1 ? false : {
                        title: '字体大小',
                        image: '\uf034',
                        popup: function ($popup, $button) {
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
                                function (name, size) {
                                    var $link = $('<a/>').attr('href', '#').css('font-size', (8 + (size * 3)) + 'px').html(name).click(function (event) {
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
                    alignleft: index != 0 ? false : {
                        title: '居左',
                        image: '<i id="font_align_left" class="fa fa-align-left"></i>',
                        //showstatic: true,    // wanted on the toolbar
                        showselection: false // wanted on selection
                    },
                    aligncenter: index != 0 ? false : {
                        title: '居中',
                        image: '<i id="font_align_center" class="fa fa-align-center"></i>',
                        //showstatic: true,    // wanted on the toolbar
                        showselection: false // wanted on selection
                    },
                    alignright: index != 0 ? false : {
                        title: '居右',
                        image: '<i id="font_align_right" class="fa fa-align-right"></i>',
                        //showstatic: true,    // wanted on the toolbar
                        showselection: false // wanted on selection
                    },
                    orderedList: index != 0 ? false : {
                        title: '有序列表',
                        image: '<i id="font_list_ol" class="fa fa-list-ol"></i>',
                        //showstatic: true,    // wanted on the toolbar
                        showselection: false // wanted on selection
                    },
                    unorderedList: index != 0 ? false : {
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
        $(".wysiwyg-toolbar").prepend("<a id='showUploadBox' href='javascript:$(\"#uploadFile_box\").show();' class='wysiwyg-toolbar-icon' title='插入图片'><i class='fa fa-photo'></i></a>");


        $("#save-article").on("click",function(){
            saveArticle();
        })

        document.onclick = function(event) {
            var e = event || window.event;
            var elem = e.srcElement || e.target;

            while (elem) {
                if (elem.id == "uploadFile_box") {
                    return;
                };
                elem = elem.parentNode;
            };
            $("#uploadFile_box").hide();
        }

    }



    var saveArticle = function(){
        if($("input[name='articleRange']:checked").length < 1){
            tips("请选择笔记范围！");
            return;
        }
        if($("input[name='articleTags']:checked").length < 1){
            tips("请为笔记选择标签！");
            return;
        }
        if($("input[name='articleTitle']").val() == ""){
            tips("请输入笔记标题！");
            return;
        }
        if($("textarea[name='articleIntroduced']").val() == ""){
            tips("请输入笔记简介！");
            return;
        }
        if($("textarea[name='articleContent']").val() == ""){
            tips("请输入博客正文！");
            return;
        }
        $("#articleForm").submit();
    }















    return {
        init:init
    }


})