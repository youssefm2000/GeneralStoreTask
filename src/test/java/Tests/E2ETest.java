package Tests;
import Base.BaseTest;
import Data.DataReader;
import Screens.P01_HomePage;
import Screens.P02_ProductsPage;
import Screens.P03_CartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import java.io.IOException;

public class E2ETest extends BaseTest {

     public P01_HomePage homePage;
     public P02_ProductsPage productsPage;
     public P03_CartPage cartPage;

    @Test
    @Epic("add two products in cart")
    @DisplayName("E2E Checkout Flow")
    @Description("This test verifies the end-to-end checkout process.")
    public void e2EScenario() throws IOException, ParseException {

    DataReader dataReader = new DataReader();
    dataReader.reader();

    homePage = new P01_HomePage(androidDriver);
    homePage.navigateToProductsPage(dataReader.name);

    productsPage = new P02_ProductsPage(androidDriver);
    productsPage.navigateToCartPage();

    cartPage = new P03_CartPage(androidDriver);
    cartPage.productIsDisplayed();
    cartPage.verifyTotalAmount();
    }
}
