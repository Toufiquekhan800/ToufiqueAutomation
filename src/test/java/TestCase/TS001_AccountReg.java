package TestCase;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TS001_AccountReg extends BaseClass{


    @Test(groups = {"sanity", "master"})
    public void Verify_Registration() throws InterruptedException {

        logger.info("**Test TS001_AccountReg start**");
        HomePage Hpage = new HomePage(driver);
        logger.info("**Click on Registration**");
        Hpage.ClickReg();

        AccountRegistrationPage AcctPage = new AccountRegistrationPage(driver);
        AcctPage.SetName();
        AcctPage.SetLastName();
        AcctPage.SetMail();
        AcctPage.setMobileNumber();
        AcctPage.setGender();
        AcctPage.SetPassword();
        AcctPage.confirmPassword();
        AcctPage.checkBox();
        logger.info("**Click on Register**");
        AcctPage.ClickRegistration();


        AcctPage.MessageConfirmation();
        Assert.assertEquals(AcctPage.MessageConfirmation(), "Account Created Successfully");
        System.out.println("Test end");
        logger.info("**test reg end**");


    }



}
