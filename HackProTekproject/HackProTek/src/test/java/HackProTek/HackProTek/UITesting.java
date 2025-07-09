package HackProTek.HackProTek;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UITesting {
	WebDriver driver;
	
	public UITesting(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/main/header/div/img")
	WebElement logoElement;
	
	@FindBy(xpath="//*[@id='serviceRating']")
	WebElement sliderElement;
	
	@FindBy(xpath="/html/body/main/div/h2")
	WebElement headerElement;
	
	public boolean isLogoDisplayed() {
		return logoElement.isDisplayed();
	}
	
	public boolean isSliderDisplayed() {
		return sliderElement.isDisplayed();
	}
	
	public boolean isHeaderDisplayed() {
		return headerElement.isDisplayed();
	}
}
