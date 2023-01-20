import java.util.Scanner;

public class PacmanV2 {

    static int[][] mapa = {
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
        { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
        { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
        { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
        { 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2 },
        { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
        { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
        { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
        { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
        { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
    };

    static Scanner entrada = new Scanner(System.in);

    static char inputUsuario;

    static int[] posicionPersonaje = { 7, 10 };

    static int[] posicionFantasma = { 5, 10 };

    static boolean terminarJuego = false;

    static String[] terreno = {
        " ",
        "#",
        ".",
    };

    static int FILA = 0;
    static int COLUMNA = 1;

    static int puntos;
    static int turnosInvencible;


    public static void main(String[] args) {
        do {
            imprimirStatus();
            imprimirPantalla();
            inputUsuario = entrada.nextLine().charAt(0);
            moverPersonaje(inputUsuario);
        } while (!terminarJuego);
    }

    static void imprimirStatus(){
        System.out.println("Puntos: [" + puntos  + "]");
    }

    static void imprimirPantalla () {
        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[fila].length; columna++) {
                if (fila == posicionPersonaje[FILA] && columna == posicionPersonaje[COLUMNA]) {
                    System.out.print("P");
                } else if (fila == posicionFantasma[FILA] && columna == posicionFantasma[COLUMNA]) {
                    System.out.print("F");
                } else {
                    imprimirTerreno(fila, columna);
                }
            }
            System.out.println();
        }
    }

    static void imprimirTerreno(int fila, int columna){
        int tile = mapa[fila][columna];
        System.out.print(terreno[tile]);
    }

    static void moverPersonaje(char inputUsuario){
        int[] posicionAnterior = posicionPersonaje;
        switch (inputUsuario) {
            case 's':
            case 'S':
            case '8':
                posicionPersonaje[0] = posicionPersonaje[0] + 1;
                break;
            case 'w':
            case 'W':
            case '2':
                posicionPersonaje[0] = posicionPersonaje[0] - 1;
                break;
            case 'a':
            case 'A':
            case '4':
                posicionPersonaje[1] = posicionPersonaje[1] - 1;
                break;
            case 'd':
            case 'D':
            case '6':
                posicionPersonaje[1] = posicionPersonaje[1] + 1;
                break;
            case 'f':
            case 'F':
                terminarJuego = true;
        }
        detectarColisiones(posicionAnterior);
        System.out.println();
    }
    
    static void detectarColisiones(int[] posicionAnterior){
        int posicionFutura = mapa[posicionPersonaje[0]][posicionPersonaje[1]];
        if (posicionFutura == 2){
            mapa[posicionAnterior[0]][posicionAnterior[1]] = 0;
            puntos += 3;
        }
    }
}