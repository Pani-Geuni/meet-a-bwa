$(function(){
    let cnt = 1;
    let cnt2 = 1;
    let flag = true;
    
    plus_list();


    /************************************************ */
    /** 버튼 클릭 이벤트 SECTION */
    /************************************************ */    
    // 투표 항목 추가 버튼
    $("#vote_list_plusBtn").click(function(){
        plus_list();
    });

    // 팝업 창닫기 버튼
    $("#closeBtn").click(function(){

    });
    
    
    /************************************************ */    
    /** 글자수 제한 **/
    /************************************************ */
    // 투표 제목 글자수 제한   
    $("#vote_title").keydown(function(){
        text_limit(15, $(this), $("#title_text_length"));
    });
    $("#vote_title").keyup(function(){
        text_limit(15, $(this), $("#title_text_length"));
    });
    
    // 투표 설명 글자수 제한
    $("#vote_description").keydown(function(){
        text_limit(150, $(this), $("#description_text_length"));
    });
    $("#vote_description").keyup(function(){
        text_limit(150, $(this), $("#description_text_length"));
    });

    /************************************************ */
    /** 투표 항목 삭제 **/
    /************************************************ */
    $("#vote_list_Wrap").on("click", ".removeBtn", function(){
        cnt2=1;
        let wrap = $(this).parents("#vote_list_Wrap");
        let sample = $(".sample").clone();
        let idx = $(this).parents(".vote_list").attr("idx");
        let arr = wrap.children(".vote_list").not(".blind");
        wrap.empty().append(sample);

        for(var i = 0; i < arr.length; i++){
            if($(arr[i]).attr("idx") != idx){
                $(arr[i]).children(".list_title").text(cnt2+".");
                wrap.append(arr[i]);
                cnt2++;
            }
        }

    });


    /************************************************ */
    /** DATEPICKER **/
    /************************************************ */
    $("#vote_endDate").datepicker({
        changeYear:true,
        changeMonth:true,
        onSelect:function(dateText) {
            console.log(dateText);
        }
    });


    /************************************************ */
    /** 함수 SECTION **/
    /************************************************ */
    // 글자수 제한 및 글자수 표기 함수
    function text_limit(max_length, element, length_txt_element){
        if(element.val().length > max_length){
            fade_in_out(element, max_length);
        }
        length_txt_element.text(element.val().length + "/" + max_length);
    }
    
    //투표 항목 추가 함수
    function plus_list(){
        let sample_list = $(".sample").clone();
        sample_list.removeClass("blind sample");
        sample_list.attr("idx", cnt);
        sample_list.children(".list_title").text(cnt2+".");
        cnt++;
        cnt2++;
        
        $("#vote_list_Wrap").append(sample_list);
    }
    
    // 토스트 함수
    function fade_in_out(element, max_length){
        element.val(element.val().substr(0,max_length));

        if(flag){
            flag = false;
            $("#toast_txt").text("글자수를 초과하였습니다.")
            $("#toastWrap").removeClass("hide");
            $("#toastWrap").removeClass("fade-out");
            $("#toastWrap").addClass("fade-in");
        
            setTimeout(function() {
                flag = true; // 추후에 사용할 수 있도록 변수값 변경
                $("#toastWrap").removeClass("fade-in");
                $("#toastWrap").addClass("fade-out");
            }, 2000);
        }
    }

});