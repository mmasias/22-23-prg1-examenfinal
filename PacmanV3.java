import java.util.Scanner;

public class PacmanV3 {
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
        int puntos = 0;
        int invencibilidad =0;

        do {
            System.out.println("PUNTOS: [" + puntos + "] / INVENCIBILIDAD: [" + invencibilidad + "]");
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna
                            && unaMatriz[laFila][laColumna] == 0) {
                        unaMatriz[laFila][laColumna] = 2;
                        puntos = puntos + 3;
                        
                    }
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
                        } else if (unaMatriz[laFila][laColumna] == 3) {
                        System.out.print("X");
                        }
                    }
                    

                    
                }
                System.out.println();
                
            }
            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'S':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'w':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case 'W':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case 'a':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case 'A':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case 'd':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'D':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'f':
                    terminar = true;
                case 'F':
                    terminar = true;
            }
        } while (!terminar);
    }

}
