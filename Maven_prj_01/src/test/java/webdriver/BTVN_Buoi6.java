package src.test.java.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.Set;

import java.time.Duration;

public class BTVN_Buoi6 {
    WebDriver driver;
    WebDriverWait explicitWait;
    private java.lang.String String;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void EX_01() throws InterruptedException {
        // Mở link
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Bấm start
        driver.findElement(By.xpath("//div[@id='start']//child::button")).click();

        //Check kq
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']//child::h4")).getText(), "Hello World!");

    }

    @Test
    public void EX_02() throws InterruptedException {
        // Mở link
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Bấm start
        driver.findElement(By.xpath("//div[@id='start']//child::button")).click();

        //Check kq
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']//child::h4")).getText(), "Hello World!");

    }

    @Test
    public void EX_03() throws InterruptedException {
        // Mở link
        driver.get("https://skills.kynaenglish.vn/");

        //Mở chat iframe
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cs_chat_iframe")));
        driver.findElement(By.id("cs_chat_iframe")).click();

        //Chuyển vào chat iframe
        driver.switchTo().frame("cs_chat_iframe");

        //Click button Gửi tin nhắn
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bottom meshim_widget_widgets_Bottom bottom_medium desktop']//child::input")));
        driver.findElement(By.xpath("//div[@class='bottom meshim_widget_widgets_Bottom bottom_medium desktop']//child::input")).click();

        //So sánh kết quả
        String error = driver.findElement(By.xpath("//input[contains(@class,'input_name')]//following-sibling::div[@class='error_message meshim_widget_widgets_ErrorMessage ng-binding']")).getText();
        Assert.assertEquals(error, "Tên của bạn chưa được nhập");

        //Quay về màn hình chính
        driver.switchTo().defaultContent();

        //Web thay đổi cấu trúc nên ko cho phép search nữa ạ
    }

    @Test
    public void EX_04() throws InterruptedException {
        // 1. Truy cập trang
        driver.get("http://live.techpanda.org/");

        // 2. Click vào mobile tab
        driver.findElement(By.xpath("//li[@class='level0 nav-1 first']")).click();
        Thread.sleep(3000);

        // 3. Add sản phẩm Sony Xperia vào để compare
        driver.findElement(By.xpath("//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='actions']//child::ul//child::li[last()]//child::a")).click();

        // 4. Verify text hiển thị
        String xperia = driver.findElement(By.xpath("//li[@class='success-msg']//descendant::li//child::span")).getText();
        Assert.assertEquals(xperia, "The product Sony Xperia has been added to comparison list.");

        // 5. Add sản phẩm Samsung Galaxy
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//parent::h2//following-sibling::div[@class='actions']//child::ul//child::li[last()]//child::a")).click();

        // 6. Verify text hiển thị
        String samsung = driver.findElement(By.xpath("//li[@class='success-msg']//descendant::li//child::span")).getText();
        Assert.assertEquals(samsung, "The product Samsung Galaxy has been added to comparison list.");

        // 7. Nhấn Compare button
        driver.findElement(By.xpath("//button[@type = 'button' and @title = 'Compare']")).click();

        // 8. Switch qua cửa sổ mới
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // 9. Verify title cửa sổ mới
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle, "Products Comparison List - Magento Commerce");

        // 10. Đóng cửa sổ, chuyển về parent window
        driver.close();
        driver.switchTo().window(originalWindow);

        // 11. Nhấn nút Clear All và accept Alert
        driver.findElement(By.xpath("//button[@type = 'button' and @title = 'Compare']//following-sibling::a")).click();
        //alert bị bug ko mở lên được nên đoạn sau em chưa làm đc ạ

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
