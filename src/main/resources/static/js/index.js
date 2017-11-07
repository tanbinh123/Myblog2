/**
 *
 * Created by b1109_000 on 2017/11/5.
 */
    //分页数据
$(document).ready(function() {
    var totalpages;
    //初始化第一页数据
    $.ajax({
        url: "blog/list",
        method: "GET",
        async: false,
        data:{
            'page' : 1,
            'size' : 5
        },
        dataType: "json",
        success: function (data) {
            console.info(data);
            var $ul = $('<ul class="col-12" id="article-list" />');
            $.each(data.data.pageList.content, function(i, obj) {
                // template 将数据填充到模板中 返回填充好的html
                var $li;
                $li = $(template("articleTemp", obj));
                $li.appendTo($ul);
            });
            $ul.appendTo('#content');
            totalpages = data.data.pageList.totalPages;
        }
    });
    // init bootpag
    $('#pagination').bootpag({
        total: totalpages,    // total pages
        page: 1,            // default page
        maxVisible: 5,     // visible pagination
        leaps: true         // next/prev leaps through maxVisible
    }).on("page", function(event, num){
        $('#content').html('');
        $.ajax({
            async: false,
            url: "blog/list",
            method: "GET",
            data:{
                'page' : num,
                'size' : 5
            },
            dataType: "json",
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                // 通常情况下textStatus和errorThown只有其中一个有值
                console.info('错误');
            },
            success: function (data) {
                var $ul = $('<ul class="col-12" id="article-list" />');
                $.each(data.data.pageList.content, function(i, obj) {
                    // template 将数据填充到模板中 返回填充好的html
                    var $li;
                    $li = $(template("articleTemp", obj));
                    $li.appendTo($ul);
                });
                $ul.appendTo('#content');
                $('#pagination').bootpag({total:data.data.pageList.totalPages});
                $('html,body').animate({scrollTop: $('#content').offset().top}, 150);
            }
        });
    });
//博客日期归档
    $.ajax({
        url: "blog/archive_date",
        method: "GET",
        async: false,
        dataType: "json",
        success: function (data) {
            console.info(data);
            $.each(data.data, function(i, obj) {
                // template 将数据填充到模板中 返回填充好的html
                var $li;
                $li = $(template("dateArchiveTemp", obj));
                $li.appendTo($('#date_archiving'));
            });
        }
    });
//博客类别归档
    $.ajax({
        url: "blog/archive_type",
        method: "GET",
        async: false,
        dataType: "json",
        success: function (data) {
            console.info(data);
            $.each(data.data, function(i, obj) {
                // template 将数据填充到模板中 返回填充好的html
                var $li;
                $li = $(template("typeArchiveTemp", obj));
                $li.appendTo($('#type_archiving'));
            });
        }
    });

//个人信息初始化
    $.ajax({
        url: "user/find",
        method: "GET",
        async: true,
        dataType: "json",
        success: function (data) {
            $(".panel-profile-img").attr('src',data.data.avatar);
            $(".panel-title").html(data.data.nickname);
            $(".m-b").html(data.data.profile);
        }
    });
});
