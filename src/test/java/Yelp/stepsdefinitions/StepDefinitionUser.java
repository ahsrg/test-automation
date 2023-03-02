package Yelp.stepsdefinitions;

import Yelp.steps.YelpUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class StepDefinitionUser {

    @Steps(shared = true)
    YelpUser user;

    @Given("^user navigates to https://www.saucedemo.com/$")
    public void userNavigateToSaucedemo(){
        user.navigatesTo();
    }

    @And("^login as standard user$")
    public void userLoginAsStandard(){
        user.loginAsStandard();
    }

    @Given("^user go to About tab$")
    public void userNavigateToAboutTab(){
        user.navigateToAboutPage();
    }

    @Then("^user goes back to Product page$")
    public void userNavigateToAProductPage(){
        user.navigateToProductPage();
    }

    @And("^order products from lowest to highest price$")
    public void userOrderProductsByPriceLowToHigh(){
        user.sortProductsBy("Price (low to high)");
    }

    @Given("^user order products from highest to lowest price$")
    public void userOrderProductsByPriceHighToLow(){
        user.sortProductsBy("Price (high to low)");
    }

    @Then("^user add to cart the (.*) most expensive products$")
    public void userAddProducts(Integer productQuantity){
        user.addNProducts(productQuantity);
    }

    @And("^review that shopping cart contains (.*) products")
    public void userReviewShoppingCart(String productQuantity){
        user.reviewShoppingCart(productQuantity);
    }

    @Then("^user go to shopping cart$")
    public void userGoToShoppingCart(){
        user.goToShoppingCart();
    }

    @And("^complete checkout process$")
    public void completeCheckoutProcess(){
        user.completeCheckout();
    }
}
