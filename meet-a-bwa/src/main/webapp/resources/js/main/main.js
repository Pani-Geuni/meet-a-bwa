$(document).ready(function() {

	$.ajax({
		url : "/main_init.do",
		success : function(response,status){
			console.log("error");
			console.log(res);
		},
		error : function(res){
			console.log("error");
			console.log(res);
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
    
});