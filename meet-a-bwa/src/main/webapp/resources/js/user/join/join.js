$(function () {

    //성별 출력
    $(function () {

        $("#gender").on("change", function () {
            console.log($(this).val());
        });
    
    });

    // NOT NULL 에 alert Popup 

    // 중복체크 결과 출력 > idCheck, NickCheck, emCheck 에서

    // 글자 수 제한 및 토스트

    // 1. NOT NULL 충족 

    // 2.아이디, 닉네임, 이메일 중복체크 상태가 'OK'
    
    // 3. pw가 8글자 이상& 재확인과 일치할 때 가입되게


    
    $("#join_btn").click(function(){
        let id = $("#id").val().length;
        let pw =$("#pw").val().length;
        let pw_check =$("#pw_check").val().length;
        let name = $("#name").val().length;
        let nickname = $("#nickname").val().length;
        let email = $("#email").val().length;
        let tel = $("#tel").val().length;
        let bitrh = $("#birth").val().length;
        let gender = $("#gender").val().length;

        console.log(id);
        console.log(pw);
        console.log(pw_check);
        console.log(name);
        console.log(nickname);
        console.log(email);
        console.log(tel);
        console.log(birth);
        console.log(gender);


        if(id>0&&pw>0&&pw_check>0&&name>0&&nickname>0
            &&email>0&&tel>0&&bitrh>0&&gender>0
            &&pw>7&&($("#pw").val()===$("#pw_check").val())
            &&$("#id").attr("readonly")
            &&$("#nickname").attr("readonly")
            &&$("#email").attr("readonly")){
                console.log("가입 가능");
        }else {
            console.log("가입 불가능");
            if(id>0&&pw>0&&pw_check>0&&name>0&&nickname>0
                &&email>0&&tel>0&&bitrh>0&&gender>0){

            }else if(pw<7&&($("#pw").val()!==$("#pw_check").val())){

            }else if($("#id").attr("readonly",false)){

            }else if($("#nickname").attr("readonly",false)){
                
            }else if($("#email").attr("readonly",false)){
                
            }
            
        }
    });


});