package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ElarLogisticsLoginPage {
    WebDriver driver;

    public ElarLogisticsLoginPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='login']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passWordInput;

    @FindBy(className = "btn-login")
    public WebElement loginBtn;




}
