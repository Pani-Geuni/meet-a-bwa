window.onload = () => {
  //const img = document.querySelector('.img-more')
  //const options = document.querySelectorAll('.post-option-item')

  // 클릭한 옵션의 text를 label에 넣기
  // const handleSelect = (item) => {
  //   img.parentElement.classList.remove('active')
  //   label.innerHTML = item.textContent
  // }

  // 옵션 클릭시 클릭한 옵션 넘김
  // options.forEach((option) => {
  //   option.addEventListener('click', () => handleSelect(option))
  // })

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
  
  /*img.addEventListener('click', () => {
 	console.log("img click")
    if (img.parentNode.classList.contains('active')) {
      img.parentNode.classList.remove('active')
    } else {
      img.parentNode.classList.add('active')
    }
  })*/
}
