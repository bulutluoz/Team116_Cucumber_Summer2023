Feature: Amazonda verilen toplu olarak verilen kelimeleri aratir


  Scenario Outline: TC13 Kullanici listedeki tum urunler icin testi tekrarlayabilmeli

    Given kullanici "amazonUrl" anasayfaya gider
    Then arama kutusuna "<aranacakKelime>" yazip, ENTER tusuna basar
    And arama sonuclarinin "<aranacakKelime>" icerdigini test eder
    Then sayfayi kapatir

    Examples:
    |aranacakKelime|
    |Nutella |
    |Java    |
    |Samsung |
    |Cannes  |
    |Nederland|

