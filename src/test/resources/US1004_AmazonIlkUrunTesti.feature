Feature: US1004 Amazonda listeden ilk urunun dogru oldugunu test eder

  @toplu @smoke @screen
  Scenario: TC08 ilk urun ismi arattirdigimiz kelimeyi icermeli

    Given kullanici "amazonUrl" anasayfaya gider
    Then arama kutusuna "Nutella" yazip, ENTER tusuna basar
    When ilk urunu tiklar
    Then urun isminde "Kutella" oldugunu test eder
    And sayfayi kapatir