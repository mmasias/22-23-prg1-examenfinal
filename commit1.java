import java.util.Scanner;

public class ExamenFinal {
    static int FILA = 0;
    static int COLUMNA = 1;
    static int contadorMonedas=0;

    static void imprimeMoneda() {

		System.out.print(" . ");
	}
    static void imprimeFantasma() {

		System.out.print("F");
	}
    static void imprimePersonaje() {

		System.out.print("P");
	}
    static void imprimeTerreno(int terreno1) {

		String[] terreno = {
				" . ",
				"[#]",
                "   ",
		};
		System.out.print(terreno[terreno1]);
	}
    static final int ARRIBA = 1;
	static final int ABAJO = 2;
	static final int IZQUIERDA = 3;
	static final int DERECHA = 4;
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unMapa = {
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
            imprimeMundo(unMapa, posicionPersonaje, posicionFantasma);
        } while (!terminar);
    }
    static void imprimeMundo(int[][] unMapa, int[] elPersonaje, int[] unFantasma) {
		for (int fila = 0; fila < unMapa.length; fila++) {
			for (int columna = 0; columna < unMapa[fila].length; columna++) {
				if (fila == elPersonaje[FILA] && columna == elPersonaje[COLUMNA]) {
					imprimePersonaje();
				} else if (fila == unFantasma[FILA] && columna == unFantasma[COLUMNA]){
                    imprimeFantasma();
				} else imprimeTerreno(unMapa[fila][columna]);
				if (fila == elPersonaje[FILA] && columna==elPersonaje[COLUMNA] && unMapa[fila][columna]==1){ 
					contadorMonedas++;
					unMapa[fila][columna]=2;
				}
				
			} 
			System.out.println();
		} if (unFantasma[FILA] == elPersonaje[FILA] && unFantasma[COLUMNA]==elPersonaje[COLUMNA]) {
			System.exit(0);
		}
		System.out.println("Monedas: "+contadorMonedas);
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
    static char preguntaChar() {

		Scanner entrada = new Scanner(System.in);
		return entrada.next().charAt(0);
        switch (inputUsuario) {
            case 's', 'S', '8':
                posicionPersonaje[2] = posicionPersonaje[2] + 1;
                break;
            case 'w', 'W', '2':
                posicionPersonaje[2] = posicionPersonaje[2] - 1;
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
    }
            private static void definePosicion(int[] elPersonaje, int[] elFantasma) {

                switch (capturaMovimiento()) {
                    case ARRIBA:
                        mueve(elPersonaje, ARRIBA);
                        break;
                    case ABAJO:
                        mueve(elPersonaje, ABAJO);
                        break;
                    case IZQUIERDA:
                        mueve(elPersonaje, IZQUIERDA);
                        break;
                    case DERECHA:
                        mueve(elPersonaje, DERECHA);
                        break;
                }
            }

}
