package HackProTek.HackProTek;

/*
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
 
public class Linearcode {
	static WebDriver driver;
	
	public static void main(String args[]) {
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        String baseUrl = "https://methilesh4.github.io/activity1/";
        driver.get(baseUrl);
		
		driver.findElement(By.xpath("//*[@id=\"billAmount\"]")).sendKeys("200000");
		
		WebElement slide = driver.findElement(By.xpath("//*[@id=\"serviceRating\"]"));
		
		Actions a = new Actions(driver);
		
		a.dragAndDropBy(slide, 1, 15).perform();
		
		driver.findElement(By.xpath("//*[@id=\"numPeople\"]")).sendKeys("5");
	}
}*/

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Linearcode {
    static WebDriver driver;

	public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        String baseUrl = "https://methilesh4.github.io/activity1/";
        driver.get(baseUrl);

        driver.findElement(By.xpath("//*[@id=\"billAmount\"]")).sendKeys("200000");

        WebElement slide = driver.findElement(By.xpath("//*[@id=\"serviceRating\"]"));

        // Use JavaScript to set the slider value directly and trigger the change event
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i <= 10; i++) {
            js.executeScript("arguments[0].value='" + i + "';", slide);
            js.executeScript("arguments[0].dispatchEvent(new Event('input'));", slide); // Trigger the input event
            try {
                Thread.sleep(500); // Wait for half a second before moving to next position (optional)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


			int currentValue = Integer.parseInt(slide.getAttribute("value"));
            System.out.println("Current Slider Value: " + currentValue);
        }

        driver.findElement(By.xpath("//*[@id=\"numPeople\"]")).sendKeys("5");
        driver.quit();
    }
}

