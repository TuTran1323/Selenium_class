package src.test.java.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BTVN_02_DragAndDrop {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void Drag_n_Drop() throws InterruptedException {
        //Mở link
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        //Action
        WebElement smallcicle = driver.findElement(By.id("draggable"));
        WebElement bigcicle = driver.findElement(By.id("droptarget"));
        Actions action = new Actions(driver);
        action.dragAndDrop(smallcicle, bigcicle).perform();
        Thread.sleep(3000);

        //Check kq
        //Assert.assertEquals("You did great!", bigcicle.getText());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
