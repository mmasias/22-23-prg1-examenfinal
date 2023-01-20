import java.util.Scanner;

public class PacmanV1y2 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

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
        int puntos = 0;


        do {
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        if (unaMatriz[laFila][laColumna] == 0) {
                            System.out.print(" ");
                        } else if (unaMatriz[laFila][laColumna] == 1) {
                            System.out.print("#");
                        }
                    }
                }
                System.out.println();
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
            }
        } while (!terminar);

        Random r = new Random();

            int[] posicionObjetos = new int[4][2];

            for (int i = 0; i < 4; i++) {
                 int fila = r.nextInt(unaMatriz.length);
                int columna = r.nextInt(unaMatriz[0].length);
                while (unaMatriz[fila][columna] == 1 || (fila == posicionPersonaje[0] && columna == posicionPersonaje[1]) || (fila == posicionFantasma[0] && columna == posicionFantasma[1])) {
                 fila = r.nextInt(unaMatriz.length);
                 columna = r.nextInt(unaMatriz[0].length);
                 }   
            posicionObjetos[i][0] = fila;
            posicionObjetos[i][1] = columna;
            }
for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
    for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
        if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
            System.out.print("P");
        } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
            System.out.print("F");
        } else {
            boolean esObjetivo = false;
            for (int i = 0; i < 4; i++) {
                if (laFila == posicionObjetos[i][0] && laColumna == posicionObjetos[i][1]) {
                    System.out.print("O");
                    esObjetivo = true;
                    break;
                }
            }
            if (!esObjetivo) {
                if (unaMatriz[laFila][laColumna] == 0) {
                    System.out.print(" ");
                } else if (unaMatriz[laFila][laColumna] == 1) {
                    System.out.print("#");
                }
                }
                }
                }
                System.out.println();
                }switch (inputUsuario) {
                    case 's', 'S', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    for (int i = 0; i < 4; i++) {
                    if (posicionPersonaje[0] == posicionObjetos[i][0] && posicionPersonaje[1] == posicionObjetos[i][1]) {
                    posicionObjetos[i][0] = -1;
                    posicionObjetos[i][1] = -1;
                    break;
                    }                    
                } 
                        
                    break;
                    case 'w', 'W', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    for (int i = 0; i < 4; i++) {
                    if (posicionPersonaje[0] == posicionObjetos[i][0] && posicionPersonaje[1] == posicionObjetos[i][1]) {
                    posicionObjetos[i][0] = -1;
                    posicionObjetos[i][1] = -1;
                    break;
                    }
                    }
                    break;
                    case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    for (int i = 0; i < 4; i++) {
                    if (posicionPersonaje[0] == posicionObjetos[i][0] && posicionPersonaje[1] == posicionObjetos[i][1]) {
                    posicionObjetos[i][0] = -1;
                    posicionObjetos[i][1] = -1;
                    break;
                    }
                    }
                    break;
                    case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    for (int i = 0; i < 4; i++) {
                    if (posicionPersonaje[0] == posicionObjetos[i][0] && posicionPersonaje[1] == posicionObjetos[i][1]) {
                    posicionObjetos[i][0] = -1;
                    posicionObjetos[i][1] = -1;
                    break;
                    }
                    }
                    break;
                    case 'q', 'Q':
                    terminar = true;
                    break;
                    }

                    do {
                        System.out.println("Puntos obtenidos:" + puntos);
                        for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                            for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                                if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna
                                        && unaMatriz[laFila][laColumna] == 0) {
                                    unaMatriz[laFila][laColumna] = 2;
                                    puntos = puntos+3;
                                }

    }
}     




