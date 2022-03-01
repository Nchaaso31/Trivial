# Trivial

## Problema 0

Extraemos el codigo duplicado a un único método "nuevaPosiciónJugador", el que llamamos desde ambos sitios.

Creamos test unitarios "si_al_principio_saco_un_1_voy_a_casilla_1".
## Problema 1
Vemos si se podria tener menos de 2 jugadores. Y al comprobarlo esta correcto.

## Problema 2 
Para que haya solo 6 jugadores como mucho tendríamos que añadir en esJugable(), un cuantosJugadores() <= 6.

## Problema 3
hay que añadir a fueRespuestaCorrecta() un enCasillaCastigo[jugadorActual] = false; y de esta forma conseguiríamos que saliese de la carcel.

## Problema 4
habría que invertir el noGanador y cambiarlo a Ganador = true, de esta forma acabaría el juego.

## Problema 5
tendríamos que reemplazar el codigo del jugador que se repite en respuestaIncorrecta() respuestaCorrecta() por un único método común  al que hemos llamado siguiente();

## Problema 6
Hemos refactorizado las partes que se repetían en fueRespuestaCorrecta(); y a esas partes las hemos llamado isGanador(); 