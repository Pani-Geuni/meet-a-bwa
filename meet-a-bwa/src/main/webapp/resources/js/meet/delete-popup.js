/**
 * @author 전판근
 */
 $(function () {

	// 라벨 클릭시 옵션 목록이 열림/닫힘
	$(".feed").on('click', '.img-more', function(event) {
	  	if ($(this).parent().hasClass('active')) {
	  		$(this).parent().removeClass('active');
	  	} else {
	  		$(this).parent().addClass('active');
	  	}
	  	
	  	event.stopPropagation();
	});
  
	$(".post-detail-top").on('click', '.img-more', function(event) {
		if ($(this).parent().hasClass('active')) {
			$(this).parent().removeClass('active');
		} else {
			$(this).parent().addClass('active');
		}
		event.stopPropagation();
  	});

	let idx = '';
	let title = '';
	let content = '';
  
	//----- OPEN
	$('[data-popup-open]').on('click', function (e) {
		idx = $(this).parent(".post-option-list").attr("idx");
    
	    // 팝업 열기 버튼 클릭시 동작하는 이벤트입니다.
	    var targeted_popup_class = $(this).attr('data-popup-open');
	    $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
	    
	    e.preventDefault();
	});

	//----- CLOSE
	$('[data-popup-close]').on('click', function (e) {
		// 팝업 닫기 버튼 클릭시 동작하는 이벤트입니다.
	    var targeted_popup_class = jQuery(this).attr('data-popup-close');
	    $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

    	e.preventDefault();
	});
  
	$("#popup-update").on('click', '.btn-submit-update', function() {
  		title = $('#update_title').val();
  		content = $('#update_content').val();
		
		ajax_load(idx, title, content);
	});
	
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
				location.reload();
			},
			error : function(res, status, text) {
				console.log(text);
			}
		})	
	}
  
	$("#btn-delete").on('click', function() {
		$.ajax({
	  	  url : "b_deleteOK.do", 
	  	  type : "GET",
	  	  data : {
	  	  	board_no : idx
	  	  },
	  	  
	  	  dataType : "json",
	  	  success : function(res) {
	  	  	// 삭제 성공시 meet-main으로 이동
	  	  	location.replace('meet-main.do')
	  	  },
	  	  error : function(res, status, text) {
	  	    console.log(text)
	  	  }
		});
  	});
});
