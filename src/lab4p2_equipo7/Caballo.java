/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo7;

import java.util.ArrayList;

/**
 *
 * @author skxka
 */
public class Caballo extends pieza {

    public Caballo() {
        super();
    }

    public Caballo(int x, int y, boolean blanca) {
        super();
        if (blanca) {
            this.nombre = "N";
        } else {
            this.nombre = "n";
        }

        this.x = x;
        this.y = y;
        this.blanco = blanca;
    }

    @Override
    public boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero) {
        ArrayList<int[]> ps = new ArrayList();
        int a = -1;
        for (int i = 1; i <= 8; i++) {
            
            int v = -2;
            int h = -1;
            if(i == 1){
                v = 2;
                h = 1;
            }else if (i== 2){
                v = 2;
                h = -1;
            }else if (i == 3){
                v = -2;
                h = 1;
            }else if(i == 4){
                v = -2;
                h = -1;
            }else if(i == 5){
                h = 2;
                v = 1;
            }else if( i == 6){
                h = 2;
                v = -1;
            }else if( i == 6){
                h = -2;
                v = 1;
            }else if(i == 8){
                h = -2;
                v = -1;
            }
            
            
            if (y - v >= 0 && y - v < 8 && x - h >= 0 && x - h < 8) {
                int nnX = x - h;
                int nnY = y - v;
                if (tablero[nnY][nnX] == null) {
                    int[] nP = new int[2];
                    nP[0] = nnY;
                    nP[1] = nnX;
                    ps.add(nP);
                } else {
                    if (((pieza) tablero[nnY][nnX]).isBlanco() != blanco) {
                        int[] nP = new int[2];
                        nP[0] = nnY;
                        nP[1] = nnX;
                        ps.add(nP);
                    }
                }
            }
        }

        int[] n = new int[2];
        n[0] = nY;
        n[1] = nX;

        for (int[] p : ps) {
            if (p[0] == n[0] && p[1] == n[1]) {

                x = nX;
                y = nY;
                return true;
            }
        }
        return false;

    }
}
