window.onload = () => {
  // 라벨 클릭시 옵션 목록이 열림/닫힘
  $(".feed").on('click', '.img-more', function(event) {
  	console.log("select click")
  	console.log($(".img-more").parent())
  	
  	if ($(this).parent().hasClass('active')) {
  		console.log("active")
  		$(this).parent().removeClass('active')
  	} else {
  		$(this).parent().addClass('active')
  	}
  	
  	event.stopPropagation()
  })
}
