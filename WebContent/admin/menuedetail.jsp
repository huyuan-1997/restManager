<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>菜品管理</title>
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
	app.controller('menuedetailController', function($scope, $http) {//function()里面的参数就是服务
		
		$scope.foodName="";
		//重新加载列表 数据
		$scope.reloadList = function() {
			//切换页码  
			$scope.findPage($scope.paginationConf.currentPage,
					$scope.paginationConf.itemsPerPage,$scope.foodName);
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
		$scope.findPage = function(page, rows,foodName) {
			$http.get('menuedetail/findPage.do?page=' + page + '&rows=' + rows+'&foodName='+foodName)
					.success(function(response) {
						$scope.list = response.rows;
						$scope.paginationConf.totalItems = response.total;//更新总记录数
					});
		}
		//增加一个菜品
		$scope.add = function() {
			$http.post('menuedetail/add.do', $scope.entity).success(
					function(response) {
						if (response.success) {
							//重新查询 
							$scope.reloadList();//重新加载
						} else {
							alert(response.message);
						}
					});
		}
		//修改一个菜品
		$scope.update = function() {
			$http.post('menuedetail/update.do', $scope.entity1).success(
					function(response) {
						if (response.success) {
							//重新查询 
							$scope.reloadList();//重新加载
						} else {
							alert(response.message);
						}
					});
		}
		//查询一个菜品
		$scope.entity1 = {};
		$scope.findOne = function(id) {
			$http.get('menuedetail/findOne.do?id=' + id).success(
					function(response) {
						$scope.entity1 = response;
					});
		}
		//图片上传
		$scope.entity = {};
		
		$scope.uploadFile = function() {
			var formData=new FormData();
		    formData.append("file",file.files[0]); 
			$http({
				method : 'POST',
				url : "upload.do",
				data : formData,
				headers : {
					'Content-Type' : undefined
				},
				transformRequest : angular.identity
			}).success(function(response) {
				if (response.success) {//如果上传成功，取出url
					$scope.entity.foodUrl = response.message;//设置文件地址
				} else {
					alert(response.message);
				}
			}).error(function() {
				alert("上传发生错误");
			});
		};
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
			$http.get('menuedetail/delete.do?ids=' + $scope.selectIds);
			$scope.reloadList();//重新加载
		}

		//菜品分类列表
		$scope.categoryList = {
			data : []
		};

		//查找菜品分类
		$scope.findCategory = function() {
			$http.get('category/findAll.do').success(function(response) {
				$scope.categoryList = {
					data : response
				};
			});
		};
		
		//赋值操作
		$scope.setValue=function(){
			$scope.entity.categoryId="";
			$scope.entity.categoryId=$scope.categoryID.id;
			
			
		}
		//赋值操作1
		$scope.setValue1=function(){
			$scope.entity1.categoryId="";
			$scope.entity1.categoryId=$scope.categoryID1.id;
		}
		//查找食品分类
		$scope.category={};
		$scope.findcategoryName = function(categoryId) {
			$http.get('menuedetail/findcategoryName.do?categoryId='+categoryId).success(function(response) {
				$scope.category = response;
			});
		};
		
	});
</script>
<script type="text/javascript" src="js/angular-select2.js"></script>
</head>

<body class="hold-transition skin-red sidebar-mini" ng-app="rsm"
	ng-controller="menuedetailController" ng-init="findCategory()">
	<!-- .box-body -->

	<div class="box-header with-border">
		<h3 class="box-title">菜品分类管理</h3>
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
				<div class="has-feedback">
					菜品名称：<input ng-model="foodName">
					<button ng-click="reloadList()" class="btn btn-default">查询</button>
				</div>
			</div>
			<!--工具栏/-->

			<!--数据列表-->
			<table id="dataList"
				class="table table-bordered table-striped table-hover dataTable">
				<thead>
					<tr>
						<th class="" style="padding-right: 0px"></th>
						<th class="sorting_asc">菜品ID</th>
						<th class="sorting">菜品名称</th>
						<th class="sorting">菜品价格</th>
						<th class="sorting">分类ID</th>
						<th class="sorting">菜品图片</th>
						<th class="sorting">排序级别</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="entity in list">
						<td><input type="checkbox"
							ng-click="updateSelection($event,entity.foodId)"></td>
						<td>{{entity.foodId}}</td>
						<td>{{entity.foodName}}</td>
						<td>{{entity.foodPrice}}</td>
						<td>{{entity.categoryId}}
						<button type="button" class="btn  btn-xs"
								data-toggle="modal" ng-click="findcategoryName(entity.categoryId)"
								data-target="#editModal2">查看</button>
						</td>
						<td><img src="{{entity.foodUrl}}" width="50px" height="30px"></td>
						<td>{{entity.foodSort}}</td>
						<td class="text-center">
							<button type="button" class="btn bg-olive btn-xs"
								ng-click="findOne(entity.foodId)" data-toggle="modal"
								data-target="#editModal1">修改</button>
						</td>
					</tr>
				</tbody>
			</table>
			<!--数据列表/-->
			<tm-pagination conf="paginationConf"></tm-pagination>
		</div>
		<!-- 数据表格 /-->
	</div>
	<!-- /.box-body -->
	<!-- 分页 -->


	<!-- 添加窗口 -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">菜品添加</h3>
				</div>
				<div class="modal-body">

					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>菜品名称</td>
							<td><input class="form-control" ng-model="entity.foodName"
								placeholder="菜品名称"></td>
						</tr>
						<tr>
							<td>菜品价格</td>
							<td><input class="form-control" ng-model="entity.foodPrice"
								placeholder="菜品价格"></td>
						</tr>
						<tr>
							<td>分类名称</td>
							<td><input select2 select2-model="categoryID" ng-click="setValue()"
								config="categoryList" placeholder=" 分类名称" class="form-control"></td>
						</tr>
						
						<tr>
							<td>排序级别</td>
							<td><input class="form-control" ng-model="entity.foodSort"
								placeholder="排序级别"></td>
						</tr>
						<tr>
							<td>商品图片</td>
							<td>
								<table>
									<tr>
										<!-- ng-model="foodUrl" -->
										<td><input type="file" id="file" />
											<button class="btn btn-primary" ng-click="uploadFile()"
												type="button">上传</button></td>
										<td><img src="{{entity.foodUrl}}" width="180px"
											height="200px"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						aria-hidden="true" ng-click="add()">保存</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 修改窗口 -->
	<div class="modal fade" id="editModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">菜品修改</h3>
				</div>
				<div class="modal-body">

					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>菜品名称</td>
							<td><input class="form-control" ng-model="entity1.foodName"
								placeholder="菜品名称"></td>
						</tr>
						<tr>
							<td>菜品价格</td>
							<td><input class="form-control" ng-model="entity1.foodPrice"
								placeholder="菜品价格"></td>
						</tr>
						<tr>
							<td>分类名称</td>
							<td><input select2 select2-model="categoryID1" ng-click="setValue1()"
								config="categoryList" placeholder="分类名称" class="form-control"></td>
						</tr>
						<tr>
							<td>排序级别</td>
							<td><input class="form-control" ng-model="entity1.foodSort"
								placeholder="排序级别"></td>
						</tr>
						<tr>
							<td>商品图片</td>
							<td>
								<table>
									<tr>
										<td><img src="{{entity1.foodUrl}}" width="180px"
											height="100px"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td><input type="hidden" class="form-control"
								ng-model="entity1.foodId"></td>
						</tr>
					</table>

				</div>
				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal"
						aria-hidden="true" ng-click="update()">保存</button>
					<button class="btn btn-default" data-dismiss="modal"
						aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 查看分类Name -->
	<div class="modal fade" id="editModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">查看菜品分类</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped" width="800px">
						<tr>
							<td>分类名称</td>
							<td>
								<input class="form-control" ng-model="category.categoryName"
								placeholder="分类名称" disabled="disabled"> 
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