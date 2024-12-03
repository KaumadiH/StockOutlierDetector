package test.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.FileProcessor;
import main.java.com.stockoutlierdetection.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    @Test
    public void testReadDataPoints_validFile() throws IOException {
        File file = new File("src/test/resources/input/LSE/GSK.csv");
        FileProcessor fileProcessor = new FileProcessor();
        List<DataPoint> dataPoints = fileProcessor.readData(file);

        assertNotNull(dataPoints);
        assertFalse(dataPoints.isEmpty());
        assertEquals("GSK", dataPoints.get(0).getStockId());
        assertEquals("02-09-2023", dataPoints.get(0).getTimestamp());
        assertEquals(1595.27, dataPoints.get(0).getPrice());
    }

    @Test
    public void testReadDataPoints_invalidFile() {
        File file = new File("src/test/resources/input/LSE/invalid_file.csv");
        FileProcessor fileProcessor = new FileProcessor();

        assertThrows(IOException.class, () -> {
            fileProcessor.readData(file);
        });
    }
}
