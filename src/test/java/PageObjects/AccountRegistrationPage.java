package PageObjects;

import TestCase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }




    //locator
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement name;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement last_name;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement mail;

    @FindBy(xpath = "//input[@id='userMobile']")
    WebElement userMobile;

    @FindBy(xpath = "//input[@value='Male']")
    WebElement gender;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement setPassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//input[@id='login']")
    WebElement ClickRegistrationBtn;

    @FindBy(xpath = "//h1[normalize-space()='Account Created Successfully']")
    WebElement SuccessConfirmation;




    //method
    public void SetName(){
        name.sendKeys("Alex4997");
    }
    public void SetLastName(){
        last_name.sendKeys("Rapp909870");
    }
    public void SetMail(){
        mail.sendKeys("imtrying04082@mail.com");
    }
    public void setMobileNumber(){
        userMobile.sendKeys("9859647719");
    }
    public void setGender(){
        gender.click();
    }
    public void SetPassword(){
        setPassword.sendKeys("Alex@9995080");
    }
    public void confirmPassword(){
        confirmPassword.sendKeys("Alex@9995080");
    }

    public void checkBox(){
        checkbox.click();
    }
    public void ClickRegistration(){
        ClickRegistrationBtn.click();
    }


    public String MessageConfirmation(){
        try {
            return (SuccessConfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }





}
