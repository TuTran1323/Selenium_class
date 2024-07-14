import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BTVN_03_Multiselect {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01() throws InterruptedException {
		// Mở link
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		//Actions
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.COMMAND).perform();
		elements.get(1).click();
		elements.get(2).click();
		action.keyUp(Keys.COMMAND).perform();
		Thread.sleep(5000);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}