import java.util.Scanner;

public class Pacman {
    
    private static int puntos = 0, invencibilidad = 0;

    public static void main(String[] args) {

        int[][] elMapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 3, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 3, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] elPersonaje = { 7, 10 };
        int[] fantasma1 = { 5, 10 };

        do {
            imprimeMapa(elMapa, elPersonaje, fantasma1);
			
        } while (movimientoPacman(elMapa, elPersonaje));
    }

    private static void dibujaPersonaje() {

		System.out.print("UwU");

	}

    private static void dibujaFantasma() {

		System.out.print("*o*");

	}

    private static boolean movimientoPacman(int[][] elMapa, int[] pacman) {

        
		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		String laDireccion="";

		inputUsuario = entrada.nextLine();

		if (inputUsuario.equals("w")) 
        {
            laDireccion="ARRIBA";
        }else if (inputUsuario.equals("W")) 
        {
            laDireccion="ARRIBA";
        }else if (inputUsuario.equals("8")) 
        {
            laDireccion="ARRIBA";
        }else if (inputUsuario.equals("a")) 
        {
            laDireccion="IZQUIERDA";
        }else if (inputUsuario.equals("A")) 
        {
            laDireccion="IZQUIERDA";
        }else if (inputUsuario.equals("4")) 
        {
            laDireccion="IZQUIERDA";
        } else if (inputUsuario.equals("s")) 
        {
            laDireccion="ABAJO";
        } else if (inputUsuario.equals("S")) 
        {
            laDireccion="ABAJO";
        }else if (inputUsuario.equals("2")) 
        {
            laDireccion="ABAJO";
        } else if (inputUsuario.equals("d")) 
        {
            laDireccion="DERECHA";
        }else if (inputUsuario.equals("D")) 
        {
            laDireccion="DERECHA";
        } else if (inputUsuario.equals("6")) 
        {
            laDireccion="DERECHA";
        }else if (inputUsuario.equals("f")) 
        {
            return false;
        }

		moverPersonaje(pacman, elMapa, laDireccion);
		return true;

	}

    private static void moverPersonaje(int[] pacman, int[][] elMapa, String unaDireccion){

		switch (unaDireccion) {
                    case "ABAJO":
                        pacman[1] = pacman[1] + 1;
                        if (invencibilidad > 0) {
                            puntos += 3;
                            invencibilidad --;
                        }
                        break;
                    case "ARRIBA":
                        pacman[1] = pacman[1] - 1;
                        if (invencibilidad > 0) {
                            puntos += 3;
                            invencibilidad --;
                        }
                        break;
                    case "IZQUIERDA":
                        pacman[0] = pacman[0] - 1;
                        if (invencibilidad > 0) {
                            puntos += 3;
                            invencibilidad --;
                        }
                        break;
                    case "DERECHA":
                        pacman[0] = pacman[0] + 1;
                        if (invencibilidad > 0) {
                            puntos += 3;
                            invencibilidad --;
                        }
                        break;
                }
                registraPuntos(pacman, elMapa);
                
	}

    private static void registraPuntos(int[] pacman, int[][] elMapa){
        if(elMapa[pacman[1]][pacman[0]] == 0){
            elMapa[pacman[1]][pacman[0]] = 2;
            puntos += 3;
        }else if(elMapa[pacman[1]][pacman[0]] == 3){
            invencibilidad += 15;
            elMapa[pacman[1]][pacman[0]] = 2;
            puntos += 6;
        }
    }

    private static void dibujaPuntos() {
		System.out.println("Tienes [ "+ puntos +" ] puntos");
    }

    private static void dibujaInvencibilidad() {
        if (invencibilidad < 15) {
            System.out.println("Te quedan [ "+ invencibilidad +" ] movimientos de invencibilidad");
        }
		
    }

    private static void imprimeMapa(int[][] mapa, int[] pacman, int[] fantasma1) {

		for (int y = 0; y < mapa.length; y++) 
		{
			for (int x = 0; x < mapa[y].length; x++) 
			{
                if (x == pacman[0] && y == pacman[1]) 
				{
                    dibujaPersonaje();

                } else if(x == fantasma1[0] && y == fantasma1[1]){
					dibujaFantasma();  
                }else {
					dibujaElemento(mapa[y][x]);
				}
			}
			System.out.println();
		}
		System.out.println();
        dibujaPuntos();
        dibujaInvencibilidad();
		System.out.println("Utilice las teclas WASD y luego presione Enter para moverse por el mapa.");

	}

    private static void dibujaElemento(int elementos) {

		String[] terreno = {
				 " . " ,
				 "[ ]" ,
                 "   " ,
                 " O "
		};
		System.out.print(terreno[elementos]);
	}
}