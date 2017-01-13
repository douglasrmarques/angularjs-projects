weatherApp.controller("home", function($http) {
    var self = this;
    $http.get("/user").success(function(data) {
      self.user = data.userAuthentication.details.name;
      self.authenticated = true;
    }).error(function() {
      self.user = "N/A";
      self.authenticated = false;
    });

    self.logout = function(){
        $http.post('/logout', {}).success(function() {
        self.authenticated = false;
        $location.path("/");
      }).error(function(data) {
        console.log("Logout failed")
        self.authenticated = false;
      });
    };
});

//City Controller
weatherApp.controller('cityController', ['$scope', '$http', '$location', '$resource', '$routeParams', 'cityService', function($scope, $http, $location, $resource, $routeParams, cityService){
    var self = this;
    $scope.city = cityService.city;

    $scope.getForecast = function(cityName){
        cityService.city = cityName;
        $location.path('/forecast');
    };

    $scope.removeCity = function(cityName){
        $http.post('/city/delete', cityName).success(function(data){
            $scope.cityList = data;
        }).error(function(data){
            $scope.isCityAdded = false;
            console.log("Service DELETE /city failed");
        });
    };

    $scope.addCity = function(){
        $http.post('/city', $scope.city).success(function(data){
            $scope.addCityMessage = "City Added!!";
            $scope.isCityAdded = true;
            $scope.cityList = data;

        }).error(function(data){
            $scope.isCityAdded = false;
            console.log("Service POST /city failed");
        });
    };

    $http.get('/city').success(function(data){
        $scope.cityList = data;
    }).error(function(data){
        console.log("Service GET /city failed");
    });

}]);

//Home Controller
weatherApp.controller('homeController', ['$scope', '$http', '$location', 'cityService', function($scope, $http, $location, cityService){
    $scope.city = cityService.city;
    $scope.submit = function(){
        $location.path("/forecast");
    };
    
    //watching the city value -- Doing interpolation
    $scope.$watch('city', function(){
       cityService.city = $scope.city; 
    });
    
}]);

//Forecast Controller
weatherApp.controller('forecastController', ['$scope', '$resource', '$routeParams', 'cityService', function($scope, $resource, $routeParams, cityService){
    // Open Weather MAP key
    this.apiKey = "b335e840d1a17643a197a2c479ece6a6"
    
    $scope.city = cityService.city;
    $scope.daysToForecast = $routeParams.daysToForecast || 1;
    
    // {callback} and {get} should be defined in order to set up security config
    $scope.forecastAPI = $resource(
        "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=" + this.apiKey, 
        {callback: "JSON_CALLBACK"}, 
        {get: 
            {method: "JSONP"}
        }
    );
    
    // Getting data from service
    $scope.forecastResult = $scope.forecastAPI.get({q: $scope.city, cnt: $scope.daysToForecast});
    
    console.log($scope.forecastResult);
    
    // The temperature must be convert from Kelvin to Celsius
    $scope.convertToFahrenheit = function(unitKelvin){
        return Math.round(unitKelvin - 273.15);
    };
    
    $scope.convertToDate = function(dateObj) {
        return new Date(dateObj * 1000);
    };
    
    console.log($scope.forecastResult);
}]);