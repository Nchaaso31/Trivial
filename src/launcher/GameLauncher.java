package launcher;


import smellytrivial.Game;

import java.util.Random;
import java.util.Scanner;

public class GameLauncher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game juego = new Game();

        juego.agregar("Maria");
        juego.agregar("Juan");


        Random rand = new Random();
        boolean esJugable = juego.esJugable();
        if (esJugable == false) {
            System.out.println("Deben ser minimo 2 y maximo 6");
            System.out.println("--Terminando programa--");
            System.exit(1);
        }
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
