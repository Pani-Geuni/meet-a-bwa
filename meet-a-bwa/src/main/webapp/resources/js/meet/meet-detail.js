/**
 * @author 전판근
 */
 $(function() {
	let idx = "";
	
	$(".meet-detail-link").on("click", function() {		
		idx = $(this).attr("idx");
		location.href = "meet-detail.do?idx=" + idx;
	})
})