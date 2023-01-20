import java.util.Scanner;
import java.util.Random;

public class Pacman {

    private static int puntos = 0, poder = 3, cuenta = 0, skin = 0;

    public static void main(String[] args) {
        int[][] unaMatrunaMatriz = {
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

        int[] pacman = { 7, 10 };
        int[] fantasma = { 5, 10 };

        do {
            mundo(unaMatrunaMatriz, pacman, fantasma); 

        } while (comandosPacman(unaMatrunaMatriz, pacman));
    }

    private static void dibujarBordeL(boolean borde) {

        System.out.print("|");
        if (borde) {
            System.out.println();
        }

    }

    private static void dibujarPacman() {
        System.out.print("P");
    }

    private static void dibujarfantasma() { 
        System.out.print("F");
    }

    private static boolean comandosPacman(int[][] unaMatrunaMatriz, int[] pacman) { 
        Scanner entrada = new Scanner(System.in);
        String inputUsuario;
        char direccion = ' ';
        inputUsuario = entrada.nextLine();

        if (inputUsuario.equals("f")) {
            return false;
        } else if (inputUsuario.equals("w")) {
            direccion = 'N';
        } else if (inputUsuario.equals("a")) {
            direccion = 'O';
        } else if (inputUsuario.equals("s")) {
            direccion = 'S';
        } else if (inputUsuario.equals("d")) {
            direccion = 'E';
        } else if (inputUsuario.equals("v")) {
            skin = 2;
        } else {
            System.out.println("No es una tecla valida");
        }
        mover(pacman, unaMatrunaMatriz, direccion);
        return true;
    }

    private static void mover(int[] pacman, int[][] unaMatrunaMatriz, char direccion) {
        int pacmanX, pacmanY;
        pacmanX = pacman[0];
        pacmanY = pacman[1];

        if (direccion == 'O') {
            if (pacmanX == 0) {
                pacmanX = unaMatrunaMatriz[0].length - 1;
            } else if (unaMatrunaMatriz[pacmanY][pacmanX - 1] % 2 == 0) {
                pacmanX = pacmanX - 1;
            }
        } else if (direccion == 'N') {
            if (pacmanY == 0) {
                pacmanY = unaMatrunaMatriz.length - 1;
            } else if (unaMatrunaMatriz[pacmanY - 1][pacmanX] % 2 == 0) {
                pacmanY = pacmanY - 1;
            }
        } else if (direccion == 'E') {
            if (pacmanX == unaMatrunaMatriz[0].length - 1) {
                pacmanX = 0;
            } else if (unaMatrunaMatriz[pacmanY][pacmanX + 1] % 2 == 0) {
                pacmanX = pacmanX + 1;
            }
        } else if (direccion == 'S') {
            if (pacmanY == unaMatrunaMatriz.length - 1) {
                pacmanY = 0;
            } else if (unaMatrunaMatriz[pacmanY + 1][pacmanX] % 2 == 0) {
                pacmanY = pacmanY + 1;
            }
        }

        pacman[0] = pacmanX;
        pacman[1] = pacmanY;

        puntos(pacman, unaMatrunaMatriz);
        poderPacman(pacman, unaMatrunaMatriz);
    }

    private static void puntos(int[] pacman, int[][] unaMatrunaMatriz) { 
        if (unaMatrunaMatriz[pacman[1]][pacman[0]] == 0) {
            unaMatrunaMatriz[pacman[1]][pacman[0]] = 2;
            puntos++;
        } else if (unaMatrunaMatriz[pacman[1]][pacman[0]] == 6) {
            unaMatrunaMatriz[pacman[1]][pacman[0]] = 2;
            System.out.println("ERES IMPARABLE!!!");
            puntos = puntos + 5;
        }
    }

    private static void poderPacman(int[] pacman, int[][] unaMatrunaMatriz) { 

        if (unaMatrunaMatriz[pacman[1]][pacman[0]] == 6) {
            for (int i = 0; i <= poder; i = i - 1) {
                System.out.println("ERES IMPARABLE!!!");
                poder = poder - 3;
            }
            System.out.println("Oh no, perdiste tu poder");
        }
    }

    private static void mundo(int[][] unaMatrunaMatriz, int[] pacman, int[] fantasma) {

        for (int y = 0; y < unaMatrunaMatriz.length; y = y + 1) {
            dibujarBordeL(false);
            for (int x = 0; x < unaMatrunaMatriz[y].length; x = x + 1) {
                if (x == pacman[0] && y == pacman[1]) {
                    dibujarPacman();
                } else if (x == fantasma[0] && y == fantasma[1]) {
                    dibujarfantasma();
                } else {
                    elementos(unaMatrunaMatriz[y][x]);
                }
            }
            dibujarBordeL(true);
        }
            puntos(pacman);
    }

    private static void cambiarmundo() { 
        if (inputUsuario.equals("v")) {
            skinactual = conjuntoDeElementosDos;
        } else if {
            skinactual = conjuntoDeElementosUno;
        }
    }

    private static void elementos(int elementosDelunaMatrunaMatriza) {

        String[] conjuntoDeElementosUno = {
                ".",
                "#",  // Bordes Skin 1
                " ", // Vacio
                "- -",
                "",
                "0", // poder
                "F", // fantasma

        };
        String[] conjuntoDeElementosDos = {
                " o ",
                "###",  // Bordes Skin 2
                "   ", // Vacio
                "- -",
                "   ",
                " x ", // poder
                "FFF", // fantasma

        };
        String[] conjuntoDeElementosTres = {
                "()",
                "##",  // Bordes Skin 3
                "  ", // Vacio
                "- -",
                "  ",
                "><", // poder
                "FF", // fantasma

        };
        System.out.print(conjuntoDeElementosDos[elementosDelunaMatrunaMatriza]);
    }
    private static void puntos(int[] pacman) {

        System.out.println("| Finalizar: f |");
        System.out.println("| Puntos: " + puntos + " |");
        System.out.println("| Numero de movimientos: " + cuenta + " |");
        System.out.println("| Skin: " + skin +" |");
    }
}