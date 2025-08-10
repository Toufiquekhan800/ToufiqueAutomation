package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Register here']")
    WebElement reg;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginPage;

    //Sing Out button
    @FindBy(xpath = "//button[normalize-space()='Sign Out']")
    WebElement Sing_Out;

    public void ClickReg(){
        reg.click();
    }

    public void lickLogin(){loginPage.click();}

    public String SingOut_validation(){
        try {
            return(Sing_Out.getText());
        }
        catch (Exception e3){
            return (e3.getMessage());
        }
    }
}


