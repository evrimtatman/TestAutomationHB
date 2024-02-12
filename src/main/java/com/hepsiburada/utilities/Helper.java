package com.hepsiburada.utilities;

public class Helper {

    public static boolean isWebDriverManager(){
        if(PropertyReader.getInstance().getProperty(
                        PropKey.BROWSER_MANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager")){
            return true;
        }
        return false;
        }

    /**
     * Method to obtain url from property file
     * @return BaseUrl
     */
    public static String getAppUrl(){
        String BaseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        return BaseUrl;
    }

    }
