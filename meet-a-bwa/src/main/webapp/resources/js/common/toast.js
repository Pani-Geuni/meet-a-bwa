//샘플 JS임 여기에 기능 구현하면 안됨
//쓰려고 하는 html의 js에 복붙해서 원하는대로 커스텀해서 사용

$(function(){
    let flag = true; // 꼭 전역변수로 선언
    function fade_in_out(){
        if(flag){
            flag = false;
        
            setTimeout(function() {
                flag = true; // 추후에 사용할 수 있도록 변수값 변경
                $("#toastWrap").removeClass("fade-in");
                $("#toastWrap").addClass("fade-out");
            }, 2000);
        }
    }
});
