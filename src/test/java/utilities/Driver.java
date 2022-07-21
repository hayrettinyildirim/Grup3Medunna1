package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    static WebDriver driver;
    public static WebDriver getDriver(){

        if (driver==null){

            switch (ConfigurationsReader.getProperty("browser")) {
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver =new FirefoxDriver();
                    break;

                case "safari":
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver =new SafariDriver();
                        break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver =new InternetExplorerDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       return driver;


    }
    public static void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void bekle(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}



