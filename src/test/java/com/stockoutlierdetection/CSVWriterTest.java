package test.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.CSVWriter;
import main.java.com.stockoutlierdetection.model.Outliers;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVWriterTest {

    @Test
    public void testWriteOutliersToFile() {
        List<Outliers> outliers = new ArrayList<>();
        outliers.add(new Outliers("GSK", "15-12-2022", 200.0, 100.0, 100.0, 100.0));

        CSVWriter writer = new CSVWriter();
        File outputFile = new File("src/test/resources/output/outliers.csv");
        try {
            writer.writeOutliersToFile(outliers, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertTrue(outputFile.exists());
    }
}
