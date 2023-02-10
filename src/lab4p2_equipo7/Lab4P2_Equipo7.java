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
        imprimir(tablero);

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

}//Fin de la clase
