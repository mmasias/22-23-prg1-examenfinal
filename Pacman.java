import java.util.Scanner;
// Se mueve
public class Pacman {

    static final int laFila = 0;
	static final int laColumna = 1;
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 2, 2, 2, 2 },
                { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int personajeX = laFila;
        int personajeY = laColumna;
        int points = 0;
        int invencibilidad = 0;
        String[] terreno = {
            " ",
            "#",
            "."
        };

        do {
            System.out.print("La cantidad de puntos es de: " + points + "/ invencibilidad: " + invencibilidad);
            System.out.println("     ");

            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                        personajeX = laFila;
                        personajeY = laColumna;
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        if (unaMatriz[laFila][laColumna] == 0) {
                            System.out.print(terreno[0]);
                        } else if (unaMatriz[laFila][laColumna] == 1) {
                            System.out.print(terreno[1]);
                         } else if (unaMatriz[laFila][laColumna] == 2) {
                             System.out.print(terreno[2]);
                        }  else if(personajeX == 2 || personajeY == 2){
                            System.out.print(" ");
                            points = points + 3;
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
    }
}