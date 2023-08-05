package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticsCompanyProfilePage {

    WebDriver driver;

    public ElarLogisticsCompanyProfilePage() {
        driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='material-icons']")
    public WebElement editBtn;

    @FindBy(id = "id_company_name")
    public WebElement nameInput;

    @FindBy(className = "confirm-cancel")
    public WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='profile-title-text']//span[contains(text(),'AAABBBCCC')]")
    public WebElement CompanyNameHeader;

    @FindBy(className = "return-span")
    public WebElement backToCompBtn;

    @FindBy(xpath = "//div[@class='title']")
    public WebElement headerAddCompany;

    @FindBy(className = "confirm-save")
    public WebElement saveBtn;

    @FindBy(className = "confirm-cancel")
    public WebElement popUpStayOnCurrentPageBtn;

    @FindBy(className = "success-title")
    public WebElement popUpSuccessfullyChangedMessage;

    @FindBy(id = "id_mc_number")
    public WebElement mCNumberField;
}
