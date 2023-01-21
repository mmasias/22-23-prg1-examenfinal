import java.util.Random;
import java.util.Scanner;

public class  PacmanExamenFinal{
    public static void main(String[] args) throws Exception {
        int[][] unMapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 2, 2, 2, 2, 2, 2, 0, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 0, 2, 2, 2, 2, 2, 2 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 4, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 4, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[][] elPersonaje = {{22,13}};

        int[][] losNPCs = {{12,13},{13,13},{14,13},{15,13},{15,13}};

        int[] reloj = {0,0};

        int[] turnosPastilla = {0};

        do {
            ImprimeMapa(unMapa, elPersonaje, losNPCs, reloj, turnosPastilla);
        } while (monedasRestantes(unMapa) && seguirVivo(elPersonaje, losNPCs) && seleccionarDireccion(unMapa, elPersonaje, losNPCs, turnosPastilla));
    }

    static boolean seleccionarDireccion(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs, int[] turnos) {

        Scanner entrada = new Scanner(System.in);
        String inputUsuario;
        inputUsuario = entrada.nextLine();
        char direccion = ' ';

        if (inputUsuario.equals("w")) {direccion = 'N';} else 
        if (inputUsuario.equals("s")) {direccion = 'S';} else 
        if (inputUsuario.equals("a")) {direccion = 'E';} else 
        if (inputUsuario.equals("d")) {direccion = 'O';} else 
        if (inputUsuario.equals("f")) {return false;}

        direccionNPCs(elMapa, losNPCs);
        Mover(elMapa, elPersonaje[0], direccion, turnos);
        return true;
    }

    static void direccionNPCs(int[][] elMapa, int[][] losNPCs) {
        char[] direcciones = { 'N', 'S', 'E', 'O' };
        char direccionSeleccionada = ' ';

        for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
            Random random = new Random();
            direccionSeleccionada = direcciones[random.nextInt(4)];
            MoverNPC(elMapa, losNPCs[unNPC], direccionSeleccionada);
        }

    }

    static void MoverNPC(int[][] elMapa, int[] losNPCs, char direccionSeleccionada) {

        int posicionYNPC = losNPCs[1];
        int posicionXNPC = losNPCs[0];

        if (direccionSeleccionada == 'N' && (elMapa[posicionYNPC - 1][posicionXNPC] % 2 == 0)) {
            posicionYNPC = posicionYNPC - 1;
        } else if (direccionSeleccionada == 'S' && (elMapa[posicionYNPC + 1][posicionXNPC] % 2 == 0)) {
            posicionYNPC = posicionYNPC + 1;
        } else if (direccionSeleccionada == 'E' && (elMapa[posicionYNPC][posicionXNPC - 1] % 2 == 0)) {
            posicionXNPC = posicionXNPC - 1;
        } else if (direccionSeleccionada == 'O' && (elMapa[posicionYNPC][posicionXNPC + 1] % 2 == 0)) {
            posicionXNPC = posicionXNPC + 1;
        }

        // --------------Bandas Transportadoras--------------
        if (elMapa[posicionYNPC][posicionXNPC] == 10) {
            posicionXNPC = posicionXNPC + 1;
        } else if (elMapa[posicionYNPC][posicionXNPC] == 12) {
            posicionXNPC = posicionXNPC - 1;
        } else if (elMapa[posicionYNPC][posicionXNPC] == 14) {
            posicionYNPC = posicionYNPC - 1;
        } else if (elMapa[posicionYNPC][posicionXNPC] == 16) {
            posicionYNPC = posicionYNPC + 1;
        }

        if (elMapa[posicionYNPC][posicionXNPC] == 0) {
            elMapa[posicionYNPC][posicionXNPC] = 0;
        }

        if (elMapa[posicionYNPC][posicionXNPC] == 2) {
            elMapa[posicionYNPC][posicionXNPC] = 2;
        }

        if (elMapa[posicionYNPC][posicionXNPC] == 8) {
            posicionXNPC = posicionXNPC - 1;
        } else if (elMapa[posicionYNPC][posicionXNPC] == 6) {
            posicionXNPC = posicionXNPC + 1;
        }

        losNPCs[1] = posicionYNPC;
        losNPCs[0] = posicionXNPC;
    }

    static void Mover(int[][] elMapa, int[] elPersonaje, char direccion, int[] turnos) {

        int posicionY = elPersonaje[1];
        int posicionX = elPersonaje[0];
        int turnosRestantes = turnos[0];

        if(direccion == 'N' && (elMapa[posicionY - 1][posicionX] %2  == 0)){
            posicionY = posicionY -1;
        }else if(direccion == 'S' && elMapa[posicionY + 1][posicionX] %2 == 0){
            posicionY = posicionY -1;
        }else if (direccion == 'E' && elMapa[posicionY][posicionX -1] %2 == 0){
            posicionX = posicionX - 1;
        }else if (direccion == 'O' && elMapa[posicionY][posicionX + 1]%2 == 0){
            posicionX = posicionX + 1;
        }

       // --------------Teletrasporte--------------
       if (posicionX == 27 && posicionY == 13) {
        posicionX = 0;
        } else if (posicionX == 0 && posicionY == 13) {
        posicionX = 27;
        }
            
        // --------------Bandas Transportadoras--------------
         if (elMapa[posicionY][posicionX] == 10) {
            posicionX = posicionX + 1;
        } else if (elMapa[posicionY][posicionX] == 12) {
            posicionX = posicionX - 1;
        } else if (elMapa[posicionY][posicionX] == 14) {
            posicionY = posicionY - 1;
        } else if (elMapa[posicionY][posicionX] == 16) {
            posicionY = posicionY + 1;
        }


        // --------------Limpiar monedas--------------
        if (elMapa[posicionY][posicionX] == 0) {
            puntos = puntos + 1;
            elMapa[posicionY][posicionX] = 2;
        }

        // --------------Turnos de pastilla-----------
        if (elMapa[posicionY][posicionX] == 4) {
            puntos = puntos + 3;
            turnosRestantes = 21;
            elMapa[posicionY][posicionX] = 2;
        }
        turnos[0] = turnosRestantes;
        restarTurnos(turnos);

        movimientosHechos = movimientosHechos + 1;
        
        //--------Invencibilidad-------
        if (movimientosHechos == 80) {
            elMapa[15][14] = 6;
        }

        if (elMapa[posicionY][posicionX] == 6) {
            puntos = puntos + 10;
            elMapa[posicionY][posicionX] = 2;
        }

        elPersonaje[1] = posicionY;
        elPersonaje[0] = posicionX;

        
    }       

    static void restarTurnos(int[] turnosRestantes) {
        if (turnosRestantes[0] > 0) {
            turnosRestantes[0] = turnosRestantes[0] - 1;
            NPCvulnerable(turnosRestantes);
        }
    }

    static boolean NPCvulnerable(int[] turnosRestantes){
        if (turnosRestantes[0] > 0) {
            estaVulnerable = true;
            return estaVulnerable;
        }
        estaVulnerable = false;
        return estaVulnerable;

    }

    static boolean seguirVivo(int[][] elPersonaje, int[][] elNPC) {
        int personajeX = elPersonaje[0][0];
        int personajeY = elPersonaje[0][1];

        if(hayNPC(elNPC, personajeY, personajeX) && estaVulnerable){
            return true;
        }
        else if(hayNPC(elNPC, personajeY, personajeX)){
            return false;
        }
        return true;
    } 

    static boolean monedasRestantes(int[][] elMapa) {
        int monedasRestantes = 0;
        for (int i = 0; i < elMapa.length; i++) {
            for (int j = 0; j < elMapa[i].length; j++) {
                if (elMapa[i][j] == 0 || elMapa[i][j] == 4) {
                    monedasRestantes = monedasRestantes + 1;
                }
            }
        }
        if (monedasRestantes == 0) {
            System.out.println("Enhorabuena, has ganado!");
            return false;
        }
        ImprimeMonedas(monedasRestantes);
        return true;
    }

    static void ImprimeMapa(int[][] MapaPorImprimir, int[][] elPersonaje, int[][] losNPCs, int[] reloj, int[] turnos) {

        limpiaPantalla();
        ImprimeBorde(MapaPorImprimir[0].length);

        for (int i = 0; i < MapaPorImprimir.length; i++) {
            for (int j = 0; j < MapaPorImprimir[i].length; j++) {
                if (puedoVer(i, j, elPersonaje)) {
                    if (i == elPersonaje[0][1] && j == elPersonaje[0][0]) {
                        ImprimePersonaje();
                    } else {
                        if (hayNPC(losNPCs, i, j)) {
                            ImprimeNPC();
                        } else {
                            ImprimeElemento(MapaPorImprimir[i][j]);
                        }
                    }
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }   
        ImprimeBorde(MapaPorImprimir[0].length);
        System.out.println("El personaje esta en: " + "X: " + "[" + elPersonaje[0][0] + "]" + " Y: " + "["
                + elPersonaje[0][1] + "]");
        System.out.println("Turnos restantes: [" + turnos[0] + "]");
        System.out.println("Movimientos hechos: " + "[" + movimientosHechos + "]");
    }

    static void limpiaPantalla() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    static void ImprimeBorde(int LongitudH) {
        for (int j = 0; j < LongitudH; j++) {
            System.out.print("---");
        }
        System.out.println();
    }

    static void ImprimePersonaje() {
        System.out.print(INICIO + WHITE_BOLD + BLACK_BACKGROUND + "\\0/" + RESET);
    }

    static boolean puedoVer(int i, int j, int[][] elPersonaje) {
        return true;
    }


    static boolean hayNPC(int[][] losNPCs, int i, int j) {

        for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
            if (losNPCs[unNPC][0] == j && losNPCs[unNPC][1] == i) {
                return true;
            }
        }
        return false;
    }

    static void ImprimeNPC() {
        if (estaVulnerable == true) {
            System.out.print(INICIO + PURPLE_BOLD + BLACK_BACKGROUND + "^|^" + RESET);
        } else {
            System.out.print(INICIO + CYAN_BOLD + BLACK_BACKGROUND + "^|^" + RESET);
        }
    }

    static void ImprimeElemento(int i) {
        String[] Elementos = {
                INICIO + YELLOW_BOLD + BLACK_BACKGROUND + " * " + RESET,
                INICIO + BLUE_BOLD + BLACK_BACKGROUND + "[=]" + RESET,
                INICIO + WHITE_BOLD + BLACK_BACKGROUND + " . " + RESET,
                "",
                INICIO + RED_BOLD + BLACK_BACKGROUND + "(0)" + RESET,
                "",
                INICIO + GREEN_BOLD + BLACK_BACKGROUND + "@@@" + RESET,
        };
        System.out.print(Elementos[i]);
    }

    static void ImprimeMonedas(int monedasRestantes){
        System.out.println("Monedas restantes: " + "[" + monedasRestantes + "]");
        System.out.println("Puntos: " + puntos);
    }

    static boolean estaVulnerable = false;
    static int puntos = 0;
    static int movimientosHechos = 0;

    private static String INICIO = "\033[";
    private static String RESET = "\033[0m";

    private static String RED_BOLD = "1;31";
    private static String GREEN_BOLD = "1;32";
    private static String YELLOW_BOLD = "1;33";
    private static String BLUE_BOLD = "1;34";
    private static String PURPLE_BOLD = "1;35";
    private static String CYAN_BOLD = "1;36";
    private static String WHITE_BOLD = "1;37";

    private static String BLACK_BACKGROUND = ";40m";

    
    
    

    


}

