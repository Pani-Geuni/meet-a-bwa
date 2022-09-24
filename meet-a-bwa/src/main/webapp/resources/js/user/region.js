$(function () {

  let cityArr = [];
  let townArr = []; 
  
  let city = '';
  let country = '';
  
  $("#city").on("click", function (e) {
    city = $(this).val();
    console.log(city);
    
    $.getJSON("/meet-a-bwa/resources/json/city.json", function(data) {
        cityArr = data.map(v => v.city);
        city_set(cityArr);
    });

  });

  $("#country").on("click", function () {
  	 country = $(this).val();
     console.log(country);
     
     if(city.val()!=undefined && city.val()!="전체"){
	      $.getJSON("/meet-a-bwa/resources/json/city.json", function(data) {
		        //townArr = data.map(v => v.arr);
		        townArr = data.filter(function(v,i){
		        	if(v.city == city){
		        		console.log(i);
		        		return true;
		        	}
		        });
		        townArr = townArr[0].arr;
			    town_set(townArr);
		  });
	}
  });


	/****************************************/
	/* 함수 섹션 */
	/****************************************/
	//도시 리스트 세팅
	function city_set(arr){
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
		let sample = $(".country_option:eq(0)").clone();
		
		for(x of arr){
			let list = sample.clone();
			list.text(x);
			list.val(x);
			
			$("#country").append(list);
		}
	}
});