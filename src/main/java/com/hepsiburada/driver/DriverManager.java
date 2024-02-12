package com.hepsiburada.driver;

import com.hepsiburada.utilities.PropertyReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class DriverManager extends DriverFactory{
    @BeforeTest
    public static void setUp(){
        prop = PropertyReader.getInstance();
        driver = getDriver();
    }

    @AfterTest
    public static void tearDown(){

        driver = null;
        quitDriver();
    }

    @BeforeMethod
    public void beforeEachMethod(){
        getDriver().manage().deleteAllCookies();
    }
}
