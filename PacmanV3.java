import java.util.Scanner;


public class PacmanV3 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int[] pastilla1 = {1,1};
        int[] pastilla2 = {1,20};
        int[] pastilla3 = {10,1};
        int[] pastilla4 = {10,20};

        int puntos = 0;

        do {
            System.out.println("PUNTOS: " + puntos/3);
            imprimeMundo(unaMatriz, posicionPersonaje, posicionFantasma, pastilla1, pastilla2, pastilla3, pastilla4);

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 1;
                    }
                    break;
                case 'w', 'W', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 1;
                    }
                    break;
                case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 1;
                    }
                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 0){
                        unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] = 2;
                        puntos = puntos + 1;
                    }
                    break;
                case 'f', 'F':
                    terminar = true;
            }

            if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[pastilla1[0]][pastilla1[1]]){
                unaMatriz[pastilla1[0]][pastilla1[1]] = 2;
                puntos = puntos + 6;

            }else if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[pastilla2[0]][pastilla2[1]]){
                unaMatriz[pastilla2[0]][pastilla2[1]] = 2;
                puntos = puntos + 6;

            } else if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[pastilla3[0]][pastilla3[1]]){
                    unaMatriz[pastilla3[0]][pastilla3[1]] = 2;
                    puntos = puntos + 6;

            }else if(unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == unaMatriz[pastilla4[0]][pastilla4[1]]){
                unaMatriz[pastilla4[0]][pastilla4[1]] = 2;
                puntos = puntos + 6;
            }
            


            
        } while (!terminar);
    }


    static void imprimeMundo(int[][] unaMatriz, int[]posicionPersonaje, int[]posicionFantasma, int[]pastilla1, int[]pastilla2,int[]pastilla3, int[]pastilla4) {
    for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
        for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
            if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                System.out.print("P");
            } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                System.out.print("F");
            } else if (laFila == pastilla1[0] && laColumna == pastilla1[1]) {
                imprimePastilla();
            } else if (laFila == pastilla2[0] && laColumna == pastilla2[1]) {
                imprimePastilla();
            } else if (laFila == pastilla3[0] && laColumna == pastilla3[1]) {
                imprimePastilla();
            } else if (laFila == pastilla4[0] && laColumna == pastilla4[1]) {
                imprimePastilla();


            }else {
                imprimeObstaculos(unaMatriz[laFila][laColumna]);
            }
        }
        System.out.println();
    }
}

    static void imprimeObstaculos(int obstaculos) {
		String[] terreno = {
				".",
				"#",
                " "
		};
		System.out.print(terreno[obstaculos]);
	}

    static void imprimePastilla() {
        System.out.print("X");
    }
    

    
    

}
