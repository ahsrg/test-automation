package Yelp.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends PageObject {

    @FindBy(id="react-burger-menu-btn")
    WebElementFacade buttonBurgerMenu;

    @FindBy(id="about_sidebar_link")
    WebElementFacade linkAbout;

    public void showBurgerMenu(){
        buttonBurgerMenu.click();
    }

    public void goToAboutPage(){
        linkAbout.click();
    }

    public void goBack(){
        getDriver().navigate().back();
    }

}
