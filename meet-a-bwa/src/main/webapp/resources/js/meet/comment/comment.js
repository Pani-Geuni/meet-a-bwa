/**
 * @author 전판근
 */
 $(function() {
	let idx = "";
	
	$(".btn-comment-delete").on("click", function() {
		idx = $(this).attr("idx");
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
				location.reload();
			},
			error : function(res, status, text) {
				console.log(text)
			}
		})
	}
})