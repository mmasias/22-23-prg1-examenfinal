import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class PacmanFinalV5 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;
        int pastillascomidas = 0;
        int turnosinvencible = 0;
        int skin = 0;
        int numeroskins = 2;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 1 },
                { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 0, 2, 2, 2, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 0 },
                { 1, 2, 2, 2, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };

        do {
                ImprimeEstado(pastillascomidas, turnosinvencible);
                ImprimeMapa(unaMatriz, posicionPersonaje, posicionFantasma, turnosinvencible, skin);

            inputUsuario = entrada.nextLine().charAt(0);
            
            switch (inputUsuario) {
                case 's', 'S', '8':
                    if (posicionPersonaje[0] + 1 == 12){
                        posicionPersonaje[0]= 0;
                    } else{
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    }
                    break;
                case 'w', 'W', '2':
                    if(posicionPersonaje[0] -1 == (-1)){
                        posicionPersonaje[0] = 11;
                    } else{
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    }
                    break;
                case 'a', 'A', '4':
                    if(posicionPersonaje[1] - 1 == (-1) ){
                        posicionPersonaje[1]= 21;
                    } else{
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    }
                    break;
                case 'd', 'D', '6':
                    if(posicionPersonaje[1] + 1 == 22){
                        posicionPersonaje[1] = 0;
                    }else{
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    }
                    break;
                case 'f', 'F':
                    terminar = true;
                    break;
                case 'v', 'V':
                    skin++;
                    if(skin > numeroskins){
                        skin = 0;
                    }
            }
            turnosinvencible= Invencibilidad(unaMatriz, posicionPersonaje, turnosinvencible);
            pastillascomidas= ComerPastillas(unaMatriz, posicionPersonaje, pastillascomidas);
            

        } while (!terminar);
    }

    static void ImprimeMapa(int[][] unaMatriz, int[] posicionPersonaje, int[] posicionFantasma, int turnosinvencible, int skin){
        for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
            for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                    if(skin == 0){
                        System.out.print("P");
                    }
                    else if(skin == 1){
                        System.out.print("\u001B[33m"+" P "+ "\u001B[37m");
                    }
                    else if(skin == 2){
                        System.out.print(" c");
                    }
                } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                    if(turnosinvencible > 0){
                        if(skin == 0){
                            System.out.print("f");
                        }
                        else if(skin == 1){
                            System.out.print("\u001B[34m"+":"+ "\u001B[37m");
                        }
                        else if(skin == 2){
                            System.out.print(" x");
                        }
                }
                    else{
                        if(skin== 0){
                            System.out.print("F");
                        }
                        else if(skin == 1){
                            System.out.print("\u001B[36m"+" Ç "+ "\u001B[37m");
                        }
                        else if(skin == 2){
                            System.out.print(" X");
                        }
                    }
                } else {
                    ImprimeTile(unaMatriz, laFila, laColumna, skin);
                }
            }
            System.out.println();
        }
    }

    static void ImprimeTile(int[][] unaMatriz, int laFila, int laColumna, int skin){
        if (unaMatriz[laFila][laColumna] == 0) {
            if(skin == 0){
                System.out.print(" ");
            } 
            else if(skin == 1){
                System.out.print("   ");
            }
            else if(skin == 2){
                System.out.print("  ");
            }
        } else if (unaMatriz[laFila][laColumna] == 1) {
            if(skin == 0){
                System.out.print("#");
            }
            else if(skin == 1){
                System.out.print("\u001B[34m"+"[#]"+ "\u001B[37m");
            }
            else if(skin == 2){
                System.out.print("[]");
            }
            

        } else if (unaMatriz[laFila][laColumna] == 2) {
            if(skin == 0){
                System.out.print(".");
            }
            else if(skin == 1){
                System.out.print("\u001B[31m"+" . "+ "\u001B[37m");
            }
            else if(skin == 2){
                System.out.print(" ,");
            }
        } else if (unaMatriz[laFila][laColumna] == 3) {
            if(skin == 0){
                System.out.print("o");
            }
            else if(skin == 1){
                System.out.print("\u001B[31m"+" o "+ "\u001B[37m");
            }
            else if(skin == 2){
                System.out.print("c ");
            }
        }
    }

    static int ComerPastillas(int[][] unaMatriz, int[] posicionPersonaje, int pastillascomidas){
        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]]== 2){
            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
            pastillascomidas++;
        }
        else if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]]== 3){
            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 0;
            pastillascomidas= pastillascomidas+2;
        }
        return pastillascomidas;
    }

    static void ImprimeEstado(int pastillascomidas, int turnosinvencible){
        System.out.print("Puntuación: " + (pastillascomidas*3));
        if(turnosinvencible > 0){
            System.out.print("                  " + "Turnos Invencible: " + turnosinvencible);
            System.out.println();
        }else{
            System.out.println();
        }
    }

    static int Invencibilidad(int[][] unaMatriz, int[] posicionPersonaje, int turnosinvencible){
        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]]== 3){
            turnosinvencible = turnosinvencible + 15;
        }
        else if(turnosinvencible > 0){
            turnosinvencible--;
        }
        else{}
        return turnosinvencible;
    }
}