package com.hepsiburada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.hepsiburada.utilities.Helper.getAppUrl;

public class BasePage extends HtmlPageObject{

    private WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    };

    private static final String SIGN_IN_LINK_XPATH = "//div[@id='myAccount']";
    private static final String DO_LOGIN = "//a[@id='login']";

    public void navigateToApp(){
        try {
            driver.navigate().to(new URL(getAppUrl()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginPage navigateToSignOnPage(){
        isTextPresentOnPage("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
        clickLinkOrBtn(By.xpath(SIGN_IN_LINK_XPATH));
        clickLinkOrBtn(By.xpath(DO_LOGIN));
        return new LoginPage(driver);
    }



}
