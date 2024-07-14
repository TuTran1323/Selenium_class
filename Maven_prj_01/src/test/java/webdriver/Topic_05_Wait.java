import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Wait {

	WebDriver driver;
	By emailTxtbox = By.xpath("//input[@name='reg_email__']");
	By confirmEmailTxtbox = By.xpath("//input[@name='reg_email_confirmation__']");
	By registrationButton = By.xpath("//a[@data-testid='open-registration-form-button']");

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_02_Explicit_Visible_Invisible() {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(registrationButton).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailTxtbox));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(confirmEmailTxtbox));
		driver.findElement(emailTxtbox).sendKeys("abc@gmail.com");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmailTxtbox));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
