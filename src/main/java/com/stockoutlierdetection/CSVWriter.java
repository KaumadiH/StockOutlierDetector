package main.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes outlier data to an output CSV file.
 */
public class CSVWriter {

    /**
     * Writes a list of outliers to a CSV file.
     *
     * @param outliers   The list of outliers to write.
     * @param output The output file where the data will be written.
     * @throws IOException If an I/O error occurs during file writing.
     */
    public static void writeOutliersToFile(List<Outliers> outliers, File output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            bw.write("Stock-ID,Timestamp,Actual Price,Mean,Deviation,% Deviation\n");
            for (Outliers outlier : outliers) {
                bw.write(outlier.toCSVRow() + "\n");
            }
        }
    }
}
