package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "new-todo")
    @CacheLookup
    private WebElement todoFiled;

    @FindBy(id = "main")
    @CacheLookup
    public WebElement listOfTasks;

    @FindBy(id = "todo-list")
    @CacheLookup
    public WebElement listOfCompletedTasks;

    @FindBy(id = "todo-count")
    @CacheLookup
    public WebElement countOfItems;

    @FindBy(xpath = "//a[contains(text(),'All')]")
    @CacheLookup
    private WebElement allLnk;

    @FindBy(xpath = "//a[contains(text(),'Active')]")
    @CacheLookup
    private WebElement activeLnk;

    @FindBy(xpath = "//a[contains(text(),'Completed')]")
    @CacheLookup
    private WebElement completedLnk;

    @FindBy(xpath = "//button[@class='destroy']")
    @CacheLookup
    private WebElement btnDelete;

    public void createNewTask(String description) throws InterruptedException {
        todoFiled.click();
        todoFiled.sendKeys(description);
        Thread.sleep(2000);
        todoFiled.sendKeys(Keys.ENTER);
    }

    public void selectAll(){
        allLnk.click();
    }

    public void selectActive() {
        activeLnk.click();
    }

    public void selectCompleted() {
        completedLnk.click();
    }

    public void updateTask(String taskDescription, String updatedText) {
        Actions action = new Actions(driver);
        WebElement task = listOfTasks.findElement(By.xpath("//label[contains(text(),'" + taskDescription + "')]"));
        action.doubleClick(task).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(updatedText).sendKeys(Keys.ENTER).perform();
    }

    public void setAsCompleted(String taskDescription) {
        listOfTasks.findElement(By.xpath("//input[@type='checkbox' and @value='" + taskDescription + "']")).click();
    }

    public void deleteTask(String taskDescription) {
        Actions action = new Actions(driver);
        WebElement task = listOfTasks.findElement(By.xpath("//label[contains(text(),'" + taskDescription + "')]"));
        action.moveToElement(task).click();
        btnDelete.click();
    }


}
