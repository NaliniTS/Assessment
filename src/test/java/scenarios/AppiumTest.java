package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void sucessLoginTest() throws InterruptedException {
        new LoginPage(driver).validLogin();
    }

    @Test
    public void searchTest() throws InterruptedException {
        new LoginPage(driver).validSearch();
    }
    
    @Test
    public void addToCartTest() throws InterruptedException {
        new LoginPage(driver).addToCart();
    }
    
    

}

