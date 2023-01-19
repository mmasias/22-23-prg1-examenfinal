# [22][23] - Programación 1 - Examen Final


## Versión base

La **[versión base](Pacman.java)**, contiene un laberinto, paredes, el personaje del pacman y un fantasma. El personaje del pacman puede moverse con *w/a/s/d* o las teclas del teclado numérico.

![](/images/v0.png)

## Versión 1: pastillas

La versión 1 implementa las pastillas en el laberinto. El pacman debe comerse las pastillas a su paso.

![](/images/v1.png)<br/>![](/images/v1_01.png)

## Versión 2: puntaje

La versión 2 implementa un contador de puntos en la parte superior del visor. Cada pastilla que come le suma 3 puntos.

![](/images/v2.png)

## Versión 3: invencibilidad

La versión 3 implementa las pastillas de invencibilidad. Son cuatro pastillas, ubicadas una en cada extremo del mapa. El pacman, al comerla, gana 6 puntos y adquiere invencibilidad por 15 movimientos. Esta invencibilidad es acumulativa (esto es, ya está invencible y come una pastilla, aumenta el tiempo de invencibilidad en 15)

![](/images/v3.png)<br/>![](/images/v3_03.png) -> ![](/images/v3_04.png)

## Versión 4: mundo toroidal

Cuando el pacman alcanza un límite del mapa e intenta "salir", aparece al otro extremo del mismo.

## Versión 5: skins

Implemente skins para el juego: el usuario puede alternar entre las diversas skins utilizando la tecla **v**.

![](/images/v5_01.png)

![](/images/v5_02.png)

![](/images/v5_03.png)


 


