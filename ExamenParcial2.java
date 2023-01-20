import java.util.Scanner;

public class ExamenParcial2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean juegoTerminado = false;
        int puntuacion = 0,
            invencibilidad = 0;

        int[][] mapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 3, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 3, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2 },
                { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
            System.out.println("Puntos: [" + puntuacion + "] / Invencibilidad: [" + invencibilidad + "]\n");
            for (int fila = 0; fila < mapa.length; fila++) {
                for (int columna = 0; columna < mapa[fila].length; columna++) {
                    if (fila == posicionPersonaje[0] && columna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (fila == posicionFantasma[0] && columna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        if (mapa[fila][columna] == 0) {
                            System.out.print(" ");
                        } 
                        else if (mapa[fila][columna] == 1) {
                            System.out.print("#");
                        }
                        else if (mapa[fila][columna] == 2) {
                            System.out.print(".");
                        }
                        else if (mapa[fila][columna] == 3) {
                            System.out.print("x");
                        }
                    }
                }
                System.out.println();
            }

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
                    juegoTerminado = true;
            }
            if (mapa[posicionPersonaje[0]][posicionPersonaje[1]] == 2) {
                mapa[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
                puntuacion = puntuacion + 3;
            }
            if (mapa[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                mapa[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
                puntuacion += 6;
                invencibilidad += 16;
            }
            if (invencibilidad > 0) {
                invencibilidad--;
            }
            // Función que teletransporta al personaje al lado contrario del mapa si se sale de los límites
            
        } while (!juegoTerminado);
    }
}