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
public class Alfil extends pieza {

    public Alfil() {
        super();
    }

    public Alfil(int x, int y, boolean blanca) {
        super();
        if (blanca) {
            nombre = "A";
        } else {
            nombre = "a";
        }
        this.x = x;
        this.y = y;
        this.blanco = blanca;
    }

    @Override
    public boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero) {
        ArrayList<int[]> pValidas = new ArrayList();
        //for para los movimientos en diagonal arriba derecha, representado por arrays
        for (int i = y - 1, j = x + 1; i >= 0 && j < tablero.length; i--, j++) {
            if (tablero[i][j] == null) {
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            } else {
                if (((pieza) tablero[i][j]).isBlanco() != blanco) {
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

            if (tablero[i][j] == null) {
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            } else {
                if (((pieza) tablero[i][j]).isBlanco() != blanco) {
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
            if (tablero[i][j] == null) {
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            } else {
                if (((pieza) tablero[i][j]).isBlanco() != blanco) {
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

            if (tablero[i][j] == null) {
                int[] pos = new int[2];
                pos[0] = j;
                pos[1] = i;
                pValidas.add(pos);
            } else {
                if (((pieza) tablero[i][j]).isBlanco() != blanco) {
                    int[] pos = new int[2];
                    pos[0] = j;
                    pos[1] = i;
                    pValidas.add(pos);
                }
                break;
            }
   
        }
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
