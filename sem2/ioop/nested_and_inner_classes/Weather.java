/*Design a Weather class with a static nested class Forecast. The Forecast class should predict weather conditions (Sunny, Rainy, Cloudy) based on input data like temperature and humidity. Use the nested class to predict and display the weather forecast for different cities.*/

class Weather {
    static class Forecast {
        static String predict(double temperature, double humidity) {
            if(temperature > 30 && humidity > 70) {
                return "Rainy";
            } else if(temperature > 25) {
                return "Sunny";
            } else {
                return "Cloudy";
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("City: Mumbai");
        System.out.println("Temperature: 32°C, Humidity: 80%");
        System.out.println("Forecast: " + Forecast.predict(32, 80));
        
        System.out.println("\nCity: Delhi");
        System.out.println("Temperature: 28°C, Humidity: 50%");
        System.out.println("Forecast: " + Forecast.predict(28, 50));
        
        System.out.println("\nCity: Bangalore");
        System.out.println("Temperature: 22°C, Humidity: 60%");
        System.out.println("Forecast: " + Forecast.predict(22, 60));
    }
}
