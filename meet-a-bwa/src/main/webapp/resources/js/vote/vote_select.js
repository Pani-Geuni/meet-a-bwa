$(function() {
	let idx = '';
	let vote_idx = '';
	let choice_idx = "";
	let flag = false;
	let updateFlag = false;
	
	// 오른쪽 섹션 - 투표 생성 버튼 클릭 (+)
	$("#vote_create_btn").click(function() {
		$(".vote-create-update-wrap").removeClass("blind");
		$("#event-create").removeClass("blind");
	});

	// 투표 리스트 선택 - 투표 보기
	$("#vote-summary-list").on("click", ".vote-list-item", function(){
		idx = $(this).attr("idx");
		ajax_load(idx);
	});
	
	
	/********************************************************************/
	/******************** 투표 보기 관련 팝업 내 이벤트 섹션 **********************/
	/********************************************************************/

	// 세팅 초기화
    $(".vote_closeBtn, #view_closeBtn2").click(function(){
    	$(".vote-view-wrap").addClass("blind");
    	$(".vote-view-wrap>.select_custom").addClass("blind");
    	$(".vote-view-wrap>.choice_mem_cnt").addClass("blind");
    	$(".vote-view-wrap>.list_percentage_wrap").addClass("blind");
    	$("#choice_wrap").find(".in_circle").removeClass("choice");
    	$(".voteBtn").addClass("blind");
    	$(".reVoteBtn").addClass("blind");
    	$(".view_closeBtn").addClass("blind");
    	$("#dropdown").addClass("blind");
    	
    	
    	let sample = $(".choiceList:eq(0)").clone();
    	$("#choice_wrap").empty().append(sample);
    });
    
    // 투표 버튼 클릭
    $("#voteBtn").click(function(){
    	let isChoice = $("#choice_wrap").find(".in_circle").hasClass("choice");
    	if(!isChoice){
    		fade_in_out("투표 항목을 선택해주세요.");
    	}else{
    		if(updateFlag){
    			location.href = "/meet-a-bwa/re_voteOK.do?vote_no=" + idx + "&user_no=" + $.cookie("user_no") + "&content_no=" + choice_idx + "&meet_no=" + location.href.split("idx=")[1];
    		}else{
    			location.href = "/meet-a-bwa/voteOK.do?vote_no=" + idx + "&user_no=" + $.cookie("user_no") + "&content_no=" + choice_idx + "&meet_no=" + location.href.split("idx=")[1];
    		}
    	}
    });
    // 재투표 버튼 클릭
    $("#re_voteBtn").click(function(){
    	flag = true;
    	$(".reVoteBtn").addClass("blind");
    	$(".voteBtn").removeClass("blind");
    	$("#choice_wrap").find(".choice_mem_cnt").addClass("blind");
		$("#choice_wrap").find(".list_percentage_wrap").addClass("blind");
		//$("#choice_wrap").find(".in_circle").removeClass("choice");
    });	
	
	
	// 커스텀 셀렉트 show, hide
    $("#more_vertival").click(function(){
        $("#dropdown").toggleClass("blind");
    });
	// 커스텀 셀렉트 선택 시 커스텀 셀렉트 닫고 삭제 여부 묻는 삭제 컨펌창 띄움
	$("#delete").click(function(){
		vote_idx = $(this).attr("voteIdx");

        $("#confirmWrap").removeClass("blind");
        $("#dropdown").addClass("blind");
    });
    // 커스텀 셀렉트 중 수정 클릭 -> 창 초기화 하여 닫은 후 수정창 오픈
    $("#update").click(function(){
    	// 세팅 초기화 후 수정 팝업 open
    	$(".vote-view-wrap").addClass("blind");
    	$(".vote-view-wrap>.select_custom").addClass("blind");
    	$(".vote-view-wrap>.choice_mem_cnt").addClass("blind");
    	$(".vote-view-wrap>.list_percentage_wrap").addClass("blind");
    	$("#choice_wrap").find(".in_circle").removeClass("choice");
    	$(".voteBtn").addClass("blind");
    	$(".reVoteBtn").addClass("blind");
    	$(".view_closeBtn").addClass("blind");
    	$("#dropdown").addClass("blind");
    	
    	
    	let sample = $(".choiceList:eq(0)").clone();
    	$("#choice_wrap").empty().append(sample);
    	
    	$(".vote-view-wrap").addClass("blind");
    	$(".vote-create-update-wrap").removeClass("blind");
    	$("#event-create").addClass("blind");
    	$("#event-update").removeClass("blind");
    });
    
    // 투표 항목 선택 시 UI변경
    $("#choice_wrap").on("click", ".out_circle", function(){
   		if(flag){
	    	$("#choice_wrap").find(".in_circle").removeClass("choice");
	    	$(this).find(".in_circle").addClass("choice");
	    	choice_idx = $(this).find(".in_circle").attr("contentIdx");
   		}
    });
    
    // 삭제 컨펌 팝업 - '예'버튼 클릭 시 삭제 로직 처리
	$("#yesBtn").click(function(){
        location.href = "/meet-a-bwa/m_vote_delete.do?vote_no=" + vote_idx + "&&meet_no=" + location.href.split("idx=")[1];
    });
    // 삭제 컨펌 팝업에서 아니오 클릭
	$("#noBtn").click(function(){
        $("#confirmWrap").addClass("blind");
    });
	
	function ajax_load(idx) {
		$.ajax({
			url : "/meet-a-bwa/m_vote_view.do",
			type : "GET",
			data : {
				user_no : $.cookie("user_no"),
				vote_no : idx
			},
			
			dataType: "JSON",
			success: function(res) {
				console.log(res);
				// 투표 정보 세팅
				$("#delete").attr("voteIdx", res.vote_no);
				$(".vote-view-wrap").removeClass("blind");
				$("#view-title").text(res.vote_title);
				$(".vote-view-wrap>.select_list_wrap").attr("voteNo", res.vote_no);
				$(".vote-view-wrap>.select_list_wrap").attr("voteNo", res.vote_no);
				$("#text_area").text(res.vote_description);
				$("#vote_writer").text("작성자 : " + res.user_name);
				
				let date = res.vote_eod.split(" ")[0];
				let time = res.vote_eod.split(" ")[1];
				let timeArr = time.split(":");
				let timeString = "";

				if(timeArr[0] > 12){
					if((timeArr[0]-12) < 10){
						timeString = "오후0"+ (timeArr[0]-12)  + ":" + timeArr[1] + ":" + timeArr[2];
					}else{
						timeString = "오후"+ (timeArr[0]-12)  + ":" + timeArr[1] + ":" + timeArr[2];
					}
				}else{
					timeString = "오전"+ timeArr[0] + ":" + timeArr[1] + ":" + timeArr[2];
				}
				
				// 작성자일 때만 수정/삭제 가능
				if(res.user_no != $.cookie("user_no")){
					$("#more_vertival").addClass("blind");
				}else{
					$("#more_vertival").removeClass("blind");
				}
				
				// 마감날짜 안지났고 / 작성자가 마감시키지 않았을 때 => 투표 / 재투표 가능
				if(new Date().getTime() <= new Date(res.vote_eod).getTime() && res.vote_state == "Y"){
					$("#end_date").text("투표마감 : " + date + " " + timeString);
					
					// 투표한적없음
					if(res.isVote == ""){
						flag = true;
						updateFlag = false;
						
						$(".voteBtn").removeClass("blind");
						
						// 투표 항목 세팅
						for(list of res.content_arr){
							let sample = $(".choiceList:eq(0)").clone().removeClass("blind");
							
							sample.find(".txt").text(list.content);
							sample.find(".in_circle").attr("contentIdx", list.content_no);
							$("#choice_wrap").append(sample);
						}
					}else{ // 투표한 적 있음
						updateFlag = true;
						flag = false;
						$(".reVoteBtn").removeClass("blind");
    					
						// 투표 항목 세팅
						for(var i = 0; i < res.content_arr.length; i++){
							let sample = $(".choiceList:eq(0)").clone().removeClass("blind");
							sample.find(".choice_mem_cnt").removeClass("blind");
	    					sample.find(".list_percentage_wrap").removeClass("blind");
							sample.find(".txt").text(res.content_arr[i].content);
							if(res.content_arr[i].content_no == res.isVote){
								sample.find(".in_circle").addClass("choice");
							}
							sample.find(".in_circle").attr("contentIdx", res.content_arr[i].content_no);
							$("#choice_wrap").append(sample);
						}
						
						
						if(res.vote_result.length > 0){
							let tmp_arr = $("#choice_wrap").children(".choiceList:gt(0)");
							for(var i = 0; i < tmp_arr.length; i++){
								let tmp = false;
								for(var j = 0; j < res.vote_result.length; j++){
									if($(tmp_arr[i]).find(".in_circle").attr("contentIdx") == res.vote_result[j].content_no){
										tmp = true;
										$(tmp_arr[i]).find(".choice_mem_cnt").text(res.vote_result[j].cnt + "명");
				    					$(tmp_arr[i]).find(".list_percentage").css("width", res.vote_result[j].percentage+"%");		
									}
								}
								if(!tmp){
									$(tmp_arr[i]).find(".choice_mem_cnt").text("0명");
			    					$(tmp_arr[i]).find(".list_percentage").css("width", "0%");	
								}
							}
						}
						
					}
				}
				// 투표 참여 / 재참여 불가능
				else{
					flag = false;
					updateFlag = false;
					$(".view_closeBtn").removeClass("blind");
					
					if(new Date().getTime() <= new Date(res.vote_eod).getTime() && res.vote_state == "N"){
						$("#end_date").text("투표조기마감");
					}
					else $("#end_date").text("투표마감 : "+ date + " " + timeString);
					
					// 투표 항목 세팅
					for(var i = 0; i < res.content_arr.length; i++){
						let sample = $(".choiceList:eq(0)").clone().removeClass("blind");
						
						if(res.vote_result.length > 0){
							sample.find(".choice_mem_cnt").removeClass("blind");
							sample.find(".choice_mem_cnt").text(res.vote_result[i].cnt + "명");
	    					sample.find(".list_percentage_wrap").removeClass("blind");
	    					sample.find(".list_percentage").css("width", res.vote_result[i].percentage+"%");
	    					
							sample.find(".txt").text(res.content_arr[i].content);
							if(res.content_arr[i].content_no == res.isVote){
								sample.find(".in_circle").addClass("choice");
							}
							sample.find(".in_circle").attr("contentIdx", res.content_arr[i].content_no);
						}else{
							sample.find(".choice_mem_cnt").removeClass("blind");
							sample.find(".choice_mem_cnt").text("0명");
	    					sample.find(".list_percentage_wrap").removeClass("blind");
						}
						sample.find(".in_circle").attr("contentIdx", res.content_arr[i].content_no);
						$("#choice_wrap").append(sample);
					}
					
				}
				
			},
			error: function(res, status, text) {
				console.log("error");
				console.log(text);
			}
		})
	}
	
	
	/********************************************************************/
	/******************** 투표 수정 관련 팝업 내 이벤트 섹션 *********************/
	/********************************************************************/
	$("#closeBtn").click(function(){
    });
})