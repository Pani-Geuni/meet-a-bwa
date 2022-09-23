/**
 * 
 */
 
 $(function(){
 	
 	$("#mypageBtn").click(function(){
 		$.ajax({
 			url : "/go_mypage.do"
 		});
 	});
 	
 });