package todoAppTest.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import todoApp.CreateTaskPage;
import todoApp.TaskListPage;
import todoAppTest.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskStd extends TestBase {
    private CreateTaskPage createTaskPage;
    private TaskListPage taskListPage;

    @Given("The app is opened.")
    public void theAppIsOpened() throws MalformedURLException {
        android_SetUp();
    }

    @When("Click on add button.")
    public void clickOnAddButton() {
        createTaskPage= new CreateTaskPage(getAppiumDriver());
        taskListPage =new TaskListPage(getAppiumDriver());
        taskListPage.clickOnAddButton();
    }

    @And("Enter Task name.")
    public void enterTaskName() {
        createTaskPage.setTitle("hello from cucumber");
    }

    @And("Enter Task Description.")
    public void enterTaskDescription() {
        createTaskPage.typeNote("i am learning cucumber");
    }

    @And("Click on save button.")
    public void clickOnSaveButton() {
        getAppiumDriver().hideKeyboard();
        createTaskPage.clickOnSaveBtn();
    }

    @Then("The Task will be created and saved.")
    public void theTaskWillBeCreatedAndSaved() {
        teardown();
    }
}
