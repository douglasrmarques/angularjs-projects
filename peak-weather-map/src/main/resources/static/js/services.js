// App Services
weatherApp.service('cityService', function(){
    //city property
    this.city = "Curitiba, PR";
});

// Weather service
weatherApp.service('weatherService' ['$resource', function($resource){
    this.getWeatherData = function(city, daysToForecast){
        var forecastAPI = $resource(
            "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=b335e840d1a17643a197a2c479ece6a6", 
            {callback: "JSON_CALLBACK"}, 
            {get: 
                {method: "JSONP"}
            }
        );

        // Getting data from service
        return forecastAPI.get({q: city, cnt: daysToForecast});  
    };
}]);