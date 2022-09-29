/**
 * 
 */
 $(function(){
 
    // 로그인 팝업 - 창닫기 버튼 클릭
    $("#login-popup-closeBtn").click(function(){
    	$('#idInput').removeClass("length_error");
		$('#pwInput').removeClass("length_error");
    	$(".login-layer").addClass("blind");
    });
    
 	// 로그인 버튼 클릭 시 제출 전에 아이디/비번 입력되었는지 확인
	  $( '#loginForm' ).submit( function() {
		$('#idInput').removeClass("length_error");
		$('#pwInput').removeClass("length_error");
		
      	if($('#idInput').val().trim().length > 0){
      		if($('#pwInput').val().trim().length > 0){
      			return true;
      		}else{
      			$('#pwInput').addClass("length_error");
      			return false;
      		}
      	}else{
  			$('#idInput').addClass("length_error");
      		if($('#pwInput').val().trim().length == 0){
      			$('#pwInput').addClass("length_error");
      			return false;
      		}
      		return false;
      	}
      });
      
 });