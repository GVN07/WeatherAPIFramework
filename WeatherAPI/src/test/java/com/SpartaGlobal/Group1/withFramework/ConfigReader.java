package com.SpartaGlobal.Group1.withFramework;

import java.io.*;

public class ConfigReader {
    public static String getConfigKey() {
        try (BufferedReader in = new BufferedReader(new FileReader("src/resources/config.txt"))) {
            String key = in.readLine().trim();
            return key;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
