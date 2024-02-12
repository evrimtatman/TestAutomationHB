package com.hepsiburada.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader propInstance;

    private PropertyReader(){

    }

    public static synchronized PropertyReader getInstance(){
        if(propInstance == null){
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * method to return properties value
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName){
        Properties prop = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(inputStream);

            if(prop.getProperty(propertyName) !=null){
                return prop.getProperty(propertyName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;


    }
}
