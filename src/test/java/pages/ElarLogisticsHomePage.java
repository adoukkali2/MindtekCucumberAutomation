package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ElarLogisticsHomePage {
    WebDriver driver;

    public ElarLogisticsHomePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#/panel/companies/list']")
    public WebElement companiesTab;

    @FindBy(xpath = "//td[@class='table-link show-popup-list']")
    public List<WebElement> existingCompanies;

    @FindBy(xpath = "//tr[2]//td[1]")
    public WebElement AbcCompany;

    @FindBy(xpath = "//p[@class='title']")
    public WebElement headerListOfCompanies;

    @FindBy(className = "link-btm-menu")
    public WebElement addCompanyBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/aside/nav/ul[3]/li[1]/a")
    public WebElement yardPageBtn;

    @FindBy(xpath = "//a[@class='link-btm-menu']")
    public WebElement addYardBtn;


}
