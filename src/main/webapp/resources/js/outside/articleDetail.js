/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil',"jqueryAniview"], function () {

    var init = function () {
        $('.aniview').AniView();

        $("#container").scrollTop(0);
    }


    return {
        init: init,
    }
})

