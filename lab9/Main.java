import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static final String API_URL = "https://fakestoreapi.com/products";
    private static final String FILE_NAME = "products.xlsx";

    public static void main(String[] args) {
        try {
            // Отримання даних з API
            String apiData = fetchDataFromAPI(API_URL);

            // Збереження даних у файл Excel
            saveDataToExcel(apiData, FILE_NAME);
            System.out.println("Дані успішно збережено у файл " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fetchDataFromAPI(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
        } else {
            throw new IOException("Failed to fetch data from API. Response code: " + responseCode);
        }
    }

    private static void saveDataToExcel(String data, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");
        int rowNum = 0;

        // Запис даних у вигляді рядків
        String[] lines = data.split("\n");
        for (String line : lines) {
            Row row = sheet.createRow(rowNum++);
            String[] values = line.split(",");
            int cellNum = 0;
            for (String value : values) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(value);
            }
        }

        // Збереження файлу Excel
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
}
