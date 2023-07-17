package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoExercisePage {

    public AutoExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

        @FindBy(xpath = "//*[@class='fa fa-lock']")
        public WebElement ilkSignupButonu;

        @FindBy(xpath = "//input[@name='name']")
        public WebElement nameKutusu;

        @FindBy(xpath = "//input[@data-qa='signup-email']")
        public WebElement emailKutusu;

        @FindBy(xpath = "//*[@data-qa='signup-button']")
        public WebElement signUpButonu;

        @FindBy(xpath = "//*[@id='id_gender1']")
        public WebElement genderRadioButton;
}
