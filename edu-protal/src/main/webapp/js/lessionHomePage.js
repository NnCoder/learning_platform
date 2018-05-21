$(document).ready(function() {
	$('.lession-info-box').on('click', 'span', function() {
		$(this).parent().parent().find('li').attr('class', '');
		$(this).parent().attr('class','active');
	});

	var learning_process = $('.learning-process').find('p').html();
	var learning_intro = $('.learning-intro').find('p').html();
 $('#more-learning-process').on('click', function(){
    layer.open({
      type: 1,
      title:'学习流程',
      area: ['800px', '360px'],
      shadeClose: true, //点击遮罩关闭
      content: '\<\div style="padding:20px;">'+learning_process+'自定义内容\<\/div>'
    });
  });
 $('#more-learning-intro').on('click', function(){
    layer.open({
      type: 1,
      title:'绪论',
      area: ['800px', '360px'],
      shadeClose: true, //点击遮罩关闭
      content: '\<\div style="padding:20px;">'+learning_intro+'自定义内容\<\/div>'
    });
  });
	//显示登录的个人账号

  // 课程资源的tab
  var tab_titles = $('.my-tab-title').find('li');
  var tab_content = $('.my-tab-content');
  var tab_item = $('#my-tab-content').find('.my-tab-item');
  tab_item.eq(0).addClass('active');
  tab_titles.eq(0).addClass('active');
  tab_titles.click(function() {
    tab_titles.removeClass('active');
    tab_titles.eq(tab_titles.index(this)).addClass('active');
    tab_item.removeClass('active');
    tab_item.eq(tab_titles.index(this)).addClass('active');
  });

// 章节资源的nav
  /*var chapter_list = $('.chapter-list').find('li');
  for (var i = 0; i < chapter_list.length; i++) {
    chapter_list.eq(i).click(function(i) {
      return function () {
        chapter_list.removeClass('active');
        chapter_list.eq(i).addClass('active'); 
      }
    }(i));
  }*/

});