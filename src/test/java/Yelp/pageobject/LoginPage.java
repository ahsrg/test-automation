package Yelp.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id="user-name")
    WebElementFacade inputUsername;

    @FindBy(id="password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade buttonLogin;

    static String standardUser = "standard_user";
    static String password = "secret_sauce";

    public void loginAsStandard(){
        inputUsername.sendKeys(standardUser);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

}
