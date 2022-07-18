angular.module('market-front').controller('cartController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8189/app/';

    $scope.loadCart = function () {
        $http.get(contextPath + 'api/v1/carts')
            .then(function (response) {
                $scope.cart = response.data
            });
    }

    $scope.clearCart = function () {
        $http.get(contextPath + 'api/v1/carts/clear')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.checkOut = function () {
        $http({
            url: contextPath + 'api/v1/orders',
            method: 'POST',
            data: $scope.orderDetails
        }).then(function (response) {
            $scope.loadCart();
            $scope.orderDetails = null
        });
    };

    $scope.disabledCheckOut = function () {
        alert("You must be logged in to place an order");
    }

    $scope.loadCart();
});