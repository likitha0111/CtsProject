package Homepage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	
	WebDriver driver;
	
	@FindBy(id = "billAmount")
	WebElement billAmountElement;
	
	@FindBy(id = "serviceRating")
	WebElement setRatingElement;
	
	@FindBy(id = "numPeople")
	WebElement noOfPeopleElement;
	
	@FindBy(xpath = "/html/body/main/div/button[1]")
	WebElement calculateButtonElement;
	
	@FindBy(id = "tipAmount")
	WebElement tipAmountElement;
	
	@FindBy(id = "totalAmount")
	WebElement totalAmountElement;
	
	@FindBy(id = "shareAmount")
	WebElement perPersonShareElement;
	
	@FindBy(xpath = "//*[@id=\"gpay\"]")
	WebElement showQRElement;
	
	@FindBy(xpath = "//*[@id=\"qrcode\"]/img")
	WebElement QRCodeElement;
	
	@FindBy(xpath = "//*[@id=\"id01\"]/div/span")
	WebElement closeElement;
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void billAmount(String num)
    {
    	billAmountElement.clear();
    	billAmountElement.sendKeys(num);
    }
    public void sliderCheck(String num)
    {	setRatingElement.clear();
    	int num1 = Integer.parseInt(num);
    	for(int i=1;i<num1;i++)
    	{
    		setRatingElement.sendKeys(Keys.ARROW_RIGHT);
    	}
    }
    public void numofPeople(String num)
    {
    	noOfPeopleElement.clear();
    	noOfPeopleElement.sendKeys(num);
    }
	
    public void clickCalculate()
    {
    	calculateButtonElement.click();
    }
    
    public String displayTipAmount()
    {
    	
    	if(tipAmountElement.isDisplayed())
    	{
    		return tipAmountElement.getText();
    	}
    	return null;
    }
    
    public String displayBillAmount()
    {
    	if(totalAmountElement.isDisplayed())
    	{
    		return totalAmountElement.getText();
    	}
    	return null;
    }
    
    public String displayPerPersonShare()
    {
    	if(perPersonShareElement.isDisplayed())
    	{
    		return perPersonShareElement.getText();
    	}
    	return null;
    }
    
    public void showQR()
    {
    	showQRElement.click();
    }
    
    public boolean checkQRCode()
    {
    	if(QRCodeElement.isDisplayed())
    	{
    		return true;
    	}
    	return false;
    }    
    
    public void closeQR()
    {
    	closeElement.click();
    }

//	public boolean isQrCodeDisplayed() {
//		WebElement Qr = driver.findElement(xpath("//*[@id=\"qrcode\"]/img"));
//		
//		return Qr.isDisplayed();
//	}
}
