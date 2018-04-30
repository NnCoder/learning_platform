$(document).ready(function() {
		// 模态框控制代码
		$('#login-btn').click(function() {
			var account,password;
			account=$('#account').val();
			password=$('#password').val();
			// if(window.localStorage){     alert("浏览支持localStorage") }else{    alert("浏览暂不支持localStorage") }
						// window.sessionStorage.setItem('account',account);
						// window.sessionStorage.setItem('password',password);
							$.cookie('USERTOKEN', account+":"+password, { expires: 7 });
							$.ajax({
								url: '',
								type: 'post',
								data: {username: account,password:password},
							})
							.done(function() {
								console.log("success");
							})
							.fail(function() {
								console.log("error");
							})
							.always(function() {
								console.log("complete");
							});
							
						// $('.show-model').find('.login-result').html('恭喜你登陆成功！');
						// $('.show-model').addClass('show-model-active');

						// $('.show-model').on('click', function(event) {
		    //         		if( $(event.target).is('.delete-btn') ||$(event.target).is('.show-model') ) {
						// 		$(this).removeClass('show-model-active');
						// 	}
						// 	if( $(event.target).is('.confirm-btn')) {
						// 		$(location).attr('href','homePage.html');
		    //         		}
						// 	if( $(event.target).is('.delete-btn')) {
						// 		$(location).attr('href','homePage.html');                		
		    //         		}
		    //     		});
			// $.ajax({
			// 	url: 'http://192.168.1.125:8080/edu/stu/login',
			// 	type: 'POST',
			// 	data: {stu_num: account,stu_psw: password},
			// 	success:function(res) {
			// 		if (res.status==1) {
			// 			window.sessionStorage.setItem('account',account);
			// 			window.sessionStorage.setItem('password',password);
			// 			$('.show-model').find('.login-result').html('恭喜你登陆成功！');
			// 			$('.show-model').addClass('show-model-active');
			// 			$('.show-model').on('click', function(event) {
		 //            		if( $(event.target).is('.delete-btn') ||$(event.target).is('.show-model') ) {
			// 					$(this).removeClass('show-model-active');
			// 				}
			// 				if( $(event.target).is('.confirm-btn')) {
			// 					$(location).attr('href','homePage.html');
		 //            		}
			// 				if( $(event.target).is('.delete-btn')) {
			// 					$(location).attr('href','homePage.html');                		
		 //            		}
		 //        		});
			// 		}else {
			// 			$('.show-model').addClass('show-model-active');
			// 			$('.show-model').find('.login-result').html('验证失败，请检查你的账号密码！');
			// 			$('.show-model').on('click', function(event){
		 //            		if( $(event.target).is('.delete-btn') ||$(event.target).is('.confirm-btn') ) {
			// 					$(this).removeClass('show-model-active');
			// 				}
		 //        		});
			// 		}
			// 	}
			// })
			// $.ajax({
			// 	url: 'http://192.168.1.125:8080/edu/stu/login',
			// 	type: 'POST',
			// 	data: {stu_num: account,stu_psw: password},
			// })
			// .done(function() {
			// 	console.log("success");
			// })
			// .fail(function() {
			// 	console.log("error");
			// })
			// .always(function() {
			// 	console.log("complete");
			// });
			

			
			// Cookies.set('account', account, { expires: 7 });
			// $.cookie('account', account, { expires: 7 });

			
			// .fail(function() {
			// 	console.log("error");
			// })
			// .always(function() {
			// 	console.log("complete");
			// });	
		});
});