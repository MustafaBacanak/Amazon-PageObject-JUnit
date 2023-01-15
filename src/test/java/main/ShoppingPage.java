package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingPage extends BasePage {

    private final By closeBasketLocator = By.cssSelector("i[class='a-icon a-icon-close']");
    private final By goLoginPageBtnLocator = By.id("nav-link-accountList");
    private final By shpngListBtnLocator = By.cssSelector("div[class='nav-panel'] > a");
    private final By deleteBtnLocator = By.cssSelector("input[name='submit.deleteItem']");
    private final By deletedTextLocator = By.xpath("//div[text()='Deleted']");

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    //* Hesabım > Alışveriş Listesi sayfasına gidilir.
    public void goShoppingList (){
        find(closeBasketLocator).click();
        scrollUpActions();
        moveToElementActions(goLoginPageBtnLocator);
        find(shpngListBtnLocator).click();
    }

    //* Alışveriş Listesi sayfası açıldığı kontrol edilir.
    public WebElement shoppingListPageControl(){
        return find(deleteBtnLocator);
    }

    //* Eklenen ürün Virgosol Liste’sinden silinir.

    public void deleteProduct(){
        find(deleteBtnLocator).click();
    }

    //* Silme işleminin gerçekleştiği kontrol edilir.
    public WebElement deletedControl(){
        return find(deletedTextLocator);
    }






}
