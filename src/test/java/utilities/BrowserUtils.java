package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BrowserUtils {
    /**
     * This method generates random emails.
     * Ex:
     * .getRandomEmail();   -> returns   user435454543jgktjktjgktg-rkergkrg@gmail.om
     */
    public static String getRandomEmail() {
        UUID uuid = UUID.randomUUID();
        return "user" + uuid + "@gmail.com";

    }

    /**
     * This method takes screenshots
     * Ex:
     * .takeScreenShot("NameOfScreenShot");
     */
    public static void takeScreenShots(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/" + testName + ".png";
        File file = new File(path);
        FileUtils.copyFile(screenShot, file);
    }

    /**
     * This method accepts a WebElement and a String value to select an option from a dropdown.
     * Ex:
     * .selectDropDownBySelectedValue(WebElement dropDown, String value);
     */
    public static void selectDropDownBySelectedValue(WebElement dropDown, String value) {
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will create a WebDriverWait object and wait for certain text to be present in a WebElement
     * Ex:
     * .waitForTextToBePresentInElement(WebElement element, String expectedText);
     */
    public static void waitForTextToBePresentInElement(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    /**
     * This method will wait for a WebElement to be clickable
     * Ex:
     * waitForElementToBeClickable(WebElement element);
     */
    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     *
     * This method scrolls down by [num] px.
     * Ex:
     *    .scrollDownBy(int numOfpixels)
     */
    public static void scrollDownBy(Integer numOfPixels){
        JavascriptExecutor jse=((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("window.scrollBy(0,"+numOfPixels+")");
    }

}
