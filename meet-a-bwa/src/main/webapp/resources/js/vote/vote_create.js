$(function(){
	let content_arr = [];
	let flag = true;
	
	$("#vote_cancleBtn").click(function(){
		$("#event-create").addClass("blind");
		$(".vote-create-update-wrap").addClass("blind");
	});
    
    // 투표 생성 버튼
    $("#vote_createBtn").click(function(){
        let title_length = $("#vote_title").val().trim().length;
        let endDate_length = $("#vote_endDate").val().trim().length;
        let time = $("#timeValue").text().trim().includes("--");
        let description_length = $("#vote_description").val().trim().length;
        let content = returnContent_checkNull();

        if(title_length > 0 && endDate_length > 0 && !time && description_length > 0 && content){
        	let time = "";
        	let arr = $("#timeValue").text().trim().split(":");
        	let ampm = arr[0];
        	if(ampm == "오후"){
        		if(Number(arr[1]) != 12){
        			time = (Number(arr[1]) + 12) + ":" + arr[2] + ":59";
        		}else{
        			console.log("dd");
        			time = arr[1] + ":" + arr[2] + ":59";
        		}
        	}else if(ampm == "오전"){
        		time = arr[1] + ":" + arr[2] + ":59";
        	}
        	
            insert_ajax(time, content_arr);
        }
        else{
            fade_in_out(undefined, undefined, "빈 항목이 존재합니다.");
        }  
    });
    
    
    function returnContent_checkNull(){
    	content_arr = [];
        let elementArr = $("#event-create").find(".list_text:gt(0)").slice();
        
        for(element of elementArr){
            if($(element).val().trim().length == 0){
            	content_arr = [];
                return false;
            }else if($(element).val().trim().length != 0){
            	content_arr.push($(element).val().trim());
            }
        }
        return true;
    }
    
    function insert_ajax(time, content_arr){
    	 $.ajax({
        	url : "/meet-a-bwa/m_vote_create.do",
			type : "POST",
			traditional : true, // data value중에 배열있을 때 필요
			dataType : 'json', // 결과값 받을 타입
			data : {
				vote_title : $("#vote_title").val().trim(),
				vote_content : $("#vote_description").val().trim(),
				vote_eod : $("#vote_endDate").val().trim() + " " + time,
				user_no : $.cookie("user_no"),
				meet_no : location.href.split("idx=")[1],
				contents : content_arr
			},
			success : function(res) {
		        if(res.result == "insert success"){
		        	$("#event-create").addClass("blind");
					$(".vote-create-update-wrap").addClass("blind");
		        	location.reload();
		        }else if(res.result == "insert fail"){
		        	fade_in_out(undefined, undefined, "오류로 인해 투표 생성에 실패하였습니다.");
		        }
			},
			error : function(error) {
			 	console.log(error);
			 }
        });
    }
    
    // 토스트 함수
    function fade_in_out(element, max_length, text){
        if(element != undefined && max_length != undefined)
            element.val(element.val().substr(0,max_length));

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