package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

//    private final By accountTexLocator = new By.ByCssSelector("sasas");
//    private final By accountTexLocator1 = By.cssSelector("sasas");
    private final By goLoginPageButton = By.id("nav-link-accountList");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //* Ana sayfanın açıldığı kontrol edilir.
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    //Login Sayfasına Git
    public void goLoginPage(){
        find(goLoginPageButton).click();
    }

    //* Login işlemi kontrol edilir.
    public String loginControl() {
    return find(goLoginPageButton).getText();
    }

}
