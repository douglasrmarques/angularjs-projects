// App Routes
weatherApp.config(function ($routeProvider){
   $routeProvider
    .when('/_=_', {
        templateUrl: 'pages/home.htm',
        controller: 'homeController'
    })
    .when('/forecast', {
        templateUrl: 'pages/forecast.htm',
        controller: 'forecastController'
    })
    .when('/forecast/:daysToForecast', {
        templateUrl: 'pages/forecast.htm',
        controller: 'forecastController'
    })
    .when('/city', {
        templateUrl: 'pages/city.htm',
        controller: 'cityController'
    })
});