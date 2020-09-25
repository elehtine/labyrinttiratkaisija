# Viikkoraportti 3

## Projekti
Lisätty luokka joka ratkaisee labyrintteja seuraamalla aina oikeanpuoleista seinämää. Koodista ei välttämättä näe ideaa miksi se toimii joten selitän sen ainakin tässä.

Algoritmi luottaa siihen että labyrintit ovat muodostettu siten, että risteyksiä voi olla tasan joka toisessa ruudussa. Jos haluaa seurata oikean puoleista seinämää jatketaan aina mahdollisimman oikealla. Eli jos mahdollista käännytään oikealle. Jos se ei ole mahdollista jatketaan suoraan. Jos suoraankaan ei voida jatkaa yritetään kääntyä vasemmalle. Jos vasemmallekaan ei pääse ollaan umpikujassa ja käännytään takaisin tulosuuntaan päin.


## Arkkitehtuuri
Labyrintin ratkaisevat luokat voisivat laajentaa (extend) Labyrintti luokan. Ne tarvitsevat luokasta kaiken tiedon. Nykyinen ratkaisu on kuitenkin toimiva. Harkitsen tätä jos vaikuttaa tarpeelliselta.
