package com.awa.framework.utilities;
import com.awa.framework.exceptions.FrameworkException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream stream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (stream == null) {
                throw new FrameworkException("config.properties not found on classpath");
            }
            PROPERTIES.load(stream);
        } catch (IOException e) {
            throw new FrameworkException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null) {
            throw new FrameworkException("Missing config key: " + key);
        }
        return value;
    }
}
