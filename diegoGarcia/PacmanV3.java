import java.util.Scanner;

public class PacmanV3 {
    public static void main(String[] args) {
        boolean terminar = false;
        int puntuacion = 0;
        boolen invencibilidad = false;

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

            imprimirPuntuacion(puntuacion);

            imprimeJuego(unaMatriz,posicionPersonaje, posicionFantasma);

            puntuacion = definirPosicion(unaMatriz,posicionPersonaje, puntuacion , terminar);
            

            
        } while (!terminar);
    }

    static void imprimirTerreno(int unValor){
        String[] terreno = { ".", "#", " ","X" };
		System.out.print(terreno[unValor]);
    }

    static void imprimeJuego(int unaMatriz[][], int[] posicionPersonaje, int[] posicionFantasma){

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

    }

    static int definirPosicion(int[][] unaMatriz, int[] posicionPersonaje , int puntuacion, boolean terminar){
        switch (preguntaChar()) {
            case 's', 'S', '2':
                posicionPersonaje[0] = posicionPersonaje[0] + 1;

                if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 3;
                }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 6;
                }

                if(invencibilidad){
                    
                }

                break;
            case 'w', 'W', '8':
                posicionPersonaje[0] = posicionPersonaje[0] - 1;

                if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 3;
                }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 6;
                }

                break;
            case 'a', 'A', '4':
                posicionPersonaje[1] = posicionPersonaje[1] - 1;

                if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 3;
                }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 6;
                }

                break;
            case 'd', 'D', '6':
                posicionPersonaje[1] = posicionPersonaje[1] + 1;

                if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 3;
                }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                    unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                    return puntuacion += 6;
                }


                break;
            case 'f', 'F':
                terminar = true;

        }
        return puntuacion;
    }

    static void imprimeJugador(){
        System.out.print("P");
    }

    static void imprimirPuntuacion(int puntuacion){
        System.out.println("PUNTUACION ["+puntuacion+"]");

    }
    static char preguntaChar() {
	    Scanner entrada = new Scanner(System.in);
		return entrada.next().charAt(0);
    }


}
