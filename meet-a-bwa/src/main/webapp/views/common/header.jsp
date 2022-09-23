<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div id = "menuWrap">
    <div id = "logoSection">
        <a href = "/meet-a-bwa/main.do">
            <img src = "/meet-a-bwa/resources/img/logo.svg" alt = "logo img" id = "logo_img">
        </a>
    </div>
    <div id = "log_Section">
        <ul id = "beforeLogin" class = "logSection blind">
            <li class = "logItem">
            	<button id = "loginBtn" class = "logBtn btn_css">로그인</button>
            </li>
        </ul>
        
        <ul id = "afterLogin" class = "logSection ">
            <li class = "logItem">
                <a href = "/meet-a-bwa/mypage.do">
            		<button id = "mypageBtn" class = "btn_css">마이페이지</button>
           		</a>
            </li>
            <li class = "logItem">
            	<button id = "logoutBtn" class = "logBtn btn_css">로그아웃</button>
            </li>
        </ul>
    </div>
</div>