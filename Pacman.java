import java.util.*;
public class Pacman {
    public static void main(String[] args) {

        boolean terminar = false;

        int[][] terreno = {
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
        int[] posPersonaje = { 7, 10 };
        int[] posFantasma = { 5, 10 };
        int[] contadorPuntos = {0};
        boolean invencibilidad = false;
        int [] skinActual = {1};
        while(terminar == false){
            skins(skinActual, terreno, posPersonaje, posFantasma, contadorPuntos);
            terminar = moverse(posPersonaje, posFantasma, skinActual);
            invencibilidad = bolaInvencibilidad(terreno, posPersonaje, contadorPuntos); 
            terminar = interaccionFantasma(posFantasma, posPersonaje, contadorPuntos, invencibilidad);
            comerBolitas(terreno, posPersonaje, contadorPuntos);
        }
    }

    static void skins(int [] skinActual, int [][] terreno, int [] posPersonaje, int [] posFantasma, int [] contadorPuntos){
        System.out.println("Puntuacion: ["+contadorPuntos[0]+"]");
        if (skinActual[0] == 1){
            mostrarTerreno1(terreno, posPersonaje, posFantasma);
        }
    }

    static void mostrarTerreno1(int [][] terreno, int [] posPersonaje, int [] posFantasma){
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
                    else if (terreno[laFila][laColumna] == 3){
                        System.out.print("X");
                    }
                }
            }
            System.out.println();
        }
    }

    static boolean moverse(int [] posPersonaje, int [] posFantasma, int [] skinActual){
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
                case '0':
                    skinActual[0] = 0;
                case '1':
                skinActual[0] = 1;
                case '3':
                skinActual[0] = 3;
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

    static boolean bolaInvencibilidad(int [][] terreno, int [] posPersonaje, int [] contadorPuntos){
        if (terreno[posPersonaje[0]][posPersonaje[1]] == 3){
            terreno[posPersonaje[0]][posPersonaje[1]] = 2;
            contadorPuntos[0]+=6;
            return true;
        }
        return false;
    }

    static boolean interaccionFantasma(int [] posFantasma, int [] posPersonaje, int [] contadorPuntos, boolean invencibilidad){
        if (posFantasma[0] == posPersonaje[0] && posFantasma[1] == posPersonaje[1]){
            if (invencibilidad){
                contadorPuntos[0]+=20;
                posFantasma [0] = 5; 
                posFantasma [1] = 10;
                return false;
            }
            return true;
        }
        return false;
    }
}