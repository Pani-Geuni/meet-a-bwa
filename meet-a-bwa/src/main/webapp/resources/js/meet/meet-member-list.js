$(function() {

	let idx = "";

	$(".meet-member-info").on('click', function() {
		
		idx = $(this).parent(".meet-summary-info").attr("idx");
		console.log(idx)
		
		location.href = "meet-member.do?meet_no=" + idx;
		
		// ajax_load(idx);
	})
})