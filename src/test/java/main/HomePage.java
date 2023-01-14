package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

//    private final By accountTexLocator1 = By.cssSelector("sasas");

    Select select;
    private final By createListBtn1 = By.xpath("//span[.='Create a List']");
    private final By createListBtn2 = By.cssSelector("input[class='a-button-input']");
    private final By createListBtn3 = By.id("wl-redesigned-create-list");
    private final By goLoginPageButton = By.id("nav-link-accountList");
    private final By shoppingListName = By.id("list-name");
    private final By goHomePage = By.id("nav-logo-sprites");
    private final By searchDropdownBox = By.id("searchDropdownBox");


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

    //* Hesabım bölümünden Team4 Liste isimli yeni bir liste oluşturulur.

    public void createList(String listName){

        moveToElementActions(goLoginPageButton);
        waitFor(1);
        find(createListBtn1).click();
        try {
            find(createListBtn2).click();
        } catch (Exception e) {

            System.out.println("Harızda bir liste olduğu için createListBtn1 çalışmadı ve catch aktif oldu ");
        }
        WebElement listNameInput = find(shoppingListName);
        listNameInput.clear();
        listNameInput.sendKeys(listName);
        find(createListBtn3).click();
        waitFor(2);
        find(goHomePage).click();
    }

    //* Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    public void categories (){
        WebElement searh = find(searchDropdownBox);
        select = new Select(searh);
        select.selectByVisibleText("Computers");
    }

    //* Bilgisayar kategorisi seçildiği kontrol edilir.
    public String categoryControl(){
        return select.getFirstSelectedOption().getText();
    }

    //* Arama alanına msi yazılır ve arama yapılır.
    public void searchProduct (String productName ){
        find(searchDropdownBox).sendKeys(Keys.TAB,productName,Keys.ENTER);

    }






}
