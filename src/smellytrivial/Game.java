package smellytrivial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList jugadores = new ArrayList();
    int[] posiciones = new int[6];
    int[] monederos = new int[6];
    boolean[] enCasillaCastigo = new boolean[6];

    LinkedList preguntasCultura = new LinkedList();
    LinkedList preguntasCiencias = new LinkedList();
    LinkedList preguntasDeportes = new LinkedList();
    LinkedList preguntasMusica = new LinkedList();

    int jugadorActual = 0;
    boolean estaSaliendoDeLaCarcel;

    public Game() {
        for (int i = 0; i < 50; i++) {
            preguntasCultura.addLast("Pregunta de Cultura " + i);
            preguntasCiencias.addLast(("Pregunta de Ciencias " + i));
            preguntasDeportes.addLast(("Pregunta de Deportes " + i));
            preguntasMusica.addLast(crearPreguntaMusica(i));
        }
    }

    public String crearPreguntaMusica(int index) {
        return "Pregunta de Música " + index;
    }

    public boolean esJugable() {
        return (cuantosJugadores() >= 2 && cuantosJugadores() <= 6);
    }

    public boolean agregar(String playerName) {


        jugadores.add(playerName);
        posiciones[cuantosJugadores()] = 0;
        monederos[cuantosJugadores()] = 0;
        enCasillaCastigo[cuantosJugadores()] = false;

        System.out.println(playerName + " se ha unido a la partida");
        System.out.println("Es el jugador número " + jugadores.size());
        return true;
    }

    public int cuantosJugadores() {
        return jugadores.size();
    }

    public void tirarDado(int puntosDado) {
        System.out.println(jugadores.get(jugadorActual) + " es el jugador actual");
        System.out.println("Ha sacado un " + puntosDado);

        if (enCasillaCastigo[jugadorActual]) {
            if (puntosDado % 2 != 0) {
                estaSaliendoDeLaCarcel = true;

                System.out.println(jugadores.get(jugadorActual) + " sale de la casilla de castigo");
                posiciones[jugadorActual] = posiciones[jugadorActual] + puntosDado;
                if (posiciones[jugadorActual] > 11) posiciones[jugadorActual] = posiciones[jugadorActual] - 12;

                System.out.println(nuevaPosicionJugador());
                System.out.println("La categoría es " + categoriaActual());
                hacerPregunta();
            } else {
                System.out.println(jugadores.get(jugadorActual) + " no sale de la casilla de castigo");
                estaSaliendoDeLaCarcel = false;
            }

        } else {

            posiciones[jugadorActual] = posiciones[jugadorActual] + puntosDado;
            if (posiciones[jugadorActual] > 11) posiciones[jugadorActual] = posiciones[jugadorActual] - 12;

            System.out.println(nuevaPosicionJugador());
            System.out.println("La categoría es " + categoriaActual());
            hacerPregunta();
        }

    }

    public String nuevaPosicionJugador() {
        return "La nueva posición de "
                + jugadores.get(jugadorActual)
                + " es "
                + posiciones[jugadorActual];
    }

    private void hacerPregunta() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();


        if (categoriaActual() == "Cultura popular")
            System.out.println(preguntasCultura.get(r.nextInt(50)));
        if (categoriaActual() == "Ciencias")
            System.out.println(preguntasCiencias.get(r.nextInt(50)));
        if (categoriaActual() == "Deportes")
            System.out.println(preguntasDeportes.get(r.nextInt(50)));
        if (categoriaActual() == "Música")
            System.out.println(preguntasMusica.get(r.nextInt(50)));
    }


    private String categoriaActual() {
        if (posiciones[jugadorActual] == 0) return "Cultura popular";
        if (posiciones[jugadorActual] == 4) return "Cultura popular";
        if (posiciones[jugadorActual] == 8) return "Cultura popular";
        if (posiciones[jugadorActual] == 1) return "Ciencias";
        if (posiciones[jugadorActual] == 5) return "Ciencias";
        if (posiciones[jugadorActual] == 9) return "Ciencias";
        if (posiciones[jugadorActual] == 2) return "Deportes";
        if (posiciones[jugadorActual] == 6) return "Deportes";
        if (posiciones[jugadorActual] == 10) return "Deportes";
        return "Música";
    }

    public boolean fueRespuestaCorrecta() {
        if (enCasillaCastigo[jugadorActual]) {
            if (estaSaliendoDeLaCarcel) {
                boolean ganador = isGanador();
                siguiente();

                return ganador;
            } else {
                siguiente();
                return true;
            }


        } else {

            isGanador();

            boolean ganador = jugadorHaGanado();
            siguiente();

            return ganador;
        }
    }

    private boolean isGanador() {
        System.out.println("Respuesta correcta!!!!");
        monederos[jugadorActual]++;
        System.out.println(jugadores.get(jugadorActual)
                + " ahora tiene "
                + monederos[jugadorActual]
                + " monedas doradas.");
        enCasillaCastigo[jugadorActual] = true;
        boolean ganador = jugadorHaGanado();
        return ganador;
    }

    private void siguiente() {
        jugadorActual++;
        if (jugadorActual == jugadores.size()) jugadorActual = 0;
    }

    public boolean respuestaIncorrecta() {
        System.out.println("Respuesta incorrecta");
        System.out.println(jugadores.get(jugadorActual) + " va a la casilla de castigo");
        enCasillaCastigo[jugadorActual] = true;

        siguiente();
        return true;
    }


    private boolean jugadorHaGanado() {
        return !(monederos[jugadorActual] == 6);
    }


}
