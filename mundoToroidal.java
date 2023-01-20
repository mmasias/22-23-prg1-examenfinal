import java.util.Scanner;

public class pacman {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int puntos = 0;
        int invencibilidad = 0;

        do {
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
                        } else if (unaMatriz[laFila][laColumna] == 3) {
                            System.out.print("X");
                        }
                    }
                    if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 3;
                    } else if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 6;
                        invencibilidad = invencibilidad + 15;
                    }

                    if(posicionPersonaje[0] > unaMatriz[laFila].length){
                        posicionPersonaje[0] = 0;
                    } else if(posicionPersonaje[0] < 0){
                        posicionPersonaje[0] = unaMatriz[laFila].length;
                    } else if(posicionPersonaje[1] > unaMatriz.length){
                        posicionPersonaje[1] = 0;
                    } else if(posicionPersonaje[1] < 0){
                        posicionPersonaje[1] = unaMatriz.length;
                    }
                }
                System.out.println();
            }

            System.out.println("El personaje está en la posición: [" + posicionPersonaje[0] + "] , [" + posicionPersonaje[1] + "]");
            System.out.println("Tu puntaje: [" + puntos + "]");
            System.out.println("Invencibilidad: [" + invencibilidad + "] movimientos");





            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    invencibilidad = invencibilidad - 1;
                    break;
                case 'w', 'W', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    invencibilidad = invencibilidad - 1;
                    break;
                case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    invencibilidad = invencibilidad - 1;
                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    invencibilidad = invencibilidad - 1;
                    break;
                case 'f', 'F':
                    terminar = true;
            }


            /*

                intente hacer las coliciones con los muros pero no me salio

                {
                case 's', 'S', '8':
                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[0] -1] % 2 == 0){posicionPersonaje[0] = posicionPersonaje[0] + 1;}
                    if(invencibilidad != 0){invencibilidad = invencibilidad - 1;}
                    break;
                case 'w', 'W', '2':
                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[0] +1] % 2 == 0){posicionPersonaje[0] = posicionPersonaje[0] - 1;}
                    if(invencibilidad != 0){invencibilidad = invencibilidad - 1;}
                    break;
                case 'a', 'A', '4':
                    if(unaMatriz[posicionPersonaje[0] -1][posicionPersonaje[0]] % 2 == 0){posicionPersonaje[1] = posicionPersonaje[1] - 1;}
                    if(invencibilidad != 0){invencibilidad = invencibilidad - 1;}
                    break;
                case 'd', 'D', '6':
                    if(unaMatriz[posicionPersonaje[0] +1][posicionPersonaje[0]] % 2 == 0){posicionPersonaje[1] = posicionPersonaje[1] + 1;}
                    if(invencibilidad != 0){invencibilidad = invencibilidad - 1;}
                    break;
                case 'f', 'F':
                    terminar = true;
            }
            */

        } while (!terminar);
    }
}
