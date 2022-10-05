/**
 * @author 최진실
 */
$(function () {
	let flag = true; // 꼭 전역변수로 선언

	//*********토스트 함수*************
	function fade_in_out(element){
	    if(flag){
	        flag = false;
	
	        if(element.attr("id") == 'meet_name'){
		        $("#toastWrap_name").removeClass("hide");
		        $("#toastWrap_name").removeClass("fade-out");
		        $("#toastWrap_name").addClass("fade-in");
	        }else if(element.attr("id")== 'meet_description'){
		        $("#toastWrap_des").removeClass("hide");
		        $("#toastWrap_des").removeClass("fade-out");
		        $("#toastWrap_des").addClass("fade-in");
	        }
	        
	        setTimeout(function() {
	            flag = true; // 추후에 사용할 수 있도록 변수값 변경
	            
	            if(element.attr("id") == 'meet_name'){
	                $("#toastWrap_name").removeClass("fade-in");
	                $("#toastWrap_name").addClass("fade-out");
	            }else if(element.attr("id")== 'meet_description'){
		            $("#toastWrap_des").removeClass("fade-in");
		            $("#toastWrap_des").addClass("fade-out");
	            }
	        }, 1000);
	    }
	}
	
	//**********글자 수 세고 제한하는 함수**********
	
	function textLengthCnt(max_length, element ,txt){
		// 글자수 세기
		if (element.val().length == 0 || element.val() == '') {
		    txt.text('0자');
		} else {
		    txt.text(element.val().length + '자');
		}
		
		// 글자수 제한
		if (element.val().length > max_length) {
		    // 500자 부터는 타이핑 되지 않도록
		    element.val(element.val().substring(0, max_length));
		    // 500자 넘으면 알림창 뜨도록
		    fade_in_out(element);
		};
	} 
	
	//***********글자 수 제한***************
	//모임 이름 글자수 제한
	$('#meet_name').keyup(function () {
		textLengthCnt(10, $(this),$(".textCount_name"));
	});
	$('#meet_name').keydown(function () {
		textLengthCnt(10, $(this),$(".textCount_name"));
	});
	//모임 소개 글자수 제한
	$('#meet_description').keyup(function () {
		textLengthCnt(500, $(this),$('.textCount'));
	});
	$('#meet_description').keydown(function () {
		textLengthCnt(500, $(this),$('.textCount'));
	});

});
