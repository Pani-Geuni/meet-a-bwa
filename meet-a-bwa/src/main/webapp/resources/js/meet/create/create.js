$(function () {

	//nop : 인원 수
//	let num = $("#num");
//    $("#nop").each(function () {
//        for (let i = 1; i <= 20; i++) {
//            $("#numberofpeople").append("<option>" + i + "</option>");
//        }
//    });

    $("#numberofpeople").on("change", function () {
        console.log($(this).val());
    });
    
    //성별 출력
    $("#gender").on("change", function () {
        console.log($(this).val());
    });
    
    
    
    
    // 로그인이 되어있을때 생성 가능(비로그인 상태면 로그인 유도 팝업)

    // NOT NULL 에 alert Popup 

    // 글자 수 제한 및 토스트

    // 1. NOT NULL 충족 

//    $("#create_meeting").click(function(){

//    });

	$(".btn-create-meet").on("click", function() {
		console.log("create meet click")
		
		location.href = "m_insert.do";
	});
});