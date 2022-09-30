$(function() {
	let idx = "";

	$("#btn-activity-create").on("click", function() {
		console.log("activity create")
		
		idx = $(this).attr("idx");
		
		location.href = "a_insert.do?meet_no=?" + idx;
		// ajax_load(idx)
	})
	
	function ajax_load(idx) {
		$.ajax({
			url : "a_insert.do",
			type : "GET",
			data : {
				meet_no : idx
			},
			
			dataType: "json",
			
			success : function(res) {
				console.log("succees")
				console.log(res)
			},
			
			error : function(res, status, text) {
				console.log("error")
				console.log(text)
			}
		})
	}
})