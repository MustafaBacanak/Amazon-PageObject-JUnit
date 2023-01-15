package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reusable.BasePage;

public class HomePage extends BasePage {

    Select select;
    private final By createListBtn1Locator = By.xpath("//span[.='Create a List']");
    private final By createListBtn2Locator = By.cssSelector("input[class='a-button-input']");
    private final By createListBtn3Locator = By.id("wl-redesigned-create-list");
    private final By goLoginPageBtnLocator = By.id("nav-link-accountList");
    private final By shoppingListNameLocator = By.id("list-name");
    private final By goHomePageLocator = By.id("nav-logo-sprites");
    private final By searchDropdownBoxLocator = By.id("searchDropdownBox");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //* Ana sayfanın açıldığı kontrol edilir.
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    //Login Sayfasına Git
    public void goLoginPage() {
        find(goLoginPageBtnLocator).click();
    }

    //* Login işlemi kontrol edilir.
    public String loginControl() {
        return find(goLoginPageBtnLocator).getText();
    }

    //* Hesabım bölümünden Team4 Liste isimli yeni bir liste oluşturulur.

    public void createList(String listName) {

        moveToElementActions(goLoginPageBtnLocator);
        waitFor(1);
        find(createListBtn1Locator).click();
        try {
            find(createListBtn2Locator).click();
        } catch (Exception e) {

            System.out.println("Harızda bir liste olduğu için createListBtn1 çalışmadı ve catch aktif oldu ");
        }
        WebElement listNameInput = find(shoppingListNameLocator);
        listNameInput.clear();
        listNameInput.sendKeys(listName);
        find(createListBtn3Locator).click();
        waitFor(1);
        find(goHomePageLocator).click();
    }

    //* Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    public void categories() {
        WebElement search = find(searchDropdownBoxLocator);
        select = new Select(search);
        select.selectByVisibleText("Computers");

    }

    //* Bilgisayar kategorisi seçildiği kontrol edilir.
    public String categoryControl() {
        return select.getFirstSelectedOption().getText();
    }

    //* Arama alanına msi yazılır ve arama yapılır.
    public void searchProduct(String productName) {
        find(searchDropdownBoxLocator).sendKeys(Keys.TAB, productName, Keys.ENTER);

    }

}
