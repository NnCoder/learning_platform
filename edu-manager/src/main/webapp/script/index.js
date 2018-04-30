$(document).ready(function() {
	// 获取账号信息
	if ($.cookie('account')&&$.cookie('password')) {
		var user_account=$.cookie('account');
		var user_password=$.cookie('password');
		alert(user_account+user_password)
		// $.ajax({
		// 	url: 'http://192.168.1.125:8080/edu/stu/query',
		// 		type: 'POST',
		// 		success:function (res) {

		// 		// if (res.status==1) {
		// 		// 	alert()
		// 			alert(JSON.stringify(res));
		// 			alert(res.student_num);
		// 			// $('.user-info').find('.user-account').html(res.student_num);
		// 			// $('.user-info').find('.user-name').html(res.student_name);
		// 			// $('.user-info').find('.user-account').html(window.sessionStorage.getItem('account'));
		// 		// 	$('.logout-btn').click(function() {
		// 		// 		window.sessionStorage.removeItem('account');
		// 		// 		window.sessionStorage.removeItem('password');
		// 		// 		$(location).attr('href','login_for_student.html');
		// 		// 	});
		// 		// }

		// 	}
		// })
	}else {
		// $(location).attr('href','login_for_student.html');
	}
	

	

});