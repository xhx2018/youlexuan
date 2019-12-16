//cart服务层
app.service('cartService', function($http){

	this.findCartList = function () {
		return $http.get('cart/findCartList.do');
	}

	this.changeNum = function (skuId,num) {
		return $http.get('cart/addGoodsToCartList.do?skuId='+skuId+'&num='+num);
	}

});