package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

//    private final By accountTexLocator = new By.ByCssSelector("sasas");
//    private final By accountTexLocator1 = By.cssSelector("sasas");
    private final By accountTexLocator2 = By.id("twotabsearchtextbox");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void sendSearchText(){

        find(accountTexLocator2).sendKeys("Kel Hakkı");
        waitFor(5);
    }

//    private List<WebElement> forIsLogin(){
//        return findAll(accountTexLocator);
//    }


}
