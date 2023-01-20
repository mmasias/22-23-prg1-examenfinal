import java.util.Scanner;
import java.util.Random;

public class PacmanV2V4 {

    private static int puntos = 0, poder = 15, cuenta = 0;

    public static void main(String[] args) {
        int[][] map = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1 },
            { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
            { 0, 0, 0, 0, 0, 1, 0, 1, 2, 2, 2, 2, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] pacman = { 11, 8 };
        int[] posicionFantasma = { 11, 5 };

        do {
            mundo(map, pacman, posicionFantasma); // se crea el mapa de pacman

        } while (comandosPacman(map, pacman));
    }

    private static void limpiarPantalla() { // se ponen los comandos para que la consola se "reinicie" cada que se pone
                                            // un comando
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\u2324\u2324");
    }

    private static void dibujarBordeB(int longitud) { // Se imprime el borde de las bases (arriba y abajo)

        System.out.print("+");
        for (int x = 0; x < longitud; x++) {
            System.out.print("---");
        }
        System.out.println("+");
    }

    private static void dibujarBordeL(boolean borde) { // Se imprime el borde de los lados (izquierda y derecha)

        System.out.print("|");
        if (borde) {
            System.out.println();
        }

    }

 
    private static void dibujarPacman() { // Se bosqueja el pacman
        System.out.print( "P");
    }

    private static void fantasma() { // Se bosqueja la fruta
        System.out.print("F");
    }

    private static boolean comandosPacman(int[][] map, int[] pacman) { // Comandos de uso de pacman w a s d | f

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
        } else {
            System.out.println("No es una tecla valida");
        }
        mover(pacman, map, direccion);
        return true;
    }

    private static void mover(int[] pacman, int[][] map, char direccion) {
        int pacmanX, pacmanY;
        pacmanX = pacman[0];
        pacmanY = pacman[1];

        // Se denota hacia donde se esta moviendo el pacman con respecto a puntos
        // cardinales

        if (direccion == 'O') {
            if (pacmanX == 0) {
                pacmanX = map[0].length - 1;
            } else if (map[pacmanY][pacmanX - 1] % 2 == 0) {
                pacmanX = pacmanX - 1;
            }
        } else if (direccion == 'N') {
            if (pacmanY == 0) {
                pacmanY = map.length - 1;
            } else if (map[pacmanY - 1][pacmanX] % 2 == 0) {
                pacmanY = pacmanY - 1;
            }
        } else if (direccion == 'E') {
            if (pacmanX == map[0].length - 1) {
                pacmanX = 0;
            } else if (map[pacmanY][pacmanX + 1] % 2 == 0) {
                pacmanX = pacmanX + 1;
            }
        } else if (direccion == 'S') {
            if (pacmanY == map.length - 1) {
                pacmanY = 0;
            } else if (map[pacmanY + 1][pacmanX] % 2 == 0) {
                pacmanY = pacmanY + 1;
            }
        }

        pacman[0] = pacmanX;
        pacman[1] = pacmanY;

        puntos(pacman, map);
        poderPacman(pacman, map);
    }

    private static void puntos(int[] pacman, int[][] map) { // Puntos del juego
        if (map[pacman[1]][pacman[0]] == 0) {
            map[pacman[1]][pacman[0]] = 2;
            puntos++;
        } else if (map[pacman[1]][pacman[0]] == 3) {
            map[pacman[1]][pacman[0]] = 2;
            System.out.println("ERES IMPARABLE!!!");
            puntos = puntos + 5;
        }
    }

    private static void poderPacman(int[] pacman, int[][] map) { // Variable Poder

        if (map[pacman[1]][pacman[0]] == 3) {
            for (int i = 0; i <= poder; i = i - 1) {
                System.out.println("ERES IMPARABLE!!!");
                poder = poder - 1;
            }
            System.out.println("Oh no, perdiste tu poder");
        }
    }

       
    private static void puntos(int[] pacman) {

        System.out.println("| Moverse: w a s d | Finalizar: f |");
        System.out.println("| Posicion Pacman: X [" + pacman[0] + "] Y [" + pacman[1] + "] |");
        System.out.println("| Puntos: " + puntos + " |");
        System.out.println("| Numero de movimientos: " + cuenta + " |");

    }


    private static void mundo(int[][] map, int[] pacman, int[]posicionFantasma) {

        limpiarPantalla();
        dibujarBordeB(map[0].length);

        for (int y = 0; y < map.length; y = y + 1) {
            dibujarBordeL(false);
            for (int x = 0; x < map[y].length; x = x + 1) {
                if (x == pacman[0] && y == pacman[1]) {
                    dibujarPacman();
                }else if (x == posicionFantasma[0] && y == posicionFantasma[1]){
                    fantasma();
                }              
                else {
                    elementos(map[y][x]);
                }
            }
            dibujarBordeL(true);
        }
        dibujarBordeB(map[0].length);
        puntos(pacman);
    }

    private static void elementos(int elementosDelMapa) { // Variable elementos

        String[] conjuntoDeElementos = {
                ".", // Puntos
                "#", // Bordes
                " ", // Vacio
                "0" // poder

        };
        System.out.print(conjuntoDeElementos[elementosDelMapa]);
    }

}
