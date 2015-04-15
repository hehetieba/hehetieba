<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/simpla.jquery.configuration.js"></script>
<decorator:head></decorator:head>
<title><decorator:title /></title>
<link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/img/favicon.ico">
</head>
 <div id="sidebar" style="margin-left:-60px; ">
        <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="book.do?method=index">hehe</a></h1>
      <!-- Logo (221px wide) -->
      <a href="#"><img id="logo" src="<%=request.getContextPath()%>/images/logo.png" alt="Hehe bookstore" /></a>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> Hello, <a href="#" title="${admin.nickname}"><c:if test="${not empty admin}">${admin.nickname}</c:if></a>,<br/>you have <a href="#messages" rel="modal" title="3 Messages">3 Messages</a><br />
        <br />
 <a href="#" title="Sign Out">Sign Out</a> </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="userlist.do?method=list"  class="nav-top-item no-submenu" id="user_list" >用户管理</a> </li>
        <li> <a href="catelist.do?method=list" class="nav-top-item no-submenu" id="cate_list" > 图书类别管理</a></li>
        <li> <a href="booklist.do?method=J_list" class="nav-top-item no-submenu" id="book_list"> 管理图书</a> </li>
    <li> <a href="Orders.do?method=list" class="nav-top-item no-submenu" id="orders_list"> 订单管理</a>

        </li>
        <li> <a href="#" class="nav-top-item"> 查看销售情况 </a>
         
        </li>
        <li> <a href="#" class="nav-top-item"> 留言管理 </a>
          <ul>
            <li><a href="#">用户注册</a></li>
            <li><a href="#">删除留言</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #main-nav -->
     
  
    </div>
  </div>
  
  
<div class="content" style="margin-left:230px; ">
 <div id="header">welcome</div> 
  <div style="float:left;  width:100%; ">

  <decorator:body></decorator:body>
  
  <div style="clear:both;"></div>
    <div id="footer" align="center"> <small>
  &#169; Copyright 2014 Dawn Group |11 Software|all members </small> </div>


  </div>
</div>
</body>
</html>