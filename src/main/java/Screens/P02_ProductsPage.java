package Screens;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.time.Duration;

public class P02_ProductsPage {
    public AndroidDriver androidDriver;

    // create constructor to initiliaze elements
    public P02_ProductsPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    // locate elements use By way
    private final By first_addtocart_btn  = By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]");
    private final By second_addtocart_btn  = By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]");
    private final By cartIcon = By.xpath("//*[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']");


    // method for navigate to cart page
    public P03_CartPage navigateToCartPage() {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        androidDriver.findElement(first_addtocart_btn).click();
        androidDriver.findElement(second_addtocart_btn).click();
        androidDriver.findElement(cartIcon).click();

        return new P03_CartPage(androidDriver);
    }
}
