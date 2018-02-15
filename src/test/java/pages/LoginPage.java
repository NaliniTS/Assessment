package pages;

import java.util.concurrent.TimeUnit;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
	
	String app_package_name = "com.ebay.mobile:id/";
	
	By signin_Button = By.id(app_package_name + "button_sign_in");
	By userId = By.id(app_package_name + "sign_in_username_entry");
    By password = By.id(app_package_name + "sign_in_password_entry");
    By login_Button = By.id(app_package_name + "sign_in_button");
    
    By search_Textbox = By.id(app_package_name + "search_box");
    By menu_searchbutton = By.id(app_package_name + "menu_search");
     

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage validLogin() {
        waitForVisibilityOf(signin_Button);
        driver.findElement(signin_Button).click();
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys("abc@xyz.com");
        driver.findElement(password).sendKeys("Password@123");
        driver.findElement(login_Button).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.id(app_package_name + "textview_deals")).getText().equalsIgnoreCase("textview_deals"));
        return new LoginPage(driver);
    }
    
    /***To Search for a product***/
	public void validSearch() {
		
		driver.findElement(search_Textbox).clear();
        driver.findElement(search_Textbox).sendKeys("Apple iPhone 6S Plus - 16 GB - GOLD");
        driver.findElement(menu_searchbutton).click();
        Assert.assertTrue(driver.findElement(By.id(app_package_name + " button_follow")).getText().equalsIgnoreCase("SAVE"));
    }
	
	/***To add a product in cart***/
	public void addToCart() {
		
		//To click on a product
		driver.findElement(By.id(app_package_name + "textview_item_title")).click();
		
		//To Scroll the window screen
		new BasePage(driver).scrollPageUp();
			
		//To click on ' But it Now ' button
		driver.findElement(By.id(app_package_name + "button_bin")).click();
		

		//To Scroll the window screen
		new BasePage(driver).scrollPageUp();
		
		//To click on ' Proceed To Pay' button
		driver.findElement(By.id(app_package_name + "proceedToPay")).click();
	}
    
    
}
