//content控制层 
app.controller('contentController' ,function($scope, $controller, contentService,contentCategoryService,uploadService){
	
	// 继承
	$controller("baseController", {
		$scope : $scope
	});
	
	// 保存
	$scope.save = function() {
		contentService.save($scope.entity).success(function(response) {
			if (response.success) {
				// 重新加载
				$scope.reloadList();
			} else {
				alert(response.message);
			}
		});
	}
	
	//查询实体 
	$scope.findOne = function(id){				
		contentService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//批量删除 
	$scope.dele = function(){			
		//获取选中的复选框			
		contentService.dele($scope.selectIds).success(
			function(response){
				if(response.success){
					$scope.reloadList();
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	// 定义搜索对象 
	$scope.searchEntity = {};
	// 搜索
	$scope.search = function(page,size){			
		contentService.search(page,size,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;
			}			
		);
	}
	
	
	//进入页面获取广告分类列表
	$scope.findContentCatList = function () {
		contentCategoryService.findAll().success(function (resp) {
			if (resp){
				$scope.contentCatList = resp;
			}
		})
	}

	//广告图片上传
	$scope.uploadFile = function () {
		uploadService.uploadFile().success(function (resp) {
			if (resp.success){//如果上传成功，取出url
				$scope.entity.pic= resp.message;//设置文件地址
			} else {
				alert(resp.message)
			}
		}).error(function () {
			alert("上传发生错误")
		})
	}


	//状态显示
	$scope.statusName = ['未启用','启用'];

});	
