import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OneAppTest {
    private AppiumDriver driver;

    @BeforeAll
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/app-acc.apk");

        driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(30000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView")).click();
        Thread.sleep(50000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='My Vodafone log in")).click();
    }

//    @AfterAll
//    public void teardown() throws InterruptedException {
//        Thread.sleep(2000);
//        if (driver!=null){
//            driver.quit();
//        }
//    }
}
