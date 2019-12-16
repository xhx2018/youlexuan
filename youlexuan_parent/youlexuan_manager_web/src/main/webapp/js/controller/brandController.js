app.controller('brandController',function ($scope,$controller,brandService) {


    //继承
    $controller('baseController',{
        $scope:$scope
    });


    $scope.findPage=function(page,size){
        brandService.findPage(page,size).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    //保存
    $scope.save=function () {
        brandService.save($scope.entity).success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    //查询单个品牌
    $scope.findOne=function (id) {
        brandService.findOne(id).success(function (resp) {
            if (resp) {
                $scope.entity=resp;
            }
        })
    };


    // //删除
    // $scope.selectIds = [];//选中的ID数组
    //
    // $scope.updateSelection = function ($event,id) {
    //     if ($event.target.checked){
    //         //选中
    //         $scope.selectIds.push(id);
    //     }else {
    //         //移出
    //
    //         var idx = $scope.selectIds.indexOf(id);
    //
    //         //第一个参数：要删除元素的索引位置
    //         //第二个参数：删除的个数
    //         $scope.selectIds.splice(idx,1);
    //     }
    // };


    $scope.delete = function () {

        if ($scope.selectIds.length>0) {
            brandService.delete($scope.selectIds).success(function (resp) {
                if (resp.success){
                    $scope.reloadList();
                } else {
                    alert(resp.message);
                }
            })

        }else {
            alert("请选中要删除的记录");
        }
    }


    $scope.searchEntity = {};
    //查询
    $scope.search=function (page,size) {

        brandService.search(page,size,$scope.searchEntity).success(function (resp) {
            $scope.list=resp.rows;
            $scope.paginationConf.totalItems = resp.total;
        });
    }



});
