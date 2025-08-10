package TestCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Parameters;


public class BaseClass {

    public  static  WebDriver driver;
    public Logger logger;
    Properties P;


    @BeforeMethod(groups = {"sanity", "regression", "master"})
    @Parameters({"os", "browser"})
    public void SetUp(String os, String browser) throws IOException {
        FileReader file= new FileReader("./src//test//resources//config.properties");
        Properties P = new Properties();
        P.load(file);
        logger = (Logger) LogManager.getLogger(this.getClass());

        switch (browser)
        {
            case "chrome" : driver = new ChromeDriver();break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default:
                System.out.println("Invalid browser"); return;
        }

        driver.get(P.getProperty("ApplicationURL"));
//        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String captureScreenShoot(String tname){

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File CaptureScreen = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir")+ "\\screenshots" + tname + " " + timestamp + ".png";
        File TargetFile = new  File(targetFilePath);

        CaptureScreen.renameTo(TargetFile);

        return targetFilePath;
    }
}
