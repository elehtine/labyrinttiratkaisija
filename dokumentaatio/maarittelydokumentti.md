# Määrittelydokumentti

Työni on suomeksi. Opinto-ohjelmani on tietojenkäsittelytieteen kandidaatti (TKT).

## Kuvaus
Työni käsittelee labyrinttien ratkaisuja. Tarkoitus on ratkaista sekä labyrinttejä jossa tietää vaan reitit joissa on käynyt, sekä labyrinttejä joista tietää kaikki reitit.

# Algoritmit
Tarkoitus on toteuttaa ainakin algoritmit ilman labyrintin tuntemusta:
 - seinän seuraaminen
 - satunnainen liikkuminen
ja algoritmit labyrintin tuntemalla:
 - leveyshaku
 - leveyshaku jollakin heuristiikalla
 - umpikujien täyttö

## Syöte
Lisäksi ohjelman kannalta taitaa olla järkevää toteuttaa labyrinttien luomisen hoitavia algoritmeja.

Labyrinttien tallentamiseen olen miettinyt kahta tapaa. Joko merkeillä kuvataan onko kohta seinää vai kulkureittiä.lisäksi lähtö on l-kirjain ja maali on m-kirjain.
Esimerkki:
#####
#l#.#
#...#
##m##
#####

Toinen tapa on kertoa mihin suuntaan reitistä saa kulkea neljän tosi/epätosi muuttujan avulla, jotka kuvaavat voiko liikkua oikealle, alas, vasemmalle vai ylös. Tämän voi tallentaa myös kokonaislukumuuttujaan, missä jokainen binäärilukubitti kertoo voiko liikkua. 1001 = 9 tarkoittaa, että voi liikkua oikealle ja ylös. Maali ja lähtö pitää antaa erikseen.
Esimerkki:
l=0,0
m=1,2
2  0  2
9  7 12
0  8  0

Tulen varmaan käyttämään ainakin ensimmäistä tapaa
