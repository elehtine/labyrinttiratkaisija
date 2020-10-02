# Määrittelydokumentti

Työni koodi ja dokumentaatio on suomeksi. Versionhallinta on englanniksi. Opinto-ohjelmani on tietojenkäsittelytieteen kandidaatti (TKT).

## Kuvaus
Työni käsittelee labyrinttien ratkaisuja. Tarkoitus on ratkaista sekä labyrinttejä jossa tietää vaan reitit joissa on käynyt, sekä labyrintteja joista tietää kaikki reitit. Teen jonkin UI:n jolla yritän havainnollistaa miten labyrintti ratkaistaan tietyllä tavalla.

## Syöte
Lisäksi ohjelman kannalta taitaa olla järkevää toteuttaa labyrinttien luomisen hoitavia algoritmeja.

Labyrinttien tallentamiseen olen miettinyt kahta tapaa. Joko merkeillä kuvataan onko kohta seinää vai kulkureittiä.lisäksi lähtö on l-kirjain ja maali on m-kirjain.  
Esimerkki:  
``#####``  
``#l#.#``  
``#...#``  
``##m##``  
``#####``

Toinen tapa on kertoa mihin suuntaan reitistä saa kulkea neljän tosi/epätosi muuttujan avulla, jotka kuvaavat voiko liikkua oikealle, alas, vasemmalle vai ylös. Tämän voi tallentaa myös kokonaislukumuuttujaan, missä jokainen binäärilukubitti kertoo voiko liikkua. 1001 = 9 tarkoittaa, että voi liikkua oikealle ja ylös. Maali ja lähtö pitää antaa erikseen.  
Esimerkki:  
``l=0,0``  
``m=1,2``  
``2  0  2``  
``9  7 12``  
``0  8  0``

Tulen käyttämään ainakin ensimmäistä tapaa

## Algoritmit

### Labyrinttien ratkaisu
Tarkoitus on toteuttaa ainakin osa seuraavista algoritmeista joissa liikutaan labyrintissa:
 - seinän seuraaminen
 - satunnainen liikkuminen
 - Tremauxin menetelmä

ja algoritmeista joissa lähdetään samanaikaisesti moneen suuntaan tai tunnetaan labyrintti etukäteen:
 - leveyshaku
 - leveyshaku jollakin heuristiikalla

### Labyrinttien luonti
Tulen aluksi generoimaan labyrintteja siten, että ne tallentuvat yllä kuvatulla ensimmäisellä tavalla. Kaikki ruudut joiden x ja y koordinaatit ovat parillisia tulee olemaan aluksi käytäviä. Tämä helpottaa labyrinttien luomista. Näiden käytävien välissä olevat ruudut joko yhdistää käytävät tai toimivat seininä. Sen sijaan ruudut joiden x ja y koordinaatit ovat parittomia tulevat aina olemaan seinämää. Alueen ympäri kulkee aina seinämä. Algoritmeilla tullaan luomaan varmaan pelkästään labyrintteja joissa ei ole syklejä. Syklit tullaan lisäämään jälkikäteen näillä näkymin.  
Tulen toteuttamaan seuraavienlaisia algoritmeja labyrinttien luomiseen:  
 - Syvyyshakuun perustuva, lisätään reittejä uuden reitin perään kunnes tulee seinämä vastaan. Tämän jälkeen peruutetaan ja jatketaan muualla
 - Kruskalin algoritmiin perustuva luonti, lisätään labyrinttiin seinämiä satunnaisessa järjestyksessä siten, että ei tule syklejä
 - Primin algoritmiin perustuva luonti. Samankaltainen kuin edellinen, mutta lähtee alusta ja kaikki seinämät lähtevät yhtenäisestä alueesta
