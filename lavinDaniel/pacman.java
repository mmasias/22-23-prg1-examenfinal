import java.util.Scanner;

class pacmanV3 {

    static final int FILA = 0;
    static final int COLUMNA = 1;

    static final int ARRIBA = 1;
    static final int ABAJO = 2;
    static final int IZQUIERDA = 3;
    static final int DERECHA = 4;

    static final int[][] MOVIMIENTOS = {
            {0, 0},
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    static int marcador = 0;
    static int invencibilidad =0;
    static final char[] TECLAS = {'x', 'w', 's', 'a', 'd'};

    public static void main(String[] args) {

        int[][] elMapa = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int[] elPersonaje = {1, 1};
        int[][] fantasma = {{8, 9}, {10, 5}, {5, 6}};
        int [][] pastilla = {{1,1},{10,1},{1,20},{10,20}};


        do {
            imprimeMundo(elMapa, elPersonaje, fantasma, pastilla);
            definePosicion(elPersonaje, elMapa,pastilla);

            if (existeFantasma(fantasma, elPersonaje[FILA], elPersonaje[COLUMNA])) {
                System.out.println("Perdiste");
                break;
            }
        } while (contador(elMapa) > 0);
    }

    private static void definePosicion(int[] elPersonaje, int[][] elMapa, int[][]pastilla) {

        switch (capturaMovimiento()) {
            case ARRIBA:
                mueve(elPersonaje, ARRIBA, elMapa, pastilla);
                break;
            case ABAJO:
                mueve(elPersonaje, ABAJO, elMapa,pastilla);
                break;
            case IZQUIERDA:
                mueve(elPersonaje, IZQUIERDA, elMapa, pastilla);
                break;
            case DERECHA:
                mueve(elPersonaje, DERECHA, elMapa, pastilla);
                break;
        }
    }

    private static int capturaMovimiento() {

        switch (preguntaChar()) {
            case 's', 'S', '2':
                return ABAJO;
            case 'w', 'W', '8':
                return ARRIBA;
            case 'a', 'A', '4':
                return IZQUIERDA;
            case 'd', 'D', '6':
                return DERECHA;
        }
        return 0;
    }

    static void imprimeMundo(int[][] unMapa, int[] unPersonaje, int[][] fantasma, int [][]pastilla) {

        for (int fila = 0; fila < unMapa.length; fila++) {
            for (int columna = 0; columna < unMapa[fila].length; columna++) {
                if (fila == unPersonaje[FILA] && columna == unPersonaje[COLUMNA]) {
                    imprimePersonaje();
                } else if (existeFantasma(fantasma, fila, columna)) {
                    imprimeFantasma();
                } else if (existePastilla(pastilla,fila, columna)) {
                    imprimePastilla();
                }else {
                    imprimeTerreno(unMapa[fila][columna]);
                }


            }
            System.out.println();

        }
        System.out.println("Puntos actuales: " + marcador);
        System.out.println("Invencibilidad"+ invencibilidad);
    }

    static void imprimeTerreno(int unTile) {

        String[] terreno = {" . ", "[#]", "~~~", "vVv", "*oO", "   "};
        System.out.print(terreno[unTile]);
    }

    static void imprimePersonaje() {

        System.out.print(" P ");
    }

    static void imprimeFantasma() {

        System.out.print(" F ");
    }
    static void imprimePastilla(){
        System.out.println("X");
    }


    static void mueve(int[] elPersonaje, int movimiento, int[][] unMapa, int [][] pastilla) {
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
            if (unMapa[elPersonaje[FILA] + MOVIMIENTOS[movimiento][FILA]][elPersonaje[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA]] == 0) {
                marcador = marcador + 3;
            } else if (unMapa[elPersonaje[FILA] + MOVIMIENTOS[movimiento][FILA]][elPersonaje[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA]== unMapa[pastilla[FILA]][pastilla[COLUMNA]]]) {
                marcador=marcador+6;
                invencibilidad=invencibilidad+15;
            } else if (mueve && invencibilidad>0) {
                invencibilidad--;
            }
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



    static boolean existeFantasma(int[][] fan, int f, int c) {
        boolean existe = false;
        for (int i = 0; i < fan.length; i++) {
            if (f == fan[i][FILA] && c == fan[i][COLUMNA]) {
                existe = true;
            }
        }
        return existe;
    }

    static int persigue(int[] fan, int[] elPersonaje) {
        int direccion = 0;
        if (fan[FILA] > elPersonaje[FILA]) {
            direccion = ARRIBA;
        } else if (fan[FILA] < elPersonaje[FILA]) {
            direccion = ABAJO;
        } else if (fan[COLUMNA] > elPersonaje[COLUMNA]) {
            direccion = IZQUIERDA;
        } else if (fan[COLUMNA] < elPersonaje[COLUMNA]) {
            direccion = DERECHA;
        }
        return direccion;
    }

    static int contador(int[][] unMapa) {
        int puntos = 0;
        for (int f = 0; f < unMapa.length; f++) {
            for (int c = 0; c < unMapa.length; c++) {
                if (unMapa[f][c] == 0) {
                    puntos++;
                }
            }
        }
        return puntos;
    }
    static boolean existePastilla (int[][]pastilla,int f, int c){
        boolean existe = false;
        for (int i = 0; i < pastilla.length; i++) {
            if (f == pastilla[i][FILA] && c == pastilla[i][COLUMNA]) {
                existe = true;
            }
        }
        return existe;
    }
}
