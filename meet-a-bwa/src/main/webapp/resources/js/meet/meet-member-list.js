/**
 * @author 전판근
 */
 $(function() {
	let idx = "";

	$(".meet-member-info").on('click', function() {
		idx = $(this).parent(".meet-summary-info").attr("idx");
		location.href = "meet-member.do?meet_no=" + idx;
	})
})