/**
 * Created by hxpeng on 2016/6/22.
 */

define(['commonJS', 'bootstrapJs', 'baseutil'], function () {

    var init = function () {

        var menuui = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;

            var links = this.el.find('.link');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
        }

        menuui.prototype.dropdown = function (e) {
            var $el = e.data.el, $this = $(this), $next = $this.next();

            $next.slideToggle();
            $this.parent().toggleClass('open');

            if (!e.data.multiple) {
                $el.find('.childMenu').not($next).slideUp().parent().removeClass('open');
            };
        }

        var menuui = new menuui($('#menuui'), false);

    }


    return {
        init: init,
    }
})

