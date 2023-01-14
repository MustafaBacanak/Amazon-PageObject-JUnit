package test;

import main.HomePage;
import main.LoginPage;
import main.ProductPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EndToEndTest extends TestBase{

    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;

 @Before
    public void getAll(){
     homePage=new HomePage(driver);
     loginPage=new LoginPage(driver);
     productPage=new ProductPage(driver);

 }
    @Test
    public void E2E() {

        Assert.assertEquals("https://www.amazon.com/",homePage.getUrl());
        homePage.goLoginPage();
        loginPage.beLogin();
        Assert.assertTrue(homePage.loginControl().contains("Osman"));
        homePage.createList("Team4");
        homePage.categories();
        Assert.assertEquals("Computers",homePage.categoryControl());
        homePage.searchProduct("msi");
        Assert.assertTrue(productPage.searchControl().contains("msi"));
        productPage.secondPageClick();
        Assert.assertEquals("2" , productPage.secPageControl());






    }

}
