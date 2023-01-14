package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By resultText = By.cssSelector("span[class='a-color-state a-text-bold']");
    private final By goSecPage = By.cssSelector("a[aria-label='Go to page 2']");
    private final By pageSecText = By.cssSelector("span.s-pagination-selected");
    private final By secondProduct = By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //* Arama yapıldığı kontrol edilir.
    public String searchControl(){
       return find(resultText).getText();

    }

    //* Arama sonuçları sayfasından 2. sayfa açılır.
    public void secondPageClick(){
        find(goSecPage).click();
    }

    //* 2. sayfanın açıldığı kontrol edilir.
    public String secPageControl(){
        return find(pageSecText).getText();
    }

    //* Sayfadaki 2. ürün oluşturulan Team4 Liste listesine eklenir.





}
