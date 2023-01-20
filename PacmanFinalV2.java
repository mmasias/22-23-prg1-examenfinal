import java.util.Scanner;

public class PacmanFinalV2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;
        int pastillascomidas = 0;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 0, 2, 2, 2, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 0 },
                { 1, 2, 2, 2, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
                ImprimeEstado(pastillascomidas);
                ImprimeMapa(unaMatriz, posicionPersonaje, posicionFantasma);

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
            }

            pastillascomidas= ComerPastillas(unaMatriz, posicionPersonaje, pastillascomidas);

        } while (!terminar);
    }

    static void ImprimeMapa(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma){
        for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
            for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                    System.out.print("P");
                } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                    System.out.print("F");
                } else {
                    ImprimeTile(unaMatriz, laFila, laColumna);
                }
            }
            System.out.println();
        }
    }

    static void ImprimeTile(int[][] unaMatriz, int laFila, int laColumna){
        if (unaMatriz[laFila][laColumna] == 0) {
            System.out.print(" ");
        } else if (unaMatriz[laFila][laColumna] == 1) {
            System.out.print("#");
        } else if (unaMatriz[laFila][laColumna] == 2) {
            System.out.print(".");
        }
    }

    static int ComerPastillas(int[][] unaMatriz, int[] posicionPersonaje, int pastillascomidas){
        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]]== 2){
            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
            pastillascomidas++;
        }
        return pastillascomidas;
    }

    static void ImprimeEstado(int pastillascomidas){
        System.out.println("Puntuación: " + (pastillascomidas*3));
    }
}