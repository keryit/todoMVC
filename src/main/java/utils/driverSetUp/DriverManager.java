package utils.driverSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {

    public static WebDriver createInstance(DriverType browser) {

        if (DriverType.CHROME == browser) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (DriverType.FIREFOX == browser) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
    }
}
