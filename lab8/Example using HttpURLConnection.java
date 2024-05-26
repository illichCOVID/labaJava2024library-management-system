// Виконання HTTP-запиту та отримання даних
// Example using HttpURLConnection
URL url = new URL("https://api.weather.com/data");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");

int responseCode = connection.getResponseCode();
if (responseCode == HttpURLConnection.HTTP_OK) {
    // Reading response data
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
        response.append(line);
    }
    reader.close();
    
    // Process the response data
    // Convert JSON response to Java objects, etc.
} else {
    // Handle HTTP error
}
connection.disconnect();
