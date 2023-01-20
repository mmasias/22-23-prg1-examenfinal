import java.util.Scanner;

public class PacmanV2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;
        int puntuacion = 0;

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

            imprimirPuntuacion(puntuacion);

            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        imprimeJugador();
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        imprimirTerreno(unaMatriz[laFila][laColumna]);
                    }
                }
                System.out.println();
            }
            


            inputUsuario = entrada.nextLine().charAt(0);

            System.out.println("\n");

            switch (inputUsuario) {
                case 's', 'S', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;

                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntuacion += 3;
                    }

                    break;
                case 'w', 'W', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;

                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntuacion += 3;
                    }

                    break;
                case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;

                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntuacion += 3;
                    }

                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;

                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntuacion += 3;
                    }


                    break;
                case 'f', 'F':
                    terminar = true;

            }

            
        } while (!terminar);
    }

    static void imprimirTerreno(int unValor){
        String[] terreno = { ".", "#", " " };
		System.out.print(terreno[unValor]);
    }

    static void imprimeJugador(){
        System.out.print("P");
    }

    static void imprimirPuntuacion(int puntuacion){
        System.out.println("PUNTUACION ["+puntuacion+"]");

    }




}
