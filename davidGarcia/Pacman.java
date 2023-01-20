import java.text.BreakIterator;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Pacman {

	static final int FILA = 0;
	static final int COLUMNA = 1;

	static final int ARRIBA = 1;
	static final int ABAJO = 2;
	static final int IZQUIERDA = 3;
	static final int DERECHA = 4;

	static final int[][] MOV = {
			{ 0, 0 },
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};

	static final char[] TECLAS = { 'x', 'w', 's', 'a', 'd' };
	static int marcador=0;
	public static void main(String[] args) {

        int[][] unaMatriz = {
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

		int[] elPersonaje = { 7, 10 };
		int[] elFantasma = { 5,10 };

		

		do {
			imprimeMatriz(unaMatriz, elPersonaje, elFantasma);
			defPosicion(elPersonaje,unaMatriz);
		} while
	}

	private static void defPosicion(int[] elPersonaje,int[][]elMapa) {

		switch (movimientoPersonaje()) {
			case ARRIBA:
				mueve(elPersonaje, ARRIBA, elMapa);
				break;
			case ABAJO:
				mueve(elPersonaje, ABAJO, elMapa);
				break;
			case IZQUIERDA:
				mueve(elPersonaje, IZQUIERDA, elMapa);
				break;
			case DERECHA:
				mueve(elPersonaje, DERECHA, elMapa);
				break;
		}
	}

	private static int movimientoPersonaje() {

		switch (preguntaChar()) {
			case 's', 'S', '8':
				return ABAJO;
			case 'w', 'W', '2':
				return ARRIBA;
			case 'a', 'A', '4':
				return IZQUIERDA;
			case 'd', 'D', '6':
				return DERECHA;
		}
		return 0;
	}

	static void imprimeMundo(int[][] unMapa, int[] unPersonaje, int[] elFantasma) {

		for (int fila = 0; fila < unMapa.length; fila++) {
			for (int columna = 0; columna < unMapa[fila].length; columna++) {
				if (fila == unPersonaje[FILA] && columna == unPersonaje[COLUMNA]) {
					imprimePersonaje();
				} else if (fila == elFantasma[FILA] && columna == elFantasma[COLUMNA]) {
					imprimeFantasma();
				}

				else {
					imprimeTerreno(unMapa[fila][columna]);
				}
			}
			System.out.println();
		
		}System.out.println("El marcador:"+marcador);
	}

	static void imprimeTerreno(int unTile) {

		String[] terreno = {
				" . ",
				"[#]",
		};
		System.out.print(terreno[unTile]);
	}

	static void imprimePersonaje() {

		System.out.print("_O_");

	}

	static void imprimeFantasma() {

		System.out.print("_F_");

	}

	static void mueve(int[] elPersonaje, int movimiento, int[][] elMapa) {
		int x = elPersonaje[FILA] + MOV[movimiento][FILA];
		int y = elPersonaje[COLUMNA] + MOV[movimiento][COLUMNA];
		if (elMapa[x][y] == 0 || elMapa[x][y] ==5 ) {
			elMapa[elPersonaje[FILA]][elPersonaje[COLUMNA]]=5;
			elPersonaje[FILA] = x;
			elPersonaje[COLUMNA] = y;
		}

	}
	
	static int preguntaInt() {

		Scanner entrada = new Scanner(System.in);
		return entrada.nextInt();
	}

	static String preguntaString() {

		Scanner entrada = new Scanner(System.in);
		return entrada.nextLine();
	}

	static char preguntaChar() {

		Scanner entrada = new Scanner(System.in);
		return entrada.next().charAt(0);
	}

	static void imprime() {

		System.out.print("_P_");
		System.out.print("_F_");

	}

}
