$(function() {
	let idx = '';

	// 오른쪽 섹션 - 투표 생성 버튼 클릭 (+)
	$("#vote_create_btn").click(function() {
		$(".vote-create-update-wrap").removeClass("blind");
		$("#event-create").removeClass("blind");
	});

	$("#vote-summary-list").on("click", ".vote-list-item", function(){
		idx = $(this).attr("idx");
		ajax_load(idx);
		console.log($(this).attr("idx"));
	});
	
	function ajax_load(idx) {
		$.ajax({
			url : "/meet-a-bwa/m_vote_selectOne.do",
			type : "GET",
			data : {
				vote_no : idx
			},
			
			dataType: "JSON",
			success: function(res) {
				console.log("succees");
				console.log(res);
				$("#vote-view-wrap").removeClass("blind");
				$("#view-title").text(res.vote_title);
				$("#vote-view-wrap>.select_list_wrap").attr("voteNo", res.vote_no);
				$("#vote-view-wrap>.select_list_wrap").attr("voteNo", res.vote_no);
				$("#text_area)
				
			},
			error: function(res, status, text) {
				console.log("error");
				console.log(text);
			}
		})
	}
})