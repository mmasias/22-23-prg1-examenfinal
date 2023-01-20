
import java.util.Scanner;
import java.util.Random;

public class array {

    static final int FILA = 0;
    static final int COLUMNA = 1;

    static final int ARRIBA = 0;
    static final int ABAJO = 1;
    static final int IZQUIERDA = 2;
    static final int DERECHA = 3;

    static final int[][] MOVIMIENTO = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public static void main(String[] args) {
        boolean continueJuego = true;
        int[][] elMapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] elPersonaje = { 7, 10 };
        int[] fantasma = { 5, 10 };
        int direccion;
        int contador=0;

        do {

            imprimeMundo(elMapa, elPersonaje, fantasma, contador);
            do {
                direccion = preguntaAdonde();
            } while (direccion == -2);

            mover(elPersonaje, direccion, elMapa);
            monedaVacia(elPersonaje, direccion, elMapa);
            contador= imprimePersonajeconpuntos(contador);
            System.out.println("vas" + contador);

        } while (continueJuego);
    }

    static int preguntaAdonde() {

        System.out.println("Adonde vas?");
        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();

        if (numero == 0 || numero == 2 || numero == 1 || numero == 3) {
            return numero;

        } else {
            System.out.println("Por favor indica un numero entre el 0 y el 3");
            return -2;
        }

    }

    static void mover(int[] unPersonaje, int direccion, int[][] elMapa) {
        int[] antiguaPosicion = { 0, 0 };
        antiguaPosicion[0] = unPersonaje[0];
        antiguaPosicion[1] = unPersonaje[1];
        unPersonaje[FILA] += MOVIMIENTO[direccion][FILA];
        unPersonaje[COLUMNA] += MOVIMIENTO[direccion][COLUMNA];
    }

    static void monedaVacia(int[] unPersonaje, int direccion, int[][] elMapa) {

    }

    static void imprimeMundo(int[][] unMapa, int[] unPersonaje, int[] fantasma, int contador) {


        for (int fila = 0; fila < unMapa.length; fila++) {

            for (int columna = 0; columna < unMapa[fila].length; columna++) {
                if (fila == unPersonaje[FILA] && columna == unPersonaje[COLUMNA] && unMapa[FILA][COLUMNA] == 0) {
                    imprimePersonajeconpuntos(contador);

                } else if (fila == unPersonaje[FILA] && columna == unPersonaje[COLUMNA]) {
                    imprimePersonaje();

                } else if (fila == fantasma[FILA] && columna == fantasma[COLUMNA]) {
                    imprimeFantasma();
                } else {
                    imprimeTerreno(unMapa[fila][columna]);

                }
            }
            System.out.println();

        }

    }

    static void imprimeTerreno(int unTile) {

        String[] terreno = {
                ".",
                " ",
                "#",
        };
        System.out.print(terreno[unTile]);
    }

    static void imprimePersonaje() {
        System.out.print("p");
    }

    static void imprimeFantasma() {
        System.out.print("f");
    }

    static void imprimeMonedavacia() {
        System.out.print("");
    }

    static int imprimePersonajeconpuntos(int contador){
        contador= contador +3;
        return contador;
    }
}
