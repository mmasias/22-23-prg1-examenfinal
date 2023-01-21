import java.util.Scanner;

public class ExamenPacman {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 3, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 3, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int[] contadorPuntos = { 0 };
        int[] turnosInvencibilidad = { 0 };

        do {
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        if (unaMatriz[laFila][laColumna] == 0) {
                            System.out.print("·");
                        } else if (unaMatriz[laFila][laColumna] == 1) {
                            System.out.print("#");
                        } else if (unaMatriz[laFila][laColumna] == 2){
                            System.out.print(" ");
                        } else if (unaMatriz[laFila][laColumna] == 3){
                            System.out.print("X");
                        }
                    }
                }
                System.out.println();
            }

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'w', 'W', '8':
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

            if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                contadorPuntos[0] = contadorPuntos[0] + 3;
            }

            if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                contadorPuntos[0] = contadorPuntos[0] + 6;
                turnosInvencibilidad[0] = turnosInvencibilidad[0] + 15;
            }

            System.out.print("Puntos: " + contadorPuntos[0] + " / ");
            System.out.println("Invencibilidad: " + turnosInvencibilidad[0]);
            if (turnosInvencibilidad[0] > 0) {
                turnosInvencibilidad[0] = turnosInvencibilidad[0] - 1;
            }

            if (posicionPersonaje[0] <= 0) {
                posicionPersonaje[0] = unaMatriz.length - 1;
            } else if (posicionPersonaje[0] >= unaMatriz.length - 1) {
                posicionPersonaje[0] = 1;
            } else if (posicionPersonaje[1] <= 0) {
                posicionPersonaje[1] = unaMatriz[0].length - 1;
            } else if (posicionPersonaje[1] >= unaMatriz[0].length - 1) {
                posicionPersonaje[1] = 1;
            }

        } while (!terminar);
    }
}
