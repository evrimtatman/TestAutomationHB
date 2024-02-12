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

    }
