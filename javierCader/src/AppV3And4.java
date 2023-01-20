import java.util.Scanner;

public class AppV3And4 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int puntos = 0;
        int tiempoInvencibilidad = 0;
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

        do {
            imprimirJuego(unaMatriz, posicionPersonaje, posicionFantasma, puntos, tiempoInvencibilidad);

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '2':
                    if (posicionPersonaje[0] + 1 >= unaMatriz.length) {
                        posicionPersonaje[0] = 0;
                    } else {
                        posicionPersonaje[0] = posicionPersonaje[0] + 1;
                        if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0] - 1][posicionPersonaje[1]] == 0
                                || unaMatriz[posicionPersonaje[0] - 1][posicionPersonaje[1]] == 3) {
                            if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                                puntos += 3;
                            } else if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                                puntos += 6;
                                tiempoInvencibilidad += 15;
                            }
                            unaMatriz[posicionPersonaje[0] - 1][posicionPersonaje[1]] = 2;
                        }
                    }
                    break;
                case 'w', 'W', '8':
                    if (posicionPersonaje[0] - 1 < 0) {
                        posicionPersonaje[0] = unaMatriz.length - 1;
                    } else {
                        posicionPersonaje[0] = posicionPersonaje[0] - 1;
                        if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0] + 1][posicionPersonaje[1]] == 0
                                || unaMatriz[posicionPersonaje[0] + 1][posicionPersonaje[1]] == 3) {
                            if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                                puntos += 3;
                            } else if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                                puntos += 6;
                                tiempoInvencibilidad += 15;
                            }
                            unaMatriz[posicionPersonaje[0] + 1][posicionPersonaje[1]] = 2;
                        }
                        break;
                    }
                case 'a', 'A', '4':
                    if (posicionPersonaje[1] - 1 < 0) {
                        posicionPersonaje[1] = unaMatriz[0].length - 1;
                    } else {
                        posicionPersonaje[1] = posicionPersonaje[1] - 1;
                        if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] + 1] == 0
                                || unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] + 1] == 3) {
                            if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                                puntos += 3;
                            } else if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                                puntos += 6;
                                tiempoInvencibilidad += 15;
                            }
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] + 1] = 2;
                        }
                    }
                    break;
                case 'd', 'D', '6':
                    if (posicionPersonaje[1] + 1 >= unaMatriz[0].length) {
                        posicionPersonaje[1] = 0;
                    } else {
                        posicionPersonaje[1] = posicionPersonaje[1] + 1;
                        if (posicionPersonaje[0] > 0 && unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] - 1] == 0
                                || unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] - 1] == 3) {
                            if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0) {
                                puntos += 3;
                            } else if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3) {
                                puntos += 6;
                                tiempoInvencibilidad += 15;
                            }
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1] - 1] = 2;
                        } 
                    }
                    break;
                case 'f', 'F' :
                    terminar = true;
                default:
                    break;
            }

            if (tiempoInvencibilidad > 0) {
                tiempoInvencibilidad -= 1;
            }

        } while (!terminar);
    }

    public static void imprimirJuego(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma, int puntos,
            int invencibilidad) {
        System.out.print("Puntos: " + "[" + puntos + "]");
        System.out.println("/ Invincibilidad: " + "[" + invencibilidad + "]");
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
            }
            System.out.println();
        }
    }

    public static boolean chequearInvencibilidad (int tiempoInvencibilidad) {
        if (tiempoInvencibilidad > 0) {
            return true;
        }
        return false;
    }
}
