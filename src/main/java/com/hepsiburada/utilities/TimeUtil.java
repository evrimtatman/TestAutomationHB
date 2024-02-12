package com.hepsiburada.utilities;

import java.time.Duration;

public class TimeUtil {

    /**
     * Method to return implicit wait
     *
     * @return long implicit wait
     */
    public static Duration getImplicitWait(){
        return Duration.parse(PropertyReader.getInstance()
                .getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    /**
     * Method to return explicit wait
     *
     * @return long explicit wait
     */
    public static Duration getExplicitWait(){
        return Duration.parse(PropertyReader.getInstance()
                .getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
