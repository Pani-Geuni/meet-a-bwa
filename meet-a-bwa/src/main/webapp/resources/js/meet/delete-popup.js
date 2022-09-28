$(function () {

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
  
  $(".post-detail-top").on('click', '.img-more', function(event) {
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

  let idx = '';
  let title = '';
  let content = '';
  
  //----- OPEN
  $('[data-popup-open]').on('click', function (e) {
    console.log($(this).parent(".post-option-list").attr("idx"))
    idx = $(this).parent(".post-option-list").attr("idx")
    
    // 팝업 열기 버튼 클릭시 동작하는 이벤트입니다.
    var targeted_popup_class = $(this).attr('data-popup-open')
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
  
  $("#popup-update").on('click', '.btn-submit-update', function() {
		
		console.log("update button clicked")
  		console.log(idx)
  		
  		console.log($('#update_title').val())
  		console.log($('#update_content').val())
  		
  		title = $('#update_title').val();
  		content = $('#update_content').val();
		
		ajax_load(idx, title, content);
	})
	
	function ajax_load(idx, title, content) {
		$.ajax({
			url : "b_updateOK.do",
			type : "POST",
			data : {
				board_no : idx,
				board_title : title,
				board_content : content
			},
			
			dataType: "json",
			
			success : function(res) {
				console.log("succees")
				console.log(res)
				
				// location.replace('b_selectOne.do?board_no=' + board_no)
				location.reload()
			},
			
			error : function(res, status, text) {
				console.log("error")
				console.log(text)
			}
		})	
	}
  
  $("#btn-delete").on('click', function() {
  	console.log("delete button clicked")
  	console.log(idx)
  	console.log(typeof idx)
  	
  	$.ajax({
  	  url : "b_deleteOK.do", 
  	  type : "GET",
  	  data : {
  	  	board_no : idx
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
