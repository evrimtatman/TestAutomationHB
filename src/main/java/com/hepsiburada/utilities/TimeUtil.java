package com.hepsiburada.utilities;


public class TimeUtil {

    /**
     * Method to return implicit wait
     *
     * @return long implicit wait
     */
    public static long getImplicitWait(){
        return Long.parseLong(PropertyReader.getInstance()
                .getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    /**
     * Method to return explicit wait
     *
     * @return long explicit wait
     */
    public static long getExplicitWait(){
        return Long.parseLong(PropertyReader.getInstance()
                .getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
