	var player=document.getElementById('video-player');
		var ctrl_btn=document.getElementById('controller-btn');
		var pause_logo=document.getElementsByClassName('pause-logo')[0];
		var current_time=document.getElementsByClassName('current-time')[0];
		var duration=document.getElementsByClassName('duration')[0];
		var video_progress=document.getElementsByClassName('video-progress')[0];
		var volume_controller=document.getElementsByClassName('volume-controller')[0];
		var full_screen=document.getElementsByClassName('full-screen')[0];

		full_screen.onclick=function() {
			if (player.requestFullscreen) {  
			    player.requestFullscreen();  
			}  
			else if (player.mozRequestFullScreen) {  
			    player.mozRequestFullScreen();  
			}  
			else if (player.webkitRequestFullScreen) {  
			    player.webkitRequestFullScreen();  
			}
			exitFullScreen ()
		};
		player.onmousemove=function(e) {
			var ylength=player.offsetHeight;
			// alert();
			if (e.layerY<(player.offsetHeight-100)) {
				player.removeAttribute('controller');
			}else {
				player.setAttribute('controller','');
			}
		}
		fullScreenSmall ();
		function fullScreenSmall () {
			player.ondblclick=function () {

			if (player.requestFullscreen) {  
			    player.requestFullscreen();  
			}  
			else if (player.mozRequestFullScreen) {  
			    player.mozRequestFullScreen();  
			}  
			else if (player.webkitRequestFullScreen) {  
			    player.webkitRequestFullScreen();  
			} exitFullScreen ();
		}	
		}
		function exitFullScreen () {
			player.ondblclick=function () {
			
			if (document.exitFullscreen) {  
		        document.exitFullscreen();  
		    }  
		    else if (document.mozCancelFullScreen) {  
		        document.mozCancelFullScreen();  
		    }  
		    else if (document.webkitCancelFullScreen) {  
		        document.webkitCancelFullScreen();  
		    }  
		    fullScreenSmall ();
			}	
		}
		
			
		player.ontimeupdate=function () {
			current_time.innerHTML=toTime(parseInt(player.currentTime));
			duration.innerHTML=toTime(parseInt(player.duration));
			video_progress.setAttribute('max',parseInt(player.duration));
			video_progress.setAttribute('value',parseInt(player.currentTime));

		}
		clickProcess();
		function clickProcess() {
			video_progress.onclick=function(e) {
				var newTime=(e.layerX/this.offsetWidth)*parseInt(player.duration);
				player.currentTime=newTime;
				// if (player.paused) {}
				
				
			};
		}
		clickVolume();
		function clickVolume() {
			volume_controller.onclick=function() {
				player.volume=this.value/100;				
				
			};
		}

		function toTime(number)
		{
			var result=parseInt(number/60)+':'+number%60;
			return result;
		}
		player.onclick=function () {
			if (this.paused) {
				this.play();
				ctrl_btn.style.background='url(../images/play.png)left center no-repeat';
				pause_logo.style.display='none';
			}else {
				this.pause();
				ctrl_btn.style.background='url(../images/asacacsacasa_r2_c2.png)left center no-repeat';
				pause_logo.style.display='block';			
			}
		}
		ctrl_btn.onclick=function () {
			if (player.paused) {
				player.play();
				ctrl_btn.style.background='url(../images/play.png)left center no-repeat';
				pause_logo.style.display='none';
			}else {
				player.pause();
				ctrl_btn.style.background='url(../images/asacacsacasa_r2_c2.png)left center no-repeat';
				pause_logo.style.display='block';			
			}
		}