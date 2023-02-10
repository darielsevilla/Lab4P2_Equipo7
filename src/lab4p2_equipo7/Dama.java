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

    public Dama( boolean blanca) {
         super();
        if(blanca){
            this.nombre = "D";
            this.x = 3;
            this.y = 0;
            this.blanco = true;
        }else{
            this.nombre = "d";
            this.x = 3;
            this.y = 7;
            this.blanco = true;
        }
    }

   

    @Override
    public boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero) {
        ArrayList<int[]> pValidas = new ArrayList();
        //for para todos los movimientos a la derecha, representados por arrays
        for (int i = x+1; i < tablero[0].length; i++) {
            if(tablero[i][y] == null){
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = y;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][y]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = y;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para todos los movimientos a la izquierda, representado por arrays
        for (int i = x-1; i > 0; i--) {
            if(tablero[i][y] == null){
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = y;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[i][y]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = y;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para todos los movimientos a la Arriba, representado por arrays
        for (int i = y+1; i > 0; i++) {
            if(tablero[x][i] == null){
                int[] pos = new int[2];
                pos[0] = x;
                pos[1] = i;
                pValidas.add(pos);
            }else{
                if(((pieza)tablero[x][i]).isBlanco() != blanco){
                    int[] pos = new int[2];
                    pos[0] = x;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
        }
        //for para 
        return false;
        
    }
    
}
