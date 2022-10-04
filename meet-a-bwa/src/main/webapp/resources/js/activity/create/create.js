$(function () {


	//nop : 인원 수
    $("#numberofpeople").on("change", function () {
        console.log($(this).val());
    });
    
    //성별 출력
    $("#gender").on("change", function () {
        console.log($(this).val());
    });
    
    
    
     //******************************프로필 이미지********************************//
     function readURL(input) {
        if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function(e) {
              $('#image').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
            // input.files[0]!=null
            if($("#image").attr('src') != "/meet-a-bwa/resources/img/placeholder1.webp"){
               console.log($("#image").attr('src'));
               $('#delete-file1').css('display','block');
               $('#delete-file1').css('opacity','1');
               
               // $('#delete-file2').css('display','block');
                  
               $('#imgWrap').hover(function(){
                  if($("#image").attr('src')!="/meet-a-bwa/resources/img/default-image2.png"){
                     $('#delete-file2').css('display','block');
                     $('#delete-file2').css('opacity','1');
                  }
               });
               
               $('#imgWrap').mouseleave(function(){
                  $('#delete-file2').css('opacity','0');
               });
   
            }
        }
     }
     
      $("#input-file").off().on("change", function(){
		 if (this.files && this.files[0]) {
		 var maxSize = 10 * 1024 * 1024; // 10MB
		 //var maxSize = 10 * 1024; // 10KB
    	 var fileSize = this.files[0].size;
		 console.log(fileSize);
			if(fileSize > maxSize){
		    	  $(".image-popup").removeClass("blind");
		    	  console.log("첨부파일 사이즈는 10KB 이내로 등록 가능합니다.");
		    	  $(this).val('');
				  $(".ok").on("click", function(){
				  	$(".image-popup").addClass("blind");
				  });
				 
				 return false;
		    }
		}
		});
     
     $("#input-file").change(function() {
        readURL(this);
     });
     
     $('#delete-file1').click(function(){
      $('#image').attr('src',"/meet-a-bwa/resources/img/placeholder1.webp");
      $('#delete-file1').css('display','none');
      // $('#delete-file1').css('opacity','0');
      });

     $('#delete-file2').click(function(){
      $('#image').attr('src',"/meet-a-bwa/resources/img/default-image2.png");
      $('#delete-file2').css('display','none');
      // $('#delete-file1').css('opacity','0');
      });
     //***********************************************************************//
     
     
     
     
   //*******************************지역 셀렉트, 태그******************************//  
  let cityArr = [];
  let townArr = []; 
  let tmpArr = [];
  
  let city = '';
  let country = '';
  
  let flag = true; //중복적인 $.getJSON 을 막기휘안 변수
  
  $("#city").on("click",function (e) {
    if(flag){ 
    	flag = false;
    	
	    $.getJSON("/meet-a-bwa/resources/json/city.json", function(data) {
	        cityArr = data.map(v => v.city);
	        city_set(cityArr);
	    });
    }
  });

  $("#city").on("change", function () {
  	city = $(this).val();
    console.log("city : " + city);
  	
  	if(city.length != 0 && city!="전체"){
  	 $.getJSON("/meet-a-bwa/resources/json/city.json", function(data) {
        townArr = data.filter(function(v,i){
        	if(v.city == city){
        		return true; 
        	}
        });
        townArr = townArr[0].arr;
	    town_set(townArr);
	  });
	  }else{
	  let arr2 = $("#country").find(".country_option:lt(2)").clone(); //시/군 선택 전체 리스트 복사
	    $("#country").empty(); 
	    
	    for(x of arr2){
	    	$("#country").append($(x));
	    } 
	  }
  });
  
   $("#country").on("change", function () {
  		console.log($(this).val());
	  	//flag = true;
  		
  });
  
 


	/****************************************/
	/* 함수 섹션 */
	/****************************************/
	//도시 리스트 세팅
	function city_set(arr){
		let arr2 = $("#city").find(".city_list:lt(2)").clone();
	    $("#city").empty();
	    console.log(arr2.length);
	    for(x of arr2){
	    	console.log($(x));
	    	$("#city").append($(x));
	    }
		let sample = $(".city_list:eq(0)").clone();
		
		for(x of arr){
			let list = sample.clone();
			list.text(x);
			list.val(x);
			
			$("#city").append(list);
		}
	}
	
	// 시/군 리스트 세팅
	function town_set(arr){
		//초기세팅
		let arr2 = $("#country").find(".country_option:lt(2)").clone(); //시/군 선택 전체 리스트 복사
	    $("#country").empty(); 
	    
	    for(x of arr2){
	    	$("#country").append($(x));
	    } 
	    
	    //도/시 선택에 맞는 시/군 세팅
		let sample = $(".country_option:eq(0)").clone();
		
		for(x of arr){
			let list = sample.clone();
			list.text(x);
			list.val(x);
			
			$("#country").append(list);
		}
	}
    //************************************************************************//
	
	 
      
      
    //*******************************연령대 태그********************************//
    let age_tag = $(".age_result:eq(0)").clone();
    let age_cnt=0;
    var arr = [];
    var arr_x = [];
    $("#ageBody").on("change", function (e) {
        age_tag = age_tag.clone();
        age_tag.removeClass("blind"); // 초기에 자동 생성된 버튼 숨기기
        let select_value = $("#ageBody option:selected").val();
        //let select_value = $("#ageBody option:selected").text();
        if (!arr.includes(select_value)&&select_value!='') {
            //선택한 관심사가 중복으로 들어가지 않도록 includes 함수 사용해서 배열 안에 해당 관심사가 없으면 아래 코드가 동작하게 함.
            age_tag.val(select_value + " X");
            arr.push(select_value);
            age_tag.attr("idx",++age_cnt);
            $("#tagWrap_age").append(age_tag);
            console.log(select_value);
            arr_x.push(select_value+" X");
            console.log(arr);
        }
    });

    $("#tagWrap_age").on("click", ".delete_age",function () {
     	let idx =$(this).attr("idx"); // 현재 배열 크기
        let arr = $(".delete_age").slice(); // 태그 배열 전체 복시
        
        let select_value = $(this).val();
        //let select_value = $(this).text();

		$("#tagWrap_age").empty().append($(arr[0]));

        for (let index = 1; index < arr.length; index++) { 
           if($(arr[index]).attr("idx")!=idx){ // 삭제할 값과 같지 않은 데이터들만
                $("#tagWrap_age").append(arr[index]); //부모에 붙여줌.
           }
        }
        
        for(let i = 0; i < result_x.length; i++) {
  			if(result_x[i]==select_value)  {
    			result.splice(i, 1);
    			result_x.splice(i, 1);
    			i--;
  			}
		}
        
        console.log("삭제 후 result:"+result);
        console.log("삭제 후 result_x:"+result_x);
    });
    //*****************************************************************//



    //***************************관심사 셀렉트, 태그***********************//
     var interest = ["취미",
        "팬클럽",
        "방송/연예",
        "스포츠/레저",
        "게임",
        "만화/애니메이션",
        "맛집/요리",
        "생활정보/인테리어",
        "건강/다이어트",
        "패션/뷰티",
        "여행/캠핑",
        "반려동물/동물",
        "문화/예술",
        "음악",
        "어학/외국어",
        "취업/자격증",
        "교육/공부",
        "IT/컴퓨터",
        "인문/과학",
        "경제/재테크",
        "종교/봉사",
        "일상/이야기",
        "나이/또래모임",
        "친목/모임",
        "자연/귀농"];

    cate_init();    
    function cate_init(){
        let sample = $(".interest_opt").eq(0).clone();
        for (let i = 0; i < interest.length; i++) {
            sample = sample.clone().text(interest[i]);
            sample.val(interest[i]);
            $("#interest").append(sample);
        }
    }


    /*************************************************** */
    /** 관심사 태그 추가 */
    /*************************************************** */
    let tag = $(".delete_interest:eq(0)").clone();
    let cnt=0;
	var arr = [];
    $("#interest").on("change", function (e) {

        tag = tag.clone();
        tag.removeClass("blind");
        let select_value = $(this).val();
    		
    		 if (!arr.includes(select_value)&&select_value!='') {
            //선택한 관심사가 중복으로 들어가지 않도록 includes 함수 사용해서 배열 안에 해당 관심사가 없으면 아래 코드가 동작하게 함.
            tag.val(select_value + " X");
            tag.attr("idx",++cnt);
            $("#tagWrap").append(tag);
            console.log(select_value);
            arr.push(select_value);
            console.log(arr);
        }
    });


    /*************************************************** */
    /** 관심사 태그 삭제 */
    /*************************************************** */
    $("#tagWrap").on("click",".delete_interest",function () {
        console.log($(this).attr("idx"));
        let idx =$(this).attr("idx");
        let arr = $(".delete_interest").slice();
        // console.log(arr);
        
        $("#tagWrap").empty().append($(arr[0]));

        for (let index = 1; index < arr.length; index++) {
           if($(arr[index]).attr("idx")!=idx){
                $("#tagWrap").append(arr[index]);    
           }
        }
    });
    //*****************************************************************//
      
      
      
      
    //***************************생성 버튼 누른 후 동작******************************//

//	$("#create_activity").click(function(){
	
    // 1. NOT NULL 충족 - alert Popup 

//		var user_id = "${user_id}"; //세션값 가져옴
//		console.log(user_id);
//		check();
//		insert_ajax();
//		console.log($("#activity_name").val());
//		console.log($("#activity_description").val());
//		console.log($("#city").val());
//		console.log($("#country").val());
//		console.log($("#interest").val());
//		console.log($("#gender").val());
//		console.log($("#numberofpeople option:selected").val());
//		console.log($("#ageBody option:selected").val());
		//console.log($.cookie("user_no"));
		//console.log(location.href.split("meet_no=")[1]);
//		});
		
	
	// 2. 서버 전달
		function insert_ajax(){ //사용 x 
		
		var form = $("#activity_create_form")[0];
    	var formData = new FormData(form);
		console.log(formData);
		console.log("$.cookie : " + $.cookie("user_no"));
 
    	 	$.ajax({
        		url : "/meet-a-bwa/a_insertOK.do",
				type : "POST",
				enctype:'multipart/form-data',
				//dataType:'json',
    			processData:false,
    			contentType:false,
    			cache:false,
				data : {
					user_no : $.cookie("user_no"),
					meet_no : location.href.split("meet_no=")[1],
					formData
				},
				dataType:'json',
				
				success : function(res) {
					console.log($.cookie("user_no"));
					console.log(location.href.split("meet_no=")[1]);
					
					console.log("res"+res);
		        	if(res.result == "insert success"){
		        		console.log("success");
		        	}else if(res.result == "insert fail"){
		        		console.log("fail");
		        	}
				},
				error : function(error) {
			 		console.log(error);
			 	}
        	});
    	}
   
	
	
   
   

});