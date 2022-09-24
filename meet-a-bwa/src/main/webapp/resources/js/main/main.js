$(document).ready(function() {

	$.ajax({
		url : "/meet-a-bwa/main_init.do",
		type : "POST",
		dataType : 'json',
		data : {
			isLogin : false, // 추후에 쿠키로 값 가져올거임
			userInterest : "",
			userRegion : ""
		},
		success : function(result) {
			console.log(result);    
		},
		error : function(request, status, error) {
		 	console.log(error);
		 }
	});
	
    $("#plusImg").click(function(){
        $("#fold_tag").removeClass("blind");
        $(this).addClass("blind");
        $("#foldImg").removeClass("blind");
    });
    
    $("#foldImg").click(function(){
        $("#fold_tag").addClass("blind");
        $(this).addClass("blind");
        $("#plusImg").removeClass("blind");
    });

    $(".tagItem").click(function(e){
        $(".tagItem").removeClass("check");
        $(e.target).addClass("check");
    })
    
 	$(".btn-cancel").click(function(){
 		$(".logout-layer").addClass("blind");
 	});
    
});