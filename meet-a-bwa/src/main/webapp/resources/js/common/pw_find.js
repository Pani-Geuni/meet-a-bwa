/**
 * 
 */
$(function(){
	let flag = true;
	 
	$("#pw_find_okBtn").click(function(){
 		if($("#pw-email-input").val().trim().length != 0){
 			find_ajax();
 		}else{
 			$("#pw_find_result").addClass("blind");
 			fade_in_out("이메일을 입력해주세요.");
 		}
 	});
 	$("#pw_find_cancleBtn").click(function(){
 		$("#pw_find_result").addClass("blind");
 		$("#pw_find_wrap").addClass("blind");
 	});
 	
 	function find_ajax(){
	 	$.ajax({
            url : "/meet-a-bwa/pw_find.do",
			type : "POST",
			dataType : 'json',
			data : {
				email : $("#pw-email-input").val().trim()
			},
			success : function(res) {
		        $("#pw_find_result").removeClass("blind");
		        
				if(res.result != "not found"){
			        $("#pw_find_result").text(res.result);
				}else{
			        $("#pw_find_result").text("해당 이메일로 가입된 회원이 없습니다.");
				}
			},
			error : function(error) {
			 	console.log(error);
			 }
        });
 	}
 	// 토스트 함수
    function fade_in_out(text){
        if(flag){
            flag = false;
            $("#toast_txt").text(text);
            $("#toastWrap").removeClass("hide");
            $("#toastWrap").removeClass("fade-out");
            $("#toastWrap").addClass("fade-in");
        
            setTimeout(function() {
                flag = true; // 추후에 사용할 수 있도록 변수값 변경
                $("#toastWrap").removeClass("fade-in");
                $("#toastWrap").addClass("fade-out");
            }, 2000);
        }
    }
 });