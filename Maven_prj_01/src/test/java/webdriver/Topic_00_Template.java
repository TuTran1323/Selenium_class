package src.test.java.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

	public class Topic_00_Template {
		WebDriver driver;

		@BeforeClass
		public void beforeClass() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}

		@Test
		public void TC_01() {
			
		}

		@AfterClass
		public void afterClass() {
			driver.quit();
		}

	}
