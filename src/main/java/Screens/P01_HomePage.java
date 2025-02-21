package Screens;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_HomePage {
    public AndroidDriver androidDriver;

    // create constructor to initiliaze elements
    public P01_HomePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    // locate elements use By way
    private final By dropDown = By.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By nameField = By.id("com.androidsample.generalstore:id/nameField");
    private final By genderOption = By.id("com.androidsample.generalstore:id/radioMale");
    private final By btnLetsShop = By.id("com.androidsample.generalstore:id/btnLetsShop");

    // method for select country and add the username to switch for product page
    public P02_ProductsPage fillForm(String username) {
        androidDriver.findElement(dropDown).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()." +
                        "scrollable(true)).scrollIntoView(new UiSelector()." +
                        "text(\"Egypt\"))")).click();
        androidDriver.findElement(nameField).sendKeys(username);
        androidDriver.findElement(genderOption).click();
        androidDriver.findElement(btnLetsShop).click();

        return new P02_ProductsPage(androidDriver);
    }
}

