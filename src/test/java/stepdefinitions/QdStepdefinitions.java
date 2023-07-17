package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.QdPage;
import utilities.ConfigReader;

public class QdStepdefinitions {

    QdPage qdPage = new QdPage();

    @Then("anasayfada login linkine click yapar")
    public void anasayfada_login_linkine_click_yapar() {
        qdPage.ilkLoginLinki.click();
    }
    @Then("email kutusuna {string} yazar")
    public void email_kutusuna_yazar(String istenenUserName) {
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty(istenenUserName));
    }
    @Then("password kutusuna {string} yazar")
    public void password_kutusuna_yazar(String istenenPassword) {
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty(istenenPassword));
    }
    @When("login butonuna basar")
    public void login_butonuna_basar() {
        qdPage.loginButonu.click();
    }
    @Then("basarili olarak giris yapildigini test eder")
    public void basarili_olarak_giris_yapildigini_test_eder() {
        Assert.assertTrue(qdPage.basariliGirisKontrolElementi.isDisplayed());
    }
}
