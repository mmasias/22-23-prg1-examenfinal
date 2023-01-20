import java.util.Scanner;

public class Pacman {

    static final int FILA = 0;
    static final int COLUMNA = 1;

    static final int ARRIBA = 0;
    static final int ABAJO = 1;
    static final int IZQUIERDA = 2;
    static final int DERECHA = 3;
    static final int SALIR = 4;
    static final int NADA = 999;

    static final int[][] MOVIMIENTO = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    static int minFila, minColumna, maxFila, maxColumna;

    static boolean terminar = true;

    public static void main(String[] args) {

        int[][] unaMatriz = {
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

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
            imprimirMundo(unaMatriz, posicionPersonaje, posicionFantasma);
            verDireccion(posicionPersonaje);
        } while (!terminar);
    }

    static void imprimirMundo(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma){

        for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
            for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                    System.out.print("P");
                } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                    System.out.print("F");
                } else {
                    if (unaMatriz[laFila][laColumna] == 0) {
                        System.out.print(" ");
                    } else if (unaMatriz[laFila][laColumna] == 1) {
                        System.out.print("#");
                    }
                }
            }
            System.out.println();
        }
    }

    static void mover(int[] unPersonaje, int direccion) {

        unPersonaje[FILA] += MOVIMIENTO[direccion][FILA];
        unPersonaje[COLUMNA] += MOVIMIENTO[direccion][COLUMNA];
    }

    static void verDireccion(int[] posicionPersonaje) {

        switch (obtenerMovimiento()) {
            case ARRIBA:
                mover(posicionPersonaje, ARRIBA);
                break;
            case ABAJO:
                mover(posicionPersonaje, ABAJO);
                break;
            case IZQUIERDA:
                mover(posicionPersonaje, IZQUIERDA);
                break;
            case DERECHA:
                mover(posicionPersonaje, DERECHA);
                break;
            case SALIR:
                terminar = !terminar;
                break;
            case NADA:
                break;
        }
    }

    static int obtenerMovimiento() {

        switch (pedirMovimiento()) {
            case 's', 'S', '8':
                return ABAJO;
            case 'w', 'W', '2':
                return ARRIBA;
            case 'a', 'A', '4':
                return IZQUIERDA;
            case 'd', 'D', '6':
                return DERECHA;
            case 'f', 'F':
                return SALIR;
        }
        return NADA;
    }

    static char pedirMovimiento() {

        Scanner entrada = new Scanner(System.in);
        String inputUsuario = entrada.nextLine() + "x";
        return inputUsuario.charAt(0);
    }
}