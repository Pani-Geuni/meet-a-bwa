<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id = "menuWrap">
    <div id = "logoSection">
        <a href = "">
            <img src = "/meet-a-bwa/resources/img/logo.svg" alt = "logo img" id = "logo_img">
        </a>
    </div>
    <div id = "log_Section">
        <!-- beforeLogin은 flex와 충돌나서 blind 클래스 add하고 logSection 클래스 remove 해줘야함-->
        <ul id = "beforeLogin" class = "blind">
            <li class = "logItem">
                <a href = "">
                    <button id = "loginBtn" class = "logBtn btn_css">로그인</button>
                </a>
            </li>
        </ul>
        
        <!-- afterLogin은 flex와 충돌나서 blind 클래스 add하고 logSection 클래스 remove 해줘야함-->
        <ul id = "afterLogin" class = "logSection">
            <li class = "logItem">
                <a href = "">
                    <button id = "mypageBtn" class = "btn_css">마이페이지</button>
                </a>
            </li>
            <li class = "logItem">
                <a href = "">
                    <button id = "logoutBtn" class = "logBtn btn_css">로그아웃</button>
                </a>
            </li>
        </ul>
    </div>
</div>