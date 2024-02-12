package com.hepsiburada.tests;

import com.hepsiburada.driver.DriverManager;
import com.hepsiburada.pages.BasePage;
import com.hepsiburada.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends DriverManager {

    @Test
    void doLogin(){
        BasePage basePage = new BasePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        basePage.navigateToApp();
        basePage.navigateToSignOnPage();
        loginPage.doLogin("evrimm@windowslive.com","test1234");
        loginPage.getMessageOnInvalidLogin();


    }
}
