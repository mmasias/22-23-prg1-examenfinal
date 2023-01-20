// Pablo Arce de Aldecoa 20/01/2023
// Examen final de programación I

// Comentar que el unico añadido que se ha hecho, es que cuando interactues con el fantasma siendo invencible, te sume 20 puntos. Ya que no puedes perder, para dar uso a la bola grande.

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
        int [] turnosInv = {0};
        boolean invencibilidad = false;
        int [] skinActual = {0}; 
        while(terminar == false){
            menus(contadorPuntos, turnosInv, skinActual);
            skins(skinActual, terreno, posPersonaje, posFantasma);
            if (turnosInv[0] > 0){turnosInv[0]--;}
            terminar = moverse(posPersonaje, posFantasma, skinActual);
            mundoToroidal(terreno, posPersonaje);
            invencibilidad = bolaInvencibilidad(terreno, posPersonaje, contadorPuntos, turnosInv); 
            interaccionFantasma(posFantasma, posPersonaje, contadorPuntos, invencibilidad);
            comerBolitas(terreno, posPersonaje, contadorPuntos);
        }
    }

    static void menus(int [] contadorPuntos, int [] turnosInv, int [] skinActual){
        System.out.println("= ".repeat(20));
        System.out.println("= ".repeat(20));
        System.out.println("Puntuacion: ["+contadorPuntos[0]+"] Inv["+turnosInv[0]+"] Skin["+skinActual[0]+"]");
    }

    static void skins(int [] skinActual, int [][] terreno, int [] posPersonaje, int [] posFantasma){
        String fantasma = "F";
        String personaje = "P";
        String bolitas = "·";
        String paredes = "#";
        String vacio =" ";
        String bola = "><";
        if (skinActual[0] == 0){
            fantasma = "F";
            personaje = "P";
            bolitas = "·";
            paredes = "#";
            vacio =" ";
            bola = "X";
        }
        if (skinActual[0] == 1){
            fantasma = "FF";
            personaje = "PP";
            bolitas = "()";
            paredes = "##";
            vacio ="  ";
            bola = "><";
        }
        if (skinActual[0] == 2){
            fantasma = "FFF";
            personaje = "PPP";
            bolitas = " O ";
            paredes = "###";
            vacio ="   ";
            bola = " X ";
        }
        mostrarTerreno(terreno, posPersonaje, posFantasma, fantasma, personaje, bolitas, paredes, vacio, bola);
    }

    static void mostrarTerreno(int [][] terreno, int [] posPersonaje, int [] posFantasma, String fantasma, String personaje, String bolitas, String paredes, String vacio, String bola){
        for (int laFila = 0; laFila < terreno.length; laFila++) {
            for (int laColumna = 0; laColumna < terreno[laFila].length; laColumna++) {
                if (laFila == posPersonaje[0] && laColumna == posPersonaje[1]) {
                    System.out.print(personaje);
                } else if (laFila == posFantasma[0] && laColumna == posFantasma[1]) {
                    System.out.print(fantasma);
                } else {
                    if (terreno[laFila][laColumna] == 0) {
                        System.out.print(bolitas);
                    } else if (terreno[laFila][laColumna] == 1) {
                        System.out.print(paredes);
                    }
                    else if (terreno[laFila][laColumna] == 2){
                        System.out.print(vacio);
                    }
                    else if (terreno[laFila][laColumna] == 3){
                        System.out.print(bola);
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
                case 'v':
                    if (skinActual[0] == 2){
                        skinActual[0] = 0;
                    }
                    else{skinActual[0]++;}
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

    static boolean bolaInvencibilidad(int [][] terreno, int [] posPersonaje, int [] contadorPuntos, int [] turnosInv){
        if (terreno[posPersonaje[0]][posPersonaje[1]] == 3){
            terreno[posPersonaje[0]][posPersonaje[1]] = 2;
            contadorPuntos[0]+=6;
            turnosInv[0]+=15;
        }
        if (turnosInv[0] > 0){
            return true;
        }
        return false;
    }

    static void interaccionFantasma(int [] posFantasma, int [] posPersonaje, int [] contadorPuntos, boolean invencibilidad){
        if (posFantasma[0] == posPersonaje[0] && posFantasma[1] == posPersonaje[1]){
            if (invencibilidad){
                contadorPuntos[0]+=20;
            }
        }
    }

    static void mundoToroidal(int [][] terreno, int [] posPersonaje){
        if (posPersonaje[0] == 12){
            posPersonaje[0] = 0;
        }
        else if (posPersonaje[0] == -1){
            posPersonaje[0] = terreno.length-1;
        }
        else if (posPersonaje[1] == terreno[1].length){
            posPersonaje[1] = 0;
        }
        else if (posPersonaje[1] == -1){
            posPersonaje[1] = terreno[1].length-1;
        }
    }
}