<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>创建贴吧管理</title>

  </head>
  
  <body>
	<table id="dg" class="easyui-datagrid" title="创建贴吧管理" style="width:800px;height:500px"
			data-options="rownumbers:true,pagination:true,singleSelect:true,url:'tiebaApplyAction_listAll',method:'get'">
		<thead>
			<tr>
		<th data-options="field:'id',width:20">ID</th>
		<th data-options="field:'tiebaName',width:80">申请贴吧名</th>		
		<th data-options="field:'applyDate',width:80">申请时间</th>
		<th data-options="field:'handleStatus',formatter:function(s){
				if(s==0){return '<a onclick=\'tongyi($(this));\'>同意</a>/<a onclick=\'butongyi($(this));\'>不同意</a>'} 
				else if(s==1){return '已经创建了该贴吧'} 
 				else if(s==2) 
 				{return '不创建该贴吧';}} ">操作</th>
			</tr>
		</thead>
	</table>

<script type="text/javascript">


function butongyi(e){
var tid=e.parent().parent().parent().children().first().text();
var tname=e.parent().parent().parent().children().first().next().text();
$.ajax({
		type:"post",
		url:"tiebaAction_notSaveTieba",
		data:{
			tiebaApplyId:tid,
			tiebaName:tname
			}	,
		dataType:"json",
		success:function(data){
	alert(data.msg);
	$('#dg').datagrid('reload');
			}	
	})	
}

function tongyi(e){
	var tid=e.parent().parent().parent().children().first().text();
	var tname=e.parent().parent().parent().children().first().next().text();
	$.ajax({
			type:"post",
			url:"tiebaAction_saveTieba",
			data:{
				tiebaApplyId:tid,
				tiebaName:tname
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
