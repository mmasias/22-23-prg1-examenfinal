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

    static int minFila, minColumna, maxFila, maxColumna, puntos = 0, invesibilidad = 0;

    static boolean terminar = false;

    public static void main(String[] args) {

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
            if(invesibilidad > 0){
                invesibilidad --;
            }
            mostrarPuntos();
            imprimirMundo(unaMatriz, posicionPersonaje, posicionFantasma);
            verAccion(posicionPersonaje);
            registrarPuntos(posicionPersonaje, unaMatriz);
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
                        System.out.print(".");
                    } else if (unaMatriz[laFila][laColumna] == 1) {
                        System.out.print("#");
                    } else if (unaMatriz[laFila][laColumna] == 2) {
                        System.out.print("O");
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

    static void verAccion(int[] posicionPersonaje) {

        switch (capturarMovimiento()) {
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

    static int capturarMovimiento() {

        switch (pedirChar()) {
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

    static char pedirChar() {

        Scanner entrada = new Scanner(System.in);
        String inputUsuario = entrada.nextLine() + "x"; // Este es un caso que justifica un comentario!
        return inputUsuario.charAt(0); // Lo comentamos en clase ;)
    }

    static int registrarPuntos(int[] posicionPersonaje, int[][] unaMatriz){
        if(unaMatriz[posicionPersonaje[FILA]][posicionPersonaje[COLUMNA]] == 0){
            puntos = puntos + 3;
        } else if(unaMatriz[posicionPersonaje[FILA]][posicionPersonaje[COLUMNA]] == 2){
            puntos = puntos + 6;
            invesibilidad = invesibilidad + 15;
        }
        return puntos;
    }

    static void mostrarPuntos(){
        System.out.println("PUNTOS " + puntos);
        System.out.println("INVENSIBILIDAD " + invesibilidad);
    }
}