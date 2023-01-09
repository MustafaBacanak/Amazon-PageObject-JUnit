package test;

import main.HomePage;
import main.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EndToEndTest extends TestBase{

    public HomePage homePage;
    public LoginPage loginPage;

 @Before
    public void getAll(){
     homePage=new HomePage(driver);
     loginPage=new LoginPage(driver);
 }

    @Test
    public void E2E() {

        Assert.assertEquals("https://www.amazon.com/",homePage.getUrl());
        homePage.goLoginPage();
        loginPage.beLogin();
        Assert.assertTrue(homePage.loginControl().contains("Osman"));


    }

}
