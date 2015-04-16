<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />        
    <![endif]-->
    <style type="text/css">
    html,body,.wrapper{ height: 100%;}
    
    </style>
<title><decorator:title /></title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/houtai.css" rel="stylesheet" type="text/css"/>
<link href="themes/default/easyui.css" rel="stylesheet" type="text/css"/>
<link href="themes/icon.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<style type="text/css">
a{ cursor: pointer;}

</style>
</head>
<body>
<div style="display: none;" id="loader"></div>
<div class="wrapper">
  <div class="sidebar">
    <div class="top"> <a href="#" class="logo"></a>
      <div class="search">
        <div class="input-prepend"> 
         
        </div>
      </div>
    </div>
    <div class="nContainer">
      <ul class="navigation bordered">
        <li class="active"><a href="userhoutai" class="blblue">用户管理</a></li>
        <li> <a href="tiebahoutai" class="blyellow">贴吧管理</a>
        </li>
        <li> <a href="tiezihoutai#" class="blgreen">帖子管理</a>
        </li>
        <li><a href="tiebasqhoutai" class="blred">建吧审核</a></li>
        <li> <a href="bazhusqhoutai" class="bldblue">吧主审核</a>
        </li>
      </ul>
      </div>
  </div>
  <div class="body" style="padding-top:100px;">
    <decorator:body></decorator:body>
    </div>
</div>

</body>
</html>