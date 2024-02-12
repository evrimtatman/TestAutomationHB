package com.hepsiburada.pages;

import com.hepsiburada.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.hepsiburada.utilities.TimeUtil.getExplicitWait;

public class HtmlPageObject extends DriverManager {

    private WebDriver driver = getDriver();

    /**
     * Method to find element by CSS
     * @param cssLocator
     * @return
     */
    public WebElement findElementByCss(String cssLocator){
        try{
            By by = By.cssSelector(cssLocator);
            WebDriverWait wait = new WebDriverWait(driver, getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        }catch (TimeoutException t){
            throw new TimeoutException();
        }
    }

    /**
     * Method to find element by Xpath
     * @param xpathLocator
     * @return
     */
    public WebElement findElementByXpath(String xpathLocator){
        try{
            By by = By.xpath(xpathLocator);
            WebDriverWait wait = new WebDriverWait(driver, getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        }catch (TimeoutException t){
            throw new TimeoutException();
        }
    }

    /**
     * Method to find element by Id
     * @param IdLocator
     * @return
     */
    public WebElement findElementById(String IdLocator){
        try{
            By by = By.id(IdLocator);
            WebDriverWait wait = new WebDriverWait(driver, getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        }catch (TimeoutException t){
            throw new TimeoutException();
        }
    }






}
