	console.log("member_id : " + member_id);
$(document).ready(function() {

	
	$.ajax({
		url : "/meet-a-bwa/main_init.do",
		type : "POST",
		dataType : 'json',
		data : {
			isLogin : $.cookie('isLogin') == "" ? false : $.cookie('isLogin'), // 추후에 쿠키로 값 가져올거임
			userInterest : $.cookie('userInterest'),
			userRegion : $.cookie('userRegion')
		},
		success : function(result) {
            load_meet(result);
		},
		error : function(error) {
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
    
    function load_meet(res){
        for(var i = 0; i < res.list_length; i++){
            let sample = $(".content_list_sample").clone();

            sample.removeClass("content_list_sample");
            sample.removeClass("blind");
            sample.find(".content_title").text(res.list[i].meet_name);
            sample.find(".content_description").text(res.list[i].meet_description);
            /* prop-flag */
            sample.find(".likeCnt").attr("likeCnt", res.list[i].like_cnt);
            
            if(res.list[i].like_cnt < 100){
            	sample.find(".likeCnt").text(res.list[i].like_cnt);
        	}
			else
        		sample.find(".likeCnt").text("99+");
				
            $("#meet_recommendSection").append(sample);
        }

    }
});