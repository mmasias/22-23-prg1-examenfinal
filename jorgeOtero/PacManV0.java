import java.util.Scanner;

public class PacManV0 {

    static final int FILA = 0;
    static final int COLUMNA = 1;
    static char inputUsuario;
    static boolean terminar = false;
    static int puntuacion = 0;
    public static void main(String[] args) {





        int[][] unaMatriz = {
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

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {

            imprimeMundo(unaMatriz, posicionPersonaje, posicionFantasma);
            movimiento(posicionPersonaje);



        } while (!terminar);
    }

    static void imprimeTerreno(int unNumeroParaTerreno){

        String[] terreno = {
            ".",
            "#",
            " ",
        };
        System.out.print(terreno[unNumeroParaTerreno]);
    }

    static void imprimeMundo(int [][]unMapa, int[] unPersonaje, int[] unVillano){
        for (int laFila = 0; laFila < unMapa.length; laFila++) {
            for (int laColumna = 0; laColumna < unMapa[laFila].length; laColumna++) {
                if (laFila == unPersonaje[FILA] && laColumna == unPersonaje[COLUMNA]) {
                    System.out.print("P");
                } else if (laFila == unVillano[FILA] && laColumna == unVillano[COLUMNA]) {
                    System.out.print("F");
                } else {
                    imprimeTerreno(unMapa[laFila][laColumna]);
                }
            }
            comePastillas(unMapa, unPersonaje);
            System.out.println();
        }
    }

    static void movimiento(int [] unPersonaje){

        Scanner entrada = new Scanner(System.in);
        inputUsuario = entrada.nextLine().charAt(0);
        switch (inputUsuario) {
            case 's', 'S', '8':
                unPersonaje[FILA] = unPersonaje[FILA] + 1;
                break;
            case 'w', 'W', '2':
                unPersonaje[FILA] = unPersonaje[FILA] - 1;
                break;
            case 'a', 'A', '4':
                unPersonaje[COLUMNA] = unPersonaje[COLUMNA] - 1;
                break;
            case 'd', 'D', '6':
                unPersonaje[COLUMNA] = unPersonaje[COLUMNA] + 1;
                break;
            case 'f', 'F':
                terminar = true;
        }
    }

    static void comePastillas(int[][] unMapa, int[] unPersonaje){
        int filaPersonaje = unPersonaje[FILA];
        int columnaPersonaje = unPersonaje[COLUMNA];
        int valorMapa;
        valorMapa = unMapa[filaPersonaje][columnaPersonaje];
        unMapa[filaPersonaje][columnaPersonaje] = 2;
        if(valorMapa==0){
        puntuacion = puntuacion + 3;
        }
    }

    static void puntaje(){
        
    }
}
