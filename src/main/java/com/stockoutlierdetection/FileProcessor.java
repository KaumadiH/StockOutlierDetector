package main.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.model.DataPoint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Processes input files and extracts data points.
 */
public class FileProcessor {

    /**
     * Reads data points from a given file.
     *
     * @param file The file to process.
     * @return A list of DataPoint objects extracted from the file.
     * @throws IOException If an I/O error occurs during file reading.
     */
    public List<DataPoint> readData(File file) throws IOException {
        List<DataPoint> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while( (line = br.readLine()) != null) {
                try{
                    String[] fields = line.split(",");
                    String stockId = fields[0].trim();
                    String timestamp = fields[1].trim();
                    double price = Double.parseDouble(fields[2].trim());
                    data.add(new DataPoint(stockId, timestamp, price));
                } catch(Exception ex) {
                    System.err.println("Skipping invalid row: " + line);
                }
            }
        }
        return data;
    }
}
