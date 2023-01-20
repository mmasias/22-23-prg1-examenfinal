import java.util.Scanner;

public class Pacman {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;
        //Añadimos las pastillas de invencibilidad en el mapa para la versión 3
        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 2, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 2, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int[] recorridoPersonaje;
        int pastillaComida = 2;
        int contador = 0; //En esta versión se añaden 3 por cada movimiento del personaje, falta corregirlo para que lo haga al comerse cada pastilla
        int invencibilidad = 0;
        int skin = 1;
        int seleccionSkin = 1;
        int inputSkin = 1;

        // Pastillas añadidas, falta incluir que desaparezcan al ser comidas
        do {

            System.out.println("Puntos: " + "["+ contador + "]" + "/ Invencibilidad: " + "["+ invencibilidad + "]");
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {                                              
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else {
                        if (unaMatriz[laFila][laColumna] == 0) {
                            System.out.print(".");                           
                        } else if (unaMatriz[laFila][laColumna] == 1) {
                            System.out.print("#");
                        }
                        else if (unaMatriz[laFila][laColumna] == 2) { //imprime las pastillas de invencibilidad
                            System.out.print("X");
                        }                       
                    }
                    //else if (unaMatriz[laFila][laColumna] == 1 && inputSkin == 1) {
                    //    System.out.print("#");
                    //}else if (unaMatriz[laFila][laColumna] == 1 && inputSkin == 2) {
                     //   System.out.print("##");
                    //}//imprime las pastillas de invencibilidad
                    // else if (unaMatriz[laFila][laColumna] == 2 && inputSkin == 1) { 
                    //    System.out.print("X");
                    //}else if (unaMatriz[laFila][laColumna] == 2 && inputSkin == 2) { 
                    //    System.out.print("><"); 
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
                    case 'v', 'V':
                    System.out.print("Seleccione skin 1,2 o 3: ");
                    inputSkin = entrada.nextLine().charAt(0);
                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'f', 'F':
                    terminar = true;
            }  contador = contador + 3;
            if(unaMatriz[2][3] == 2){ //Condicional para las pastillas de invencibilidad (no funciona bien)
                invencibilidad = invencibilidad + 15;
                contador = contador + 6;
            }

        } while (!terminar);
    }
