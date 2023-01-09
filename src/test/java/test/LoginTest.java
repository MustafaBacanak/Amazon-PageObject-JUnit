package test;

import main.HomePage;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends TestBase{

    public HomePage homepage;

 @Before
    public void getAll(){
     homepage=new HomePage(driver);
 }

    @Test
    public void test01() {
     homepage.sendSearchText();

    }
}
