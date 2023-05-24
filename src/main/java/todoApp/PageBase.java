package todoApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    private final AppiumDriver appiumDriver;
    private static final long waitTime=10;

    public PageBase(AppiumDriver appiumDriver){
        this.appiumDriver=appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);

    }

    public void waitForVisibility(MobileElement mobileElement){
        WebDriverWait wait = new WebDriverWait(appiumDriver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public void textFieldClear(MobileElement mobileElement){
        waitForVisibility(mobileElement);
        mobileElement.clear();
    }

    public void clickOn(MobileElement mobileElement){
        waitForVisibility(mobileElement);
        mobileElement.click();
    }

    public void sendKeys(MobileElement mobileElement, String text){
        waitForVisibility(mobileElement);
        mobileElement.sendKeys(text);
    }

    public String getAttributeValue(MobileElement mobileElement, String attributeKey){
        waitForVisibility(mobileElement);
        return mobileElement.getAttribute(attributeKey);
    }
}
