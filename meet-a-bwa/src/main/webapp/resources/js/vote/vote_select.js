$(function() {
	let idx = '';

	$('.vote-list-item').on('click', function() {
		console.log($(this).attr('idx'));
		
		idx = $(this).attr('idx');
		
		ajax_load(idx);
	})
	
	function ajax_load(idx) {
		$.ajax({
			url : "m_vote_selectOne.do",
			type : "GET",
			data : {
				vote_no : idx
			},
			
			dataType: "JSON",
			
			success: function(res) {
				console.log("succees")
				console.log(res)
			},
			
			error: function(res, status, text) {
				console.log("error")
				console.log(text)
			}
		})
	}
})