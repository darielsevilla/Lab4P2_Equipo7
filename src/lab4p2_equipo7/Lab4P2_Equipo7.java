/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p2_equipo7;

import java.util.*;

public class Lab4P2_Equipo7 {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<pieza> piezas = new ArrayList();

    public static void main(String[] args) {
        Object[][] tablero = new Object[8][8];
        Dama Dblanca = new Dama(true);
        tablero[Dblanca.getY()][Dblanca.getX()] = Dblanca;
        imprimir(tablero);
        
        System.out.println("Jugador blancar: ");
        String j1 = leer.nextLine();
        System.out.println("Jugador negro: ");
        String j2 = leer.nextLine();
        String input = "";
        int turno = 0;
        do{
            if(turno == 0){
                System.out.println("Juega " + j1 + ":");
                
            }else{
                System.out.println("Juega " + j2 + ":");
            }
            //pedir entrada
            input = leer.next();
                if(input.equals("gusbai")){
                    break;
                }
                //validacion
                if(input.contains("|") && input.contains("-")){
                    String[] split = input.split("\\|");
                    String[] split2 = split[1].split("-");
                    for (String a : split) {
                        System.out.println(a);
                    }
                    System.out.println(tablero[7][3]);
                    
                    String nombre = split[0];
                    String posInicial = split2[0].toUpperCase();
                    String posNueva = split2[1].toUpperCase();
                    System.out.println(nombre);
                    int[] posIn = new int[2];
                    int[] posFin = new int[2];
                    //columna
                    posIn[0] = ((int) posInicial.charAt(0)) - 65 ;
                    //fila
                    posIn[1] =  Integer.parseInt(Character.toString(posInicial.charAt(1))) - 1;
                   
                    posFin[0] = ((int) posNueva.charAt(0)) - 65 ;
                    posFin[1] =  Integer.parseInt(Character.toString(posNueva.charAt(1))) - 1;
                   
                    if(posIn[0] <= 8 && posIn[0] >= 0 && posIn[1] <= 8 && posIn[1] >= 0){
                        if(tablero[posIn[1]][posIn[0]] != null){
                            if(((pieza)tablero[posIn[1]][posIn[0]]).getNombre().equals(nombre)){
                                if(turno == 0 && ((pieza)tablero[posIn[1]][posIn[0]]).isBlanco() || turno == 1 && !((pieza)tablero[posIn[0]][posIn[1]]).isBlanco()){
                                        
                                    System.out.println(posFin[1]);
                                    System.out.println(posFin[0]);
                                    if(((pieza)tablero[posIn[1]][posIn[0]]).movimiento(posIn[0], posIn[1], posFin[0], posFin[1], tablero)){
                                        tablero[posFin[1]][posFin[0]] = ((pieza)tablero[posIn[1]][posIn[0]]);
                                        tablero[posIn[1]][posIn[0]] = null;
                                    }else{
                                        System.out.println("Movimiento no valido");
                                    }
                                }
                            }else{
                                System.out.println("Nombre invalido");
                            }
                        }else{
                            System.out.println("Alli no hay una pueza");
                        }
                    }
                }else{
                    System.out.println("Ingrese notacion valida");
                }
                imprimir(tablero);
                if(turno == 0){
                    turno++;
                }else{
                    turno--;
                }
        }while(!input.equals("gusbai"));
        
        

    }//Fin del main 

    public static void imprimir(Object[][] tablero) {
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + ((pieza) tablero[i][j]).getNombre() + "]");
                }

            }
            System.out.println("");
        }
        
        
    }//Fin metodo imprimir

    public static boolean checkInt(String par){
        try{
            Integer.parseInt(par);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}//Fin de la clase
