package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
    	File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apps/");
		File app = new File(appDir, "com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
		
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "bacon");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.ebay.mobile");
		capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
