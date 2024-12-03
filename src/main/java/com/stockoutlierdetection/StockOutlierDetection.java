package main.java.com.stockoutlierdetection;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.stockoutlierdetection.DataSample;
import main.java.com.stockoutlierdetection.model.*;

/**
 * Entry point for detecting stock price outliers from input files.
 */
public class StockOutlierDetection {
    private static final Logger logger = Logger.getLogger(StockOutlierDetection.class.getName());

    public static void main(String[] args) {
        try {
            // Read Configurations
            ConfigManager config = ConfigManager.loadConfig("src/main/resources/config.properties");
            File inputFiles = new File(config.getInputFilesPath());
            File outputFiles = new File(config.getOutputFilesPath());
            int sampleSize = config.getSampleSize();

            //Validate folders
            validateFolders(inputFiles, outputFiles);

            //Initialize components
            FileProcessor fileProcessor = new FileProcessor();
            DataSample dataSample = new DataSample();
            OutlierFinder outlierFinder = new OutlierFinder();
            CSVWriter csvWriter = new CSVWriter();

            // Process files
            for (File file : inputFiles.listFiles((dir, name) -> name.endsWith(".csv"))) {
                try {
                    logger.info("Processing file: " + file.getName());
                    List<DataPoint> dataPoints = fileProcessor.readData(file);

                    if (dataPoints.size() < sampleSize) {
                        logger.warning("Skipping file as there is no data: " + file.getName());
                        continue;
                    }

                    List<DataPoint> sample = dataSample.getRandomSample(dataPoints, sampleSize);
                    List<Outliers> outliers = outlierFinder.detectOutliers(sample);
                    File outputFile = new File(outputFiles, file.getName().replace(".csv",
                            "_outliers.csv"));
                    csvWriter.writeOutliersToFile(outliers, outputFile);

                    logger.info("File processed successfully: " + file.getName());
                } catch (Exception ex) {
                    logger.log(Level.SEVERE, "Error processing file: " + file.getName(), ex);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error", e);
        }
    }

    private static void validateFolders(File inputFiles, File outputFiles) throws IOException {
        if (!inputFiles.exists() || !inputFiles.isDirectory()) {
            throw new IOException("Input files are not found: " + inputFiles.getAbsolutePath());
        }
        if (!outputFiles.exists()) {
            if (!outputFiles.mkdirs()) {
                throw new IOException("Failed to create output files: " + outputFiles.getAbsolutePath());
            }
        }
    }
}