angular.module('market-front').controller('cartController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/cart/';

    $scope.loadCart = function () {
        $http.get(contextPath + 'api/v1/cart/' + $localStorage.springWebGuestCartId)
            .then(function (response) {
                $scope.cart = response.data
            });
    }

    $scope.clearCart = function () {
        $http.get(contextPath + 'api/v1/cart/' + $localStorage.springWebGuestCartId + '/clear')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.checkOut = function () {
        $http({
            url: 'http://localhost:5555/core/api/v1/orders',
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