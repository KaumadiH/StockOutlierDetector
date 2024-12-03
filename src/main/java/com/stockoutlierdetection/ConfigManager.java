package main.java.com.stockoutlierdetection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigManager handles loading and providing access to application configuration.
 */
public class ConfigManager {
    private final String inputFilesPath;
    private final String outputFilesPath;
    private final int sampleSize;

    /**
     * Private constructor to initialize configuration values.
     */
    private ConfigManager(String inputFilesPath, String outputFilesPath, int sampleSize) {
        this.inputFilesPath = inputFilesPath;
        this.outputFilesPath = outputFilesPath;
        this.sampleSize = sampleSize;
    }

    /**
     * @param filePath Path to the configuration file.
     * @return ConfigManager instance.
     * @throws IOException if the file cannot be read.
     */
    public static ConfigManager loadConfig(String filePath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        }

        String inputPath = properties.getProperty("input.path");
        String outputPath = properties.getProperty("output.path");
        int sampleSize = Integer.parseInt(properties.getProperty("sample.size"));

        return new ConfigManager(inputPath, outputPath, sampleSize);
    }

    /**
     * @return Input files path.
     */
    public String getInputFilesPath() {
        return inputFilesPath;
    }

    /**
     * @return Output files path.
     */
    public String getOutputFilesPath() {
        return outputFilesPath;
    }

    /**
     * @return Sample size for processing.
     */
    public int getSampleSize() {
        return sampleSize;
    }
}

