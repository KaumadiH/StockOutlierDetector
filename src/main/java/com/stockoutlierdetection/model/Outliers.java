package main.java.com.stockoutlierdetection.model;

/**
 * Represents an outliers in the stock price dataset.
 */
public class Outliers {
    private final String stockId;
    private final String timestamp;
    private final double price;
    private final double mean;
    private final double deviation;
    private final double percentageDeviation;

    /**
     * Constructs new Outliers.
     *
     * @param stockId             The stock identifier (ticker symbol).
     * @param timestamp           The timestamp of the outlier.
     * @param price               The stock price at the given timestamp.
     * @param mean                The mean of the sampled data points.
     * @param deviation           The deviation of the stock price from the mean.
     * @param percentageDeviation The percentage deviation over the threshold.
     */
    public Outliers(String stockId, String timestamp, double price, double mean, double deviation,
                    double percentageDeviation) {
        this.stockId = stockId;
        this.timestamp = timestamp;
        this.price = price;
        this.mean = mean;
        this.deviation = deviation;
        this.percentageDeviation = percentageDeviation;
    }

    /**
     * Creates an Outlier object from a DataPoint and statistical values.
     *
     * @param dp     The data point to evaluate.
     * @param mean   The mean of the sampled data points.
     * @param stdDev The standard deviation of the sampled data points.
     * @return A new Outlier instance.
     */
    public static Outliers fromData(DataPoint dp, double mean, double stdDev) {
        double deviation = dp.getPrice() - mean;
        double percentageDeviation = (deviation / (2 * stdDev)) * 100;
        return new Outliers(dp.getStockId(), dp.getTimestamp(), dp.getPrice(), mean, deviation, percentageDeviation);
    }

    /**
     * Converts the Outlier object into a CSV row format.
     *
     * @return A string representing the outlier in CSV row format.
     */
    public String toCSVRow() {
        return String.join(",", stockId, timestamp, String.valueOf(price), String.valueOf(mean),
                String.valueOf(deviation), String.format("%.2f%%", percentageDeviation));
    }
}

