package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.BasePage;

public class LogOutPage extends BasePage {

    private final By goLoginBtnLocator = By.id("nav-link-accountList");
    private final By singOutBtnLocator = By.xpath("//span[.='Sign Out']");
    private final By createAccBtnLocator = By.id("createAccountSubmit");


    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    //* Üye çıkış işlemi yapılır.
    public void logOut(){
        moveToElementActions(goLoginBtnLocator);
        waitFor(1);
        find(singOutBtnLocator).click();
    }

    //* Çıkış işleminin yapıldığı kontrol edilir.
    public WebElement logOutControl(){
        return find(createAccBtnLocator);

    }
}
