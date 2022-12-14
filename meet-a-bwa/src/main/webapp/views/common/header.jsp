<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<c:set var = "list" value = "${list}"/>
<div id = "menuWrap">
    <div id = "logoSection">
        <img src = "/meet-a-bwa/resources/img/logo.svg" alt = "logo img" id = "logo_img">
    </div>
    <div id = "log_Section">
    	<c:choose>
			<c:when test="${list.isLogin eq false || list.isLogin eq null}">
		        <ul id = "beforeLogin" class = "logSection">
		            <li class = "logItem">
		            	<button id = "loginBtn" class = "logBtn btn_css">로그인</button>
		            </li>
		        </ul>
	        </c:when>
	        
	        <c:when test="${list.isLogin eq true}">
		        <ul id = "afterLogin" class = "logSection">
		            <li class = "logItem">
		           		<input type = "button" id = "mypageBtn" class = "btn_css" value = "마이페이지">
		            </li>
		            <li class = "logItem">
		            	<input type = "button" id = "logoutBtn" class = "logBtn btn_css" value = "로그아웃">
		            </li>
		        </ul>
	        </c:when>
        </c:choose>
        
    </div>
</div>