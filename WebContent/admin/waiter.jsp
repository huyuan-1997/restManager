<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>服务员管理</title>
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>


</head>
<body class="hold-transition skin-red sidebar-mini">
	<!-- .box-body -->
	<div class="box-header with-border">
		<h3 class="box-title">服务员管理</h3>
	</div>

	<div class="box-body">

		<!-- 数据表格 -->
		<div class="table-box">

			<!--工具栏-->
			<div class="pull-left">
				<div class="form-group form-inline">
					<div class="btn-group">
						<button type="button" class="btn btn-default" title="新建"
							data-toggle="modal" data-target="#editModal">
							<i class="fa fa-file-o"></i> 新建
						</button>
						<button type="button" class="btn btn-default" title="删除">
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
						<th class="" style="padding-right: 0px"><input id="selall"
							type="checkbox" class="icheckbox_square-blue"></th>
						<th class="sorting_asc">ID</th>
						<th class="sorting">服务员编号</th>
						<th class="sorting">桌号</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><input type="checkbox"></td>
						<td>1</td>
						<td>小刘</td>
						<td>3</td>
						<td class="text-center">
							<button type="button" class="btn bg-olive btn-xs"
								data-toggle="modal" data-target="#editModal">修改</button>
						</td>
					</tr>
				</tbody>
			</table>
			<!--数据列表/-->


		</div>
		<!-- 数据表格 /-->




	</div>

	<!-- 厨师任务窗口 -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">服务员修改</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>服务员名称</td>
							<td><input class="form-control" placeholder="服务员名称">
							</td>
							<td>桌号</td>
							<td><input class="form-control" placeholder="桌号">
							</td>
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