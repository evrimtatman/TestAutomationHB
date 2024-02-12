package com.hepsiburada.driver;

import com.hepsiburada.utilities.Helper;
import com.hepsiburada.utilities.PropKey;
import com.hepsiburada.utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static com.hepsiburada.utilities.Helper.isWebDriverManager;

public enum BrowserType implements DriverSetup{
    CHROME{
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public ChromeOptions getBrowserOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.setAcceptInsecureCerts(true);
            return chromeOptions;
        }

        @Override
        public WebDriver getWebDriver() {
            String browserPath = PropertyReader.getInstance()
                    .getProperty(PropKey.CHROME_DRIVER_PATH.getPropVal());
           if(isWebDriverManager()){
                WebDriverManager.chromedriver().setup();
            }else {
                System.setProperty("webdriver.chrome.driver", browserPath);
            }
           ChromeOptions chromeOptions = getBrowserOptions();
            return new ChromeDriver(chromeOptions);
        }
    },

    FIREFOX{
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public FirefoxOptions getBrowserOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            //Accept untrusted certificates
            firefoxProfile.setAcceptUntrustedCertificates(true);
            firefoxProfile.setAssumeUntrustedCertificateIssuer(false);

            //Set Firefox profile capabilities
            firefoxOptions.setCapability(FirefoxDriver.SystemProperty.BROWSER_PROFILE, firefoxProfile);
            return firefoxOptions;
        }

        @Override
        public WebDriver getWebDriver() {
            String browserPath = PropertyReader.getInstance()
                    .getProperty(PropKey.FIREFOX_DRIVER_PATH.getPropVal());
            if(isWebDriverManager()){
                WebDriverManager.firefoxdriver().setup();
            }else {
                System.setProperty("webdriver.gecko.driver", browserPath);
            }
            FirefoxOptions firefoxOptions = getBrowserOptions();
            return new FirefoxDriver(firefoxOptions);
        }
    };


}
