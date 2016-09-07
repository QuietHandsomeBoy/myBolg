/**
 * Created by hxpeng on 2016/7/15.
 */

define(['bootstrapSelect', 'icheck', 'ajaxfileupload', "wysiwyg", "wysiwygEditor", "toastr", "baseutil"], function () {

    var publicUtil = PublicUtil;

    var init = function () {

        if ($('#key-words-list').width() != 0) {
            $("input[name='keyWords']").val('').css({
                'padding-left': $('#key-words-list').width()
            });
        } else {
            $("input[name='keyWords']").val('').css({'padding-left': "15px"});
        }

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

        $("#save-as-draft").on("click", function () {
            saveArticle("draft");
        })

        $("#save-article").on("click", function () {
            saveArticle("normal");
        })

        $("#tags-list-box").on("click", "span", function () {
            $(this).remove();
        })

        $(".left-box-content").on("click", ".add-btn", function () {
            var classLength = $(".related-article-box").find("div").length;

            var btnType = $(this).attr("data-type");
            if (btnType == 'add') {
                if (classLength > 1) {
                    tips("最多只可添加两个相关文章链接！");
                    return;
                }
                $(".related-article-box").find("button").each(function () {
                    $(this).attr("data-type", "del").removeClass("fa-plus").addClass("fa-minus");
                })
                var html = "<div>" +
                    '<input type="text" name="aboutArticleId" class="form-control key-words-input" autocomplete="off"/>' +
                    '<button class="add-btn fa fa-minus" type="button" data-type="del"></button>' +
                    '</div>';
                $(".related-article-box").append(html);
            } else if (btnType == 'del') {
                $(this).parent().remove();
                if ($(".related-article-box").find("div").length == 1) {
                    $(".related-article-box").find("button").each(function () {
                        $(this).attr("data-type", "add").removeClass("fa-minus").addClass("fa-plus");
                    })
                    return;
                }
            }
        })

        $("input[name='keyWords']").blur(formatKeyWords).keydown(keyWordKeydown);

        $("#choosArticleTagsBtn").on("click", function () {
            var tagWords = new Array();
            $.each($("#tags-list-box").find("span"), function (k, v) {
                var tag = {};
                tag.tagId = $(v).attr("id");
                tag.tagHtml = $(v).html();
                tagWords.push(tag);
            })
            var obj = {
                tipsId: "articleTags",
                tagWords: tagWords
            }
            operateTips(obj);
        })


        $("#articleForm").find("input").keypress(function (e) {
            var code = (e ? e.which : event.keyCode);
            if (code == 13) {
                return false;
            }
        })

        $('#article-content').each(function (index, element) {
            $(element).wysiwyg({
                //classes: 'some-more-classes',
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


    }

    function keyWordKeydown(ev) {
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

    function tagsWordKeydown(ev) {
        var code = (ev ? ev.which : event.keyCode);
        if (code == 8) {
            //如果是退格键
            var ss = $('#choosed-tags-box span');
            if (ss.length > 0 && $("input[name='choosedTagsInput']").val().length == 0) {
                ss.eq(ss.length - 1).remove();
                formatTagsWords();
            } else if (ss.length == 1) {
                ss.eq(ss.length - 1).remove();
                formatTagsWords();
                $("input[name='choosedTagsInput']").css({'padding-left': 15});
            }
        }
    }

    /**
     * 格式化输入字符串获取标签或关键词
     * @param stringVal 需要格式化的字符串
     * @param boxClassName 容器className
     * @param wordsLength 最多可格式化获得的长度
     */
    var getFormatWords = function (stringVal, boxClassName, wordsLength) {
        if (publicUtil.isNotEmpty(new String(stringVal).trim())) {
            var words = new Array();
            var wordsHtml = "";
            var oldwordsHtml = "";
            $('#' + boxClassName).find("span").each(function () {
                var word = {};
                word.wordId = "";
                word.wordhtml = this.innerHTML;
                if (publicUtil.isNotEmpty($(this).attr("id"))) {
                    word.wordId = $(this).attr("id");
                }
                words.push(word);
                wordsHtml += this.innerHTML + ',';
            });
            oldwordsHtml = wordsHtml;
            wordsHtml += stringVal.trim(',').replace(/[^\u4e00-\u9fa5\w\s\-+.#,，]+/g, '');
            wordsHtml = wordsHtml.trim(',').split(/[,，]+/g);
            oldwordsHtml = oldwordsHtml.trim(',').split(/[,，]+/g);
            for (var i = 0; i < wordsHtml.length; i++) {
                if ($.inArray(wordsHtml[i], oldwordsHtml) == -1) {
                    var word = {};
                    word.wordId = "";
                    word.wordhtml = wordsHtml[i];
                    words.push(word);
                }
                if (words.length == wordsLength) {
                    $(".tags-sources-box").find("input[type='checkbox']").not("input:checked").iCheck('disable');
                    break
                }
            }
            var resultHtml = '';
            $.each(words, function (k, v) {
                resultHtml += '<span title="' + v.wordhtml + '" id="' + v.wordId + '">' + v.wordhtml + '</span>';
            });
            $('#' + boxClassName).html(resultHtml);
            $('#' + boxClassName).find("span").click(function () {
                $(this).remove();
                var wordId = $(this).attr("id");
                if (publicUtil.isNotEmpty(wordId)) {
                    cleanTagChecked(wordId);
                }
                if ($('#' + boxClassName).find("span").length < 5) {
                    $(".tags-sources-box").find("input[type='checkbox']").iCheck('enable');
                }
                getFormatWords("", boxClassName, wordsLength);
            });
        }

        if ($('#' + boxClassName).find("span").length == 0) {
            $('#' + boxClassName).parent().find("input[type='text']").val('').css({'padding-left': 15});
        } else {
            var w = $('#' + boxClassName).width();
            $('#' + boxClassName).parent().find("input[type='text']").val('').css({'padding-left': w});
        }
    }
    var cleanTagChecked = function (id) {
        $(".tags-list").find("input[type=checkbox]:checked").each(function () {
            if ($(this).attr("id") == id) {
                $(this).iCheck('uncheck');
                return false;
            }
        })
    }

    var formatKeyWords = function () {
        getFormatWords($("input[name='keyWords']").val(), "key-words-list", 4);
    }
    var formatTagsWords = function () {
        getFormatWords($("input[name='choosedTagsInput']").val(), "choosed-tags-box", 5);
    }

    var checkaboutArticleId = function () {
        $.each($("input[name='aboutArticleId']"), function (k, v) {
            if (publicUtil.isNotEmpty(url)) {
                var url = $(v).val();
                if (publicUtil.isNotEmpty(url)) {
                    //if (url.toLowerCase().indexOf("http://localhost:8082") == -1 || url.toLowerCase().indexOf("/article/articleDetail/") == -1) {
                    if (url.indexOf("http://localhost:8082") == -1 || url.indexOf("/article/articleDetail/") == -1 || url.indexOf(".html") == -1) {
                        return false;
                    }
                    var splitStr = url.split("/");
                    var articleId = 0;
                    if (splitStr.length == 6) {
                        articleId = splitStr[5];
                        articleId = articleId.substring(articleId.indexOf("."), articleId.length);
                    }
                    if (publicUtil.isNotEmpty(articleId)) {
                        $.ajax({
                            type: "POST",
                            url: ctx + "/admin/article/isArticle.json",
                            dataType: "json",
                            data: {"articleId": articleId},
                            async: false,
                            success: function (data) {
                                if (data.result == 'true') {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        })
                    }
                }
            }
        })
        return true;
    }


    var checkArticle = function () {

        if (!checkaboutArticleId()) {
            tips("请输入正确的文章地址！")
            return false;
        }
        if (!publicUtil.isNotEmpty($("select[name='articleRights']").val())) {
            tips("请选择文章来源渠道！");
            return false;
        }
        if (!publicUtil.isNotEmpty($("select[name='articleRange']").val())) {
            tips("请选择文章所属分类！");
            return false;
        }
        if ($("#tags-list-box").find("span").length < 1) {
            tips("请为笔记选择标签！");
            return false;
        }

        if (!publicUtil.isNotEmpty($("input[name='articleTitle']").val())) {
            tips("请输入笔记标题！");
            return false;
        }
        if ($("textarea[name='articleContent']").val() == "") {
            tips("请输入博客正文！");
            return false;
        }

        return true;
    }

    var saveArticle = function (status) {
        if (checkArticle()) {

            var articleId = $("#articleId").val();
            var newArticleId = $("#newArticleId").val();
            var articleRights = $("select[name='articleRights']").val();
            var articleRange = $("select[name='articleRange']").val();
            var articleTags = $("#tags-list-box").find("span");
            var articleTitle = encodeURIComponent($("input[name='articleTitle']").val());
            var articleContent = $("textarea[name='articleContent']").val();
            var isPublic = $("input[name='isPublic']").is(':checked') ? 1 : 0;
            var onTop = $("input[name='onTop']").is(':checked') ? 1 : 0;
            var limitComments = $("input[name='limitComments']").is(':checked') ? 1 : 0;

            var tagsStr = "";
            var tagArray = new Array();
            if (articleTags.length > 0 && articleTags.length < 6) {
                $.each(articleTags, function (k, v) {
                    var tag = {};
                    if (publicUtil.isNotEmpty($(v).attr("id"))) {
                        tag.id = $(v).attr("id");
                    }
                    tag.tagName = $(v).html();
                    tagArray.push(tag);
                })
                tagsStr = JSON.stringify(tagArray);
            }

            var keyWords = '';
            var keyWordsSpan = $("#key-words-list span");
            if (keyWordsSpan.length > 0) {
                $.each(keyWordsSpan, function () {
                    keyWords += $(this).html() + ',';
                })
            }
            keyWords = keyWords.substring(0, keyWords.length - 1);
            var aboutArticleId = '';
            $.each($("input[name='aboutArticleId']"), function (k, v) {
                var splitStr = $(v).val().split("/");
                //获取相关文章的ID
                aboutArticleId += splitStr[6].substring(0, splitStr[6].indexOf(".")) + ',';
            })
            aboutArticleId = aboutArticleId.substring(0,aboutArticleId.length-1);
            var articleIntroduced = publicUtil.isNotEmpty(new String($("textarea[name='articleIntroduced']").val()).trim)
                ? encodeURIComponent($("textarea[name='articleIntroduced']").val()) : "";
            var content = encodeURIComponent(new String($("textarea[name='articleContent']").val()).trim());
            var articleData = "newArticleId=" + newArticleId + "&articleId=" + articleId + "&articleTitle=" + articleTitle + "&articleIntroduced=" + articleIntroduced + "&articleTags=" + articleTags;
            articleData += "&articleRange=" + articleRange + "&keyWords=" + keyWords + "&isPublic=" + isPublic + "&onTop=" + onTop + "&limitComments=" + limitComments;
            articleData += "&articleRights=" + articleRights + "&articleStatus=" + status + "&content=" + content + "&tagsStr=" + tagsStr + "&aboutArticleId=" + aboutArticleId;

            $.ajax({
                type: "POST",
                url: ctx + "/admin/article/saveArticle.json",
                dataType: "json",
                data: articleData,
                async: false,
                success: function (data) {
                    if (data.result == "success") {
                        tips("新增成功！！");
                    }
                }

            })
        }
    }


    //操作弹出框
    var operateTips = function (obj) {

        if (obj == null) {
            return;
        }
        //obj = {
        //    tipsId : "",
        //    operateType : "",
        //}
        var tagHtml = "";
        if (obj.tagWords.length > 0) {
            $.each(obj.tagWords, function (k, v) {
                tagHtml += '<span title="' + v.tagHtml + '" id="' + v.tagId + '">' + v.tagHtml + '</span>'
            })
        }
        var selectHtml = '<option value="">--请选择--</option>';
        if (publicUtil.isNotEmpty($("#tagEnum").val())) {
            var tagEnum = JSON.parse($("#tagEnum").val());
            $.each(tagEnum, function (k, v) {
                selectHtml += '<option value="' + k + '">' + v + '</option>';
            })
        }
        var html =
            '<div class="tips-div" id="' + obj.tipsId + '">' +
            '<div class="operate-content">' +
            '<h3>选择标签</h3>' +
            '<div>' +
            '<div class="choose-tags-input-box">' +
            '<p>已选择标签：</p>' +
            '<div style="position: relative; height: 50px;"><div id="choosed-tags-box">' + tagHtml + '</div>' +
            '<input type="text" name="choosedTagsInput" class="form-control choosed-tags-input" autocomplete="off"/>' +
            '</div>' +
            '<span class="err-tips">最多只能设置五个标签</span>' +
            '</div>' +
            '<div class="choose-tags-sources-box">' +
            '<p>已选择标签：</p>' +
            '<div>' +
            '<input placeholder="输入标签查找.." id="typeNameInput"/>' +
            '<select class="selectpicker" id="tagTypeSelect">' + selectHtml + '</select>' +
            '<button type="button" id="searcheTags">查询</button>' +
            '</div>' +
            '<div class="tags-sources-box"><div class="pagination-loading" style="display: none;"></div><ul class="tags-list" style="opacity: 0;"></ul></div>' +
            '</div>' +
            '<div style="overflow: auto; padding: 10px 0;">' +
            '<button class="btn btn-default pull-right" id="closeTipsBox" onclick="closeTips(' + "'" + obj.tipsId + "'" + ')">Close me!</button>' +
            '<button class="btn btn-default pull-right choose-it" id="chooseBtn">Choose it!</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="tips-background-div"></div>';

        $("body").append(html);
        $("#searcheTags").on("click", function () {
            $(".tags-sources-box").find("ul").css("opacity", "0");
            $(".pagination-loading").show();
            searchTags();
        })
        $('.selectpicker').selectpicker({
            showIcon: true,
            showTick: true,
            style: 'select-btn'
        });
        $("#choosed-tags-box").on("click", "span", function () {
            var tagId = $(this).remove().attr("id");
            $.each($(".tags-sources-box").find("input[type='checkbox']:checked"), function (k, v) {
                if ($(v).val() == tagId) {
                    $(v).iCheck('uncheck');
                    return false;
                }
            })
        })

        $("input[name='choosedTagsInput']").blur(formatTagsWords).keydown(tagsWordKeydown);
        formatTagsWords();

        $("#typeNameInput").keypress(function (e) {
            var code = (e ? e.which : event.keyCode);
            if (code == 13) {
                $(".tags-sources-box").find("ul").css("opacity", "0");
                $(".pagination-loading").show();
                searchTags();
            }
            return false;
        })
        $("#chooseBtn").on("click", function () {
            var words = new Array();
            $("#choosed-tags-box").find("span").each(function () {
                var word = {};
                word.wordhtml = this.innerHTML;
                word.wordId = "";
                if ($(this).attr("id") != "") {
                    word.wordId = $(this).attr("id");
                }
                words.push(word);
            });
            if (words.length > 0) {
                var resultHtml = "";
                $.each(words, function (k, v) {
                    resultHtml += '<li><span id="' + v.wordId + '" title="' + v.wordhtml + '">' + v.wordhtml + '</span></li>'
                })
                $("#tags-list-box").html(resultHtml);
            }
            $("#closeTipsBox").click();
        })

        setTimeout(function () {
            $("#" + obj.tipsId).addClass("tips-show");
        }, 100);
    }

    var searchTags = function () {
        var tagName = $("#typeNameInput").val();
        var tagType = $("#tagTypeSelect").val();
        $.ajax({
            type: "POST",
            url: ctx + "/admin/tags/findTags.json",
            dataType: "json",
            data: {"tagName": tagName, "tagType": tagType},
            async: false,
            success: function (data) {
                var spanSet = $("#choosed-tags-box").find("span");
                var resultObj = JSON.parse(data);
                var stat = resultObj.stat;
                if (stat == 'success') {
                    var tagList = resultObj.tagList;
                    var resultHtml = "";
                    $.each(tagList, function (k, v) {
                        resultHtml += '<li><label class=""><input type="checkbox"';
                        if (spanSet.length > 0) {
                            $.each(spanSet, function (z, j) {
                                if ($(j).attr("id") == v.id) {
                                    resultHtml += ' checked ';
                                }
                            })
                        }
                        resultHtml += 'value="' + v.id + '" class="i-checks">' + v.tagName + '</label></li>';
                    })
                    setTimeout(function () {
                        $(".pagination-loading").hide();
                        $(".tags-sources-box").find("ul").html(resultHtml);
                        $('.tags-list .i-checks').iCheck({
                            checkboxClass: 'icheckbox_flat-blue'
                        });
                        $(".tags-sources-box ul input[type=checkbox]").on('ifChecked', function () {
                            bingArticleTag($(this).parents("label").clone(), "add");
                        });
                        $(".tags-sources-box ul input[type=checkbox]").on('ifUnchecked', function () {
                            bingArticleTag($(this).parents("label").clone(), "remove");
                        });
                        if (spanSet.length >= 5) {
                            $(".tags-sources-box").find("input[type='checkbox']").not("input:checked").iCheck('disable');
                        }
                        $(".tags-sources-box").find("ul").css("opacity", "1");
                    }, 500);
                } else {
                    $(".tags-sources-box").append("<h5 style='text-align: center;line-height: 40px;'>未查找到相关标签....</h5>");
                }
            }
        })
    }

    var bingArticleTag = function (tag, type) {
        var tagId = $(tag).find("input[type='checkbox']").val();
        if (type == "add") {
            if ($("#choosed-tags-box").find("span").length >= 5) {
                $(".err-tips").css("visibility", "visible");
                return;
            } else {
                $(tag).find("div").remove();
                var tagName = tag.html();
                $("#choosed-tags-box").append("<span title='" + tagName + "' id='" + tagId + "'>" + tagName + "</span>");
                if ($("#choosed-tags-box").find("span").length == 5) {
                    $(".tags-sources-box").find("input[type='checkbox']").not("input:checked").iCheck('disable');
                }
            }
        } else if (type == "remove") {
            $.each($("#choosed-tags-box").find("span"), function () {
                if ($(this).attr("id") == tagId) {
                    $(this).remove();
                }
            })
            if ($("#choosed-tags-box").find("span").length < 5) {
                $(".tags-sources-box").find("input[type='checkbox']").iCheck('enable');
            }
        }
        $("input[name='choosedTagsInput']").val('').css({
            'padding-left': $('#choosed-tags-box').width()
        });
    }


    return {
        init: init
    }


})