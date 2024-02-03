
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Facebook_signup {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Launch the webdriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }
    @Test
    public void facebook() throws InterruptedException {
        //Launch the website
        driver.get("https://www.facebook.com/");
        //Verify the title of the website
        Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");

        //Create new account
        WebElement ele=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        ele.click();
        Thread.sleep(5000);

        driver.findElement(By.name("firstname")).sendKeys("Rooban");//Enter first name
        driver.findElement(By.name("lastname")).sendKeys("Williams");//Enter last name
        driver.findElement(By.name("reg_email__")).sendKeys("roobanams@gmail.com");//Enter email id
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("roobanams@gmail.com");//Re-enter email id
        driver.findElement(By.name("reg_passwd__")).sendKeys("Keys@2001");//Enter password

        Select day=new Select(driver.findElement(By.id("day")));
        day.selectByValue("1");//Select day from the drop down
        Select month=new Select(driver.findElement(By.id("month")));
        month.selectByValue("1");//Select month from the drop down
        Select year=new Select(driver.findElement(By.id("year")));
        year.selectByValue("2000");//Select year from the drop down
        driver.findElement(By.xpath("//label[text()='Female']")).click();//Select Gender
        driver.findElement(By.name("websubmit")).click();//Click on Sign up button
        Thread.sleep(8000);
        //To verify the user is successfully registered on the website
        String name=driver.findElement(By.xpath("//span[text()='Rooban']")).getText();
        Assert.assertEquals(name,"Rooban");

    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }


}
