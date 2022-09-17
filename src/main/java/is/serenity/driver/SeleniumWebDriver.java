package is.serenity.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumWebDriver {
    public static WebDriver driver;

    public static SeleniumWebDriver ChromeWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--star-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        return new SeleniumWebDriver();
    }

    public static WebDriver on(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

}
