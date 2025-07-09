package HackProTek.HackProTek;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pro.utilities.DataProviders;

public class Main extends BaseClass{
	
	@Test(dataProvider="inputData", dataProviderClass=DataProviders.class)
	public void homepagetest(String billam, String slider, String nuofpeople) throws InterruptedException 
	{
	    // Input values into the application
	    homepage.billAmount(billam);
	    homepage.sliderCheck(slider);
	    homepage.numofPeople(nuofpeople);
	    homepage.clickCalculate();

//	    boolean alertHandled = false;
	    try {
	        driver.switchTo().alert().accept();
//	        alertHandled = true;
	        // If alert is shown, it's expected for invalid input — test passes
//	        Assert.assertTrue(true, "Alert displayed and handled correctly.");
	        Assert.assertTrue(true," it is an valid inputs");
	    } catch (Exception e) {
	        // No alert was shown — now check if the input was invalid
	        boolean isBillValid = billam.matches("^(0|[1-9]\\d*)(\\.\\d+)?$");
	        boolean isPeopleValid = nuofpeople.matches("^[1-9]\\d*$");

	        if (!isBillValid || !isPeopleValid) {
	            // Invalid input but no alert — this is a bug
	            Assert.fail("Bug: Invalid input processed without alert. Bill = " + billam + ", People = " + nuofpeople);
	        } else {
	            // Valid input — proceed with result checks
	            System.out.println(homepage.displayTipAmount());
	            System.out.println(homepage.displayBillAmount());
	            System.out.println(homepage.displayPerPersonShare());
	            homepage.showQR();
	            System.out.println(homepage.checkQRCode());
	            homepage.closeQR();
	        }
	    }
	}
}
