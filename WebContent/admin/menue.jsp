<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>菜单分类管理</title>
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
</script>
<link rel="stylesheet" href="plugins/select2/select2.css" />
<link rel="stylesheet" href="plugins/select2/select2-bootstrap.css" />
<script src="plugins/select2/select2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="plugins/angularjs/angular.min.js"></script>
<!-- 分页组件开始 -->
<script src="plugins/angularjs/pagination.js"></script>
<link rel="stylesheet" href="plugins/angularjs/pagination.css">
<!-- 分页组件结束 -->

<script>
	var app = angular.module('rsm', [ 'pagination' ]);//定义模块	
	//使用模块定义controller
	app.controller('categoryController', function($scope, $http) {//function()里面的参数就是服务

		//重新加载列表 数据
		$scope.reloadList = function() {
			//切换页码  
			$scope.findPage($scope.paginationConf.currentPage,
					$scope.paginationConf.itemsPerPage);
		};
		//分页控件配置 
		$scope.paginationConf = {
			currentPage : 1,
			totalItems : 10,
			itemsPerPage : 10,
			perPageOptions : [ 2, 4, 6, 8, 10 ],
			onChange : function() {
				$scope.reloadList();//重新加载
			}
		};
		//分页
		$scope.findPage = function(page, rows) {
			$http.get('category/findPage.do?page=' + page + '&rows=' + rows)
					.success(function(response) {
						$scope.list = response.rows;
						$scope.paginationConf.totalItems = response.total;//更新总记录数
					});
		}
		//增加一个菜品分类
		$scope.add = function() {
			$http.post('category/add.do', $scope.entity).success(
					function(response) {
						if (response.success) {
							//重新查询 
							$scope.reloadList();//重新加载
						} else {
							alert(response.message);
						}
					});
		}
		//修改一个菜品分类
		$scope.update = function() {
			$http.post('category/update.do', $scope.entity1).success(
					function(response) {
						if (response.success) {
							//重新查询 
							$scope.reloadList();//重新加载
						} else {
							alert(response.message);
						}
					});
		}
		//查询一个菜品分类
		$scope.findOne = function(id) {
			$http.get('category/findOne.do?id=' + id).success(
					function(response) {
						$scope.entity1 = response;
					});
		}
		//选中的ID集合 
		$scope.selectIds = [];
		//更新复选
		$scope.updateSelection = function($event, id) {
			if ($event.target.checked) {//如果是被选中,则增加到数组//源事件，用来获得checked属性
				$scope.selectIds.push(id);
			} else {
				var idx = $scope.selectIds.indexOf(id);
				$scope.selectIds.splice(idx, 1);//删除 
			}
		}

		//批量删除 
		$scope.dele = function() {
			//获取选中的复选框			
			$http.get('category/delete.do?ids=' + $scope.selectIds);
			$scope.reloadList();//重新加载
		}

		//菜品厨师列表
		$scope.cookList = {
			data : []
		};

		//查找厨师分类
		$scope.findAllCook = function() {
			$http.get('category/findAllCook.do').success(function(response) {
				$scope.cookList = {
					data : response
				};
			});
		};
		//赋值操作
		$scope.setValue = function() {
			$scope.entity.cookId = "";
			$scope.entity.cookId = $scope.cookID.id;
			//alert($scope.entity.cookId);
		}
		//赋值操作1
		$scope.setValue1 = function() {
			$scope.entity1.cookId = "";
			$scope.entity1.cookId = $scope.cookID1.id;
			//alert($scope.entity.cookId);
		}
		
		//查找一个厨师
		//查找厨师分类
		$scope.cook={};
		$scope.findCook = function(cookId) {
			$http.get('category/findCook.do?cookId='+cookId).success(function(response) {
				$scope.cook = response;
			});
		};

	});
</script>
<script type="text/javascript" src="js/angular-select2.js"></script>
</head>
<body class="hold-transition skin-red sidebar-mini" ng-app="rsm"
	ng-controller="categoryController" ng-init="findAllCook()">
	<!-- .box-body -->
	<div class="box-header with-border">
		<h3 class="box-title">菜单分类管理</h3>
	</div>

	<div class="box-body">

		<!-- 数据表格 -->
		<div class="table-box">

			<!--工具栏-->
			<div class="pull-left">
				<div class="form-group form-inline">
					<div class="btn-group">
						<button type="button" class="btn btn-default" title="新建"
							ng-click="entity={}" data-toggle="modal" data-target="#editModal">
							<i class="fa fa-file-o"></i> 新建
						</button>
						<button type="button" class="btn btn-default" ng-click="dele()"
							title="删除">
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
						<th class="" style="padding-right: 0px"></th>
						<th class="sorting_asc">分类ID</th>
						<th class="sorting">分类名称</th>
						<th class="sorting">厨师ID</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>

					<tr ng-repeat="entity in list">
						<td><input ng-click="updateSelection($event,entity.id)"
							type="checkbox"></td>
						<td>{{entity.id}}</td>
						<td>{{entity.categoryName}}</td>
						<td>{{entity.cookId}}
							<button type="button" class="btn  btn-xs"
								data-toggle="modal" ng-click="findCook(entity.cookId)"
								data-target="#editModal2">查看</button>
						</td>
						<td class="text-center">
							<button type="button" class="btn bg-olive btn-xs"
								data-toggle="modal" ng-click="findOne(entity.id)"
								data-target="#editModal1">修改</button>
						</td>
					</tr>
				</tbody>
			</table>
			<!--数据列表/-->
			<!-- 分页 -->
			<tm-pagination conf="paginationConf"></tm-pagination>


		</div>
		<!-- 数据表格 /-->




	</div>
	<!-- /.box-body -->
	<!-- 菜单分类增加窗口 -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">增加分类</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>分类名称</td>
							<td><input class="form-control"
								ng-model="entity.categoryName" placeholder="分类名称"></td>
							<td>主厨名称</td>
							<td>
								<!-- <input class="form-control" ng-model="entity.cookId"
								placeholder="主厨ID"> --> <input select2 select2-model="cookID"
								ng-click="setValue()" config="cookList" placeholder="厨师名称"
								class="form-control">
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						ng-click="add()" aria-hidden="true">完成</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 菜单分类修改窗口 -->
	<div class="modal fade" id="editModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">修改分类</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>分类名称</td>
							<td><input class="form-control"
								ng-model="entity1.categoryName" placeholder="分类名称"></td>
							<td>主厨名称</td>
							<td>
								<!-- <input class="form-control" ng-model="entity1.cookId"
								placeholder="主厨ID"> --> <input select2 select2-model="cookID1"
								ng-click="setValue1()" config="cookList" placeholder="厨师名称"
								class="form-control">
							</td>
							<td><input type="hidden" class="form-control"
								ng-model="entity1.id"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						ng-click="update()" aria-hidden="true">完成</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 查看厨师 -->
	<div class="modal fade" id="editModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">查看厨师</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>主厨名称</td>
							<td>
								<input class="form-control" ng-model="cook.cook_name"
								placeholder="主厨名称" disabled="disabled"> 
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						ng-click="update()" aria-hidden="true">完成</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>