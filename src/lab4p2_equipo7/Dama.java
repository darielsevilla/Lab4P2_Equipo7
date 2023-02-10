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
public class Dama extends pieza{

    public Dama() {
        super();
    }

    public Dama(boolean blanca) {
         super();
        if(blanca){
            this.nombre = "Q";
            this.x = 3;
            this.y = 7;
            this.blanco = true;
        }else{
            this.nombre = "q";
            this.x = 3;
            this.y = 0;
            this.blanco = true;
        }
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
        //for para los movimientos en diagonal arriba derecha, representado por arrays
        for (int i = y-1, j = x + 1; i >= 0 && j < tablero.length; i--, j++) {
            if(tablero[i][j] == null){
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][j]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = j;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para los movimientos en diagonal arriba izquierda, representado por arrays
        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {

            
            if(tablero[i][j] == null){
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][j]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = j;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para los movimientos en diagonal abajo izquierda, representado por arrays
        for (int i = y + 1, j = x - 1; i < tablero.length && j >= 0; i--, j++) {
            if(tablero[i][j] == null){
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][j]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = j;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para los movimientos diagonal abajo derecha, representado por arrays
        for (int i = y + 1, j = x + 1; i < tablero.length && j < tablero.length; i++, j++) {
           
            if(tablero[i][j] == null){
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][j]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = j;
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
