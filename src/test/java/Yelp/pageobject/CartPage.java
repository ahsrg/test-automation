package Yelp.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(xpath = "//*[@class=\"cart_item\"]")
    List<WebElementFacade> cartItems;

    @FindBy(id = "checkout")
    WebElementFacade buttonCheckout;

    @FindBy(xpath = "//*[@class=\"inventory_item_price\"]")
    List<WebElementFacade> cartPrices;

    public void getCartItemsDetails(){
        String cartDetails = "";
        for (int i = 0; i < cartItems.size(); i++) {
            cartDetails += cartItems.get(i).getText() + "\n";
        }
        Serenity.recordReportData().withTitle("Shopping cart list").andContents(cartDetails);
    }

    public void clickCheckoutButton(){
        buttonCheckout.click();
    }

    public Double getTotalPrice(){
        Double totalPrice = 0.0;
        for (int i = 0; i < cartPrices.size(); i++) {
            totalPrice += Double.parseDouble(cartPrices.get(i).getText().replace("$",""));
        }
        return totalPrice;
    }
}
