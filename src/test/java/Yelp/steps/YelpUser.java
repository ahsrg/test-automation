package Yelp.steps;

import Yelp.pageobject.BurgerMenu;
import Yelp.pageobject.LoginPage;
import Yelp.pageobject.MainPage;
import net.thucydides.core.annotations.Steps;

public class YelpUser {

    @Steps(shared = true)
    MainPage mainPage;
    @Steps(shared = true)
    LoginPage loginPage;
    @Steps(shared = true)
    BurgerMenu burgerMenu;

    public void navigatesTo(){
        loginPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        loginPage.open();
    }

    public void loginAsStandard(){
        loginPage.loginAsStandard();
    }

    public void navigateToAboutPage(){
        burgerMenu.showBurgerMenu();
        burgerMenu.goToAboutPage();
    }

    public void navigateToProductPage(){
        burgerMenu.goBack();
    }
}
