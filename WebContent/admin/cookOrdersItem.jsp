<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详细</title>
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
<body>
	<!-- .box-body -->
	<div class="box-header with-border">
		<h3 class="box-title">订单信息</h3>
	</div>

	<div class="box-body">

		<!-- 数据表格 -->
		<div class="table-box">

			<!--工具栏-->
			<div class="pull-left">
				<div class="form-group form-inline">
					<div class="btn-group">
						<a class="btn btn-default" href="cook.do">退出</a>
						<a class="btn btn-default" disabled="true">当前第${paging.page }页</a>
					</div>
				</div>
			</div>
			<div class="box-tools pull-right">
				<div class="has-feedback"></div>
			</div>
			<!--工具栏/-->

			<!--数据列表-->
			<table id="dataList"
				class="table table-bordered table-striped table-hover dataTable text-center">
				<thead>
					<tr>

						<!-- <th class="" style="padding-right: 0px"><input id="selall"
							type="checkbox" class="icheckbox_square-blue"></th> -->
						<th class="sorting_asc">订单编号</th>
						<th class="sorting">菜品名称</th>
						<th class="sorting">菜品数量</th>
						<th class="sorting">菜品状态</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cookOrderItems}" var="orderItems">
						<tr ng-repeat="entityn in list">
							<td>${orderItems.order_id}</td>
							<td>${orderItems.food_name}</td>
							<td>${orderItems.amount}</td>
							<td style="color:${orderItems.status==1?'black':'red'}">${orderItems.status==1?'等待制作':'制作中'}</td>
							<td>
							<a title="开始制作菜品，状态改为制作中"
								
								class="btn  bg-olive btn-m"
								href="startCookOrderItem.do?cookid=${cookid }&itemId=${orderItems.id }&page=${paging.page}"
								>开始制作</a> &nbsp; 
							<a title="菜品制作完成"
							
								type="button" class="btn  bg-olive btn-m"
								href="finishCookOrderItem.do?cookid=${cookid }&itemIdFin=${orderItems.id }&page=${paging.page}">
							        完成出菜</a>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			
<!-- 分页 -->
		<div style="position: absolute; bottom: 20px; left: 20px">
			<a class="btn  bg-olive btn-xs"href="cookOrderItems.do?page=1&id=${cookid }">&lt;&lt; 首页 </a> 
			<a class="btn  bg-olive btn-xs"href="cookOrderItems.do?page=${paging.page-1 }&id=${cookid }&totalPages=${paging.totalPages}">&lt; 上一页 </a>
			<form action="cookOrderItems.do?id=${cookid }&totalPages=${paging.totalPages}"
				method="post" style="display: inline-block">
				第<input  style="width: 30px; height: 18px; text-align:left;display: inline-block" type="text" name="page" value="${paging.page}">
				页/共[${paging.totalPages}]页
				<input class="btn  bg-olive btn-xs" type="submit" value="跳转">
			</form>
				
			<a class="btn  bg-olive btn-xs"href="cookOrderItems.do?page=${paging.page+1}&id=${cookid }&totalPages=${paging.totalPages}">下一页&gt;</a> 
			<a class="btn  bg-olive btn-xs"href="cookOrderItems.do?page=${paging.totalPages}&id=${cookid }">末页&gt;&gt;</a>
		</div>
			
</body>
</html>