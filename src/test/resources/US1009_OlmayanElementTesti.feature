Feature: US1009 kullanici olmayan bir webelementi test eder


  Scenario: TC15 olmayan butonu test edebilmeli

    Given kullanici "heroqaurl" anasayfaya gider
    When Add Element butonuna basar
    And Delete butonu gorununceye kadar bekler
    Then Delete butonunun gorunur oldugunu test eder
    And Delete butonuna basarak butonu siler
    And Delete butonunun gorunmedigini test eder
    Then sayfayi kapatir
