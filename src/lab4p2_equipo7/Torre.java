/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo7;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Torre extends pieza {

    public Torre() {
        super();
    }

    public Torre(int x, int y, boolean blanca) {
        super();
        if(blanca){
            nombre = "T";
            
        }else{
            nombre = "t";
            
        }
       
        this.x = x;
        this.y = y;
        this.blanco = blanca;
    }
    
    
    @Override
    public boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero) {
        ArrayList<int[]> pValidas = new ArrayList();
         //for para todos los movimientos a la derecha, representados por arrays
        for (int i = x+1; i < tablero[0].length; i++) {
            if(tablero[y][i] == null){
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = y;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[y][i]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = y;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para todos los movimientos a la izquierda, representado por arrays
        for (int i = x-1; i >= 0; i--) {
            if(tablero[y][i] == null){
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = y;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[y][i]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = y;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para todos los movimientos arriba, representado por arrays
        for (int i = y-1; i >= 0; i--) {
            if(tablero[i][x] == null){
                int[] pos = new int[2];
                pos[0] = x;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][x]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = x;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para todos los movimientos abajo, representado por arrays
        for (int i = y+1; i < tablero.length || i > tablero[0].length; i++) {
            if(tablero[i][x] == null){
                int[] pos = new int[2];
                pos[0] = x;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][x]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = x;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
        }

        //boolean para validar
        int[] validar = new int[2];
        validar[0] = nX;
        validar[1] = nY;
        
       
        for (int[] i : pValidas) {
            
            if(i[0] == validar[0] && i[1] == validar[1]){
                return true;
            }
        }
        
       return false;
    }
    
}
