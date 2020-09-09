# Viikkoraportti 1

## Projekti
Olen alustanut Maven-projektin. Tarkoitus olisi saada tehtyä jonkinlainen ohjelma joka kuvaa labyrinttien ratkaisua vaiheittain.

## Syöte
Olen miettinyt missä muodossa tallennan labyrintit. Minulla on 2 vaihtoehtoista tapaa joilla voisin tallentaa labyrintit. Joko kerron mihin suuntaan kulkureittiruudusta ei ole seinää, tai kerron onko ruutu seinä vai kulkureitti. Näitä en selitä tässä tarkemmin, mutta ne lukevat nykyisessä versiossa määrittelydokumenttia.

## Algoritmit
Olen etsinyt algoritmeja joilla labyrintin voi ratkaista ja miettinyt mitä niistä toteutan. Tässä muutama:
 - Seinää seuraava algoritmi. Labyrintissä kuljetaan aina vaikka oikean puoleisen seinän vieressä. Tällä tavalla pääsee loppuun jos sekä alku että loppu sijaitsee saman seinämän varrella, kuten ulkoreunalla labyrinttia. Ei kulje välttämättä lyhintä reittiä.
 - Satunnainen liikkuminen labyrintissa. Jos jokaisessa kohdassa lähtee aina satunnaiseen suuntaan, pääsee lopulta aina perille. Ei kulje välttämättä lyhintä reittiä.
 - Tremauxin menetelmä. Kuljetaan satunnaisesti ja merkitään risteyksiä niin, että ei kuljeta samaa käytävää enempää kuin kaksi kertaa. Saadaan lopulta reitti jos sellainen on. Tämä ei välttämättä ole nopein mahdollinen.
 - Leveyshaku. Jos tuntee labyrintin, voi leveyshaun avulla saada nopeimman reitin.
 - Leveyshaku käyttäen jotain heuristiikkaa. Heuristiikka voi olla katsoa seuraavaksi ruutuja joista voi päästä nopeiten maaliin jos reitti olisi mahdollisimman lyhyt (Manhattan etäisyys). Näin saadaan aina nopein reitti.
 - Umpikujien täyttäminen. Jos tunnetaan labyrintti, voidaan etsiä kaikki umpikujat. Lähdetään tekemään umpikujista seiniä niin kauan kunnes tulee risteys vastaan. Jos labyrintissa on alunperin yksi mahdollinen reitti, tällä tekniikalla saadaan se.

## Labyrinttien automaattinen luonti
Olen miettinyt miten generoisin automaattisesti labyrintteja. Tulen käyttämään ainakin syvyyshakuun perustuvaa luomista. Alussa on vain yksi ruutu joka kuuluu labyrinttiin. Tähän lisätään kulkureitti johonkin sen viereisistä ruuduista ja aletaan tarkastelemaan uutta ruutua. Sitten taas siihen lisätään kulkureitti johonkin suuntaan. Tätä jatketaan niin kauan ei pysty enää valitsemaan viereistä ruutua joka ei olisi jo kulkureittiä. Siinä tilanteessa peruutetaan kunnes se on taas mahdollista. Lopulta on koko rajattu alue osana labyrinttiä ja jokaisesta kohdasta on vain yksi reitti muihin kohtiin.


