package Screens;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class P03_CartPage {
    public AndroidDriver androidDriver;

    // create constructor to initiliaze elements
    public P03_CartPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    // locate elements use By way
    private final By first_productTitle = By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productName'])[1] ");
    private final By second_productTitle = By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productName'])[2]");
    private final By price_of_first_product  = By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productPrice'])[1]");
    private final By price_of_second_product  = By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productPrice'])[2]");
    private final By total_amount  = By.xpath("//*[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']");

    // method to assert that the two products are displayed im the cart page
    public P03_CartPage productIsDisplayed(){
        Assert.assertTrue(androidDriver.findElement(first_productTitle).isDisplayed());
        Assert.assertTrue(androidDriver.findElement(second_productTitle).isDisplayed());
        return this;
    }

    //method for verify the total amount of the two products are equal the sum of two products
    public void verifyTotalAmount() {

        // Locate product price elements
        String product1 = androidDriver.findElement(price_of_first_product).getText().replace("$", "").trim();
        String product2 = androidDriver.findElement(price_of_second_product).getText().replace("$", "").trim();
        String totalAmount = androidDriver.findElement(total_amount).getText().replace("$", "").trim();

        // Extract and clean text values
        float  price1 =  Float.parseFloat(product1);
        float  price2 =  Float.parseFloat(product2);
        float expectedTotal = price1 + price2;

        // Extract and clean total amount value
        float actualTotalPrice = Float.parseFloat(totalAmount);

        // Assertion for verify the total amount equals the sum of two products value
        Assert.assertEquals(expectedTotal,actualTotalPrice,0);
    }
}
