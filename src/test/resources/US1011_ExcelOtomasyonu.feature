Feature: US1011 Excel otomasyonu

  @wip
  Scenario: TC17 kullanici excel dosyasini testlerde kullanabilmeli

    Given kullanici excel dosyasini kullanabilecegi ayarlari yapar
    Then indexi 5 olan satirdaki indexi 3 olan hucreyi yazdirir
    And baskenti "Ankara" olan ulkenin ingilizce ismini yazdirir
    And Ulke sayisininin 190 oldugunu test eder
    And Fiziki olarak kullanilan satir sayisinin 191 oldugunu test eder
    And baskenti "Amsterdam" olan ulkenin tum bilgilerini yazdirir
