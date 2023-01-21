import java.util.Scanner;

import javax.naming.InvalidNameException;

public class PacmanV3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] mapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 3, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 3, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2 },
                { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        int puntos = 0;
        int invencibilidad = 0;

        do {

            System.out.println("Puntos: ["+ puntos + "] - " + " Invenvibilidad: [" + invencibilidad + "]");

            for (int laFila = 0; laFila < mapa.length; laFila++) {
                for (int laColumna = 0; laColumna < mapa[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        if (mapa[laFila][laColumna] == 0) {
                            System.out.print(" ");
                        } else if (mapa[laFila][laColumna] == 1) {
                            System.out.print("#");
                        } else if (mapa[laFila][laColumna] == 2){
                            System.out.print(".");
                        } else if (mapa[laFila][laColumna] == 3){
                            System.out.print("X");
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
                    terminar = true;
            }

            int[] dataPastillas = comerPastillas(mapa, posicionPersonaje, puntos, invencibilidad);
            puntos = dataPastillas[0];
            invencibilidad = dataPastillas[1];

        } while (!terminar);
    }

    static int[] comerPastillas(int[][] mapa, int[] posicionPersonaje, int puntos, int invencibilidad){

        if(mapa[posicionPersonaje[0]][posicionPersonaje[1]] == 2){
            
             mapa[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
             puntos += 3;
        }


        if (invencibilidad > 0) {
            invencibilidad -= 1;
        }

        if (mapa[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
            mapa[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
            invencibilidad += 15;
            puntos += 6;
        }

        int[] resultado = {puntos, invencibilidad};

        return resultado;
    }

}