package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.BasePage;

import java.util.List;

public class ProductPage extends BasePage {

    private final By resultTextLocator = By.cssSelector("span[class='a-color-state a-text-bold']");
    private final By goSecPageLocator = By.cssSelector("a[aria-label='Go to page 2']");
    private final By pageSecTextLocator = By.cssSelector("span.s-pagination-selected");
    private final By productsListLocator = By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']");
    private final By addToListLocator = By.id("add-to-wishlist-button-submit");
    private final By basketProductLocator = By.xpath("//*[text()='View Your List']");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //* Arama yapıldığı kontrol edilir.
    public String searchControl(){
       return find(resultTextLocator).getText();

    }

    //* Arama sonuçları sayfasından 2. sayfa açılır.
    public void secondPageClick(){
        find(goSecPageLocator).click();
    }

    //* 2. sayfanın açıldığı kontrol edilir.
    public String secPageControl(){
        return find(pageSecTextLocator).getText();
    }

    //* Sayfadaki 2. ürün oluşturulan Team4 Liste listesine eklenir.
    public void secondProductAddList (){
        List<WebElement> productList =findAll(productsListLocator);
        productList.get(1).click();
        waitFor(1);
       find(addToListLocator).click();

    }

    //* 2. Ürünün listeye eklendiği kontrol edilir.
    public WebElement basketControl(){
        return find(basketProductLocator);
    }





}
