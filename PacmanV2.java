import java.util.Scanner;

public class PacmanV2 {

    private static int puntos = 0;
    private static int movimientos = 0;
    private static int duracionInvincibilidad = 0;
    public static void main(String[] args) {

        

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2 },
                { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
            
            imprimeMundo(unaMatriz, posicionPersonaje, posicionFantasma);

            
        } while (procesarMovimineto(posicionPersonaje, posicionFantasma, unaMatriz));


    }

    
    private static void imprimeMundo(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma) {
        
        for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
            for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                    imprimePersonaje();
                } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                    imprimeFantasma();
                } else {
                    imprimeTerreno(unaMatriz[laFila][laColumna]);
                }
            }
            System.out.println();
        }
        imprimeStatus(posicionPersonaje);
    }

    static void imprimePersonaje(){

        System.out.print("P");

    }

    
    static void imprimeFantasma(){

        System.out.print("F");

    }

    private static void imprimeTerreno(int elementosDelMapa){

        String[] terreno = { " ", "#", "." };
        System.out.print(terreno[elementosDelMapa]);
    }


    private static boolean procesarMovimineto(int[] posicionPersonaje, int[] posicionFantasma, int[][] unaMatriz) {
        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        char laDireccion = ' ';
        boolean terminar = false;
        inputUsuario = entrada.nextLine().charAt(0);
            
        switch (inputUsuario) {
                case 's', 'S', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    laDireccion = 'S';
                    break;
                case 'w', 'W', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    laDireccion = 'N';
                    break;
                case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    laDireccion = 'O';
                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    laDireccion = 'E';
                    break;
                case 'f', 'F':
                    terminar = true;
                    break;
                }

                boolean continuar = true;
                return continuar;

            }

            private static boolean mueve(int[] posicionPersonaje, int[][] unaMatriz, char unaDireccion) {
                int elPersonajeX, elPersonajeY;
                elPersonajeX = posicionPersonaje[0];
                elPersonajeY = posicionPersonaje[1];
        
                boolean seMueve = false;
        
                if (unaDireccion == 'N') {
                    seMueve = true;

                } else if (unaDireccion == 'S') {
        
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    seMueve = true;

                } else if (unaDireccion == 'E') {
                    
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    seMueve = true;
                    
                } else if (unaDireccion == 'O') {

                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    seMueve = true;
                    
                }
        
                posicionPersonaje[0] = elPersonajeX;
                posicionPersonaje[1] = elPersonajeY;
        
                
                    registraMovimiento(seMueve);
                    return registraPuntos(posicionPersonaje, unaMatriz);
            }

            private static void registraMovimiento(boolean seMueve) {
                if (seMueve) {
                    movimientos++;
                }
            }

            private static void imprimeStatus(int[] elPersonaje) {

                System.out.println("El personaje está en X:[" + elPersonaje[0] + "] Y:[" + elPersonaje[1] + "] | Tienes [ " + puntos + " ] puntos | Haz hecho [ " + movimientos + " ] movimientos");
                

        
                System.out.println("Para moverte usa las teclas (W/A/S/D)");
        
            }

        private static boolean registraPuntos(int[] posicionPersonaje, int[][] unaMatriz) {
            if (unaMatriz[posicionPersonaje[1]][posicionPersonaje[0]] == 2) {
                unaMatriz[posicionPersonaje[1]][posicionPersonaje[0]] = 0;
                puntos++;
            } else if (unaMatriz[posicionPersonaje[1]][posicionPersonaje[0]] == 4) {
                unaMatriz[posicionPersonaje[1]][posicionPersonaje[0]] = 0;
                puntos += 5;
            }
    
            boolean hayPastillas = false;
            for (int y = 0; y < unaMatriz.length; y++) {
                for (int x = 0; x < unaMatriz[y].length; x++) {
                    if (unaMatriz[y][x] == 2 || unaMatriz[y][x] == 4) {
                        hayPastillas = true;
                    }
                }
            }
            if (!hayPastillas) {
                imprimeMundo(unaMatriz, posicionPersonaje, posicionPersonaje);
                System.out.println(" Haz ganado el juego con [ " + puntos + " ] puntos | Haciendo [ " + movimientos  + " ] movimientos");
            }
            return hayPastillas; 
        }

}