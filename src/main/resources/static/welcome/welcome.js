angular.module('market-front').controller('welcomeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/';

    $scope.tryToRegistration = function () {
        $http.post(contextPath + 'api/v1/users', $scope.newUser)
            .then(function successCallback(response) {
                alert('Registration success ' + response.data.username);
                $scope.newUser = null;
            }, function errorCallback(response) {
                alert('REGISTRATION FAILED');
            });
    }
});