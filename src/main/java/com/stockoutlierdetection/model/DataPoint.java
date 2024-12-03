package main.java.com.stockoutlierdetection.model;

/**
 * Represents a single data point in the stock price dataset.
 */
public class DataPoint {
    private final String stockId;
    private final String timestamp;
    private final double price;

    /**
     * Constructs a new DataPoint.
     *
     * @param stockId   The stock identifier (ticker symbol).
     * @param timestamp The timestamp of the data point in dd-mm-yyyy format.
     * @param price     The stock price at the given timestamp.
     */
    public DataPoint(String stockId, String timestamp, double price) {
        this.stockId = stockId;
        this.timestamp = timestamp;
        this.price = price;
    }

    /**
     * Returns the stock identifier.
     *
     * @return The stock ID.
     */
    public String getStockId() {
        return stockId;
    }

    /**
     * Returns the timestamp of the data point.
     *
     * @return The timestamp in dd-mm-yyyy format.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Returns the stock price.
     *
     * @return The stock price.
     */
    public double getPrice() {
        return price;
    }
}

