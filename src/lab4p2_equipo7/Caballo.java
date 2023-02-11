/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo7;

/**
 *
 * @author skxka
 */
public class Caballo extends pieza {

    public Caballo() {
        super();
    }

    public Caballo(String nombre, int x, int y, boolean blanca) {
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
        boolean mover = true;
        if (blanco == true) {
            if ((nX == 1 && nY == 2 || nX == 2 && nY == y)) {
            } else {
                mover = false;
            }
            }else {
                 mover = false;   
                    }
            return mover;
        }

    }
