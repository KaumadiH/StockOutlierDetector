package main.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.model.DataPoint;

import java.util.List;
import java.util.Random;

/**
 * Provides functionality to randomly sample data points.
 */
public class DataSample {
    private final Random random = new Random();

    /**
     * Retrieves a random sample of data points.
     *
     * @param dataPoints       The list of data points to sample from.
     * @param sampleSize The number of consecutive points to include in the sample.
     * @return A sublist containing the sampled data points.
     * @throws IllegalArgumentException If the dataset size is smaller than the sample size.
     */
    public List<DataPoint> getRandomSample(List<DataPoint> dataPoints, int sampleSize) {
        if (dataPoints.size() < sampleSize) {
            throw new IllegalArgumentException("Not enough data points for sampling.");
        }
        int startIndex = random.nextInt(dataPoints.size() - sampleSize + 1);
        return dataPoints.subList(startIndex, startIndex + sampleSize);
    }
}
