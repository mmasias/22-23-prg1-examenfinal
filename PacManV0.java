import java.util.Scanner;

public class PacManV0 {

	static final int FILA = 0;
	static final int COLUMNA = 1;

	static final int ARRIBA = 1;
	static final int ABAJO = 2;
	static final int IZQUIERDA = 3;
	static final int DERECHA = 4;

	static final int[][] MOVIMIENTOS = {
			{ 0, 0 },
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};

	static final char[] TECLAS = { 'x', 'w', 's', 'a', 'd' };

	public static void main(String[] args) {

		int[][] elMapa = { 
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

		int[] posicionPersonaje = { 7, 10 };
		int[] posicionFantasma = { 5, 10 };

		do {
			imprimeMundo(elMapa, posicionPersonaje);
			definePosicion(posicionPersonaje);
		} while (true);
	}

	private static void definePosicion(int[] posicionPersonaje) {

		switch (capturaMovimiento()) {
			case ARRIBA:
				mueve(posicionPersonaje, ARRIBA);
				break;
			case ABAJO:
				mueve(posicionPersonaje, ABAJO);
				break;
			case IZQUIERDA:
				mueve(posicionPersonaje, IZQUIERDA);
				break;
			case DERECHA:
				mueve(posicionPersonaje, DERECHA);
				break;
		}
	}

	private static int capturaMovimiento() {

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

	static void imprimeMundo(int[][] unMapa, int[] unPersonaje) {

		for (int fila = 0; fila < unMapa.length; fila++) {
			for (int columna = 0; columna < unMapa[fila].length; columna++) {
				if (fila == unPersonaje[FILA] && columna == unPersonaje[COLUMNA]) {
					imprimePersonaje();
				} else {
					imprimeTerreno(unMapa[fila][columna]);
				}
			}
			System.out.println();
		}
	}

	static void imprimeTerreno(int unTile) {

		String[] terreno = {
				" ",
				"#",
				
				
		};
		System.out.print(terreno[unTile]);
	}
	static void imprimeFantasma() {

		System.out.print(false);
	}

	static void imprimePersonaje() {

		System.out.print("P");
	}

	static void mueve(int[] posicionPersonaje, int movimiento) {

		posicionPersonaje[FILA] = posicionPersonaje[FILA] + MOVIMIENTOS[movimiento][FILA];
		posicionPersonaje[COLUMNA] = posicionPersonaje[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA];
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
}