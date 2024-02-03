
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

public class Draganddrop {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Launch the webdriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }
    @Test
    public void drag_drop() throws InterruptedException {
        //Launch the website
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        //Locating source and target element
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Thread.sleep(3000);
        //To perform drag and drop actions
        Actions a= new Actions(driver);
        a.dragAndDrop(drag,drop).perform();

        //To verify the colour property
        String colourafterdrop=drop.getCssValue("color");
        //System.out.println(colourafterdrop);
        Assert.assertEquals(colourafterdrop,"rgba(119, 118, 32, 1)");

        //To verify the text
        String text=drop.getText();
        Assert.assertEquals(text,"Dropped!");


    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }

}
