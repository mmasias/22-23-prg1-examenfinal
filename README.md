# [22][23] - Programación 1 - Examen Final

|Versiones|Imagen|Detalle
|-|-|-
|0, versión base|![](/images/v0.png)|La **[versión base](Pacman.java)**, contiene un laberinto, paredes, el personaje del pacman y un fantasma. El personaje del pacman puede moverse con *w/a/s/d* o las teclas del teclado numérico. 
|1, pastillas|![](/images/v1.png)<br/>![](/images/v1_01.png)|La versión 1 implementa las pastillas en el laberinto. El pacman debe comerse las pastillas a su paso.
|2, contador de puntos|![](/images/v2.png)|La versión 2 implementa un contador de puntos en la parte superior del visor. Cada pastilla que come le suma 3 puntos.
|3, invencibilidad|![](/images/v3.png)<br/>![](/images/v3_01.png)<br/>![](/images/v3_01.png)<br/>![](/images/v3_03.png)<br/>![](/images/v3_04.png)|La versión 3 implementa las pastillas de invencibilidad. Son cuatro pastillas, ubicadas una en cada extremo del mapa. El pacman, al comerla, gana 6 puntos y adquiere invencibilidad por 15 movimientos. Esta invencibilidad es acumulativa (esto es, ya está invencible y come una pastilla, aumenta el tiempo de invencibilidad en 15)