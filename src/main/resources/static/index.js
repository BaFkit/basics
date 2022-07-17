angular.module('app', ['ngStorage']).controller('listController', function ($scope, $rootScope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    if ($localStorage.springWebUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
    }

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

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:8189/app/api/v1/carts/add/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:8189/app/api/v1/carts')
            .then(function (response) {
                $scope.Cart = response.data
            });
    }

    $scope.clearCart = function () {
        $http.get('http://localhost:8189/app/api/v1/carts/clear')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.loadOrders = function () {
        $http.get('http://localhost:8189/app/api/v1/orders')
            .then(function (response) {
                $scope.MyOrders = response.data
            });
    }

    $scope.tryToAuth = function () {
        $http.post('http://localhost:8189/app/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.tryToRegistration = function () {
        $http.post('http://localhost:8189/app/api/v1/users', $scope.newUser)
            .then(function successCallback(response) {
                alert('Registration success ' + response.data.username);
                $scope.newUser = null;
            }, function errorCallback(response) {
                alert('REGISTRATION FAILED');
            });
    }

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.showCurrentUserInfo = function () {
        $http.get('http://localhost:8189/app/api/v1/profile')
            .then(function successCallback(response) {
                alert('MY NAME IS: ' + response.data.username);
            }, function errorCallback(response) {
                alert('UNAUTHORIZED');
            });
    }

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
    $scope.loadCart();
    $scope.loadOrders();
});