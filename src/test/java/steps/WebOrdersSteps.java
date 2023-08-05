package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WebOrdersSteps {
    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();

    @Given("User navigates to application")
    public void user_navigates_to_application() {
        driver.get(ConfigReader.getProperty("WebOrdersURL"));
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        webOrdersLoginPage.loginField.sendKeys(username);
        webOrdersLoginPage.passWordField.sendKeys(password);
        webOrdersLoginPage.loginBtn.click();
    }

    @Then("User is successfully logged in and lands on the homepage")
    public void user_is_successfully_logged_in_and_lands_on_the_homepage() {
        String expectedTitle = "Web Orders";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("User validates error message {string}")
    public void user_validates_error_message(String message) {
        Assert.assertEquals(message, webOrdersLoginPage.errorMessage.getText());
    }

    @When("User clicks on Order tab")
    public void user_clicks_on_order_tab() {
        webOrdersHomePage.orderTab.click();
    }

    @When("User selects product {string} and quantity {int}")
    public void user_selects_product_my_money_and_quantity(String product, Integer quantity) {
        BrowserUtils.selectDropDownBySelectedValue(webOrdersOrderPage.dropDown, product);
        webOrdersOrderPage.quantityInput.sendKeys(Keys.BACK_SPACE + quantity.toString());
        webOrdersOrderPage.calculateBtn.click();
    }


    @When("User validates the price is correctly calculated for {int}")
    public void user_validates_the_price_is_correctly_calculated_for(Integer quantity) {
        int price = Integer.parseInt(webOrdersOrderPage.unitPrice.getAttribute("value"));
        int discount = Integer.parseInt(webOrdersOrderPage.discount.getAttribute("value"));
        System.out.println(price);
        System.out.println(discount);

        int expectedTotal;

        if (quantity >= 10) {
            expectedTotal = quantity * price * (100 - discount) / 100;
        } else expectedTotal = price * quantity;
        int actualTotal = Integer.parseInt(webOrdersOrderPage.total.getAttribute("value"));

        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @When("User created order with data")
    public void user_created_order_with_data(DataTable dataTable) {
        List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);

        for (int i=0;i<data.size();i++){
            BrowserUtils.selectDropDownBySelectedValue(webOrdersOrderPage.dropDown, data.get(i).get("PRODUCT").toString());
            webOrdersOrderPage.quantityInput.sendKeys(Keys.BACK_SPACE + data.get(i).get("QUANTITY").toString());
            webOrdersOrderPage.inputName.sendKeys(data.get(i).get("CUSTOMER NAME").toString());
            webOrdersOrderPage.inputStreet.sendKeys(data.get(i).get("STREET").toString());
            webOrdersOrderPage.inputCity.sendKeys(data.get(i).get("CITY").toString());
            webOrdersOrderPage.inputState.sendKeys(data.get(i).get("STATE").toString());
            webOrdersOrderPage.inputZip.sendKeys(data.get(i).get("ZIP").toString());
            webOrdersOrderPage.visaCardBtn.click();
            webOrdersOrderPage.inputCardNum.sendKeys(data.get(i).get("CARD NUM").toString());
            webOrdersOrderPage.inputExpDate.sendKeys(data.get(i).get("EXP DATE").toString());
            webOrdersOrderPage.processBtn.click();
            user_validates_success_message("New order has been successfully added.");

        }

    }

    @Then("User validates success message {string}")
    public void user_validates_success_message(String string) {

        String actualMessage = webOrdersOrderPage.successMessage.getText();
        Assert.assertEquals(string, actualMessage);

    }

    @Then("User validates created order is in the list of all orders.")
    public void user_validates_created_order_is_in_the_list_of_all_orders() {


    }
}


// cucumber is a bdd framework: focuses on testing user case scenario, what the users do, what the users behavior is
// on the application. Uses gherkin language to write test scripts
//