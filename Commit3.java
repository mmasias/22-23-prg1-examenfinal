import java.util.Scanner;

public class CxamenFinal3 {
    static int[] elPersonaje = { 7, 10 };
    static int[] elFantasma = { 5, 10 };
    static int FILA = 0;
    static int COLUMNA = 1;
    static int contadorMonedas=0;
    static int invencible=0;
    static final int[][] MOVIMIENTOS = {
        { 0, 0 },
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
};
    static void imprimeFantasma() {

		System.out.print(" F ");
	}
    static void imprimePersonaje() {

		System.out.print(" P ");
	}
    static void imprimeTerreno(int unTile) {

		String[] terreno = {
				" . ",
				"[#]",
                "   ",
                " X ",
		};
		System.out.print(terreno[unTile]);
	}
    static final int ARRIBA = 1;
	static final int ABAJO = 2;
	static final int IZQUIERDA = 3;
	static final int DERECHA = 4;
    static boolean terminar = false;
    public static void main(String[] args) {

        int[][] unMapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 3, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 3, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 2, 2, 2, 2, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };



        do {
            imprimeMundo(unMapa, elPersonaje, elFantasma);
            definePosicion(elPersonaje);
        } while (!terminar);
    }
    static void imprimeMundo(int[][] unMapa, int[] elPersonaje, int[] unFantasma) {
		for (int fila = 0; fila < unMapa.length; fila++) {
			for (int columna = 0; columna < unMapa[fila].length; columna++) {
				if (fila == elPersonaje[FILA] && columna == elPersonaje[COLUMNA]) {
					imprimePersonaje();
				} else if (fila == unFantasma[FILA] && columna == unFantasma[COLUMNA]){
                    imprimeFantasma();
				}
                else imprimeTerreno(unMapa[fila][columna]);
				if (fila == elPersonaje[FILA] && columna==elPersonaje[COLUMNA] && unMapa[fila][columna]==0){ 
					contadorMonedas++;
					unMapa[fila][columna]=2;
				}
                if (fila == elPersonaje[FILA] && columna==elPersonaje[COLUMNA] && unMapa[fila][columna]==3){ 
                    contadorMonedas = contadorMonedas + 2;
					unMapa[fila][columna]=2;
                    invencible = invencible + 15;
				}
				
			}
			System.out.println();
		}
        if (elFantasma[FILA] == elPersonaje[FILA] && elFantasma [COLUMNA]==elPersonaje[COLUMNA] && invencible >= 15) {
            System.out.println("USTED SE HA COMIDO UN FANTASMA");
        }
		System.out.println("Puntos: "+ contadorMonedas*3);
        System.out.println("Invencibilidad: "+ invencible);
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
    }
    private static void definePosicion(int[] elPersonaje) {

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
        
    static void mueve(int[] elPersonaje, int movimiento) {
        elPersonaje[FILA] = elPersonaje[FILA] + MOVIMIENTOS[movimiento][FILA];
        elPersonaje[COLUMNA] = elPersonaje[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA];
        if( elPersonaje[FILA]==11){
            elPersonaje[FILA]=1;
            }
            if( elPersonaje[FILA]==0){
            elPersonaje[FILA]=10;
            }
            
            if( elPersonaje[COLUMNA]==21){
            elPersonaje[COLUMNA]=1;
            }
            if( elPersonaje[COLUMNA]==0){
            elPersonaje[COLUMNA]=20;
            }
    }
}
