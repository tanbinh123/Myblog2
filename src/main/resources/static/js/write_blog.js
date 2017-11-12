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
        var content = UM.getEditor('container').getContent();
        var tags = $("#form-field-tags").val();
        console.info("tags:"+tags);
        if (title == null || title == '') {
            $.messager.alert('提示', "请输入标题！");
        } else if (blogTypeId == null || blogTypeId == '') {
            $.messager.alert('提示', "请选择博客类别！");
        } else if (content == null || content == '') {
            $.messager.alert('提示', "请输入内容！");
        } else {
            $.post(
                    "${pageContext.request.contextPath}/admin/BlogAction!save.action",
                    {
                        'title' : title,
                        'typeId' : blogTypeId,
                        'content' : content,
                            'contentNoTag' : UM.getEditor('container')
                            .getContentTxt(),
                        'summary' : UM.getEditor('container')
                            .getContentTxt().substr(0, 155),
                        'tags' : tags
                    }, function(result) {
                        $.messager.alert('提示', result.msg);
                    }, "json");
        }
    })
})