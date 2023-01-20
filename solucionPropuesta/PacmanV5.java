import java.util.Scanner;

public class PacmanV5 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 4, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 4, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 0 },
                { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
		int puntos=0;
		int invencibilidad=0;
		
		int limiteInferior=0; 
		int limiteSuperior=unaMatriz.length-1;
		int limiteIzquierdo=0;
		int limiteDerecho=unaMatriz[0].length-1;
		int skin=0;

        do {
			System.out.println("Pts: [" + puntos + "] / INV: [" + invencibilidad + "] / Skin:"+skin);
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        imprimePacman(skin);
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        imprimeFantasma(skin);
                    } else {
                        imprimeTerreno(unaMatriz[laFila][laColumna], skin);
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
				case 'v', 'V':
					skin = skin + 1;
					if (skin>2) {skin=0;}
					break;
                case 'f', 'F':
                    terminar = true;
            }
			
			if (posicionPersonaje[0]<limiteInferior) {posicionPersonaje[0]=limiteSuperior;}
			if (posicionPersonaje[0]>limiteSuperior) {posicionPersonaje[0]=limiteInferior;}
			if (posicionPersonaje[1]<limiteIzquierdo) {posicionPersonaje[1]=limiteDerecho;}
			if (posicionPersonaje[1]>limiteDerecho) {posicionPersonaje[1]=limiteIzquierdo;}
					
			if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 2){
				unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]]=0;
				puntos = puntos+3;
			} else if (unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]] == 4) {
				unaMatriz[posicionPersonaje[0]][posicionPersonaje[1]]=0;
				puntos = puntos+6;
				invencibilidad=invencibilidad+15;
			}
			
			if (invencibilidad>0) {
				invencibilidad=invencibilidad-1;
			}
			
        } while (!terminar);
    }
	
	static void imprimeTerreno(int unTile, int skin){
		
		String[][] terreno = {
			{" ","  ","   "},
			{"#","##","###"},
			{".","()"," O "},
			{"?","??","???"},
			{"*","><"," X "}
		};
		System.out.print(terreno[unTile][skin]);
	}	
	
	static void imprimePacman(int skin){
		String[] pacman = {"P","PP","PPP"};
		System.out.print(pacman[skin]);
	}
	
	static void imprimeFantasma(int skin){
		String[] fantasma = {"F","FF","FFF"};
		System.out.print(fantasma[skin]);
	}
	
}