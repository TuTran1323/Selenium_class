package src.test.java.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_selenium_api {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	public void TC_01_url() {
		// Mở tab
		driver.get("https://tiki.vn");

		// lấy title
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		// đóng tab
		driver.close();
	}

	@AfterClass
	public void afterClass() {
		// đóng browser
		driver.quit();
	}

	@Test
	public void TC_02_textbox() {
		// Mở 1 page
		driver.get("https://demo.nopcommerce.com/login?");	
		
		//viết vào field email
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc@gmail.com");
		//sleepInSeconds(5);
		//Thread.sleep(3000);
		driver.navigate();

		//đóng tab
		driver.close();
	}


}
