package test.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.model.*;
import main.java.com.stockoutlierdetection.OutlierFinder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OutlierDetectorTest {

    @Test
    public void testDetectOutliers() {
        List<DataPoint> dataPoints = new ArrayList<>();
        dataPoints.add(new DataPoint("GSK", "12-12-2022", 100.0));
        dataPoints.add(new DataPoint("GSK", "13-12-2022", 102.0));
        dataPoints.add(new DataPoint("GSK", "14-12-2022", 98.0));
        // Add outliers
        dataPoints.add(new DataPoint("GSK", "15-12-2022", 200.0));

        OutlierFinder detector = new OutlierFinder();
        List<Outliers> outliers = detector.detectOutliers(dataPoints);

        assertNotNull(outliers);
        assertEquals(1, outliers.size());
        //assertEquals(200.0, outliers.get(0).getPrice(0));
    }

    @Test
    public void testDetectOutliers_noOutliers() {
        List<DataPoint> dataPoints = new ArrayList<>();
        dataPoints.add(new DataPoint("GSK", "12-12-2022", 100.0));
        dataPoints.add(new DataPoint("GSK", "13-12-2022", 102.0));
        dataPoints.add(new DataPoint("GSK", "14-12-2022", 98.0));

        OutlierFinder detector = new OutlierFinder();
        List<Outliers> outliers = detector.detectOutliers(dataPoints);

        assertNotNull(outliers);
        assertEquals(0, outliers.size());
    }
}
