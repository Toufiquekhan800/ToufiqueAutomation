package TestCase;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS002_AccountLogin extends  BaseClass{


    @Test(dependsOnMethods = "Verify_Registration", groups = {"regression", "master"})
    public void Verify_Login() throws InterruptedException {

        logger.info("***LogIn Test Case Start***");
        LoginPage LgPage = new LoginPage(driver);
        logger.info("***Filled the userName***");
        LgPage.setLoginUsername("imtrying72442@mail.om");
        logger.info("***Filled the Password***");
        LgPage.setLoginPassword("Alex@1234569");
        logger.info("***Logging***");
        LgPage.clickLogin();

        HomePage HP = new HomePage(driver);
        HP.SingOut_validation();
        Assert.assertEquals(HP.SingOut_validation(), "Sign Out");
        logger.info("***LogIn TestCase excecuted***");
    }

    }
