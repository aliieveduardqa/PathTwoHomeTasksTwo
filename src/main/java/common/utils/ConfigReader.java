package common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(file);
            logger.info("Configuration properties loaded successfully.");
        } catch (IOException e) {
            logger.error("Could not read config.properties file", e);
            throw new RuntimeException("Could not read config.properties file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}