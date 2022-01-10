# WeatherAPIFramework

## About our project?
- Our project is designed to test the efficiency of a Weather API
- The API's documentation can be found on : https://openweathermap.org/current





### User Stories




- As a user, given that i want to search for the weather of a particular city in a given country, when i search for a city and country then i am presented with the correct city and country name and data
- As a user, given that i want to search for the weather of a particular city, when i search for a city then i am presented with the correct city name and data
- As a user, given that i want to search for the weather of a particular longitude and latitude, when i search by them, then i am presented with the correct weather information for that location
- As a user, given that I input an invalid request in the URL, when i receive the response, then i want to be presented with the an appropriate error code, stating a 404 not found error
- As a user, given that i want to search for the weather of a particular zipcode, when i search for that zipcode then i am presented with the correct zip code data
- As a user, given that I input an invalid request in the longitude and latitude, when enter data that is out of range , then i want to be presented with the an appropriate error code, stating a 400 error as the the longitude / latitude combination does not exist




## How to run the project:
1. Pull the project
2. Go to https://openweathermap.org/price and create a free account
3. Generate an API key here https://home.openweathermap.org/api_keys
4. Inside the [resources](https://github.com/GVN07/WeatherAPIFramework/tree/dev/WeatherAPI/src/resources) folder, create a config.txt file and insert your API key
5. Now you can run the tests
