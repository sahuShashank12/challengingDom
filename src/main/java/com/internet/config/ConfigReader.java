package com.internet.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.Properties;

public class ConfigReader {
    private static ConfigReader configReader;
    private Properties prop;
    private ConfigReader(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
            prop.load(ip);
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance(){
        if (configReader == null) {
            synchronized (ConfigReader.class) {
                configReader = new ConfigReader();
            }
        }
        return configReader;
    }
    public String getConfigProperty(String propName){
        return prop.getProperty(propName);
    }
}
