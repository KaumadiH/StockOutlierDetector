package test.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.DataSample;
import main.java.com.stockoutlierdetection.model.DataPoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataSamplerTest {

    @Test
    public void testGetRandomSample() {
        List<DataPoint> dataPoints = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataPoints.add(new DataPoint("GSK", "10-10-2022", 106.0 + i));
        }

        DataSample sampler = new DataSample();
        List<DataPoint> sample = sampler.getRandomSample(dataPoints, 30);

        assertNotNull(sample);
        assertEquals(30, sample.size());
    }

    @Test
    public void testGetRandomSample_notEnoughData() {
        List<DataPoint> dataPoints = new ArrayList<>();
        DataSample sampler = new DataSample();

        assertThrows(IllegalArgumentException.class, () -> {
            sampler.getRandomSample(dataPoints, 30);
        });
    }
}
