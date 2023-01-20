import java.util.Scanner;
class pacman{	
	


	public static void main(String[] args){
		int turno=0;
        
        
		int[][] unMapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1 },
                { 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2 },
                { 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

        };

		int[][] elPersonaje = { { 7, 10 } };
        int[][] losNPCs = {{ 5, 10 }};
	

            
		do {
        
			imprimeMapa(unMapa, elPersonaje, losNPCs);
			System.out.println(""); 

		} while ((procesaMovimiento(unMapa,elPersonaje)));
	}

	private static void limpiaPantalla() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}

	private static boolean procesaMovimiento(int[][] elMapa, int[][]elPersonaje){
		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		
		inputUsuario = entrada.nextLine();
        int elPersonajeX, elPersonajeY;
		
        
		
        elPersonajeX = elPersonaje[0][0];
		elPersonajeY = elPersonaje[0][1];
		    if (inputUsuario.equals("a") && elMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) {
			elPersonajeX = elPersonajeX - 1;
		    } else if (inputUsuario.equals("d") && elMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) {
			elPersonajeX = elPersonajeX + 1;
		    } else if (inputUsuario.equals("w") && elMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) {
			elPersonajeY = elPersonajeY - 1;
		    } else if (inputUsuario.equals("s") && elMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) {
			elPersonajeY = elPersonajeY + 1;
	    	} else if (inputUsuario.equals("f")) {
			        return false;
		}
       
        elPersonaje[0][0] = elPersonajeX;
		elPersonaje[0][1] = elPersonajeY;

        if(elMapa[elPersonajeY][elPersonajeX]==2){
			puntos= puntos+3;
			elMapa[elPersonajeY][elPersonajeX]=0;
			
        }
		if(elMapa[elPersonajeY][elPersonajeX]==4){
			puntos=puntos+6;
			elMapa[elPersonajeY][elPersonajeX]=0;
			turnosPastilla=turnosPastilla+15;
		}





		return true;
	}

	
    private static void imprimeMapa(int[][] mapaPorImprimir, int[][]elPersonaje, int[][] losNPCs){
		limpiaPantalla();
		System.out.println("");
		System.out.println("Puntos: " + puntos);

		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		for (int i=0; i<mapaPorImprimir.length; i=i+1){
			imprimeBordeVertical(false);
			for (int j=0; j<mapaPorImprimir[i].length; j=j+1) {
					if (i==elPersonaje[0][1] && j==elPersonaje[0][0]) {
						imprimePersonaje();
					}else {
						if (hayNPC(losNPCs, i, j)) {
							imprimeNPC();
						} else {
							imprimeElemento(mapaPorImprimir[i][j]);
						}
					}
				 
			}
			

        
			imprimeBordeVertical(true);
		}		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		imprimeStatus(elPersonaje, losNPCs);



	}
	private static void imprimeStatus(int[][] elPersonaje, int[][] losNPCs) {
		System.out.println("Personaje en X:[" + elPersonaje[0][0] + "] Y:[" + elPersonaje[0][1] + "]");
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			System.out.print("NPC[" + unNPC + "]=(" + losNPCs[unNPC][0] + "," + losNPCs[unNPC][1] + ") - ");
		}System.out.println("");
		if(turnosPastilla>0){
			turnosPastilla=turnosPastilla-1;
			System.out.println("Te quedan "+ turnosPastilla + " movimientos con pastilla de invencibilidad");
		}else{ System.out.println("Eres mortal");}
	}

	private static boolean muerePacman(int[][] elPersonaje, int[][] losNPCs) {
        for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
            if((elPersonaje[0][0] == losNPCs[unNPC][0]) && (elPersonaje[0][1]== losNPCs[unNPC][1]) && turnosPastilla==0){
                System.out.println("Pacman murio :( Se termino el juego");
                return false;
            }//else if((elPersonaje[0][0] == losNPCs[unNPC][0]) && (elPersonaje[0][1]== losNPCs[unNPC][1]) && turnosPastilla>0){}
				
			
            
        }
        return true;
    }

	private static void imprimePersonaje(){
		System.out.print(" :v");
	}
	private static void imprimeBordeHorizontal(int laLongitud){
		System.out.print("+");
		for (int j=0;j<laLongitud;j=j+1){
			System.out.print("---");
		}
		System.out.println("+");		
	}
	private static void imprimeBordeVertical(boolean bordeDerecho){
		System.out.print("|");
		if (bordeDerecho) {System.out.println();}
	}
	
	
	private static boolean hayNPC(int[][] losNPCs, int i, int j) {
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			if (losNPCs[unNPC][0] == j && losNPCs[unNPC][1] == i) {
				return true;
			}
		}
		return false;
	}
	
	private static void imprimeNPC() {
		System.out.print("^V^");
	}

	private static void imprimeElemento(int elementoDelMapa) {
		String[] matrizDeElementos = {"   ","[#]"," . ","333"," X "};
		System.out.print(matrizDeElementos[elementoDelMapa]);
	}
	static int turnosPastilla=0;
	static int puntos=0;

}
