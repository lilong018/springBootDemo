layui.use(['layer', 'form'], function () {
    let layer = layui.layer
        , form = layui.form;
    form.render(null, 'test1');
    form.on('submit(formSubmit)', function (data) {
        let method = data.form.method,
            action = data.form.action,
            field = data.field;
        if (JSON.stringify(field) == "{}") {
            field = $(data.form).serializeJson();
        }
        layer.load();
        sendAjax(method, action, field)
        return false;
    });

    $('.js-ajax-form').submit(function (e) {
        let action = $(this)[0].action,
            type = $(this)[0].method,
            data = $(this).serializeJson();
        console.log('表单this',$(this))
        console.log("是否自定义请求类型",data._method);
        if (data._method != null) {
            type = data._method;
        }
        sendAjax(type, action, data)
        return false;
    })

    function sendAjax(type, url, json) {
        layer.load();
        $.ajax({
            type: type,
            url: url,
            data: json,
            dataType: "json",
            success: (res) => {
                layer.closeAll('loading');
                if (!res.succeed) { //错误
                    layer.msg('' + res.msg, {icon: 5, time: res.wait * 1000}, function () {
                        //什么都不做
                    });
                } else {
                    if (res.msg != '' && res.msg != null) {
                        layer.msg('' + res.msg, {time: res.wait * 1000}, function () {
                            if (res.url != '' && res.url != null) { //不是空
                                if (res.url.substring(0, 1) != '/' && res.url.substring(0, 4) != 'http') { //如果给的是 abc这样的路径
                                    console.log(window.location.href.substring(0,window.location.href.lastIndexOf("/")+1))
                                    window.location.href = window.location.href.substring(0,window.location.href.lastIndexOf("/")+1) +res.url;
                                } else {//如果给的是 /abc 这样的路径
                                    window.location.href = '' + res.url;
                                }
                            } else { //是空
                                window.location.reload();
                            }
                        });
                    } else {
                        layer.msg('成功', {time: res.wait * 1000}, function () {
                            if (res.url != '' && res.url != null) { //不是空
                                if (res.url.substring(0, 1) != '/' && res.url.substring(0, 4) != 'http') { //如果给的是 abc这样的路径
                                    window.location.href = window.location.href.substring(0,window.location.href.lastIndexOf("/")+1) +res.url;
                                } else {//如果给的是 /abc 这样的路径
                                    window.location.href = '' + res.url;
                                }
                            } else { //是空
                                window.location.reload();
                            }
                        });
                    }
                }
            },
            error: (res) => {
                layer.closeAll('loading');
                layer.msg('请求失败，服务繁忙...', {icon: 5});
            }
        });

    }


    $(document).ready(() =>{
        $(".js-ajax-get").click(function (e) {
            let $this = $(this),
                data = $this.data('data'),
                url = $this.data('url');
            if (url == null || url == '') {
                let href = $this.attr('href')
                if (url == null || url == '') {
                    layer.msg('链接不存在', {icon: 5, time: 3000}, function () {
                        //什么都不做
                    });
                    return false;
                }
                url = href;
            }
            if (data == null || data == '') {
                data = "{}";
            }
            data = JSON.parse(data);
            sendAjax('get', url, data)
            return false;
        })
        $(".js-ajax-post").click(function (e) {
            let $this = $(this),
                data = $this.data('data'),
                url = $this.data('url');
            if (url == null || url == '') {
                let href = $this.attr('href')
                if (url == null || url == '') {
                    layer.msg('链接不存在', {icon: 5, time: 3000}, function () {
                        //什么都不做
                    });
                    return false;
                }
                url = href;
            }
            if (data == null || data == '') {
                data = "{}";
            }
            data = JSON.parse(data);
            sendAjax("post", url, data)
            return false;
        })
        $(".js-ajax-put").click(function (e) {
            let $this = $(this),
                data = $this.data('data'),
                url = $this.data('url');
            if (url == null || url == '') {
                let href = $this.attr('href')
                if (url == null || url == '') {
                    layer.msg('链接不存在', {icon: 5, time: 3000}, function () {
                        //什么都不做
                    });
                    return false;
                }
                url = href;
            }
            if (data == null || data == '') {
                data = "{}";
            }
            data = JSON.parse(data);
            sendAjax('put', url, data)
            return false;
        })
        $(".js-ajax-delete").click(function (e) {
            if (confirm("您确定要删除吗？")) {
                let $this = $(this),
                    data = $this.data('data'),
                    url = $this.data('url');
                if (url == null || url == '') {
                    let href = $this.attr('href')
                    if (href == null || href == '') {
                        layer.msg('链接不存在', {icon: 5, time: 3000}, function () {
                            //什么都不做
                        });
                        return false;
                    }
                    url = href;
                }
                if (data == null || data == '') {
                    data = "{}";
                }
                data = JSON.parse(data);
                sendAjax('delete', url, data)
            }
            return false;
        })
        $(".js-ajax-head").click(function (e) {
            let $this = $(this),
                data = $this.data('data'),
                url = $this.data('url');
            if (url == null || url == '') {
                let href = $this.attr('href')
                if (url == null || url == '') {
                    layer.msg('链接不存在', {icon: 5, time: 3000}, function () {
                        //什么都不做
                    });
                    return false;
                }
                url = href;
            }
            if (data == null || data == '') {
                data = "{}";
            }
            data = JSON.parse(data);
            sendAjax('head', url, data)
            return false;
        })
        $(".js-ajax-options").click(function (e) {
            let $this = $(this),
                data = $this.data('data'),
                url = $this.data('url');
            if (url == null || url == '') {
                let href = $this.attr('href')
                if (url == null || url == '') {
                    layer.msg('链接不存在', {icon: 5, time: 3000}, function () {
                        //什么都不做
                    });
                    return false;
                }
                url = href;
            }
            if (data == null || data == '') {
                data = "{}";
            }
            data = JSON.parse(data);
            sendAjax("options", url, data)
            return false;
        })
    });

});

(function ($) {
    $.fn.serializeJson = function () {
        let serializeObj = {};
        let dataArr = this.serializeArray();
        $(dataArr).each(function () {
            // serializeObj[this.name] = this.value;
            if (serializeObj[this.name]) { // 字段是否存在
                //字段存在
                if ($.isArray(serializeObj[this.name])) { // 检查“值”是否被分类为“数组”对象。
                    serializeObj[this.name].push(this.value);
                } else { // 不是就把他做成数组
                    serializeObj[this.name] = [ serializeObj[this.name], this.value ];
                }
            } else {
                serializeObj[this.name] = this.value; // 添加一个新的属性
            }
        });
        return serializeObj;
    };
})(jQuery);