/**
 * @author 최진실
 */
$(function() {
	let idx='';
	
	$("#activity-summary-list").on("click", ".activity_list_item", function() {
		idx = $(this).attr("idx");
		location.href = "/meet-a-bwa/activity-main.do?idx=" + idx;
	});
});