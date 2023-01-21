import java.util.Scanner;

public class PacmanV5 {
    public static void main(String[] args) {
        boolean terminar = false;
        int puntuacion = 0;
        boolean invencibilidad = false;
        int contadorInvencible = 0;
        int contadorSkin = 1;

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
            System.out.println(contadorSkin);

            if (contadorInvencible == 0){
                invencibilidad = false;
            }else{
                imprimirInvencibilidad(contadorInvencible);
            }

            imprimeJuego(unaMatriz,posicionPersonaje, posicionFantasma, contadorSkin);

            switch (preguntaChar()) {
                case 's', 'S', '2':
    
                    if(posicionPersonaje[0]== 11){
                        posicionPersonaje[0] = 0;
                    }else{
                        posicionPersonaje[0] = posicionPersonaje[0] + 1;
    
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            puntuacion += 3;
                        }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            invencibilidad = true;
                            contadorInvencible += 15;
                            puntuacion += 6;
                        }
    
                    }
    
    
                    
    
                    if(invencibilidad){
                        contadorInvencible--;
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            unaMatriz[posicionFantasma[0]][posicionFantasma[1]] = 2;
                        }
    
                    }else{
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            terminar = true;
                        }
                    }
    
                    break;
                case 'w', 'W', '8':
                    if(posicionPersonaje[0]== 0){
                        posicionPersonaje[0] = 11;
                    }else{
                        posicionPersonaje[0] = posicionPersonaje[0] - 1;
    
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            puntuacion += 3;
                        }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            invencibilidad = true;
                            contadorInvencible += 15;
                            puntuacion += 6;
                        }
                    
                    }
    
                    if(invencibilidad){
                        contadorInvencible--;
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            unaMatriz[posicionFantasma[0]][posicionFantasma[1]] = 2;
                        }
    
                    }else{
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            terminar = true;
                        }
                    }
    
                    break;
                case 'a', 'A', '4':
                    if(posicionPersonaje[1] == 0){
                        posicionPersonaje[1] = 21;
                    }else{
                        posicionPersonaje[1] = posicionPersonaje[1] - 1;
    
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            puntuacion += 3;
                        }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            invencibilidad = true;
                            contadorInvencible += 15;
                            puntuacion += 6;
                        }
                    
                    }
    
                    if(invencibilidad){
                        contadorInvencible--;
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            unaMatriz[posicionFantasma[0]][posicionFantasma[1]] = 2;
                        }
    
                    }else{
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            terminar = true;
                        }
                    }
    
                    break;
                case 'd', 'D', '6':
                    if(posicionPersonaje[1] == 21){
                        posicionPersonaje[1] = 0;
                    }else{
                        posicionPersonaje[1] = posicionPersonaje[1] + 1;
    
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            puntuacion += 3;
                        }else  if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 3){
                            unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                            invencibilidad = true;
                            contadorInvencible += 15;
                            puntuacion += 6;
                        }
                    
                    }
    
                    if(invencibilidad){
                        contadorInvencible--;
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            unaMatriz[posicionFantasma[0]][posicionFantasma[1]] = 2;
                        }
    
                    }else{
                        if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[posicionFantasma[0]][posicionFantasma[1]]){
                            terminar = true;
                        }
                    }
                    break;
    
                case 'v','V':
                    if(contadorSkin == 3){
                        contadorSkin = 1;
                    }else{
                        contadorSkin++;
                    }
                    
                    break;
                    
                case 'f', 'F':
                    terminar = true;
    
            }
            

            
        } while (!terminar);
    }


    static void imprimirTerreno(int unValor){
        String[] terreno = { ".", "#", " ","X" };
		System.out.print(terreno[unValor]);
    }
    static void imprimirTerreno2(int unValor){
        String[] terreno = { "()", "##", "  ","><" };
		System.out.print(terreno[unValor]);
    }
    static void imprimirTerreno3(int unValor){
        String[] terreno = { " 0 ", "###", "   "," X " };
		System.out.print(terreno[unValor]);
    }


    static void imprimeJugador(){
        System.out.print("P");
    }
    static void imprimeJugador2(){
        System.out.print("PP");
    }
    static void imprimeJugador3(){
        System.out.print("PPP");
    }

    static void imprimeFantasma(){
        System.out.print("F");
    }
    static void imprimeFantasma2(){
        System.out.print("FF");
    }
    static void imprimeFantasma3(){
        System.out.print("FFF");
    }

    static void imprimeJuego(int unaMatriz[][], int[] posicionPersonaje, int[] posicionFantasma, int contadorSkin){

        for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
            for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                    switch (contadorSkin) {
                        case 1:
                            imprimeJugador();
                            break;
                        case 2:
                            imprimeJugador2();
                            break;
                        case 3:
                            imprimeJugador3();
                            break;
                    }
                } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                    switch (contadorSkin) {
                        case 1:
                            imprimeFantasma();
                            break;
                        case 2:
                            imprimeFantasma2();
                            break;
                        case 3:
                            imprimeFantasma3();
                            break;
                    }
                } else {
                    switch (contadorSkin) {
                        case 1:
                            imprimirTerreno(unaMatriz[laFila][laColumna]);
                            break;
                        case 2:
                            imprimirTerreno2(unaMatriz[laFila][laColumna]);
                            break;
                        case 3:
                            imprimirTerreno3(unaMatriz[laFila][laColumna]);
                            break;
                    }
                    
                }
            }
            System.out.println();
        }

    }


    static void imprimirPuntuacion(int puntuacion){
        System.out.print("PUNTUACION ["+puntuacion+"] / ");

    }
    static char preguntaChar() {
	    Scanner entrada = new Scanner(System.in);
		return entrada.next().charAt(0);
    }

    static void imprimirInvencibilidad(int contador){
        System.out.println("Invencibilidad["+contador+"]");
    }

   

}
