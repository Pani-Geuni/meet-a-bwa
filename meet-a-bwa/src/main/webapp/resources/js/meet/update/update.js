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
    
    
    // NOT NULL 에 alert Popup 

    // 글자 수 제한 및 토스트

    // 1. NOT NULL 충족 

//    $("#update_meet_information_btn").click(function(){
       
//    });
});