package todoApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TaskListPage extends PageBase {

    public TaskListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(id="fab")
    private MobileElement addButton;

    public void clickOnAddButton(){
        clickOn(addButton);
    }
}
