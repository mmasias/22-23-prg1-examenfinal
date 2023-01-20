import java.util.Scanner;

class Mundo2D {

    static final int FILA = 0;
    static final int COLUMNA = 1;

    static final int ARRIBA = 1;
    static final int ABAJO = 2;
    static final int IZQUIERDA = 3;
    static final int DERECHA = 4;

    static final int[][] MOVIMIENTOS = {
            { 0, 0 },
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    static final char[] TECLAS = { 'x', 'w', 's', 'a', 'd' };

    public static void main(String[] args) {

        int[][] elMapa = {
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

        int[] elPersonaje = { 7, 10 };
        int[] fantasma ={ 5, 10 } ;

        do {
            imprimeMundo(elMapa, elPersonaje, fantasma);
            definePosicion(elPersonaje, elMapa);
            if (fantasma[FILA]== elPersonaje[FILA] && fantasma[COLUMNA]== elPersonaje[COLUMNA]){
                System.out.println("Perdiste");
                break;
            }
        } while (true);
    }

    private static void definePosicion(int[] elPersonaje, int [][]elMapa) {

        switch (capturaMovimiento()) {
            case ARRIBA:	mueve(elPersonaje, ARRIBA, elMapa);		break;
            case ABAJO:		mueve(elPersonaje, ABAJO, elMapa); 		break;
            case IZQUIERDA:	mueve(elPersonaje, IZQUIERDA, elMapa);	break;
            case DERECHA:	mueve(elPersonaje, DERECHA, elMapa);	break;
        }
    }

    private static int capturaMovimiento() {

        switch (preguntaChar()) {
            case 's', 'S', '2':	return ABAJO;
            case 'w', 'W', '8':	return ARRIBA;
            case 'a', 'A', '4':	return IZQUIERDA;
            case 'd', 'D', '6':	return DERECHA;
        }
        return 0;
    }

    static void imprimeMundo(int[][] unMapa, int[] unPersonaje, int []fantasma) {

        for (int fila = 0; fila < unMapa.length; fila++) {
            for (int columna = 0; columna < unMapa[fila].length; columna++) {
                if (fila == unPersonaje[FILA] && columna == unPersonaje[COLUMNA]) {
                    imprimePersonaje();
                } else if (fila == fantasma[FILA] && columna == fantasma[COLUMNA]) {
                    imprimeFantasma();
                } else {
                    imprimeTerreno(unMapa[fila][columna]);
                }

            }
            System.out.println();
        }
    }

    static void imprimeTerreno(int unTile) {

        String[] terreno = { " . ", "[#]", "~~~", "vVv", "*oO", "  " };
        System.out.print(terreno[unTile]);
    }

    static void imprimePersonaje() {

        System.out.print("P");
    }
    static void imprimeFantasma() {

        System.out.print("F");
    }


    static void mueve(int[] elPersonaje, int movimiento, int [][] unMapa) {
        boolean mueve = false;
        int f = elPersonaje[FILA] + MOVIMIENTOS[movimiento][FILA];
        int c = elPersonaje[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA];
        if (f < 0 || f > unMapa.length || c < 0 || c > unMapa[0].length) {
            mueve = false;
        } else if (unMapa[f][c] == 1) {
            mueve = false;
        } else if (unMapa[f][c] == 0) {
            mueve = true;
        } else if (unMapa[f][c] == 5) {
            mueve = true;
        }
        if (mueve) {


            unMapa[elPersonaje[FILA]][elPersonaje[COLUMNA]] = 5;
            elPersonaje[FILA] = elPersonaje[FILA] + MOVIMIENTOS[movimiento][FILA];
            elPersonaje[COLUMNA] = elPersonaje[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA];
        }
    }

    static int preguntaInt() {

        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    static String preguntaString() {

        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }

    static char preguntaChar() {
        System.out.println("Donde te vas a mover?");
        Scanner entrada = new Scanner(System.in);
        return entrada.next().charAt(0);
    }

}
