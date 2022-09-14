import Browser.Browser;
import Browser.Info;
import Pages.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class baseTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = Browser.getDriver();
        driver.navigate().to(Info.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);}
        driver.close();
        driver.quit();
    }
    public homePage statLoginPage(){

        return PageFactory.initElements(driver, homePage.class);
    }
}
