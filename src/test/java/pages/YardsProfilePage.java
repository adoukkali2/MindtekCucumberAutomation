package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class YardsProfilePage {

    WebDriver driver;

    public YardsProfilePage() {
       driver=Driver.getDriver();
       PageFactory.initElements(driver,this);
    }



    @FindBy(id = "id_yard_location")
    public WebElement nameInput;

    @FindBy(xpath = "//select[@id='id_status']")
    public WebElement statusDropDwn;

    @FindBy(xpath = "//input[@id='id_address']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id='id_apt_suite_company_co']")
    public WebElement aptSuiteInputNonRequired;

    @FindBy(xpath = "//input[@id='id_city']")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement stateDropDwn;

    @FindBy(xpath = "//input[@id='id_zip_code']")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//input[@class='input-form border disabled-company disabled-not-ext']")
    public WebElement servicePhoneInputNonRequired;

    @FindBy(xpath = "//div[@class='form-content']//div[1]//p[2]//span[1]//span[2]//input[1]")
    public WebElement contactNameNonRequired;

    @FindBy(xpath = "//input[@class='disabled-not-ext input-form border disabled-company']")
    public WebElement ownerPhoneInputNonRequired;

    @FindBy(xpath = "//div[@class='form-content']//div[1]//p[2]//span[1]//span[2]//input[1]")
    public WebElement contactNameInputNonRequired;

    @FindBy(xpath = "//input[@id='id_spots']")
    public WebElement spotsInput;

    @FindBy(xpath = "//input[@id='id_warning']")
    public WebElement warningInputNonRequired;

    @FindBy(xpath = "//textarea[@id='id_notes']")
    public WebElement notesInputNonRequired;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement saveAddYardBtn;

}
