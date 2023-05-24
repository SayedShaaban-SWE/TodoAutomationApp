package todoApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateTaskPage extends PageBase{
    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id="editTextTitre")
    private MobileElement titleTextField;

    @AndroidFindBy(id="editTextNote")
    private MobileElement noteTextField;

    @AndroidFindBy(id="action_save")
    private MobileElement saveBtn;

    public void setTitle(String title){
        textFieldClear(titleTextField);
        sendKeys(titleTextField,title);

    }

    public void typeNote(String note){
        textFieldClear(noteTextField);
        sendKeys(noteTextField,note);

    }

    public void clickOnSaveBtn(){
        clickOn(saveBtn);
    }
}
