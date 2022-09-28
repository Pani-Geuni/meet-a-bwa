<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  투표 확인 -->
    
    
<!-- START voteWrap -->
    <div id = "voteWrap">
        <div id = "divWrap" class = "vote_section">
            <div id = "header_wrap" class = "wrap_common">
                <span id = "title">투표 제목 부분입니다.</span>
                <img src = "../img/more-vertical.png" alt = "더보기 세로 이미지" id = "more_vertival"/>
                <!-- 숨기고 싶을 때, select_custom 제거 후 blind 추가-->
                <!-- 보이고 싶을 때, select_custom 추가 후 blind 제거-->
                <div id = "dropdown" class = "blind">
                    <img src = "../img/vector.png" alt = "셀렉트 before 이미지" id = "select_img"/>
                    <ul class = "select_list_wrap">
                        <li class = "select_list" id = "update">수정</li>
                        <li class = "select_list" id = "delete">삭제</li>
                    </ul>
                </div>
            </div>
            <div id = "body_wrap" class = "wrap_common">
                <!-- START 투표 설명란 -->
                <!-- START 투표 설명없으면, class blind 추가 -->
                <fieldset id = "description_field">
                    <legend class = "field_title">투표 설명</legend>
                    <div id = "vote_description">
                        <p id = "text_area">
                            2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
                            2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
                            2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
                            2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.
                        </p>
                    </div>
                </fieldset>
                <!-- END 투표 설명란 -->

                <!-- START 투표 선택란 -->
                <div id = "choice_wrap">
                    <!-- START choiceList-->
                    <div class = "choiceList">
                        <section class = "txt_wrap_section">
                            <section class = "txt_section">
                                <span class = "txt">항목 타이틀 자리</span>
                                <!-- 결과보여줄 때, blind 제거 -->
                                <span class = "choice_mem_cnt blind"></span>
                            </section>

                            <!-- 결과보여줄 때, blind 제거해서 -->
                            <span class = "list_percentage_wrap blind">
                                <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
                                <span class = "list_percentage"></span>
                            </span>
                        </section>

                        <div class = "out_circle">
                            <!-- 보일 때 choice 추가-->
                            <!-- 가릴 때 choice 삭제-->
                            <div class = "in_circle">

                            </div>
                        </div>
                    </div>
                    <!-- END choiceList -->
                    <!-- START choiceList-->
                    <div class = "choiceList">
                        <section class = "txt_wrap_section">
                            <section class = "txt_section">
                                <span class = "txt">항목 타이틀 자리</span>
                                <!-- 결과보여줄 때, blind 제거 -->
                                <span class = "choice_mem_cnt blind"></span>
                            </section>

                            <!-- 결과보여줄 때, blind 제거해서 -->
                            <span class = "list_percentage_wrap blind">
                                <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
                                <span class = "list_percentage"></span>
                            </span>
                        </section>

                        <div class = "out_circle">
                            <div class = "in_circle">

                            </div>
                        </div>
                    </div>
                    <!-- END choiceList -->
                </div>
                <!-- END 투표 선택란 -->
            </div>
            
            <div id = "footer_wrap" class = "wrap_common">
                <section id = "footer_info">
                    <span class = "info_common">작성자 정상윤</span>
                    <span class = "info_common" id = "end_date">투표마감:2022-09-01 오전10:00</span>
                </section>

                <section class = "btn_section blind">
                    <input type = "button" id = "voteBtn"  class = "btnCommon" value="투표하기"/>
                </section>
                <section class="btn_section">
                    <input type = "button" id = "re_voteBtn"  class = "btnCommon" value="재투표하기"/>
                </section>
                <section class="btn_section blind">
                    <input type = "button" id = "re_voteBtn"  class = "btnCommon" value="닫기"/>
                </section>
            </div>
        </div>

    </div>
    <!-- END voteWrap -->
    
    <div id = "confirmWrap" class = "blind"> 
        <div id = "confirm_head">
            <img src = "../img/fluent_more-horizontal-20-regular.png" id = "more-horizontal"/>
        </div>
        <div id = "confirm_txt_wrap">
            <span id = "confirm_txt">삭제하시겠습니까?</span>
        </div>
        <div id = "confirm_btn_wrap">
            <input type = "button" id = "yesBtn" class = "confirm_btn_common" value = "예"/>
            <input type = "button" id = "noBtn" class = "confirm_btn_common" value = "아니오"/>
        </div>
    </div>