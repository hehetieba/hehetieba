<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>贴吧管理</title>

  </head>
  
  <body>
	<table id="dg" class="easyui-datagrid" title="贴吧管理" style="width:800px;height:500px"
			data-options="rownumbers:true,pagination:true,singleSelect:true,url:'tiebaAction_listInHoutai',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
		<th data-options="field:'id',width:20">ID</th>
		<th data-options="field:'tiebaName',width:80">吧名</th>		
		<th data-options="field:'headImg',width:'auto',align:'center',formatter:function(v){return '<img src=<%=request.getContextPath()%>/upload/'+v+' height=50;>'}">吧头像</th>	
		<th data-options="field:'intruduction',width:80">简介</th>			
		<th data-options="field:'memberCount',width:80">成员数</th>
		<th data-options="field:'tieCount',width:80">帖子数</th>
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
			url : 'tiebaAction_findByTiebaName_houtai?tiebaName=' + searchStr
		});
	} else {
		$('#dg').datagrid({
			url : 'tiebaAction_listInHoutai'
		});
	}
});
function jinyong(e){
var bid=e.parent().parent().parent().children().first().text();
$.ajax({
		type:"post",
		url:"tiebaAction_disableTieba",
		data:{
			tiebaId:bid
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
			url:"tiebaAction_enableTieba",
			data:{
				tiebaId:uid
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
