$(function () {


	//nop : 인원 수
	let num = $("#num");
    $("#nop").each(function () {
        for (let i = 1; i <= 20; i++) {
            $("#numberofpeople").append("<option>" + i + "</option>");
        }
    });

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

    
    $("#create_activity").click(function(){
        let activity_name = $("#activity_name").val().length;
        let activity_description =$("#activity_description").val().length;

        console.log(activity_name);
        console.log(activity_description);

        if(activity_name>0&&activity_description>0){
                console.log("가입 가능");
        }else {
            console.log("가입 불가능");
            if(activity_name>0&&activity_description>0&&pw_check>0&&name>0&&nickname>0
                &&email>0&&tel>0&&bitrh>0&&gender>0){

            }
            
        }
    });

});