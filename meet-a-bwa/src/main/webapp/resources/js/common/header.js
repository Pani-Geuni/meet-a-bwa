/**
 * 
 */
 
 $(function(){
 	
 	$("#beforeLogin").click(function(){
 		$(".login-layer").removeClass("blind");
 	});
 	
 	$("#afterLogin").click(function(){
 		$(".logout-layer").removeClass("blind");
 	});
 	
 	$(".btn-cancel").click(function(){
 		$(".logout-layer").addClass("blind");
 	});
 });