package launcher;


import smellytrivial.Game;

import java.util.Random;

public class GameLauncher {

    public static void main(String[] args) {
        Game juego = new Game();

        juego.agregar("Maria");
        juego.agregar("Juan");
        juego.agregar("Antonio");

        Random rand = new Random();

        boolean Ganador = true;
        do {

            juego.tirarDado(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                Ganador = juego.respuestaIncorrecta();
            } else {
                Ganador = juego.fueRespuestaCorrecta();
            }



        } while (Ganador);

    }
}
