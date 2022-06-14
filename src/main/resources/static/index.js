angular.module('app', []).controller('listController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
        });
    };

    // $scope.addProduct = function () {
    //     $http.post(contextPath + '/products', $scope.newProduct)
    //         .then(function (response) {
    //             $scope.loadProducts();
    //             $scope.newProduct = null;
    //         })
    // }
    //
    // $scope.deleteProduct = function (productId) {
    //     $http.delete(contextPath + '/products/' + productId)
    //         .then(function (response) {
    //             $scope.loadProducts();
    //         });
    // }

    $scope.loadProducts();
});