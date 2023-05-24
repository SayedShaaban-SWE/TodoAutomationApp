import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidRealDeviceDemo {
    private AppiumDriver driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9.0");
        caps.setCapability("deviceName","Sayed Shabaan");
        //caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void clickOnAppButton(){
        driver.findElementByAccessibilityId ("Facebook").click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Go to profile\"]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Profile picture\"]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"See profile picture\"]")).click();
        driver.closeApp();



    }

    @AfterTest
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
