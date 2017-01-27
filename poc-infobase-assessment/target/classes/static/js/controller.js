// Application's controllers

infobaseApp.controller("productController", ['$scope', '$http', '$window', '$location', '$routeParams', 'productService', function($scope, $http, $window, $location, $routeParams, productService){
    $scope.listItems = productService.defaultProductList;
    $scope.isDisplayProductView = productService.isDisplayProductView;

    $scope.backHome = function(){
        $scope.isDisplayProductView = true;
        $location.path('/');
    }
}]);

infobaseApp.controller("home", ['$scope', '$http', '$window', '$location', '$routeParams', 'productService', function($scope, $http, $window, $location, $routeParams, productService){
    $scope.isDisplayProductView = productService.isDisplayProductView;

    $scope.isDisplayAuditInput = false;
    $scope.isMessageSuccess = false;
    $scope.isMessageFailure = false;

    $scope.message = "";
    $scope.userName = "";

    this.defaultProductList = [{
      productName: "Product Test Version 2.0X (2017)",
      title: "Product Test Title",
      description: "This is some description about the product you are going to buy!",
      price: 10.99,
      imgUrl: "images/prod01.png"
    },];

    $scope.sendAuditMessage = function(){
        $scope.auditMessage = {
            message: $scope.message,
            isConfirmed: false,
            userName: $scope.userName
        };

        $http.post('/audit/sendMessage', $scope.auditMessage)
            .success(function(data){
                $scope.isMessageSuccess = true;
            })
            .error(function(data){
                $scope.isMessageFailure = true;
            }
        );
    };

    $scope.listItems = productService.defaultProductList;
    $scope.droppedObjects = [];

    $scope.onDragComplete = function(data, evt) {
      var index = $scope.droppedObjects.indexOf(data);
      if (index > -1) {
        $scope.droppedObjects.splice(index, 1);
      }
    }

    $scope.onDropAuditMessage = function(data, evt) {
      $scope.isDisplayAuditInput = true;
      var index = $scope.droppedObjects.indexOf(data);
      if (index == -1){
        $scope.droppedObjects.push(data);
      }
    }

    $scope.onDropComplete = function(data, evt) {
      console.log("drop success, data:", data);
      var index = $scope.droppedObjects.indexOf(data);
      if (index == -1){
        $scope.droppedObjects.push(data);
      }

      $scope.isDisplayProductView = false;
      $scope.isDisplayAuditInput = false;

      $location.path('/productDetail')
    }
}]);

infobaseApp.controller("main", ['$scope', '$http', '$window', '$location', '$routeParams', 'productService', 'ngDraggable', function($scope, $http, $window, $location, $routeParams, productService, ngDraggable){
    $scope.isDisplayProductView = productService.isDisplayProductView;
    $scope.adMessage = "Welcome to Our Page";

    $scope.isDisplayAuditInput = false;
    $scope.isMessageSuccess = false;
    $scope.isMessageFailure = false;

    $http.get('/ad/getAdDefaultPartner')
        .then(function(response){
            console.log(response);
            $http.get(response.data.url)
                .success(function(data){
                    $scope.adMessage = data;
                })
                .error(function(data){
                    console.log("Service " + response.data.url + " Failed");
                }
            );
            $location.path('/home');
        }
    );
}]);