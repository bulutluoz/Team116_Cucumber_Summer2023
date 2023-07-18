package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelStepdefinitions {

    Workbook workbook;
    FileInputStream fis;
    Sheet sheet;
    String turkceBaskentIsmi;
    String ingilizceIsim;

    @Given("kullanici excel dosyasini kullanabilecegi ayarlari yapar")
    public void kullanici_excel_dosyasini_kullanabilecegi_ayarlari_yapar() throws IOException {
        String dosyaYolu = "src/test/resources/ulkeler.xlsx";
        fis = new FileInputStream(dosyaYolu);
        workbook = WorkbookFactory.create(fis);
        sheet = workbook.getSheet("Sayfa1");
    }
    @Then("indexi {int} olan satirdaki indexi {int} olan hucreyi yazdirir")
    public void indexi_olan_satirdaki_indexi_olan_hucreyi_yazdirir(Integer satirIndex, Integer sutunIndex) {

        System.out.println("Satir no : " + (satirIndex+1) +" ve sutun adi : " + ((char)(sutunIndex+65))
                            +" olan hucredeki bilgi : " +
                            sheet.getRow(satirIndex).getCell(sutunIndex));
    }
    @Then("baskenti {string} olan ulkenin ingilizce ismini yazdirir")
    public void baskenti_olan_ulkenin_ingilizce_ismini_yazdirir(String istenenBaskentIsmi) {

        boolean flag = true;

        for (int i = 0; i <= sheet.getLastRowNum() ; i++) {

            turkceBaskentIsmi = sheet.getRow(i).getCell(3).toString();

            if (turkceBaskentIsmi.equals(istenenBaskentIsmi)){

                System.out.println("Baskenti "+istenenBaskentIsmi+" olan ulke : "+ sheet.getRow(i).getCell(0));
                flag = false;
            }

        }

        if (flag) System.out.println("Baskenti " + istenenBaskentIsmi + " olan ulke yok...!");

    }
    @Then("Ulke sayisininin {int} oldugunu test eder")
    public void ulke_sayisininin_oldugunu_test_eder(int expectedUlkeSayisi) {

        int actualUlkeSayisi = sheet.getLastRowNum();
        // normalde getLastRowNum son satirin indexini verdigi icin 1 ekleriz
        // ama excelde baslik satiri da oldugundan ulke sayisi getLastRowNum'a esit olur
        Assert.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);
    }
    @Then("Fiziki olarak kullanilan satir sayisinin {int} oldugunu test eder")
    public void fiziki_olarak_kullanilan_satir_sayisinin_oldugunu_test_eder(int expectedFizikisatirsayisi) {

        int actualFizikiSatrSayisi = sheet.getPhysicalNumberOfRows();

        Assert.assertEquals(expectedFizikisatirsayisi,actualFizikiSatrSayisi);
    }
    @Then("baskenti {string} olan ulkenin tum bilgilerini yazdirir")
    public void baskenti_olan_ulkenin_tum_bilgilerini_yazdirir(String istenenUlkeBaskenti) {

        for (int i = 0; i <= sheet.getLastRowNum() ; i++) {

            turkceBaskentIsmi = sheet.getRow(i).getCell(3).toString();

            if (turkceBaskentIsmi.equals(istenenUlkeBaskenti)){

                System.out.println("Verilen baskent'e ait bilgiler :  " +
                        "\nIngilizce ulke ismi : " + sheet.getRow(i).getCell(0)+
                        "\nIngilizce baskent ismi : " + sheet.getRow(i).getCell(1)+
                        "\nTurkce ulke ismi : " + sheet.getRow(i).getCell(2)+
                        "\nTurkce baskent ismi : "+ sheet.getRow(i).getCell(3));
            }
        }
    }
}
