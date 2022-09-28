$(function() {
		console.log("onload....");
		let btn_nickCheck = $("#btn_nickCheck");
		let result = $("#result");
		// console.log(result);

		$("#btn_nickCheck").click(function(event) {
			console.log("onclick....");
			//let u_nickname = document.querySelector("#u_nickname");
			let u_nickname = $("#u_nickname");
			// console.log(u_nickname);
			console.log(u_nickname.val());
			
			let req = new XMLHttpRequest();

			 //req.load( function() {
			 req.addEventListener("load", function() {
			 	if(this.status==200){
			 		try {
						let txt_json = this.responseText;
						let obj_json = JSON.parse(txt_json);
						//let obj_json = {result : "OK"};
						// let obj_json = {result : "Not OK"};
						console.log(obj_json);
						console.log(obj_json.result);

						let txt = "";
						if (obj_json.result === 'Not OK') {
							$(".toastText_nickCheck").removeClass("blind");
							$(".toastText_nickCheck").text("사용중인 닉네임 입니다.");
							$(".toastText_nickCheck").addClass("no");
						} else {
							$(".toastText_nickCheck").removeClass("blind");
							$(".toastText_nickCheck").text("사용가능한 닉네임 입니다.");
							$(".toastText_nickCheck").addClass("yes");
							$("#u_nickname").attr("readonly",true);
							$("#btn_nickCheck").addClass("blind");
							$("#btn_nickRe").removeClass("blind");
							$("#btn_nickRe").click(function(){
								$("#btn_nickCheck").removeClass("blind");
								$("#btn_nickRe").addClass("blind");
								$("#u_nickname").removeAttr("readonly");
								// '사용 가능한 아이디' 토스트 메시지 지우기
								$(".toastText_nickCheck").addClass("blind");
							});
						}
			 		} catch (e) {
			 			console.log("json 형식이 아님.");
			 		}
					
			 	}//end if
				

				

			 });
			
			req.open("GET",
					"http://localhost:8090/meet-a-bwa/nickCheck.do?u_nickname="
							+ u_nickname.val());
			req.send();

			event.preventDefault();
			event.stopPropagation();
		});
	});