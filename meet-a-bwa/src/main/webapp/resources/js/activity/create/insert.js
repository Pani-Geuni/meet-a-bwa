/**
 * @author 최진실
 */
 $(function() {
	let idx = "";

	$("#btn-activity-create").on("click", function() {
		idx = $(this).attr("idx");
		location.href = "a_insert.do?meet_no=" + idx;
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
			},
			error : function(res, status, text) {
				console.log(text)
			}
		})
	}
})