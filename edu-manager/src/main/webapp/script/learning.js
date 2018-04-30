$(document).ready(function() {
			$('.knowledge-point-item').on('click', 'li', function(event) {
				event.preventDefault();
				if (($(this).attr('class')+'a').indexOf('show-list')>=0) {
					$(this).removeClass('show-list');
				}else {
					$('.show-list').removeClass('show-list');
					$(this).addClass('show-list');
				}

			});

				var list_length=$('.knowledge-point-item').length;
				$('#arrow-right').click(function() {
					if (!$('#knowledge-point-list').is(":animated")) {
						var leftLength=document.getElementById('knowledge-point-list').offsetLeft;
						// alert(leftLength);
						if (-leftLength<(list_length-4)*230||leftLength==0) {

							$('#knowledge-point-list').animate({left: leftLength-460+'px'});							
						}
					}	
				});
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
		});