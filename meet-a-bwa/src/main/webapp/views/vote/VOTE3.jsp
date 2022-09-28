<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 이벤트 수정 -->
    
    
<!-- Start voteWrap -->
<div id = "voteWrap">
    <!-- Start vote_popup -->
    <div id = "vote_popup">
        <div id = "topSection">
            <h1 id = "title">투표 수정</h1>
            <img src = "../img/close.png" alt = "close이미지" id = "closeBtn" />
        </div>

        <!-- Start sectionWrap -->
        <div id = 'sectionWrap'>
            <section id = "titleSection" class = "section_common">
                <h4 class = "section_title">투표 제목</h4>
                <section id = "title_section">
                    <input type = "text" id = "vote_title" class = "common" placeholder="투표 제목" value="">
                    <span id = "title_text_length" class = "text_length">0/15</span>
                </section>
            </section>

            <section id = "endDateSection"  class = "section_common">
                <h4 class = "section_title">투표 마감 시간/날짜 설정</h4>
                <div id = "pickerWrap">
                    <input type = "text" id = "vote_endDate" class = "dateCommon" autocomplete="off" placeholder="날짜를 선택해주세요.">
                    <div id = "timepicker_box" class = "dateCommon">
                        <section id = "timeSection">
                            <span id = "timeValue">--:--:--</span>
                        </section>

                        <section id = "timeImgSection">
                            <img src="../img/clock.svg" id = "timeImg" alt = "시계이미지" />
                        </section>

                        <div id = "customTimePicker" class = "blind">
                            <div id = "ampm_choice">
                                <ul id = "ampm_listWrap">
                                    <li class = "sample ampm-list"></li>
                                </ul>
                            </div>
                            <div id = "time_choice" class = "choiceCommon">
                                <ul id = "time_listWrap">
                                    <li class = "sample time-list"></li>
                                </ul>
                            </div>
                            <div id = "minute_choice" class = "choiceCommon">
                                <ul id = "minute_listWrap">
                                    <li class = "sample minute-list"></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class = "section_common">
                <h4 class = "section_title">투표 내용</h4>
                <section>
                    <textarea id = "vote_description" class = "common" placeholder="투표 내용"></textarea>
                    <span id = "description_text_length" class = "text_length">0/150</span>
                </section>
            </section>

            <section id = "voteSection"  class = "section_common">
                <h4 class = "section_title">투표 항목</h4>

                <div id = "vote_list_Wrap">
                    <!-- SAMPLE VOTE LIST -->
                    <div class = "vote_list sample blind">
                        <label class = "list_title"></label>
                        <input type = "text" class = "list_text" value=""/>
                        <img src = "../img/close.png" alt = "항목 삭제 이미지" class = "removeBtn" />
                    </div>
            </section>
            <input type ="button" id = "vote_list_plusBtn" value="투표 항목 추가" />
                
        </div><!-- END sectionWrap -->
        
        <div id = "btnWrap">
            <input type ="button" id = "vote_updateBtn" class = "btnCommon" value="투표 수정">
        </div>
    </div><!-- END vote_popup -->
</div><!-- END voteWrap -->

<!-- START toastWrap -->
<!-- 필요할 때, hide 없애고 fade-in 클래스 추가-->
<div id = "toastWrap" class = "hide">
    <span id = "toast_txt"></span>
<div><!-- END toastWrap -->