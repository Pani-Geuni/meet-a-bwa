$(function() {
	let idx = "";
	
	$(".btn-comment-delete").on("click", function() {
		idx = $(this).attr("idx");
		
		console.log(idx);
		ajax_load(idx);
	})
	
	function ajax_load(idx) {
	
		$.ajax({
			url : "/meet-a-bwa/c_deleteOK.do",
			type : "POST",
			dataType : "json",
			data : {
				comment_no : idx
			},
			
			success : function(res) {
				console.log("succees")
				console.log(res)
				
				location.reload();
			},
			
			error : function(res, status, text) {
				console.log("error")
				console.log(text)
			}
		})
	}
})