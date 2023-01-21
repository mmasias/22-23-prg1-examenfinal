import java.util.Scanner;

public class sergioMoreno_examenFinal {
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
        int invencibilidad = 0;
        int v=1;

        //RETOS 1/2/3/5

        do {
            System.out.println("Puntos "+"[" + puntos + "]");
            System.out.println("Invencibilidad "+"[" + invencibilidad + "]");
            System.out.println("Skin "+"[" + v + "]");

            if(invencibilidad>0){
                invencibilidad--;
            }

            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {

                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna && unaMatriz[laFila][laColumna] == 0){
                        unaMatriz[laFila][laColumna] = 2;
                        puntos++;
                    }

                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna && unaMatriz[laFila][laColumna] == 3){
                        puntos = puntos + 6;
                        invencibilidad = invencibilidad + 15;
                    }


                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {

                        if(v==1){
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print(".");
                            } else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("#");
                            } else if (unaMatriz[laFila][laColumna] == 2){
                                System.out.print(" ");
                            } else if (unaMatriz[laFila][laColumna] == 3){
                                System.out.print("X");
                            }
                        }

                        if(v==2){
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print("=");
                            } else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("?");
                            } else if (unaMatriz[laFila][laColumna] == 2){
                                System.out.print(" ");
                            } else if (unaMatriz[laFila][laColumna] == 3){
                                System.out.print("X");
                            }
                        }

                        if(v==3){
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print("*");
                            } else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print(";");
                            } else if (unaMatriz[laFila][laColumna] == 2){
                                System.out.print(" ");
                            } else if (unaMatriz[laFila][laColumna] == 3){
                                System.out.print("X");
                            }
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
                    break;
                case 'v', 'V':
                    v++;
                    if(v==4){
                        v=1;
                    }
                    break;
            }
        } while (!terminar);

    }
}