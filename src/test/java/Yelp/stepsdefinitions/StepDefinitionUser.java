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
        Serenity.takeScreenshot();
    }

    @And("^login as standard user$")
    public void userLoginAsStandard(){
        user.loginAsStandard();
        Serenity.takeScreenshot();
    }

    @Given("^user go to About tab$")
    public void userNavigateToAboutTab(){
        user.navigateToAboutPage();
        Serenity.takeScreenshot();
    }

    @And("^user goes back to Product page$")
    public void userNavigateToAProductPage(){

    }
}
