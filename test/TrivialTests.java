import launcher.GameLauncher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

import java.util.Random;

public class TrivialTests {
    @Test
    public void true_is_true(){
        Assertions.assertTrue(true);
    }

    @Test
    public void crear_Game(){
        Game trivial = new Game();
    }

    @Test
    public void si_al_principio_saco_un_1_voy_a_casilla_1(){
        //Arrange
        Game sut = new Game();
        sut.agregar("Maria");
        sut.agregar("Juan");

        sut.tirarDado(1);

        String expected = "La nueva posición de Maria es 1";

        //Act
        String actual = sut.nuevaPosicionJugador();

        //Assert
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void problema1MenosDe2jugadores(){
        Game juegoa = new Game();

        juegoa.agregar("Maria");

        boolean esJugable = juegoa.esJugable();
        if (!esJugable) {
            System.out.println("Deben ser minimo 2");
            System.out.println("--Terminando programa--");
            System.exit(1);
        }
    }
    @Test
    public void problema2MasDe6jugadores() {
        Game juegoa = new Game();

        juegoa.agregar("Maaria");
        juegoa.agregar("Madria");
        juegoa.agregar("Marvia");
        juegoa.agregar("Mariba");
        juegoa.agregar("Marian");
        juegoa.agregar("Mariama");
        juegoa.agregar("Mariama");

        boolean esJugable = juegoa.esJugable();
        if (!esJugable) {
            System.out.println("Deben ser minimo 2 y maximo 6");
            System.out.println("--Terminando programa--");
            System.exit(1);
        }
    }
}
