$(function() {
	let idx = "";
	
	$(".meet-detail-link").on("click", function() {		
		idx = $(this).attr("idx");
		console.log(idx);
		
		location.href = "meet-detail.do?idx=" + idx;
	})
})