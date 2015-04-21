<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户管理</title>

  </head>
  
  <body>
	<table id="dg" class="easyui-datagrid" title="用户管理" style="width:800px;height:500px"
			data-options="rownumbers:true,pagination:true,singleSelect:true,url:'userAction_findAll',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
		<th data-options="field:'id',width:20">ID</th>
		<th data-options="field:'username',width:80">用户名</th>		
		<th data-options="field:'headImg',width:'auto',align:'center',formatter:function(v){return '<img src=<%=request.getContextPath()%>/upload/'+v+' height=50;>'}">头像</th>	
		<th data-options="field:'nickname',width:80">昵称</th>
		<th data-options="field:'gender',formatter:function(v){
				if(v==1) 
				{return '男';}
				else 
				{return '女'};
				},align:'center',width:32">性别</th>			
		<th data-options="field:'birthday',width:80">生日</th>
		<th data-options="field:'introduction',width:80">简介</th>			
		<th data-options="field:'createDate',width:80">注册时间</th>
		<th data-options="field:'enabled',formatter:function(s){if(s==1){return '<a onclick=\'jinyong($(this))\'>禁用</a>'} else{return '<a onclick=\'huifu($(this))\'>恢复</a>'}} ">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:2px 5px;">
		<input id="searchStr" type="text" style="width: 200px;border: 1px solid;">
		<a id="search" class="easyui-linkbutton" iconCls="icon-search">Search</a>
	</div>
<script type="text/javascript">

$("#search").click(function() {
	var searchStr = $("#searchStr").val();
	if (searchStr != "" && searchStr != null) {
		$('#dg').datagrid({
			url : 'userAction_findByUsernameOrNickname?name=' + searchStr
		});
	} else {
		$('#dg').datagrid({
			url : 'userAction_findAll'
		});
	}
});
function jinyong(e){
var uid=e.parent().parent().parent().children().first().text();
$.ajax({
		type:"post",
		url:"userAction_disableUser",
		data:{
			userId:uid
			}	,
		dataType:"json",
		success:function(data){
	alert(data.msg);
	$('#dg').datagrid('reload');
			}	
	})	
}

function huifu(e){
	var uid=e.parent().parent().parent().children().first().text();
	$.ajax({
			type:"post",
			url:"userAction_enableUser",
			data:{
				userId:uid
				}	,
			dataType:"json",
			success:function(data){
		alert(data.msg);
		$('#dg').datagrid('reload');
				}	
		})	
	}
</script>
  </body>
</html>
