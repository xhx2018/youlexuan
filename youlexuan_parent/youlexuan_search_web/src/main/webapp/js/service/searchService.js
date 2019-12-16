//search服务层
app.service('searchsService', function($http){

	this.search = function (searchMap) {
		return $http.post('itemsearch/search.do',searchMap);
	}

});