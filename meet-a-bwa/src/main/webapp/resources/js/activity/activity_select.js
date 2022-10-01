// meet main의 우측 side bar에서
// 원하는 액티비티 item 클릭 시, 해당 액티비티로 이동

$(function() {
	let idx='';
	
	$("#activity-summary-list").on("click", ".activity_list_item", function() {
		idx = $(this).attr("idx");
		
		console.log("activity no : ", idx);
		// ajax_load(idx);
	})
	
	// TODO
	// 10월 01일 액티비티 피드 서블릿 생성시
	// ajax_load 함수 만들 것
})