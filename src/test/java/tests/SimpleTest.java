package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.SetUp;

import static utils.Constant.DRIVER;

public class SimpleTest extends SetUp {

    private MainPage mainPage;

    @Test
    public void createNewTask() throws InterruptedException {
        mainPage = new MainPage(DRIVER);

        //1. Create new Task
        mainPage.createNewTask("Case1: implement new page for site");

        //2. Check that task is created, check count of items
        Assert.assertEquals(mainPage.listOfTasks.getText(), "Case1: implement new page for site");
        Assert.assertEquals(mainPage.countOfItems.getText(), "1 item left");

        //3. Select "Active" and verify that task visible
        mainPage.selectActive();
        Assert.assertEquals(mainPage.listOfTasks.getText(), "Case1: implement new page for site");

        //4. Select "Completed" and verify that list is empty
        mainPage.selectCompleted();
        Assert.assertNotEquals(mainPage.listOfTasks.getText(), "Case1: implement new page for site");

        //5. Creating more tasks
        mainPage.selectActive();
        mainPage.createNewTask("Case2: delete no needed comments");
        mainPage.createNewTask("Case3: add unit test");

        //6. Verify that tasks created, verify count of tasks
        Assert.assertEquals(mainPage.listOfTasks.getText(), "Case1: implement new page for site\n" +
                "Case2: delete no needed comments\n" +
                "Case3: add unit test");
        Assert.assertEquals(mainPage.countOfItems.getText(), "3 items left");

        //7. Update first task
        mainPage.updateTask("Case1: implement new page for site", "Updated: implement new page for site");

        //8. Verify that task updated
        Assert.assertEquals(mainPage.listOfTasks.getText(), "Updated: implement new page for site\n" +
                "Case2: delete no needed comments\n" +
                "Case3: add unit test");

        //9. Set first task as Completed
        mainPage.setAsCompleted("Case1: implement new page for site");

        //10. Verify count of items
        Assert.assertEquals(mainPage.countOfItems.getText(), "2 items left");

        //11.Go to Completed and verify that task under Completed
        mainPage.selectCompleted();
        Assert.assertEquals(mainPage.listOfTasks.getText(), "Updated: implement new page for site");

        //12. Update completed task
        mainPage.updateTask("Updated: implement new page for site", "Done: implement new page for site");

        //13. Verify that task updated
        Assert.assertEquals(mainPage.listOfCompletedTasks.getText(), "Done: implement new page for site");

        //14. Delete second task
        mainPage.deleteTask("Case2: delete no needed comments");

        //15. Verify list of all tasks
        mainPage.selectAll();
        Assert.assertEquals(mainPage.listOfTasks.getText(), "Case2: delete no needed comments\n" +
                "Case3: add unit test");








    }
}
