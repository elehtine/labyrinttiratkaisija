# Toteutusdokumentti

## Aikavaativuus

Taulukossa n on leveys ja m on korkeus

| Algoritmi     | Seinän seuraaminen | Leveyshaku | Syvyyshaku | Prim  | Kruskal          |
| ------------- | ------------------ | ---------- | ---------- | ----- | ---------------- |
| Aikavaativuus | O(nm)              | O(nm)      | O(nm)      | O(nm) | O(nm log(nm) )   |

## Tiedostorakenne
Ohjelmassa on kansiot domain, ui ja util.

### util
Kansiossa util on luokka Tarkistaja joka tarkistaa ratkaiseeko annettu reitti labyrintin.

### domain
Kansiossa domain on luokat labyrintin kuvaamiselle, sekä niiden luomiselle ja ratkaisemiselle.

### ui
Kansiossa ui on käyttöliittymän näyttämiseen tarvittavat luokat. Sinne tulee jonkinlaisia havainnollistuksia algoritmeista.

## lähteet
[Wikipedia: Maze solving algorithm](https://en.wikipedia.org/wiki/Maze_solving_algorithm)
[Wikipedia: Maze generation algorithm](https://en.wikipedia.org/wiki/Maze_generation_algorithm)
