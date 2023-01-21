import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

   

        String[][] mapa = {

                {"[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]"}, 
                {"[]","o",".",".",".",".",".",".",".",".",".",".",".","[]","[]","[]",".",".",".",".",".",".",".",".",".",".",".","o","[]"}, 
                {"[]",".","[]","[]","[]",".","[]","[]","[]","[]","[]","[]",".",".",".",".",".","[]","[]","[]","[]","[]","[]",".","[]","[]","[]",".","[]"}, 
                {"[]",".",".",".",".",".","[]","[]","[]","[]","[]","[]",".","[]","[]","[]",".","[]","[]","[]","[]","[]","[]",".",".",".",".",".","[]"}, 
                {"[]",".","[]","[]","[]",".",".",".",".",".",".","o",".",".",".",".",".","o",".",".",".",".",".",".","[]","[]","[]",".","[]"}, 
                {"[]",".","[]","[]","[]",".","[]","[]","[]","[]","[]",".","[]","[]","[]","[]","[]",".","[]","[]","[]","[]","[]",".","[]","[]","[]",".","[]"}, 
                {"[]",".",".",".",".",".",".",".",".",".",".",".","[]","","","","[]",".",".",".",".",".",".",".",".",".",".",".","[]"}, 
                {"[]",".","[]","[]","[]","[]","[]","[]","[]","[]","[]",".","[]","","","","[]",".","[]","[]","[]","[]","[]","[]","[]","[]","[]",".","[]"}, 
                {"",".","[]","[]","[]","[]","[]","[]","[]","[]","[]",".","[]","","","","[]",".","[]","[]","[]","[]","[]","[]","[]","[]","[]",".",""},
                {"[]",".","[]","[]","[]","[]","[]","[]","[]","[]","[]",".","[]","","","","[]",".","[]","[]","[]","[]","[]","[]","[]","[]","[]",".","[]"}, 
                {"[]",".",".",".",".",".",".",".",".",".",".",".","[]","","","","[]",".",".",".",".",".",".",".",".",".",".",".","[]"}, 
                {"[]",".","[]","[]","[]",".","[]","[]","[]","[]","[]",".","[]","[]","[]","[]","[]",".","[]","[]","[]","[]","[]",".","[]","[]","[]",".","[]"}, 
                {"[]",".","[]","[]","[]",".",".",".",".",".",".","o",".",".",".",".",".","o",".",".",".",".",".",".","[]","[]","[]",".","[]"}, 
                {"[]",".",".",".",".",".","[]","[]","[]","[]","[]","[]",".","[]","[]","[]",".","[]","[]","[]","[]","[]","[]",".",".",".",".",".","[]"}, 
                {"[]",".","[]","[]","[]",".","[]","[]","[]","[]","[]","[]",".",".",".",".",".","[]","[]","[]","[]","[]","[]",".","[]","[]","[]",".","[]"}, 
                {"[]","o",".",".",".",".",".",".",".",".",".",".",".","[]","[]","[]",".",".",".",".",".",".",".",".",".",".",".","o","[]"}, 
                {"[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]","[]"} 

        };

      

        int pacmanI = 14;
        int pacmanJ = 14;
        int fantasmaI = 4;
        int fantasmaJ = 14;
        int fantasmaI2 = 4;
        int fantasmaJ2 = 5;
        int turnos = 0;
        int bolitas = 0;
        int puntos = 0;
        int vidas = 2;
        int end = 0;
        int poder = 0;


        String posAnteriorFantasma = " ";
        String posAnteriorFantasma2 = " ";
        mapa[pacmanJ][pacmanJ] = "<O";
        mapa[fantasmaI][fantasmaJ] = "F";
        mapa[fantasmaI2][fantasmaJ2] = "F";



      

        for(int i=0;i<mapa.length;i++){

            for(int j=0;j<mapa[0].length;j++){


                System.out.print(mapa[i][j]+"\t");

            }

            System.out.println();

        }

       

        Scanner entrada = new Scanner(System.in);

        while(bolitas!=199){


           

         

            

           

            System.out.println("Donde vas a moverte?(w,a,s,d");
            String movPacman = entrada.next();

         

            if(movPacman.equalsIgnoreCase("w")){

                if(mapa[pacmanI-1][pacmanJ]=="[]"){ 


                }else{

                    mapa[pacmanI][pacmanJ] = " ";

                    if(mapa[pacmanI-1][pacmanJ] == "." || mapa[pacmanI-1][pacmanJ] == "o"){ 

                        if(mapa[pacmanI-1][pacmanJ] == "o"){ 


                            poder = poder + 15; 


                        }
                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI-1][pacmanJ] = "<O";

                    pacmanI = pacmanI - 1;

                    System.out.println("Pacman hacia arriba");

                  

                    turnos++;

                }

            }

           

            if(movPacman.equalsIgnoreCase("a")){

                if(pacmanI==8 && pacmanJ==0){ 

                    mapa[pacmanI][pacmanJ] = " ";
                    pacmanI=8;
                    pacmanJ=28;
                    mapa[pacmanI][pacmanJ] = "<O";

                } else if (mapa[pacmanI][pacmanJ-1]=="[]") { 

                    System.out.println("Hay una pared");
                    
                } else{

                    mapa[pacmanI][pacmanJ] = " ";

                    if(mapa[pacmanI][pacmanJ-1] == "." || mapa[pacmanI][pacmanJ-1] == "o"){ 

                        if(mapa[pacmanI][pacmanJ-1] == "o"){ 


                            poder = poder + 15; 


                        }

                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI][pacmanJ-1] = "<O";

                    pacmanJ = pacmanJ - 1;

                    System.out.println("Pacman hacia izquierda");

                   

                    turnos++;

                }

            }

            

            if(movPacman.equalsIgnoreCase("d")){

                if(pacmanI==8 && pacmanJ==28){ 

                    mapa[pacmanI][pacmanJ] = " ";
                    pacmanI=8;
                    pacmanJ=0;
                    mapa[pacmanI][pacmanJ] = "<O";

                } else if(mapa[pacmanI][pacmanJ+1]=="[]"){ 

                    System.out.println("Hay una pared");

                }else{

                    mapa[pacmanI][pacmanJ] = " ";

                    if(mapa[pacmanI][pacmanJ+1] == "." || mapa[pacmanI][pacmanJ+1] == "o"){ 

                        if(mapa[pacmanI][pacmanJ+1] == "o"){ 


                            poder = poder + 15; 


                        }

                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI][pacmanJ+1] = "<O";

                    pacmanJ = pacmanJ+1;

                    System.out.println("Pacman hacia la derecha");

                    

                    turnos++;

                }

            }

           

            if(movPacman.equalsIgnoreCase("s")){

                if(mapa[pacmanI+1][pacmanJ]=="[]"){

                    System.out.println("Hay una pared");

                }else{

                    mapa[pacmanI][pacmanJ] = " ";

                    if(mapa[pacmanI+1][pacmanJ] == "." || mapa[pacmanI+1][pacmanJ] == "o"){ 

                        if(mapa[pacmanI+1][pacmanJ] == "o"){ 

                            poder = poder + 15; 

                        }

                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI+1][pacmanJ] = "<O";

                    pacmanI = pacmanI+1;

                    System.out.println("Pacman hacia abajo");

                   

                    turnos++;

                }

            }


            

            for(int i=0;i<mapa.length;i++) {

                for(int j=0;j<mapa[i].length;j++) {

                    System.out.print(mapa[i][j]+"\t");

                }

                System.out.println();

            }

            System.out.println("Turnos: "+turnos);

           

            System.out.println("Puntos conseguidos: "+puntos);

            System.out.println("Vidas: "+vidas);

            System.out.println("Poder: "+poder);

            

            if(poder>0){

                poder--;

            }

      

            if((mapa[pacmanI][pacmanJ] == mapa[fantasmaI][fantasmaJ])){

                if(poder==0){

                    

                    vidas--;

                    if(vidas>=0){

                       

                        mapa[14][14] = "<O";

                        pacmanI = 14;
                        pacmanJ = 14;

                    }else{

                       

                        end = 1;

                        break;

                    }

                }else{

                   

                        mapa[4][14] = "Ñ";
                        fantasmaI = 4;
                        fantasmaJ = 14;


                }

            }

            if((mapa[pacmanI][pacmanJ] == mapa[fantasmaI2][fantasmaJ2])){

                if(poder==0){

                   

                    vidas--;

                    if(vidas>=0){

                        

                        mapa[14][14] = "<O";

                        pacmanI = 14;
                        pacmanJ = 14;

                    }else{

                        

                        end = 1;

                        break;

                    }

                }else{

                 

                    mapa[4][5] = "F";
                    fantasmaI2 = 4;
                    fantasmaJ2 = 5;


                }

            }

        }

       

        if(end==0){

            System.out.println("Victoria");

        } else if (end==1) {

            System.out.println("Derrota");

        }

    }

}
