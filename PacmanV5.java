import java.util.Scanner;

public class PacmanV4 {
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
        int contador=0;
        int invencibilidad = 0;
        int skin = 1;

        do {
            System.out.println("Puntos: [" + contador + "] / " + "Invencibilidad: [" + invencibilidad + "] / Skin: [" + skin + "]");
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna && unaMatriz[laFila][laColumna] == 0) {
                        unaMatriz[laFila][laColumna] = 2;
                        contador = contador + 3;
                    }
                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna && unaMatriz[laFila][laColumna] == 3) {
                        invencibilidad = invencibilidad + 15;
                        contador = contador + 6;
                    }

                    if (posicionPersonaje[0] == 12){
                        posicionPersonaje[0] = 0;
                    }

                    if (posicionPersonaje[0] == -1){
                        posicionPersonaje[0] = 11;
                    }

                    if (posicionPersonaje[1] == 22){
                        posicionPersonaje[1] = 0;
                    }

                    if (posicionPersonaje[1] == -1){
                        posicionPersonaje[1] = 21;
                    }
                    if (skin == 1) {
                        if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                            System.out.print("P");
                        } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                            System.out.print("F");
                        } else {
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print(".");
                            }else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("#");
                            }else if (unaMatriz[laFila][laColumna] == 2) {
                                System.out.print(" ");
                            }else if (unaMatriz[laFila][laColumna] == 3) {
                                System.out.print("X");
                            }
                        }
                    } else if (skin == 2) {
                        if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                            System.out.print("PP");
                        } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                            System.out.print("FF");
                        } else {
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print("()");
                            }else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("##");
                            }else if (unaMatriz[laFila][laColumna] == 2) {
                                System.out.print(" ");
                            }else if (unaMatriz[laFila][laColumna] == 3) {
                                System.out.print("><");
                            }
                        }
                    } else if (skin == 3) {
                        if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                            System.out.print("PPP");
                        } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                            System.out.print("FFF");
                        } else {
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print("O");
                            }else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("###");
                            }else if (unaMatriz[laFila][laColumna] == 2) {
                                System.out.print(" ");
                            }else if (unaMatriz[laFila][laColumna] == 3) {
                                System.out.print("X");
                            }
                        }
                    }
                }
                System.out.println();
            }

            if (invencibilidad > 0) {
                invencibilidad = invencibilidad - 1;
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
                case 'v':
                    skin++;
                    if(skin==4){
                        skin=1;
                    }
                    break;
            }
        } while (!terminar);
    }
}