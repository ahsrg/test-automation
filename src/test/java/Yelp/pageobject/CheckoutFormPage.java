package Yelp.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.yecht.Data;

import java.util.List;

public class CheckoutFormPage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade inputFirstName;

    @FindBy(id = "last-name")
    WebElementFacade inputLastName;

    @FindBy(id = "postal-code")
    WebElementFacade inputPostalCode;

    @FindBy(id = "continue")
    WebElementFacade buttonContinue;

    @FindBy(id = "finish")
    WebElementFacade buttonFinish;

    @FindBy(xpath = "//*[@class=\"summary_info_label\"][1]")
    WebElementFacade textPaymentInfo;

    @FindBy(xpath = "//*[@class=\"summary_value_label\"][1]")
    WebElementFacade textPaymentValue;

    @FindBy(xpath = "//*[@class=\"summary_info_label\"][2]")
    WebElementFacade textShippingInfo;

    @FindBy(xpath = "//*[@class=\"summary_value_label\"][2]")
    WebElementFacade textShippingValue;

    @FindBy(xpath = "//*[@class=\"summary_info_label\"][3]")
    WebElementFacade textPriceInfo;

    @FindBy(xpath = "//*[@class=\"summary_subtotal_label\"]")
    WebElementFacade textSubTotal;

    @FindBy(xpath = "//*[@class=\"summary_tax_label\"]")
    WebElementFacade textTaxValue;

    @FindBy(xpath = "//*[@class=\"summary_info_label summary_total_label\"]")
    WebElementFacade textTotalValue;

    @FindBy(xpath = "//*[@class=\"complete-header\"]")
    WebElementFacade textHeader;

    @FindBy(xpath = "//*[@class=\"complete-text\"]")
    WebElementFacade textComplete;

    static String firstName = "Maria";
    static String lastName = "Scott";
    static String postalCode = "34567";
    static String successHeader = "Thank you for your order!";
    static String successText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    public void completeStepOne(){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        buttonContinue.click();
    }

    public void completeStepTwo(){
        buttonFinish.click();
    }

    public void compareTotalPrice(Double totalPrice){
        Double subTotal = Double.parseDouble(textSubTotal.getText().replace("Item total: $",""));
        Assert.assertEquals(subTotal, totalPrice);
    }
    public void summaryReport(){
        String summary = textPaymentInfo.getText() + ": " + textPaymentValue.getText() + "\n" +
                textShippingInfo.getText() + ": " + textShippingValue.getText() + "\n" +
                textPriceInfo.getText() + "\n" +
                "   " + textSubTotal.getText() + "\n" +
                "   " + textTaxValue.getText() + "\n" +
                textTotalValue.getText();
        Serenity.recordReportData().withTitle("Checkout summary").andContents(summary);
    }

    public void successMessage(){
        Assert.assertEquals(textHeader.getText(), successHeader);
        Assert.assertEquals(textComplete.getText(), successText);
    }
}
