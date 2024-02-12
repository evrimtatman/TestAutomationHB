package com.hepsiburada.utilities;

public enum PropKey {

    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSER_MANAGER("browserManager"),


    //Driver Paths
    CHROME_DRIVER_PATH("chromeDriverPath"),
    FIREFOX_DRIVER_PATH("geckoDriverPath"),

    //Timeouts
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait");

    private final String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal(){
        return this.propVal;
    }
}
