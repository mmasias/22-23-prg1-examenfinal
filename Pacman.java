import java.util.*;
public class Pacman {
    public static void main(String[] args) {

        boolean terminar = false;

        int[][] terreno = {
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

        int[] posPersonaje = { 7, 10 };
        int[] posFantasma = { 5, 10 };
        int[] contadorPuntos = {0};
        while(terminar == false){
            mostrarTerreno(terreno, posPersonaje, posFantasma, contadorPuntos);
            terminar = moverse(posPersonaje, posFantasma);
            comerBolitas(terreno, posPersonaje, contadorPuntos);
        }
    }

    static void mostrarTerreno(int [][] terreno, int [] posPersonaje, int [] posFantasma, int [] contadorPuntos){
        System.out.println(" ".repeat(10)+"Puntuacion: "+contadorPuntos[0]);
        for (int laFila = 0; laFila < terreno.length; laFila++) {
            for (int laColumna = 0; laColumna < terreno[laFila].length; laColumna++) {
                if (laFila == posPersonaje[0] && laColumna == posPersonaje[1]) {
                    System.out.print("P");
                } else if (laFila == posFantasma[0] && laColumna == posFantasma[1]) {
                    System.out.print("F");
                } else {
                    if (terreno[laFila][laColumna] == 0) {
                        System.out.print("·");
                    } else if (terreno[laFila][laColumna] == 1) {
                        System.out.print("#");
                    }
                    else if (terreno[laFila][laColumna] == 2){
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    static boolean moverse(int [] posPersonaje, int [] posFantasma){
        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '8':
                    posPersonaje[0] = posPersonaje[0] + 1;
                    break;
                case 'w', 'W', '2':
                    posPersonaje[0] = posPersonaje[0] - 1;
                    break;
                case 'a', 'A', '4':
                    posPersonaje[1] = posPersonaje[1] - 1;
                    break;
                case 'd', 'D', '6':
                    posPersonaje[1] = posPersonaje[1] + 1;
                    break;
                case 'f', 'F':
                    return true;
            }
        return false;
    }
    
    static void comerBolitas(int [][] terreno, int [] posPersonaje, int [] contadorPuntos){
        if (terreno[posPersonaje[0]][posPersonaje[1]] == 0){
            terreno[posPersonaje[0]][posPersonaje[1]] = 2;
            contadorPuntos[0]+=3;
        }
    }
}