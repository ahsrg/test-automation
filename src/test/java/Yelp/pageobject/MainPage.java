package Yelp.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage extends PageObject {

    @FindBy(xpath="//*[@class=\"product_sort_container\"]")
    WebElementFacade buttonFilter;

    @FindBy(xpath = "//*[@class=\"btn btn_primary btn_small btn_inventory\"]")
    List<WebElementFacade> buttonsToAdd;

    @FindBy(xpath="//*[@class=\"shopping_cart_badge\"]")
    WebElementFacade shoppingCartBadge;

    @FindBy(xpath="//*[@class=\"shopping_cart_link\"]")
    WebElementFacade buttonShoppingCart;

    static String buttonAddToCardClass = "btn btn_primary btn_small btn_inventory";

    static List<WebElementFacade> addToCardButtons;

    public void showFilterOptions(){
        buttonFilter.click();
    }

    public void selectFilter(String sortBy){
        Select select = new Select(buttonFilter);
        select.selectByVisibleText(sortBy);
    }

    public void addProducts(Integer quantity){
        while (quantity > 0 ){
            buttonsToAdd.get(quantity-1).click();
            quantity--;
        }
    }

    public void shoppingCartHaveNProducts(String quantity){
        Assert.assertEquals(shoppingCartBadge.getText(), quantity);
    }

    public void goToShoppingCart(){
        buttonShoppingCart.click();
    }
}
