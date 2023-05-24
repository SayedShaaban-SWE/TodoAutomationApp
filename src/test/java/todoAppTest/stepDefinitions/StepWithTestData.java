package todoAppTest.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import todoApp.CreateTaskPage;
import todoApp.TaskListPage;
import todoAppTest.TestBase;

import java.net.MalformedURLException;

public class StepWithTestData extends TestBase {
    private CreateTaskPage createTaskPage;
    private TaskListPage taskListPage;

    @Given("The app is opened2.")
    public void theAppIsOpened() throws MalformedURLException {
        android_SetUp();
    }

    @When("Click on add button2.")
    public void clickOnAddButton() {
        createTaskPage= new CreateTaskPage(getAppiumDriver());
        taskListPage =new TaskListPage(getAppiumDriver());
        taskListPage.clickOnAddButton();
    }

    @And("Enter please1 {string}.")
    public void enter1(String arg0) {
        createTaskPage.setTitle(arg0);
    }

    @And("Enter please2 {string}.")
    public void enter2(String arg0) {
        createTaskPage.typeNote(arg0);
    }

    @And("Click on save button2.")
    public void clickOnSaveButton() {
        getAppiumDriver().hideKeyboard();
        createTaskPage.clickOnSaveBtn();
    }

    @Then("The Task will be created and saved2.")
    public void theTaskWillBeCreatedAndSaved() {
        teardown();
    }


}
