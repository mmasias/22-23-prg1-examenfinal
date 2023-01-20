import java.util.Scanner;

public class Pacman {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

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
        int laFila = 12;
        int laColumna = 22;
        int puntos = 0;

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
            System.out.println("\nPuntos [" + puntos + "]");
            impresionDelMapa(unaMatriz, posicionPersonaje, posicionFantasma, laFila, laColumna);
            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '8':
                    if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 3;
                    }
                    if (posicionPersonaje[0] + 1 == laFila) {
                        posicionPersonaje[0] = 0;
                    }
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'w', 'W', '2':
                    if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 3;
                    }
                    if (posicionPersonaje[0] - 1 == 0) {
                        posicionPersonaje[0] = laFila;
                    }
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case 'a', 'A', '4':
                    if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 3;
                    }
                    if (posicionPersonaje[1] - 1 == 0) {
                        posicionPersonaje[1] = laColumna;
                    }
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case 'd', 'D', '6':
                    if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 3;
                    }
                    if (posicionPersonaje[1] + 1 == laColumna) {
                        posicionPersonaje[1] = 0;
                    }
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'f', 'F':
                    terminar = true;
            }

        } while (!terminar);
    }

    static void movimientosUsuario(char inputUsuario, int[] posicionPersonaje, boolean terminar, int[][] unaMatriz,
            int puntos) {
        switch (inputUsuario) {
            case 's', 'S', '8':
                if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    puntos = puntos + 3;
                }
                posicionPersonaje[0] = posicionPersonaje[0] + 1;
                break;
            case 'w', 'W', '2':
                if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    puntos = puntos + 3;
                }
                posicionPersonaje[0] = posicionPersonaje[0] - 1;
                break;
            case 'a', 'A', '4':
                if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    puntos = puntos + 3;
                }
                posicionPersonaje[1] = posicionPersonaje[1] - 1;
                break;
            case 'd', 'D', '6':
                if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    puntos = puntos + 3;
                }
                posicionPersonaje[1] = posicionPersonaje[1] + 1;
                break;
            case 'f', 'F':
                terminar = true;
        }
    }

    static void impresionDelMapa(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma, int laFila,
            int laColumna) {
        for (laFila = 0; laFila < unaMatriz.length; laFila++) {
            for (laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
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
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}