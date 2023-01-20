import java.util.Scanner;

public class Pacman {

    static final String DIBUJO_JUGADOR = " P ";
    static final String DIBUJO_FANTASMA = " F ";
    static final String DIBUJO_PARED = "[ ]";
    static final String DIBUJO_PASTILLA = " . ";
    static final String DIBUJO_AIRE = "   ";
    
    static boolean terminar = false;

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
            dibujarJuego(unaMatriz, posicionPersonaje, posicionFantasma);
            moverJugador(posicionPersonaje);
        } while (!terminar);
    }

    static void dibujarJuego(int[][] mapa, int[] posicionJugador, int[] posicionFantasma) {
        for (int laFila = 0; laFila < mapa.length; laFila++) {
            for (int laColumna = 0; laColumna < mapa[laFila].length; laColumna++) {
                if (laFila == posicionJugador[0] && laColumna == posicionJugador[1]) {
                    System.out.print(DIBUJO_JUGADOR);
                } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                    System.out.print(DIBUJO_FANTASMA);
                } else {
                    dibujarMapa(mapa[laFila][laColumna]);
                }
            }
            System.out.println();
        }
    }

    static void dibujarMapa(int casillaMapa) {
        switch (casillaMapa) {
            case 0:
                System.out.print(DIBUJO_PASTILLA);
                break;
            case 1:
                System.out.print(DIBUJO_PARED);
                break;
            case 2:
                System.out.print(DIBUJO_AIRE);
                break;
        }
    }

    static void moverJugador(int[] posicionPersonaje) {
        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        inputUsuario = entrada.nextLine().charAt(0);
        switch (inputUsuario) {
            case 's', 'S', '8':
                posicionPersonaje[0] = posicionPersonaje[0] + 1;
                break;
            case 'w', 'W', '2':
                posicionPersonaje[0] = posicionPersonaje[0] - 1;
                break;
            case 'a', 'A', '4':
                posicionPersonaje[1] = posicionPersonaje[1] - 1;
                break;
            case 'd', 'D', '6':
                posicionPersonaje[1] = posicionPersonaje[1] + 1;
                break;
            case 'f', 'F':
                terminar = true;
        }
        entrada.close();
    }
}