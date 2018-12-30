package utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.driverSetUp.DriverFactory;
import utils.driverSetUp.DriverManager;
import utils.driverSetUp.DriverType;

import static utils.Constant.DRIVER;
import static utils.Constant.URL;

public class SetUp {

    @BeforeTest
    public void setupClass() {
        DRIVER = DriverManager.createInstance(DriverType.CHROME);
        DriverFactory.setWebDriver(DRIVER);
        DRIVER.manage().window().maximize();
        DRIVER.get(URL);
    }


    @AfterTest
    public void tearDown() {
     //   DRIVER.manage().deleteAllCookies();
     //   DRIVER.quit();
    }
}
