/**
 * Created by b1109_000 on 2017/11/10.
 */
$(function(){
    var tag_input = $('#form-field-tags');
    console.info(tag_input);
    try{
        tag_input.tag(

            {
                placeholder:tag_input.attr('placeholder'),
                //enable typeahead by specifying the source array
                source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
                /**
                 //or fetch data from database, fetch those that match "query"
                 source: function(query, process) {
						  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
						  .done(function(result_items){
							process(result_items);
						  });
						}
                 */
            }
        )

        //programmatically add/remove a tag
        var $tag_obj = $('#form-field-tags').data('tag');
      //  $tag_obj.add('Programmatically Added');

        var index = $tag_obj.inValues('some tag');
        $tag_obj.remove(index);
    }
    catch(e) {
        //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
        tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
        //autosize($('#form-field-tags'));
    }


});


$(function(){

    $("#submitData").click(function(){
        var title = $("#title").val();
        var blogTypeId = $("#blogTypeId").val();
        var htmlContent = UM.getEditor('container').getContent();
        var tags = $("#form-field-tags").val();
        if (title == null || title == '') {
            $("#msg").text('博客标题不能为空！');
            $( "#dialog-message").dialog( "open" );
        } else if (blogTypeId == null || blogTypeId == '') {
            $("#msg").text('请选择博客类别！');
            $( "#dialog-message").dialog( "open" );
        } else if (htmlContent == null || htmlContent == '') {
            $("#msg").text('请输入内容！');
            $( "#dialog-message").dialog( "open" );

        } else {
            $.post("/blog/save",
                    {
                        'title' : title,
                        'blogType' : blogTypeId,
                        'htmlContent' : htmlContent,
                        'content' : UM.getEditor('container')
                            .getContentTxt(),
                        'summary' : UM.getEditor('container')
                            .getContentTxt().substr(0, 155),
                        'tags' : tags
                    }, function(result) {
                    $("#msg").text(result.msg);
                    $( "#dialog-message").dialog( "open" );
                    }, "json");
        }
    })
});

$(function(){
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function(title) {
            var $title = this.options.title || '&nbsp;'
            if( ("title_html" in this.options) && this.options.title_html == true )
                title.html($title);
            else title.text($title);
        }
    }));
    $( "#dialog-message" ).dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        title: "<div class='widget-header widget-header-small'><h4 class='smaller'>提示</h4></div>",
        title_html: true,
        buttons: [
            {
                text: "确定",
                "class" : "btn btn-primary btn-minier",
                click: function() {
                    $( this ).dialog( "close" );
                }
            }
        ]
    });
})