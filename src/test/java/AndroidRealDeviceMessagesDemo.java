import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidRealDeviceMessagesDemo {
    private AppiumDriver driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9.0");
        caps.setCapability("deviceName","Sayed Shabaan");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void clickOnAppButton(){
        // Find the most recent message element
        MobileElement recentMessage = (MobileElement) driver.findElement(
                By
                        .xpath("//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[2]"));

        // Get the text value of the most recent message
        String messageText = recentMessage.getText();
        System.out.println("The most recent message is: " + messageText);
        String[] words = messageText.split(" "); // split the string into an array of words
        String word = words[4]; // get the 4 word ("9233")

        int letter1 =Character.getNumericValue(word.charAt(0)) ; // get the second letter ("9")
        int letter2 = Character.getNumericValue(word.charAt(1)); // get the second letter ("2")
        int letter3 = Character.getNumericValue(word.charAt(2)); // get the second letter ("3")
        int letter4 = Character.getNumericValue(word.charAt(3)); // get the second letter ("3")
        System.out.println(letter1 + "\n" +letter2 + "\n" +letter3 + "\n" + letter4);


    }

    @AfterTest
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
