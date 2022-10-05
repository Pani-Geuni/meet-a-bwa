/**
 * @author 전판근
 */
 $(function() {
	let idx = "";
	
	$(".btn-meet.join").on("click", function() {
		idx = $(this).attr("idx");
		ajax_load(idx);
	});
	
	function ajax_load(idx) {
		$.ajax({
			url : "/meet-a-bwa/m_registered.do",
			type : "POST",
			dataType : "json",
			data : {
				meet_no : idx
			},
			
			success : function(res) {
				location.reload();
			},
			error : function(res, status, text) {
				console.log(text);
			}
		});
	}
	
	// 모임의 일반 회원의 모임 탈퇴
	$(".btn-meet-info-exit").on("click", function() {
		idx = $(this).attr("idx");
		ajax_load_exit(idx);
	})
	
	function ajax_load_exit(idx) {
		$.ajax({
			url : "/meet-a-bwa/m_leave.do",
			type : "POST",
			dataType : "json",
			data : {
				meet_no : idx
			},
			
			success : function(res) {
				location.reload();
			},
			error : function(res, status, text) {
				console.log(text)
			}
		})
	}
	
	$(".btn-meet-info-edit").on("click", function() {
		idx = $(this).attr("idx");
		location.href = "m_update.do?meet_no=" + idx;
	})
})