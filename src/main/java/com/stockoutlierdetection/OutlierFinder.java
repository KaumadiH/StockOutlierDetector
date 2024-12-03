package main.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Detects outliers in a dataset based on statistical thresholds.
 */
public class OutlierFinder {

    /**
     * Detects outliers from a sampled dataset.
     *
     * @param sample The sampled data points to analyze.
     * @return A list of Outlier objects representing the detected outliers.
     */
    public static List<Outliers> detectOutliers(List<DataPoint> sample){
        List<Outliers> outliers = new ArrayList<>();
        double mean = sample.stream().mapToDouble(DataPoint::getPrice).average().orElse(0);
        double stdDev = Math.sqrt(sample.stream()
                .mapToDouble(dp -> Math.pow(dp.getPrice() - mean, 2))
                .average()
                .orElse(0));

        double threshold = 2 * stdDev;

        for (DataPoint dp : sample) {
            if (Math.abs(dp.getPrice() - mean) > threshold) {
                outliers.add(Outliers.fromData(dp, mean, stdDev));
            }
        }
        return outliers;
    }
}
