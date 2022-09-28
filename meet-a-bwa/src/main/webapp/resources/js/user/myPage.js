$(function() {
	$(".edit-user-info").on('click', function() {
		console.log("개인 정보 수정");
		
		// $.cookie("user_no");
		
		location.replace("u_update.do?user_no=" + $.cookie("user_no"));
	})
})