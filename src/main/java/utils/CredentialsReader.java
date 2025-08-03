package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsReader {
    private static final String FILE_PATH = "credentials.properties"; // Jenkins will inject this

    public static String getEmail() {
        return getProperty("NAUKRI_EMAIL");
    }

    public static String getPassword() {
        return getProperty("NAUKRI_PASSWORD");
    }

    private static String getProperty(String key) {
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);
            props.load(fis);
            return props.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load credentials from file: " + FILE_PATH, e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // Optionally log this
                    System.err.println("Failed to close FileInputStream: " + e.getMessage());
                }
            }
        }
    }
}
