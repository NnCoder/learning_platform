$(document).ready(function() {
			/*$('.knowledge-point-item').on('click', 'li', function(event) {
				event.preventDefault();
				if (($(this).attr('class')+'a').indexOf('show-list')>=0) {
					$(this).removeClass('show-list');
				}else {
					$('.show-list').removeClass('show-list');
					$(this).addClass('show-list');
				}

			});*/

				/*var list_length=$('.knowledge-point-item').length;
				$('#arrow-right').click(function() {
					if (!$('#knowledge-point-list').is(":animated")) {
						var leftLength=document.getElementById('knowledge-point-list').offsetLeft;
						// alert(leftLength);
						if (-leftLength<(list_length-4)*230||leftLength==0) {

							$('#knowledge-point-list').animate({left: leftLength-460+'px'});							
						}
					}	
				});*/
				$('#arrow-left').click(function() {
					if (!$('#knowledge-point-list').is(":animated")) {
						var leftLength=document.getElementById('knowledge-point-list').offsetLeft;
						if (leftLength<0) {
							$('#knowledge-point-list').animate({left: leftLength+460+'px'});
						}
					}	
				});
				var tab_items = $('#details-tab').find('li');
				for (var i = 0; i < tab_items.length; i++) {
					tab_items.eq(i).click(function(i) {
						return function () {
							tab_items.removeClass('active');
							tab_items.eq(i).addClass('active');
						};
					}(i));
				}
			   var check_response = $('.check-response');	
			   check_response.click(function(event) {
			   	var responseBox =$(this).parents('.comment').find('.answer-box');
			   	if (responseBox.attr('class').indexOf('active')<0) {
			   		responseBox.addClass('active');	
			   	}else {
					responseBox.removeClass('active');
			   	}
			   });
			   var reply = $('.reply');	
			   reply.click(function(event) {
			   	var responseBox = $(this).parents('.comment').find('.answer-box');
			   	if (responseBox.attr('class').indexOf('active')<0) {
			   		responseBox.addClass('active');	
			   	}else {
					responseBox.removeClass('active');
			   	}
			   });	
			   var response_btn = document.getElementsByClassName('reply-btn');
			   var inserted_html ='<div class="replyer-img-box"><i class="fa fa-user"></i><span class="responser-name"></span></div><div class="reply-text"><p></p><p class="edit-time">时间：刚刚</p></div>';
					for (var i = response_btn.length - 1; i >= 0; i--) {
						response_btn[i].onclick = function() {
							var reply_content = document.createElement('div');
							reply_content.className = 'reply-content';
							reply_content.innerHTML=inserted_html;
							var comment = this.parentNode.parentNode;
							var answer_box = comment.getElementsByClassName('answer-box')[0];
							var user_name = reply_content.getElementsByClassName('responser-name')[0];
							var form = this.parentNode.getElementsByTagName('form')[0];//form标签在这
							$.post('/comments.do',$(form).serialize(),function(res) {alert("回复成功")});
							var form_text = this.parentNode.getElementsByTagName('textarea')[0].value;
							var repler_name = this.parentNode.getElementsByClassName('replyer-name')[0].innerHTML;
							reply_content.getElementsByClassName('reply-text')[0].getElementsByTagName('p')[0].innerHTML = form_text;
							user_name.innerHTML=repler_name;
							comment.insertBefore(reply_content,answer_box);
							form.reset();
					}
				}
					
		});