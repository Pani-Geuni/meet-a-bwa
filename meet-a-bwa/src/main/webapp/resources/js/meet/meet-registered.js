$(function() {
	let idx = "";
	
	$(".btn-meet.join").on("click", function() {
		console.log("join click");
		
		idx = $(this).attr("idx");
		console.log(idx);
		
		ajax_load(idx);
	})
	
	function ajax_load(idx) {
		$.ajax({
			url : "/meet-a-bwa/m_registered.do",
			type : "POST",
			dataType : "json",
			data : {
				meet_no : idx
			},
			
			success : function(res) {
				console.log("succees")
				
				location.reload();
			},
			
			error : function(res, status, text) {
				console.log("error");
				console.log(text);
			}
		})
	}
})