package main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findAll(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void selectFromDropDown(WebElement dropdown, String secenek) {

        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum option'lari return eder
        for (WebElement w : options) {
            if (w.getText().equals(secenek)) {
                w.click();
                break;
            }
        }
    }

    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    MULTIPLE WINDOW
    public void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //    MULTIPLE WINDOW INDEX
    public void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    //    ACTIONS_DRAG_AND_DROP
    public void dragAndDropActions(WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source,target).perform();
    }

    //    ACTIONS_SCROLL_DOWN
    public void scrollDownActions() {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //    ACTIONS_SCROLL_UP
    public void scrollUpActions() {
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //    ACTIONS_HOVER_OVER
    public void moveToElementActions(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        new Actions(driver).moveToElement(element).perform();
    }

    // By Locator  >>   List<String>
    public List<String> getElementsText(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> elementText = new ArrayList<>();
        for (WebElement w : elements) {
            if (!w.getText().isEmpty()) {
                elementText.add(w.getText());
            }
        }
        return elementText;
    }

    //   SCREENSHOTS > Tüm Sayfa
    public void takeScreenShotOfPage() throws IOException {

//        1. Take screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }

    //    SCREENSHOT > Spesific Element
    public void takeScreenshotOfElement(WebElement element) throws IOException {

//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }

}
