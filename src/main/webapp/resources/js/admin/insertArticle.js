/**
 * Created by hxpeng on 2016/7/15.
 */

define(['bootstrapSelect', 'icheck', 'ajaxfileupload', 'wysiwyg', "wysiwygEditor", "toastr"], function () {


    var wysiwygeditor;

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
            "ifChecked": function () {
                $(this).val(1);
            },
            "ifUnchecked": function () {
                $(this).val(0);
            }
        })

        $('.tags-list .i-checks').iCheck({
            checkboxClass: 'icheckbox_flat-blue'
        });

        $("#save-as-draft").on("click",function(){
            saveArticleContent();
        })

        $(document).on("click",".add-btn",function(){
            var btnType = $(this).attr("data-type");
            if (btnType == 'add') {
                var classLength = $(".related-article-box").find("div").length;
                if(classLength > 1){
                    tips("最多只可添加两个相关文章链接！");
                    return;
                }
                $(".related-article-box").find("button").each(function () {
                    $(this).attr("data-type","del").removeClass("fa-plus").addClass("fa-minus");
                })
                var html = "<div>"+
                    '<input type="text" name="aboutArticleUrl" class="form-control key-words-input"/>'+
                    '<button class="add-btn fa fa-plus" type="button" data-type="add"></button>'+
                    '</div>';
                $(".related-article-box").append(html);
            } else if (btnType == 'del') {
                $(this).parent().remove();
                //var classLength = $(".related-article-box").find("div").length;
                //if(classLength > 1){
                //    var obj = $(".related-article-box").find("div").eq(classLength-1);
                //    var lastObj = obj.prev();
                //    lastObj.find("button").removeClass("fa-minus").addClass("fa-plus");
                //    obj.remove();
                //}else{
                //    return;
                //}
            }
        })

        $("input[name='keyWords']").blur(formatKeyWords).keydown(tagKeydown);

        $("#choosArticleTagsBtn").on("click", function () {
            var obj = {
                tipsId: "articleTags"
            }
            operateTips(obj);
        })

        $('#article-content').each(function (index, element) {
            wysiwygeditor = $(element).wysiwyg({
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
        $(".wysiwyg-toolbar").append(orderBtn);

        $("#save-article").on("click", function () {
            saveArticle();
        })

    }

    function tagKeydown(ev) {
        var code = (ev ? ev.which : event.keyCode);
        if (code == 8) {
            //如果是退格键
            var ss = $('#key-words-list span');
            if (ss.length > 0 && $("input[name='keyWords']").val().length == 0) {
                ss.eq(ss.length - 1).remove();
                formatKeyWords();
            } else if (ss.length == 1) {
                ss.eq(ss.length - 1).remove();
                formatKeyWords();
                $("input[name='keyWords']").css({'padding-left': 15});
            }
        }
    }

    var formatKeyWords = function () {
        if ($("input[name='keyWords']").val()) {
            var keyWords = '';
            $('#key-words-list span').each(function () {
                keyWords += this.innerHTML + ',';
            });
            keyWords += $("input[name='keyWords']").val().trim(',').replace(/[^\u4e00-\u9fa5\w\s\-+.#,，]+/g, '');
            keyWords = keyWords.trim(',').split(/[,，]+/g);
            var s = [];
            for (var i = 0; i < keyWords.length; i++) {
                if ($.inArray(keyWords[i], s)) {
                    if (keyWords[i] != '') {
                        s.push(keyWords[i].trim().slice(0, 20));
                    }
                }
                if (s.length == 4) break;
            }
            var resultHtml = '';
            for (var i = 0; i < s.length; i++) {
                resultHtml += '<span title="' + s[i] + '">' + s[i] + '</span>';
            }
            $('#key-words-list').html(resultHtml);
            $('#key-words-list span').click(function () {
                $(this).remove();
                formatKeyWords();
            });
        }
        if ($('#key-words-list span').length == 0) {
            $("input[name='keyWords']").css({'padding-left': 15});
        } else {
            var w = $('#key-words-list').width();
            $("input[name='keyWords']").val('').css({
                'padding-left': w
            });
        }
    }

    var saveArticle = function () {
        if ($("select[name='articleRights']").val() == '') {
            tips("请选择文章来源渠道！");
            return;
        }
        if ($("select[name='articleRange']").val() == '') {
            tips("请选择文章所属分类！");
            return;
        }
        if ($("input[name='articleTags']:checked").length < 1) {
            tips("请为笔记选择标签！");
            return;
        }
        if ($("input[name='articleTitle']").val() == "") {
            tips("请输入笔记标题！");
            return;
        }
        if ($("textarea[name='articleIntroduced']").val() == "") {
            tips("请输入笔记简介！");
            return;
        }
        if ($("textarea[name='articleContent']").val() == "") {
            tips("请输入博客正文！");
            return;
        }
        $("#articleForm").submit();
    }


    var saveArticleContent = function(){
        wysiwygeditor.getHTML();
    }

    return {
        init: init
    }


})