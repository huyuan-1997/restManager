<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>厨师管理</title>
<metacontent="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"name="viewport">
<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet" href="plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#btn_addCooker").click(function() {
			$("#addCooker").submit();
		});
		
		$("#btn_deleteCookers").click(function(){
			var flag=0;
	          $(":checkbox[name='ids']").each(function(){
	              if(  $(this).prop("checked")==true){
	            	  flag=1
	              }
	           });
	           
			if(flag==1){
				var v = confirm("确认删除吗？")
				if(v==true){
					$("#deleteCookers").submit();
				}
			}
		});
		

	})
</script>


</head>
<body class="hold-transition skin-red sidebar-mini">
	<!-- .box-body -->
	<div class="box-header with-border">
		<h3 class="box-title">厨师管理</h3>
	</div>

	<div class="box-body">

		<!-- 数据表格 -->
		<div class="table-box">

			<!--工具栏-->
			<div class="pull-left">
				<div class="form-group form-inline">
					<div class="btn-group">
						<button type="button" class="btn btn-default" title="新建"
							data-toggle="modal" data-target="#editModal1">
							<i class="fa fa-file-o"></i> 新建
						</button>
						<button type="button" class="btn btn-default" title="删除" id="btn_deleteCookers">
							<i class="fa fa-trash-o"></i> 删除
						</button>
						<button type="button" class="btn btn-default" title="刷新"
							onclick="window.location.reload();">
							<i class="fa fa-refresh"></i> 刷新
						</button>
					</div>
				</div>
			</div>
			<div class="box-tools pull-right">
				<div class="has-feedback"></div>
			</div>
			<!--工具栏/-->

			<!--数据列表-->
			<table id="dataList"
				class="table table-bordered table-striped table-hover dataTable">
				<thead>
					<tr>
						<th class="" style="padding-right: 0px">选择</th>
						<th class="sorting_asc">厨师ID</th>
						<th class="sorting">厨师名称</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
				<form id="deleteCookers" action="deleteCookers.do" method="post" >
				<c:forEach items="${cookers}" var="cooker">
					<tr>
						<td><input type="checkbox" name="ids" value="${cooker.id }"></td>
						<td>${cooker.id }</td>
						<td>${cooker.cook_name }</td>
						<td class="text-center">
							<a type="button" class="btn bg-olive btn-s" href="cookOrderItems.do?id=${cooker.id }"+>开始任务</a>
						</td>
					</tr>
				</c:forEach>
				</form>
				</tbody>
			</table>
			<!-- 分页 -->
			
			<!--数据列表/-->


		</div>
		<!-- 数据表格 /-->




	</div>
	<!-- /.box-body -->

	<!-- 新增厨师窗口 -->
	<div class="modal fade" id="editModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">新增厨师</h3>
				</div>
				<div class="modal-body">
				
				<form id="addCooker" action="insertCooker.do" method="post" >
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>厨师名称</td>
							<td><input class="form-control" placeholder="厨师名称" name="cook_name">
							</td>
						</tr>
					</table>
					</form>
					
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						aria-hidden="true"id="btn_addCooker">添加</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 厨师任务窗口 -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">厨师任务</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>菜单名称</td>
							<td><input class="form-control" placeholder="菜单名称">
							</td>
							<td><button type="button" class="btn btn-default" title="出菜"
									data-toggle="modal" data-target="#editModal1">
									<i class="fa fa-file-o"></i> 出菜
								</button></td>
						</tr>

					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						aria-hidden="true">完成</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>