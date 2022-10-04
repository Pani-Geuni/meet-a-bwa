$(function () {

    //로그인이 되어있고(안되어있으면 로그인 유도하는 팝업......), 모임에 가입되어있을 때(모임 가입 유도 팝업), 가입 가능

    //사용자 - 액티비티 가입 전 > 1)액티비티 가입하기 버튼, 2)액티비티 가입 유도 섹션, 3)이벤트/투표/활동 신청 섹션, 수정.삭제/탈퇴버튼 비활성화

    //사용자 - 액티비티 가입 후 > 1)액티비티 가입하기 버튼 비활성화, 2)액티비티 가입유도 섹션 비활성화, 3)이벤트/투표/활동 신청 섹션, 탈퇴버튼, 수정/삭제버튼 비활성화

    //액티비티 개설자 > 1)액티비티 가입하기 버튼 비활성화, 2)액티비티 가입유도 섹션 비활성화, 3)이벤트/투표/활동 신청 섹션, 수정/삭제버튼, 탈퇴버튼 비활성화

    //스크롤 생성 > 이벤트, 투표, 활동 신청이 일정 칸 이상을 넘었을때

    //가입 후 팝업(activityPopup_joinSuccess.html)

    //탈퇴 재확인 팝업(activityPopup_exitCheck.html)

    //삭제 재확인 팝업(activityPopup_deleteCheck.html)

    //액티비티 좋아요 버튼
    
    
    
	
    
    // 액티비티 가입하기
    let idx = "";
	
	$("#join_activity_btn").on("click", function() {
		idxx = $(this).attr("idxx");
		if(idxx==null){
			$(".login-layer").removeClass("blind");
		}
		else {
		idx = $(this).attr("idx");
		
		ajax_load(idx);
		}
	});
	
	function ajax_load(idx) {
		$.ajax({
			url : "/meet-a-bwa/a_registered.do",
			type : "GET",
			dataType : "json",
			data : {
				activity_no : idx
			},
			
			success : function(res) {
				console.log("succees")
				
				location.reload();
			},
			
			error : function(res, status, text) {
				console.log("error");
				console.log(text);
			}
		});
	}
	
	// 액티비티 탈퇴
	$(".activityExitBtn").on("click", function() {
//		$(".activityExit-popup").removeClass("blind");
//		$(".withdrawal").click(function() {
//		$(".activityExit-popup").addClass("blind");
		console.log($(this).attr("idx"));
		
		idx = $(this).attr("idx");
		
		ajax_load_exit(idx);
//		});
//		$(".cancle").click(function() {
//				$(".activityExit-popup").addClass("blind");
//		});
	});
	
	function ajax_load_exit(idx) {
		$.ajax({
			url : "/meet-a-bwa/a_withdrawal.do",
			type : "GET",
			dataType : "json",
			data : {
				activity_no : idx
			},
			
			success : function(res) {
				console.log("success");
				console.log(res)
				
				location.reload();
			},
			
			error : function(res, status, text) {
				console.log("error")
				console.log(text)
			}
		});
	}
});