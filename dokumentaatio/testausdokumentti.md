# Testausdokumentti

## Yksikkötestaus
Projektin kaikki luokat on yksikkötestattu käyttäen JUnit kirjastoa.

## Suorituskykytestaus
Kaikki algoritmit ovat luokkaa O(nm) tai O(nm log(nm) missä n on korkeus ja m on leveys. Algoritmit pitäisi pystyä ajamaan alle sekuntissa kun n ja m ovat molemmat 5000 tai alle.

Syvyyshaulla luodessa käytettiin rekursiota joten siinä kuitenkin tulee stack overflow error.

Kruskalin algoritmissa kestää noin 6 sekuntia mainitun kokoisilla labyrinteilla. Tämä on aika paljon ja johtuu varmaan osittain union find rakenteesta.

Seinää seuraamalla reitistä tulee hirveän pitkä. Sen takia merkkijonojen yhdistäminen vei paljon aikaa. Tätä varten toteutin StringRakentaja luokan joka vähensi aikaa huomattavasti. Leveyshaulla ratkaisemisessa on sama ongelma mutta se ei ole niin paha joten en tehnyt asialle mitään.

Testit voi ajaa komennolla ```mvn exec:java -Dexec.mainClass="labyrinttiratkaisija.util.SuorituskykyTestaus"```

Esimerkki testauksen antamasta tuloksesta:
```
Labyrinttien korkeus: 	 4999
Labyrinttien leveys: 	 4999
Leveyshaulla luomisessa tulisi stack overflow joten siina leveys ja korkeus on 199. 

Luomiseen kulunut aika: 
Kruskal	6.531433729
Prim	1.14397666
Syvyyshaku	0.012241597


Ratkaisemiseen kulunut aika: 
	Kruskal	Prim	Syvyyshaku
Leveyshaku	2.935082097	0.764252711	0.002969565
Seinan seuraaminen	0.986995174	0.592995235	0.001566106
```

## Toistaminen
Kloonaa projekti omalle koneelle. Mene komentorivillä oikeaan kansioon [Labyrinttiratkaisija](https://github.com/elehtine/labyrinttiratkaisija/tree/master/Labyrinttiratkaisija) ja aja komento ```mvn exec:java -Dexec.mainClass="labyrinttiratkaisija.util.SuorituskykyTestaus"```.
