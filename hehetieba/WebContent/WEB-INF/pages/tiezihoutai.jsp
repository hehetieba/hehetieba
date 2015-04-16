<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>帖子管理</title>

  </head>
  
  <body>
	<table id="dg" class="easyui-datagrid" title="用户管理" style="width:800px;height:500px"
			data-options="rownumbers:true,pagination:true,singleSelect:true,url:'tieTitleAction_findAll',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
		<th data-options="field:'tieTitleId',width:20">ID</th>
		<th data-options="field:'title',width:80">帖子标题</th>		
		<th data-options="field:'username',width:80">发表人</th>	
		<th data-options="field:'tiebaName',width:80">来自贴吧</th>
		<th data-options="field:'createDate',width:80">创建时间</th>			
		<th data-options="field:'shanchu',formatter:function(s){return '<a onclick=\'shanchu($(this))\'>删除</a>'}" >操作</th>
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
			url : 'tieTitleAction_searchByTitle?title=' + searchStr
		});
	} else {
		$('#dg').datagrid({
			url : 'tieTitleAction_findAll'
		});
	}
});
function shanchu(e){
var tid=e.parent().parent().parent().children().first().text();
$.ajax({
		type:"post",
		url:"tieTitleAction_delete",
		data:{
			tieTitleId:tid
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
