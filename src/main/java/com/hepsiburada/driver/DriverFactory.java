package com.hepsiburada.driver;

import com.hepsiburada.utilities.PropKey;
import com.hepsiburada.utilities.PropertyReader;
import com.hepsiburada.utilities.TimeUtil;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.hepsiburada.utilities.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null;
    //in order to not have issue while having multiple threads for web-driver
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Method to get Web Driver
     * @return web driver
     */
    public static WebDriver getDriver(){
        if(driver == null){
            driverThreadLocal.set(getBrowser().getWebDriver());
        }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(getImplicitWait());
        return driverThreadLocal.get();
    }

    /**
     *Method to quit Web Driver
     */
    public static void quitDriver(){
        driverThreadLocal.get().quit();
    }

    /**
     * Method to determine browser type
     * @return Browser type
     */
    private static BrowserType getBrowser(){
        if(prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("CHROME")){
            return BrowserType.CHROME;
        } else if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("FIREFOX")){
            return BrowserType.FIREFOX;
        }else {
            return BrowserType.CHROME;
        }
    }
}
