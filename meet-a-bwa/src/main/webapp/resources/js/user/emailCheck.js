$(function() {
    console.log("onload....");
    let btn_emCheck = $("#btn_emCheck");
    let result = $("#result");
    // console.log(result);

    $("#btn_emCheck").click(function(event) {
        console.log("onclick....");
        //let email = document.querySelector("#email");
        let email = $("#email");
        console.log(email.val());
        
        let req = new XMLHttpRequest();

        // req.load( function() {
         req.addEventListener("load", function() {
             if(this.status==200){
                 try {
                   	let txt_json = this.responseText;
                    let obj_json = JSON.parse(txt_json);
                    // let obj_json = {result : "OK"};
                    // let obj_json = {result : "Not OK"};
                    console.log(obj_json);
                    console.log(obj_json.result);

                    let txt = "";
						if (obj_json.result === 'Not OK') {
							$(".toastText_emailCheck").removeClass("blind");
							$(".toastText_emailCheck").text("사용중인 이메일 입니다.");
							$(".toastText_emailCheck").addClass("no");
						} else {
							$(".toastText_emailCheck").removeClass("blind");
							$(".toastText_emailCheck").text("사용가능한 이메일 입니다.");
							$(".toastText_emailCheck").addClass("yes");
                            $("#email").attr("readonly",true);
							$("#btn_emCheck").addClass("blind");
							$("#btn_emRe").removeClass("blind");
							$("#btn_emRe").click(function(){
								$("#btn_emCheck").removeClass("blind");
								$("#btn_emRe").addClass("blind");
								$("#email").removeAttr("readonly");
								// '사용 가능한 아이디' 토스트 메시지 지우기
								$(".toastText_emailCheck").addClass("blind");
							});
						}
                 } catch (e) {
                     console.log("json 형식이 아님.");
                 }
                
             }//end if
            

            

         });
        
        req.open("GET",
                "http://localhost:8090/meet-a-bwa/emailCheck.do?email="
                        + email.val());
        req.send();

        event.preventDefault();
        event.stopPropagation();
    });
});