package steps;

import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import pages.ElarLogisticsCompanyProfilePage;
import pages.ElarLogisticsHomePage;
import pages.ElarLogisticsLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class ElarLogisticSteps {
    WebDriver driver = Driver.getDriver();
    ElarLogisticsLoginPage elarLogisticsLoginPage = new ElarLogisticsLoginPage();
    ElarLogisticsHomePage elarLogisticsHomePage = new ElarLogisticsHomePage();
    ElarLogisticsCompanyProfilePage elarLogisticsCompanyProfilePage = new ElarLogisticsCompanyProfilePage();


    @Given("User navigates to Elar Logistics application")
    public void user_navigates_to_elar_logistics_application() {
        driver.get(ConfigReader.getProperty("ElarLogisticsURL"));
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) throws InterruptedException {
        elarLogisticsLoginPage.userNameInput.sendKeys(username);
        elarLogisticsLoginPage.passWordInput.sendKeys(password);
        elarLogisticsLoginPage.loginBtn.click();
        Thread.sleep(2000);
    }


    @When("User clicks on companies tab")
    public void user_clicks_on_companies_tab() {
        elarLogisticsHomePage.companiesTab.click();
    }

    @When("User selects {string} company")
    public void user_selects_company(String string) {
        elarLogisticsHomePage.AbcCompany.click();
    }


    @When("User clicks on edit button")
    public void user_clicks_on_edit_button() throws InterruptedException {
        elarLogisticsCompanyProfilePage.editBtn.click();
        BrowserUtils.scrollDownBy(2000);
    }

    @Then("User validates fields are editable")
    public void user_validates_fields_are_editable() {
        Assert.assertTrue(elarLogisticsCompanyProfilePage.cancelBtn.getText().equalsIgnoreCase("cancel"));
    }


    @When("User clicks on cancel button")
    public void user_clicks_on_cancel_button() {
        elarLogisticsCompanyProfilePage.cancelBtn.click();
    }


    @Then("User validates fields remain the same")
    public void user_validates_fields_remain_the_same() {
        String actual = elarLogisticsCompanyProfilePage.nameInput.getAttribute("value");
        String expected = "AAABBBCCC";
        Assert.assertEquals(expected, actual);
    }


    @When("User clicks on company name and rename it")
    public void user_clicks_on_company_name_and_rename_it() {
        elarLogisticsCompanyProfilePage.nameInput.clear();
        elarLogisticsCompanyProfilePage.nameInput.sendKeys("Abcdefg");
    }


    @Then("User validates edited fields remain the same")
    public void user_validates_edited_fields_remain_the_same() {

        String actual = elarLogisticsCompanyProfilePage.CompanyNameHeader.getText();
        String expected = "AAABBBCCC";
        Assert.assertEquals(expected, actual);
    }

    @When("User clicks back to companies button")
    public void user_clicks_back_to_companies_button() {
        elarLogisticsCompanyProfilePage.backToCompBtn.click();
    }


    @Then("User validates list of companies is displayed")
    public void user_validates_list_of_companies_is_displayed() {
        String expected = "List of Companies";
        String actual = elarLogisticsHomePage.headerListOfCompanies.getText();
        Assert.assertEquals(expected, actual);

    }

    @When("User clicks on Add company button")
    public void user_clicks_on_add_company_button() {
        elarLogisticsHomePage.addCompanyBtn.click();
    }


    @Then("User validates navigation to company creation page")
    public void user_validates_navigation_to_company_creation_page() {
        Assert.assertTrue(elarLogisticsCompanyProfilePage.headerAddCompany.getText().equalsIgnoreCase("Add company"));
    }


    @Then("User Validates Company Name can't be cleared")
    public void user_validates_company_name_can_t_be_cleared() {
        try {
            elarLogisticsCompanyProfilePage.nameInput.clear();
            Assert.fail("Element is changeable");
        } catch (InvalidElementStateException exception) {
            Assert.assertTrue("Element not changeable as expected", true);
        }

    }

    @Then("User validates existing companies are editable")
    public void user_validates_existing_companies_are_editable() {
        try {
            elarLogisticsCompanyProfilePage.nameInput.clear();
            Assert.assertTrue("Element is editable as expected", true);
        } catch (InvalidElementStateException exception) {
            Assert.fail("Element not editable");
        }

    }

    @Then("User Validates fields are immutable")
    public void user_validates_fields_are_immutable() {
        try {
            elarLogisticsCompanyProfilePage.nameInput.clear();
            Assert.fail("Element is changeable");
        } catch (InvalidElementStateException exception) {
            Assert.assertTrue("Element not changeable as expected", true);
        }

    }

    @When("User clicks on company name and renames it")
    public void user_clicks_on_company_name_and_renames_it() {
        elarLogisticsCompanyProfilePage.nameInput.clear();
        elarLogisticsCompanyProfilePage.nameInput.sendKeys("M&A Logistics");
    }


    @When("User clicks on save button")
    public void user_clicks_on_save_button() {
        elarLogisticsCompanyProfilePage.saveBtn.click();
    }


    @When("User clicks on Stay on current page when pop-up is visible")
    public void user_clicks_on_stay_on_current_page_when_pop_up_is_visible() {
        elarLogisticsCompanyProfilePage.popUpStayOnCurrentPageBtn.click();
    }


    @Then("User validates input is saved")
    public void user_validates_input_is_saved() {
        String expected = "M&A Logistics";
        Assert.assertEquals(expected, elarLogisticsCompanyProfilePage.nameInput.getAttribute("value"));
    }

    @When("User changes the MC Number")
    public void user_changes_the_mc_number() {
        elarLogisticsCompanyProfilePage.mCNumberField.clear();
        elarLogisticsCompanyProfilePage.mCNumberField.sendKeys("9873223232");
    }


    @Then("User validates pop-up says AAABBBCCC successfully changed")
    public void user_validates_pop_up_says() {
        String expected = "AAABBBCCC\n" +
                "successfully changed";
        Assert.assertEquals(expected, elarLogisticsCompanyProfilePage.popUpSuccessfullyChangedMessage.getText());
    }

    @Then("User validates pop-up includes company name")
    public void user_validates_pop_up_includes_company_name() {

        Assert.assertTrue(elarLogisticsCompanyProfilePage.popUpSuccessfullyChangedMessage.getText().contains("AAABBBCCC"));
    }


}
