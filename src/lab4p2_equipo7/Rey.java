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
public class Rey extends pieza {

    public Rey() {
        super();
    }

    public Rey(boolean blanca) {
        super();
        if (blanca) {
            nombre = "K";
            x = 4;
            y = 7;
        } else {
            nombre = "k";
            x = 4;
            y = 0;
        }
        blanco = blanca;
    }

    @Override
    public boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero) {
        ArrayList<int[]> moves = new ArrayList();

        for (int i = y - 1; i <= y + 1; i++) {

            for (int j = x - 1; j <= x + 1; j++) {

                if (i >= 0 && i < 8 && j >= 0 && j < 8) {
                    if (!(i == y && j == x)) {
                        if (tablero[i][j] == null) {
                            int[] mat = new int[2];
                            mat[0] = j;
                            mat[1] = i;
                            moves.add(mat);
                        } else {

                            if (((pieza) tablero[i][j]).isBlanco() != this.blanco) {
                                int[] mat = new int[2];
                                mat[0] = j;
                                mat[1] = i;
                                moves.add(mat);
                            }
                        }
                    }
                } else {
                    
                }
            }
        }

        for (int[] move : moves) {
            if (move[0] == nX && move[1] == nY) {
                System.out.println(move[0] + " " + move[1]);
                y = nY;
                x = nX;
                return true;
            }
        }
        return false;
    }

    public boolean inJaque(ArrayList<pieza> pieza, Object[][] tablero) {
      
        for (int i = 0; i < pieza.size(); i++) {
            pieza p = pieza.get(i);
            if (Boolean.compare(p.isBlanco(), blanco) != 0) {
                if (p.movimiento(p.getX(), p.getY(), x, y, tablero)) {
                   
                    return true;
                }
            }

        }
        return false;
        
    }
    
    public boolean inJaque(Object[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if(tablero[i][j] != null){
                    if(Boolean.compare(((pieza)tablero[i][j]).isBlanco(), blanco) != 0){
                    if(((pieza)tablero[i][j]).movimiento(((pieza)tablero[i][j]).getX(), ((pieza)tablero[i][j]).getY(), x, y, tablero)){
                        return true;
                    }
                }
                }
            }
        }
        return false;
                
                
    }
    
}
