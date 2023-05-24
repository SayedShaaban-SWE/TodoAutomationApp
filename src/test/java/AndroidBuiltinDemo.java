import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBuiltinDemo {
    private AppiumDriver driver;
    private SoftAssert softAssert;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void clickOnAppButton(){
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        softAssert=new SoftAssert();
        softAssert.assertEquals(result,10);
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
