import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoMation {

    WebDriver driver;

    @Before
    public void browser() {

        String baseUrl = "http://automationpractice.com/index.php";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
        @Test
                public void verifyDisplayErrorMessage(){
            driver.findElement(By.xpath("//a[@class='login']")).click();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vrajeshpatel13583@yahoo.com");
            driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("abcd1234");
            driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
            String expectErrorMessage = "There is 1 error";

            WebElement errorMessage = driver.findElement(By.xpath("//p[text()='There is 1 error']"));
            String actualErrorMessage = errorMessage.getText();//This is actual error message from web site
            Assert.assertEquals("Error message not display", expectErrorMessage, actualErrorMessage);

        }









    }




