package com.automationproj.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Config file not found at src/main/resources/config.properties");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
