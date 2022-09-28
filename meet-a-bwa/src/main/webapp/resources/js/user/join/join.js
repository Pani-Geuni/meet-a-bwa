$(function () {


    //성별 출력
   

        $("#gender").on("change", function () {
            console.log($(this).val());
        });
 

        $("#birth").on("change", function () {
            console.log($(this).val());
            console.log(typeof($(this).val()));
        });
   

    // NOT NULL 에 alert Popup 

    // 중복체크 결과 출력 > idCheck, NickCheck, emCheck 에서

    // 글자 수 제한 및 토스트

    // 1. NOT NULL 충족 

    // 2.아이디, 닉네임, 이메일 중복체크 상태가 'OK'
    
    // 3. pw가 8글자 이상& 재확인과 일치할 때 가입되게


    
    
    

});