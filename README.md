# Stock Outlier Detection

This project is on implementing an outlier detection system in Java for stock market data. The application identifies 
the outliers in the stock price data by applying a statistical rule: finding stock prices that deviate more than 2 
standard deviations from the mean of a sampled dataset. It is meant to be used with data coming from a wide variety of 
global stock exchanges.

## Features
- Stock Data Sampling: Samples 30 consecutive data points from stock data files.
- Outlier Detection: Detects outliers based on the 2 standard deviation rule.
- CSV Output: Saves outliers to a CSV file for further analysis.
- Extensible: The project is designed to be extended with new functionality in the future, such as additional outlier 
detection strategies, enhanced reporting features, and optimizations.

## Requirements
Ensure that the following are installed, before you running this application.
- Java 11 or higher
- Maven 3.6 or higher
- IntelliJ IDEA or another IDE for Java development

## Setup

1. Clone the repository.
2. Make sure you have [Maven](https://maven.apache.org/) installed.
3. Open the project in IntelliJ IDEA or another Java IDE.
4. Configure the `config.properties` file at `src/main/resources/config.properties` to specify input and output paths.
5. Place your stock data files (in CSV format) in the input folder `(/resources/input/LSE/)`.

## Running the Application

1. To run the application, execute the `StockOutlierDetection` class in the `src/main/java` folder.
2. After running the application, the output will be saved in the directory specified by the output.path property 
(e.g., src/main/resources/output/).
3. Each output file will contain the following columns for each outlier detected:
   - Stock-ID: The stock ticker.
   - Timestamp: The timestamp when the outlier occurred.
   - Stock Price: The actual stock price at that timestamp.
   - Mean: The mean of the 30 sampled data points.
   - Deviation: The difference between the stock price and the mean.
   - % Deviation: The percentage deviation over and above the threshold.

## Unit Tests

Unit tests for various components like `DataSampler`, `OutlierDetector`, and `CSVWriter` are located in the 
`src/test/java` folder.
- ConfigManagerTest.java: Tests the loading and validation of configuration properties.
- FileProcessorTest.java: Tests reading and parsing CSV files.
- DataSamplerTest.java: Tests the sampling of data.
- OutlierDetectorTest.java: Tests the outlier detection logic.
- CSVWriterTest.java: Tests the writing of output to CSV files

### Future Enhancements
Some suggestions to improve the project:

1. Additional Functionality or Checks
   - Multiple Outlier Detection Algorithms: Implement additional statistical checks, such as the IQR 
   (Interquartile Range) method for outlier detection, or machine learning-based methods.
   - Time-based Anomaly Detection: Implement functionality to detect anomalies based on trends or patterns in stock 
   price movements over time.
2. Optimizations for Performance and Scalability
   - Asynchronous Processing: Use multithreading or asynchronous programming to process large datasets more efficiently,
   especially when dealing with large numbers of stock data files.
   - Efficient Data Sampling: Instead of reading entire files into memory, process the data in chunks, especially if the
   data files are large. This can improve both performance and memory usage.
   Distributed Processing: For massive datasets, consider integrating with distributed computing frameworks such as 
   Apache Spark to parallelize the sampling and outlier detection tasks.
3. Extensibility and Maintainability
   - Modularize the Codebase: Further modularize the classes by splitting up larger methods into smaller, reusable ones. 
   This improves readability and reusability.
   - Configuration Flexibility: Allow users to specify custom rules for outlier detection (e.g., the number of standard 
   deviations) via the configuration file.

### Time Spent
The task is estimated to completed within 2 hours. However, due to various challenges encountered during implementation and testing, additional time was spent ensuring correct handling of edge cases, input file validation, and enhancing the modularity of the code.

#### Tasks Completed:
- Data sampling functionality (extracting 30 consecutive data points).
- Outlier detection logic using 2 standard deviations rule.
- Reading and writing to CSV files.
- Basic unit tests for core components.