//content服务层
app.service('contentService', function($http){

	this.findByCategoryId = function (catId) {
		return $http.get('../content/findByCategoryId.do?catId='+catId);
	}


});