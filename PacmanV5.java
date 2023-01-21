import java.util.Scanner;

public class PacmanV5 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 1 },
            { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
            { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
            { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
            { 0, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 0 },
            { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
            { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
            { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
            { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
            { 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int posicionPastillas;
        int puntosPersonaje = 0;
        int posicionInvencibilidad;
        int duracionInvencibilidad = 15;
        int skin;

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
                        }else if (unaMatriz[laFila][laColumna]== 2){
                            System.out.print(".");
                        }else if(unaMatriz[laFila][laColumna]== 3){
                            System.out.print("X");
                        }
                    }
                }
                System.out.print("Puntos: [["+ puntosPersonaje +"]] / Invencibilidad: [["+duracionInvencibilidad+"] / Skin: [["+skin+"]]");
                System.out.println();
            }

                if(posicionPersonaje = posicionPastillas){
                    unaMatriz[laFila][laColumna] = 2;
                    System.out.print(" ");
                    puntosPersonaje = puntosPersonaje +3;
                }else{
                    unaMatriz[laFila][laColumna] = 2;
                    System.out.print(".");
                }

                if(posicionPersonaje = posicionInvencibilidad){
                    
                    when(posicionPersonaje = posicionPastillas);
                        unaMatriz[laFila][laColumna] = 2;
                        System.out.print(" ");
                        puntosPersonaje = puntosPersonaje+6;
                    }

                    //como programar que con cada movimiento la duracion se reduzca

                    //programar si se come otra invencibilidad se sume a la que ya tenia
                    
            //MOVIMIENTO

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

            //SKIN

            if(inputUsuario = v){

                skin = skin +1;

                for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                    for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                        if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                            System.out.print("PP");
                        } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                            System.out.print("FF");
                        } else {
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print(" ");
                            } else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("#");
                            }else if (unaMatriz[laFila][laColumna]== 2){
                                System.out.print("()");
                            }else if(unaMatriz[laFila][laColumna]== 3){
                                System.out.print("X");
                            }
                        }
                    }
                    System.out.print("Puntos: [["+ puntosPersonaje +"]] / Invencibilidad: [["+duracionInvencibilidad+"] / Skin: [["+skin+"]]");
                    System.out.println();
                }

            }else if(inputUsuario = vv){   //Para que salga el segundo skin hay que meter dos v "vv"

                skin = skin+2;

                for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                    for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                        if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                            System.out.print("PPP");
                        } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                            System.out.print("FFF");
                        } else {
                            if (unaMatriz[laFila][laColumna] == 0) {
                                System.out.print(" ");
                            } else if (unaMatriz[laFila][laColumna] == 1) {
                                System.out.print("#");
                            }else if (unaMatriz[laFila][laColumna]== 2){
                                System.out.print("O");
                            }else if(unaMatriz[laFila][laColumna]== 3){
                                System.out.print("X");
                            }
                        }
                    }
                    System.out.print("Puntos: [["+ puntosPersonaje +"]] / Invencibilidad: [["+duracionInvencibilidad+"] / Skin: [["+skin+"]]");
                    System.out.println();
                }


            }


        } while (!terminar);
    }
}