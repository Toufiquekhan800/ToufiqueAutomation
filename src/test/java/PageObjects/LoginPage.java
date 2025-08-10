package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement loginUserName;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement LoginPassword;

    @FindBy(xpath = "//input[@id='login']")
    WebElement Login;





    public void setLoginUsername(String mail){
        loginUserName.sendKeys(mail);
    }

    public void setLoginPassword(String password){
        LoginPassword.sendKeys(password);
    }

    public void clickLogin(){
        Login.click();
    }







}
