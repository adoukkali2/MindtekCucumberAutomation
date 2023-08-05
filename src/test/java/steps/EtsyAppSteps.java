package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHomePageSteps = new EtsyHomePage();

    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));
    }

    @When("User searches for {string}")
    public void user_searches_for(String searchBoxInput) {
        etsyHomePageSteps.searchBox.sendKeys(searchBoxInput + Keys.ENTER);
    }


    @Then("User validates search result contains")
    public void user_validates_search_result_contains(DataTable data) {
        List<String> keywords = data.asList();
        for (WebElement el : etsyHomePageSteps.items) {
            boolean isFound = false;
            for (int i = 0; i < keywords.size(); i++) {
                if (el.getText().toLowerCase().contains(keywords.get(i))) isFound = true;
            }
            Assert.assertTrue(el.getText() + " does not contain keyword " + keywords + "]", isFound);
        }
    }

    @When("User selects price range over {int}")
    public void user_selects_price_range_over(Integer int1) {
        etsyHomePageSteps.allFiltersBtn.click();
        etsyHomePageSteps.overThousandBtn.click();
        etsyHomePageSteps.applyBtn.click();
    }


    @Then("user validates price range for items over {double}")
    public void user_validates_price_range_for_items_over(Double priceRange) {
        driver.navigate().refresh();
        for (WebElement price : etsyHomePageSteps.prices) {
            System.out.println(price.getText());
            Double prices = Double.parseDouble(price.getText().replace(",", ""));
            Assert.assertTrue(prices + " is less then " + priceRange, prices >= priceRange);

        }
    }

    @When("User clicks on {string} module")
    public void user_clicks_on_module(String module) {
        if (module.equals("Fashion Favorites")) etsyHomePageSteps.fashionFavoriteModule.click();
        else if (module.equals("Jewelry & Accessories")) etsyHomePageSteps.jewelryAccessoriesModule.click();
        else if (module.equals("Clothing & Shoes")) etsyHomePageSteps.clothingShoeModule.click();
        else if (module.equals("Home & Living")) etsyHomePageSteps.homeAndLivingModule.click();
        else if (module.equals("Wedding & Party")) etsyHomePageSteps.weddingAndParty.click();
        else if (module.equals("Toys & Entertainment")) etsyHomePageSteps.toysAndEntertainmentModule.click();
        else if (module.equals("Art & Collectibles")) etsyHomePageSteps.artAndCollectionsModule.click();
        else if (module.equals("Craft Supplies")) etsyHomePageSteps.craftSuppliesModule.click();
        else if (module.equals("Gifts & Gift Cards")) etsyHomePageSteps.giftCardsModule.click();
        else System.out.println("Not a module");

    }


    @Then("User validates the {string} title")
    public void user_validates_the_title(String title) {
        Assert.assertEquals("Title is incorrect or doesn't match", title, driver.getTitle());
    }

}
