# [22][23] - Programación 1 - Examen Final

|Versiones|Imagen|Detalle|Solución propuesta
|-|-|-|:-:
|0|![](/images/v0.png)|La **[versión base](Pacman.java)**, contiene un laberinto, paredes, el personaje del pacman y un fantasma. El personaje del pacman puede moverse con *w/a/s/d* o las teclas del teclado numérico. |[:memo:](./solucionPropuesta/PacmanV0.java)
|1|![](/images/v1.png)<br/>![](/images/v1_01.png)|**Pastillas**<br />La versión 1 implementa las pastillas en el laberinto. El pacman debe comerse las pastillas a su paso.|[:memo:](./solucionPropuesta/PacmanV1.java)
|2|![](/images/v2.png)|**Puntaje**<br />La versión 2 implementa un contador de puntos en la parte superior del visor. Cada pastilla que come le suma 3 puntos.|[:memo:](./solucionPropuesta/PacmanV2.java)
|3|![](/images/v3.png)<br/>![](/images/v3_01.png)![](/images/v3_02.png)<br/>![](/images/v3_03.png)![](/images/v3_04.png)|**Invencibilidad**<br />La versión 3 implementa las pastillas de invencibilidad. Son cuatro pastillas, ubicadas una en cada extremo del mapa. El pacman, al comerla, gana 6 puntos y adquiere invencibilidad por 15 movimientos. Esta invencibilidad es acumulativa (esto es, ya está invencible y come una pastilla, aumenta el tiempo de invencibilidad en 15)|[:memo:](./solucionPropuesta/PacmanV3.java)
|4| |**Mundo toroidal**<br/>Cuando el pacman alcanza un límite del mapa e intenta "salir", aparece al otro extremo del mismo.|[:memo:](./solucionPropuesta/PacmanV4.java)
|5|![](/images/v5_01.png)![](/images/v5_02.png)<br/>![](/images/v5_03.png)|**Skins**<br/>Implemente skins para el juego: el usuario puede alternar entre las diversas skins utilizando la tecla **v**.|[:memo:](./solucionPropuesta/PacmanV5.java)