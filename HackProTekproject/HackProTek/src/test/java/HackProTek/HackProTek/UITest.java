package HackProTek.HackProTek;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UITest {
	
	WebDriver driver;
	UITesting uitest;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://methilesh4.github.io/activity1/");
		
		uitest = new UITesting(driver);
	}
	
	
	@Test(priority = 1)
	public void isLogoDisplayedTest() {
		
		Assert.assertEquals(uitest.isLogoDisplayed(), true);
	}
	
	@Test(priority = 2)
	public void isSliderDisplayedTest() {
		
		Assert.assertEquals(uitest.isSliderDisplayed(), true);
	}
	
	@Test(priority = 3)
	public void isHeaderDisplayedTest() {
		
		Assert.assertEquals(uitest.isHeaderDisplayed(), true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}
