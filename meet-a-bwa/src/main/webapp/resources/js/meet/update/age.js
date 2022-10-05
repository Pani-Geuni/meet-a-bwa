/**
 * @author 최진실
 */
 $(function () {

    let ageRange = $("#ageRange");
    $("#ageWrap").each(function () {
        for (let i = 10; i <= 90; i+=10) {
            $("#ageBody").append("<option>" + i + "대"+ "</option>");
        }
    });

    let tag = $(".age_result:eq(0)").clone();
    var arr = [];
    
    $("#ageBody").on("change", function (e) {
        tag = tag.clone();
        tag.removeClass("blind"); // 초기에 자동 생성된 버튼 숨기기
        let select_value = $("#ageBody option:selected").text();
        
        if (arr.includes(select_value) == false) {
            //선택한 관심사가 중복으로 들어가지 않도록 includes 함수 사용해서 배열 안에 해당 관심사가 없으면 아래 코드가 동작하게 함.
            tag.val(select_value + " X");
            $("#tagWrap_age").append(tag);
            console.log(select_value);
            arr.push(select_value);
            console.log(arr);
        }
    });

    $("#tagWrap_age").on("click", function () {
        $("#delete_age").remove(); //관심사 삭제

        let select_value = $(this).attr('text');//배열에서도 삭제
        var delarr = arr.indexOf(select_value);
        if (delarr > -1) {
            arr.slice(delarr, 1);
        }
    });

});