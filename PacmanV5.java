import java.util.Scanner;

public class PacmanV5 {
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

        final String[][] SKINS = {
            {" ", "#", ".", "X", "F", "P"},
            {"  ", "##", "()", "><", "FF", "PP"},
            {"   ", "###", " o ", " X ", "FFF", "PPP"}
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        int puntos = 0;
        int invencibilidad = 0;

        int skinActiva = 0;

        do {

            System.out.println("Puntos: ["+ puntos + "] - " + " Invenvibilidad: [" + invencibilidad + "]");

            for (int laFila = 0; laFila < mapa.length; laFila++) {
                for (int laColumna = 0; laColumna < mapa[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print(SKINS[skinActiva][5]);
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print(SKINS[skinActiva][4]);
                    } else {
                        if (mapa[laFila][laColumna] == 0) {
                            System.out.print(SKINS[skinActiva][0]);
                        } else if (mapa[laFila][laColumna] == 1) {
                            System.out.print(SKINS[skinActiva][1]);
                        } else if (mapa[laFila][laColumna] == 2){
                            System.out.print(SKINS[skinActiva][2]);
                        } else if (mapa[laFila][laColumna] == 3){
                            System.out.print(SKINS[skinActiva][3]);
                        }
                    }
                }
                System.out.println();
            }

            inputUsuario = entrada.nextLine().charAt(0);

            switch (inputUsuario) {
                case 'v', 'V':
                    skinActiva++;
                    if(skinActiva >= SKINS.length){
                    skinActiva = 0;
                    }
                    break;
                case 's', 'S', '8':
                    if((posicionPersonaje[0] + 1) <= 11){
                        posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    } else posicionPersonaje[0] = 0;
                    break;
                case 'w', 'W', '2':
                    if((posicionPersonaje[0] - 1) >= 0){
                        posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    } else posicionPersonaje[0] = 11;
                    break;
                case 'a', 'A', '4':
                    if((posicionPersonaje[1] - 1) >= 0){
                        posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    } else posicionPersonaje[1] = 21;
                    break;
                case 'd', 'D', '6':
                    if((posicionPersonaje[1] + 1) <= 21){
                        posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    } else posicionPersonaje[1] = 0;
                    break;
                case 'f', 'F':
                    terminar = true;
            }

            puntos = comerPastillas(mapa, posicionPersonaje, puntos);
            invencibilidad = comerInvencibilidad(mapa, posicionPersonaje, invencibilidad);

        } while (!terminar);
    }

    static int comerPastillas(int[][] mapa, int[] posicionPersonaje, int puntos){

        if(mapa[posicionPersonaje[0]][posicionPersonaje[1]] == 2){

             mapa[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
             puntos += 3;
        }

        return puntos;
    }

    static int comerInvencibilidad(int[][] mapa, int[] posicionPersonaje, int invencibilidad) {

        if (invencibilidad > 0){
            invencibilidad -= 1;
        }

        if (mapa[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
            mapa[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
            invencibilidad += 15;
        }

        return invencibilidad;
    }


}