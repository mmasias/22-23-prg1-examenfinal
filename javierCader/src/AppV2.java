import java.util.Scanner;

public class AppV2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int puntos = 0;
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

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
            imprimirJuego(unaMatriz, posicionPersonaje, posicionFantasma, puntos);

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0] - 1][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0] - 1][posicionPersonaje[1]] = 2;
                        puntos += 1;
                    }
                    break;
                case 'w', 'W', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0] + 1][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0] + 1][posicionPersonaje[1]] = 2;
                        puntos += 1;
                    }
                    break;
                case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] + 1] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] + 1] = 2;
                        puntos += 1;
                    }
                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] - 1] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] - 1] = 2;
                        puntos += 1;
                    }
                    break;
            }
        } while (!terminar);
    }

    public static void imprimirJuego(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma, int puntos) {
        System.out.println("Puntos: " + "[" + puntos + "]");
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
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}