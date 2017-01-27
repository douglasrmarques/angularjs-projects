// App Routes
infobaseApp.config(function ($routeProvider){
   $routeProvider
    .when('/productDetail', {
        templateUrl: 'pages/product/productDetail.html',
        controller: 'productController'
    })
    .when('/home', {
        templateUrl: 'pages/home/home.html',
        controller: 'home'
    })
});