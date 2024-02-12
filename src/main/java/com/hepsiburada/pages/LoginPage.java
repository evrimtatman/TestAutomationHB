package com.hepsiburada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private static final String USER_NAME_INPUT = "//input[@name='username']";
    private static final String PASSWORD_INPUT = "//input[@name='password']";
    private static final String LOGIN_BTN_ENTRY_PAGE = "//button[@name='btnLogin']";
    private static final String LOGIN_BUTTON_WELCOME_PAGE = "//button[@type='submit']";
    private static final String HELP_LINK = "//span[@data-test-id='span']";
    private static final String REGISTER_LINK = "//*[text()='Üye ol']";

    private static final String WELCOME_HEADER = "//h1[@div(contains('Hoş geldiniz'))]";
    private static final String INVALID_LOGIN_LABEL =
            "//div[@type='ERROR']//*[text()='Girdiğiniz şifre eksik veya hatalı.']";

    private static final String UNEXPECTED_LOGIN_LABEL = "//div[@type='ERROR']//*[text()='Beklenmeyen bir hata oluştu.']";


    private WebDriver driver = getDriver();

    @FindBy(xpath = LOGIN_BTN_ENTRY_PAGE)
    private WebElement loginBtn;

    /**
     * Method to login application
     * @param userName
     * @param password
     * @return
     */
    public DashBoardPage doLogin(String userName, String password){
        enterTextIntoTextBox(By.xpath(USER_NAME_INPUT), userName);
        clickLinkOrBtn(loginBtn);
        enterTextIntoTextBox(By.xpath(PASSWORD_INPUT), password);
        clickLinkOrBtn(By.xpath(LOGIN_BUTTON_WELCOME_PAGE));
        return new DashBoardPage(driver);
    }

    /**
     * Method navigate to registration page
     * @return
     */
    public AccountsPage navigateToRegistrationPage(){
        clickLinkOrBtn(By.xpath(REGISTER_LINK));
        return new AccountsPage(driver);

    }

    /**
     * Method to return invalid login message
     * @return
     */
    public String getMessageOnInvalidLogin(){
        return getTextFromElement(By.xpath(INVALID_LOGIN_LABEL));

    }

}
