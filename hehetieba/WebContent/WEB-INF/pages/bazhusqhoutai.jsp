<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>吧主申请管理</title>

  </head>
  
  <body>
	<table id="dg" class="easyui-datagrid" title="吧主申请管理" style="width:800px;height:500px"
			data-options="rownumbers:true,pagination:true,singleSelect:true,url:'tiebaOwnerApply_listAll',method:'get'">
		<thead>
			<tr>
		<th data-options="field:'id',width:20">ID</th>
		<th data-options="field:'userId',width:50">申请人ID</th>
		<th data-options="field:'tiebaId',width:50">申请吧ID</th>
		<th data-options="field:'username',width:80">申请人</th>		
		<th data-options="field:'tiebaName',width:80">申请吧名</th>
		<th data-options="field:'applyDate',width:80">申请时间</th>
		<th data-options="field:'handleStatus',formatter:function(s){
				if(s==0){return '<a onclick=\'tongyi($(this));\'>同意</a>/<a onclick=\'butongyi($(this));\'>不同意</a>'} 
				else if(s==1){return '已同意'} 
 				else if(s==2) 
 				{return '不同意';}} ">操作</th>
			</tr>
		</thead>
	</table>

<script type="text/javascript">


function tongyi(e){
	var taid=e.parent().parent().parent().children().first().text();
	var uid=e.parent().parent().parent().children().first().next().text();
	var tid=e.parent().parent().parent().children().first().next().next().text();
	var tname=e.parent().parent().parent().children().first().next().next().next().next().text();
	$.ajax({
			type:"post",
			url:"tiebaOwnerApply_agree",
			data:{
				tiebaOwnerApplyId:taid,
				userId:uid,
				tiebaId:tid,
				tiebaName:tname
				}	,
			dataType:"json",
			success:function(data){
		alert(data.message);
		$('#dg').datagrid('reload');
				}	
		})	
	}
function  butongyi(e){
	var taid=e.parent().parent().parent().children().first().text();
	var uid=e.parent().parent().parent().children().first().next().text();
	var tid=e.parent().parent().parent().children().first().next().next().text();
	var tname=e.parent().parent().parent().children().first().next().next().next().next().text();
	$.ajax({
			type:"post",
			url:"tiebaOwnerApply_disAgree",
			data:{
				tiebaOwnerApplyId:taid,
				userId:uid,
				tiebaId:tid,
				tiebaName:tname
				}	,
			dataType:"json",
			success:function(data){
		alert(data.message);
		$('#dg').datagrid('reload');
				}	
		})	
	}
</script>
  </body>
</html>
