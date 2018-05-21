$(function(){
		var selection = $("#aq-course1").find("select");
		var chapter_list = $("#aq-course2").find("select");
		var point_list = $("#aq-course3").find("select");
		selection.change(function(){
			$.ajax({
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				type : "GET",
				url : "admin/get-knowledge-point/" + selection.val(),
				success : function(message,tst,jqXHR) {
					if(!util.checkSessionOut(jqXHR))return false;
					if (message.result == "success") {
						chapter_list.empty();
						$.each(message.object,function(key,values){
							point_list.append("<option value=\"" + key + "\">" + values + "</option>");
						});
					} else {
						util.error("操作失败请稍后尝试");
					}
				},
				error : function(xhr) {
					util.error("操作失败请稍后尝试");
				}
			});
		});
		
		chapter_list.change(function(){
			$.ajax({
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				type : "GET",
				url : "admin/get-knowledge-point/" + selection.val(),
				success : function(message,tst,jqXHR) {
					if(!util.checkSessionOut(jqXHR))return false;
					if (message.result == "success") {
						point_list.empty();
						$.each(message.object,function(key,values){
							point_list.append("<option value=\"" + key + "\">" + values + "</option>");
						});
					} else {
						util.error("操作失败请稍后尝试");
					}
				},
				error : function(xhr) {
					util.error("操作失败请稍后尝试");
				}
			});
		});
		
		
});

