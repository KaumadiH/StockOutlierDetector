package test.java.com.stockoutlierdetection;

import main.java.com.stockoutlierdetection.ConfigManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigManagerTest {

    @Test
    public void testLoadConfig_validFile() throws IOException {
        ConfigManager config = ConfigManager.loadConfig("src/test/resources/config.properties");
        assertNotNull(config);
        assertEquals("src/test/resources/input/LSE", config.getInputFilesPath());
        assertEquals("src/test/resources/output", config.getOutputFilesPath());
        assertEquals(30, config.getSampleSize());
    }

    @Test
    public void testLoadConfig_invalidFile() {
        assertThrows(IOException.class, () -> {
            ConfigManager.loadConfig("src/test/resources/invalid-config.properties");
        });
    }
}
