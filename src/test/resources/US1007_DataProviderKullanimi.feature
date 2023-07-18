Feature: Amazonda verilen toplu olarak verilen kelimeleri aratir


  Scenario Outline: TC13 Kullanici listedeki tum urunler icin testi tekrarlayabilmeli

    Given kullanici "amazonUrl" anasayfaya gider
    Then arama kutusuna "<aranacakKelime>" yazip, ENTER tusuna basar
    And 10 saniye bekler
    And arama sonuclarinin "<aranacakKelime>" icerdigini test eder
    Then sayfayi kapatir

    Examples:
    |aranacakKelime |
    |Java           |
    |Nutella        |
    |Samsung        |
    |Cannes         |
    |Nederland      |

