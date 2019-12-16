//login服务层
app.service('loginService', function($http){
    // 保存
    this.getName = function() {
        return $http.post('../user/getName');
    }

    this.sendCode = function (phone) {
        return $http.get('../user/sendCode?phone='+phone);
    }

});