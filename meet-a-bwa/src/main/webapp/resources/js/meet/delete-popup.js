$(function () {

  let idx = '';
  
  //----- OPEN
  $('[data-popup-open]').on('click', function (e) {
    console.log($(this).parent(".post-option-list").attr("idx"))
    idx = $(this).parent(".post-option-list").attr("idx")
    
    // 팝업 열기 버튼 클릭시 동작하는 이벤트입니다.
    var targeted_popup_class = jQuery(this).attr('data-popup-open')
    $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350)

    e.preventDefault()
  })

  //----- CLOSE
  $('[data-popup-close]').on('click', function (e) {
    // 팝업 닫기 버튼 클릭시 동작하는 이벤트입니다.
    var targeted_popup_class = jQuery(this).attr('data-popup-close')
    $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350)

    e.preventDefault()
  })
  
  $("#btn-delete").on('click', function() {
  	console.log("delete button clicked")
  	console.log(idx)
  	console.log(typeof idx)
  	
  	$.ajax({
  	  url : "b_deleteOK.do", 
  	  type : "GET",
  	  data : {
  	  	"board_no" : idx
  	  },
  	  
  	  dataType : "json",
  	  
  	  success : function(res) {
  	    console.log("success")
  	  	console.log(res)
  	  	
  	  	// 삭제 성공시 meet-main으로 이동
  	  	location.replace('meet-main.do')
  	  	// location.reload()
  	  },
  	  
  	  error : function(res, status, text) {
  	  	console.log("error")
  	    console.log(text)
  	  }
  	})
  })
})
