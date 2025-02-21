package Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver androidDriver;
    public AppiumDriverLocalService service;

    // method to start emulator
    @BeforeMethod
    @Step("Test Setup - Open the appium server and emulator")
    public void setUp() throws IOException {

        //code to start appium server automatic without manual command
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//youss//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
                 service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("YoussefElshemy");
        options.setApp(System.getProperty("user.dir")+"//src//test//java//Resources//General-Store.apk");
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // method to close emulator and the appium server
    @AfterMethod
    @Step("Test Teardown - close the appium server and emulator")
    public void tearDown() {
       androidDriver.quit();
       service.stop();
    }
}
