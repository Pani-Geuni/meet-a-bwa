$(function() {

	let idx = "";

	$(".meet-member-info").on('click', function() {
		
		idx = $(this).parent(".meet-summary-info").attr("idx");
		console.log(idx)
		console.log(typeof idx);
		
		ajax_load(idx);
	})
	
	function ajax_load(idx) {
		$.ajax({
			url : "/meet-a-bwa/meet-member.do",
			type : "GET",
			data : {
				meet_no : idx
			},
			
			dataType: "json",
			
			success : function(res) {
				console.log("succees")
				console.log(res)
				
				location.replace("meet-member.do?meet_no=" + meet_no)
				//location.reload()
			},
			
			error : function(res, status, text) {
				console.log("error")
				console.log(res)
				console.log(text)
			}
		})	
	}
})