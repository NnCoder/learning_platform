$(document).ready(function() {


	var rankPagination = $('#rank-pagination');
	var paginationList = Array.prototype.slice.call(rankPagination.find('li'),0);
	var list_length = paginationList.length;
	
	if(pageLength == undefined){
		var pageLength = 1;
	}
	pagination (pageLength);
	// 调用分页的效果	
	if(fresh == undefined){
		var fresh = function(index) {
			console.log('第'+index+'页');
		}
	}
	
	
	function getActiveIndex() {
		for (var i = 0; i < paginationList.length; i++) {
			if (paginationList[i].getAttribute('class')=='active') {
				fresh(parseInt(paginationList[i].innerHTML));
			}
		}
	}
	function pagination (pageLength) {
		for (var i = 0; i < paginationList.length; i++) {
			paginationList[i].onclick = function(i) {
				return function () {
					if (i == 0) {
						previousPage(pageLength);
					}else if(i == (list_length-1)) {
						nextPage(pageLength);
					}else if(i ==list_length-2){
						toLastPage(pageLength);
						activate(5);
					}else if (i <list_length-3) {
						activate(i);
					}
					getActiveIndex();
				}

			}(i);
		}
	}
	function nextPage (pageLength) {
		if(parseInt(paginationList[1].innerHTML)>(pageLength-5)) {
			return;
		}else {
			for (var i = 1; i < 6; i++) {
				paginationList[i].innerHTML=parseInt(paginationList[i].innerHTML)+1;
			}
		}
		
	}
	function activate(index) {
		for (var i = 0; i < paginationList.length; i++) {
			paginationList[i].removeAttribute('class');
		}
		paginationList[index].setAttribute('class','active');
	}
	function toLastPage(pageLength) {
		for (var i = 1; i < 6; i++) {
				paginationList[i].innerHTML=(pageLength-5+i);
			}
	}
	function previousPage (pageLength) {
		if(parseInt(paginationList[1].innerHTML)<=1) {
			return;
		}else {
			for (var i = 1; i < 6; i++) {
				paginationList[i].innerHTML=parseInt(paginationList[i].innerHTML)-1;
			}
		}
	}

});
