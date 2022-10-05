/**
 * @author 최진실
 */

$(function () {

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
            arr.push(select_value);
        }
    });


    /*************************************************** */
    /** 관심사 태그 삭제 */
    /*************************************************** */
    $("#tagWrap").on("click",".delete_interest",function () {
        let idx =$(this).attr("idx");
        let arr = $(".delete_interest").slice();
        
        $("#tagWrap").empty().append($(arr[0]));

        for (let index = 1; index < arr.length; index++) {
           if($(arr[index]).attr("idx")!=idx){
                $("#tagWrap").append(arr[index]);    
           }
        }

    });

});