package HackProTek.HackProTek;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Homepage.Homepage;

public class BaseClass {
	
	public static WebDriver driver;
	public Homepage homepage;
	@BeforeClass
	@Parameters("browser")
	public void setup(String str)
	{  
        switch(str.toLowerCase()) 
        {
        	case "chrome":
        		  ChromeOptions options = new ChromeOptions();
        		  options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        		  driver = new ChromeDriver();
        		  break;
        		  
        	case "edge":
        		  EdgeOptions options1 = new EdgeOptions();
        		  options1.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        		  driver = new EdgeDriver();
        		  break;
        		  
        }
      
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        String baseUrl = "https://methilesh4.github.io/activity1/";
        driver.get(baseUrl);
        homepage = new Homepage(driver);
	}
	 public  String captureScreen(String tname) throws IOException 
	 {
		 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 String filepath = "src/test/resource/screenshots/" + timeStamp() + tname + " newrep.png";
		 File dest = new File(filepath);
		 FileUtils.copyFile(src, dest);
		 return filepath;
	 }
	 
	public static String timeStamp() 
	{
	     return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
