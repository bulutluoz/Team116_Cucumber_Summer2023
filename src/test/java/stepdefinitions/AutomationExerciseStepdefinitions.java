package stepdefinitions;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutoExercisePage;
import utilities.Driver;

public class AutomationExerciseStepdefinitions {
    AutoExercisePage autoExercisePage = new AutoExercisePage();
    Faker faker = new Faker();


    @Given("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        autoExercisePage.ilkSignupButonu.click();
    }
    @Given("user Create an account bölümüne email adresi girer")
    public void user_create_an_account_bölümüne_email_adresi_girer() {


        autoExercisePage.nameKutusu.sendKeys(faker.name().username());
        autoExercisePage.emailKutusu.sendKeys(faker.internet().emailAddress());
    }
    @Given("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        autoExercisePage.signUpButonu.click();
    }
    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(autoExercisePage.genderRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();


    }
    @Given("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {

    }
    @Then("hesap olustugunu test edin")
    public void hesap_olustugunu_test_edin() {

    }
}
