package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElarLogisticsHomePage;
import pages.YardsProfilePage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class ElarYardSteps {
    WebDriver driver = Driver.getDriver();
    ElarLogisticsHomePage elarLogisticsHomePage = new ElarLogisticsHomePage();
    YardsProfilePage yardsProfilePage = new YardsProfilePage();


    @When("User clicks on Yards tab")
    public void user_clicks_on_yards_tab() {
        elarLogisticsHomePage.yardPageBtn.click();
    }


    @When("User clicks on Add yard")
    public void user_clicks_on_add_yard() {
        elarLogisticsHomePage.addYardBtn.click();

    }


    @When("User inputs required yard data")
    public void user_inputs_required_yard_data(DataTable datatable) {
        List<Map<String, Object>> data = datatable.asMaps(String.class, Object.class);
        for (int i = 0; i < data.size(); i++) {
            yardsProfilePage.nameInput.sendKeys(data.get(i).get("NAME").toString());
            yardsProfilePage.streetInput.sendKeys(data.get(i).get("STREET").toString());
            yardsProfilePage.cityInput.sendKeys(data.get(i).get("CITY").toString());
            yardsProfilePage.stateDropDwn.click();
            BrowserUtils.selectDropDownBySelectedValue(yardsProfilePage.stateDropDwn, "California");
            yardsProfilePage.zipCodeInput.sendKeys(data.get(i).get("ZIP CODE").toString());


        }

    }

    @When("User clicks on add yard button")
    public void user_clicks_on_add_yard_button() {

    }

    @Then("User validates Yard is saved in application and Yard is correctly inserted into core_yard table in Database")
    public void user_validates_yard_is_saved_in_application_and_yard_is_correctly_inserted_into_core_yard_table_in_database() {

    }


}
