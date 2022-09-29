// $(document).ready(function popupShow() {
//   $('.popup').show()
// })

function writePopupShow() {
  $('.write-popup-layer').show()
}

function writePopupHide() {
  $('.write-popup-layer').hide()
}


$(function() {
	let idx = '';
	
	$('#btn-meet-write').on('click', function() {
		console.log("글쓰기 버튼 클릭");
		
		idx = $(this).attr('idx');
		
		console.log(idx)
	})
})