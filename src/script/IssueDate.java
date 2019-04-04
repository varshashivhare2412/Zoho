package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class IssueDate extends BaseTest{
	@Test(priority=3)
	public void testValidLogin() throws InterruptedException {
		String un=XL.getData(XL_PATH,"IssueDate",1,0);
		String pw=XL.getData(XL_PATH, "IssueDate", 1,1);
		String idate=XL.getData(XL_PATH,"IssueDate", 1,2);
		
		//Enter valid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		
		//Enter valid password
		l.setPassword(pw);
		
		//click on login button
		l.clickLogin();
		
		// click on settings
		Thread.sleep(2000);
		EnterTimeTrackPage ett= new EnterTimeTrackPage(driver);
		ett.clickSettings();
		
		// click on licenses
		ett.clickLicenses();
		
		// verify issue date
		LicensePage lp= new LicensePage(driver);
		lp.verifyIssueDate(idate);
}
}

