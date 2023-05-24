package todoAppTest;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import todoApp.CreateTaskPage;
import todoApp.TaskListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class CreateTaskTest extends TestBase {
    private CreateTaskPage createTaskPage;
    private TaskListPage taskListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir")+"/data/TasksData.json","Tasks Data",2);
    }


    @Test(dataProvider="tasks data")
    public void createListTest(String taskName, String taskDesc) throws MalformedURLException {
        android_SetUp();
        createTaskPage= new CreateTaskPage(getAppiumDriver());
        taskListPage =new TaskListPage(getAppiumDriver());

        taskListPage.clickOnAddButton();
        createTaskPage.setTitle(taskName);
        createTaskPage.typeNote(taskDesc);
        getAppiumDriver().hideKeyboard();
        createTaskPage.clickOnSaveBtn();
        teardown();
    }
}
