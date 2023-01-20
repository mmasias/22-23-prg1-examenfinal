import java.util.Scanner;

public class PacManV0 {

    static final int FILA = 0;
    static final int COLUMNA = 1;
    static char inputUsuario;
    static boolean terminar = false;
    static int puntuacion = 0;
    static int movimientos = 16;
    static boolean primerSuperPoder = false;
    static int filaMax=11;
    static int filaMin=0;
    static int columnaMax=21;
    static int columnaMin=0;
    static int version = 1;
    public static void main(String[] args) {





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
            mostrarMovimientos();
            puntaje();
            imprimeMundo(unaMatriz, posicionPersonaje, posicionFantasma);
            movimiento(posicionPersonaje);



        } while (!terminar);
    }

    static void imprimeTerrenoVersion1(int unNumeroParaTerreno){

        String[] terreno = {
            ".",
            "#",
            " ",
            "X",
        };
        System.out.print(terreno[unNumeroParaTerreno]);
    }

    static void imprimeTerrenoVersion2(int unNumeroParaTerreno){

        String[] terreno = {
            "()",
            "##",
            "  ",
            "><",
        };
        System.out.print(terreno[unNumeroParaTerreno]);
    }

    
    static void imprimeTerrenoVersion3(int unNumeroParaTerreno){

        String[] terreno = {
            " O ",
            "###",
            "   ",
            " X ",
        };
        System.out.print(terreno[unNumeroParaTerreno]);
    }


    static void imprimeMundo(int [][]unMapa, int[] unPersonaje, int[] unVillano){
        for (int laFila = 0; laFila < unMapa.length; laFila++) {
            for (int laColumna = 0; laColumna < unMapa[laFila].length; laColumna++) {
                if (laFila == unPersonaje[FILA] && laColumna == unPersonaje[COLUMNA]) {
                    System.out.print("P");
                } else if(unPersonaje[FILA]>filaMax){
                    unPersonaje[FILA] = filaMin;
                } else if(unPersonaje[FILA]<filaMin){
                    unPersonaje[FILA] = filaMax;
                } else if(unPersonaje[COLUMNA]>columnaMax){
                    unPersonaje[COLUMNA] = columnaMin;
                } else if(unPersonaje[COLUMNA]<columnaMin){
                    unPersonaje[COLUMNA] = columnaMax;
                } else if (laFila == unVillano[FILA] && laColumna == unVillano[COLUMNA]) {
                    System.out.print("F");
                } else {
                    imprimeTerrenoVersion3(unMapa[laFila][laColumna]);
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
            case 'v', 'V':
                if(version ==1){
                    version =2;
                } else if(version=0)

        }
    }

    static void comePastillas(int[][] unMapa, int[] unPersonaje){
        int filaPersonaje = unPersonaje[FILA];
        int columnaPersonaje = unPersonaje[COLUMNA];
        int valorMapa;
        valorMapa = unMapa[filaPersonaje][columnaPersonaje];
        if(valorMapa==0){
            puntuacion = puntuacion + 3;
            unMapa[filaPersonaje][columnaPersonaje] = 2;
        }else if(valorMapa == 3 && primerSuperPoder == true ){
            
            puntuacion = puntuacion + 6;
            movimientos = movimientos + 15;
            unMapa[filaPersonaje][columnaPersonaje] = 2;

        }else if(valorMapa== 3 && primerSuperPoder == false){
            puntuacion = puntuacion + 6;
            primerSuperPoder = true;
            unMapa[filaPersonaje][columnaPersonaje] = 2;
        } 
    }

    static void puntaje(){
        System.out.println("Puntos: [" + puntuacion + "]");
    }

    static int conteoDeMovimientos(){
        if(primerSuperPoder == true){
            movimientos--;
            if(movimientos<=0){
                primerSuperPoder = false;
                movimientos = 15;
            }
        } else{
            movimientos=15;}
        return movimientos;
    }
    static void mostrarMovimientos(){
        if(primerSuperPoder == true || movimientos<=0)
        System.out.print("INVENCIBILIDAD:[" + conteoDeMovimientos() + "]");
    }
}
