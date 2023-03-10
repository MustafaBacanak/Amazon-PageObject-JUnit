package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusable.BasePage;

public class LoginPage extends BasePage {

    private final By signInEmailOrPhoneLocator = By.id("ap_email");
    private final By continueBtnLocator = By.id("continue");
    private final By passwordLocator = By.id("ap_password");
    private final By singInSubmitLocator = By.id("signInSubmit");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //* Siteye login olunur.
    public void beLogin(){
        find(signInEmailOrPhoneLocator).sendKeys("+905066964168");
        find(continueBtnLocator).click();
        find(passwordLocator).sendKeys("LTUJFNAXF977.");
        find(singInSubmitLocator).click();
    }

}
