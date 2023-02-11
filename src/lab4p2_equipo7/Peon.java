package lab4p2_equipo7;


public class Peon extends pieza {

    public Peon() {
        super();
    }

    public Peon(int x, int y, boolean blanca) {
        super();
        if (blanca) {
            this.nombre = "P";
            this.blanco = true;
        } else {
            this.nombre = "p";
            this.blanco = false;
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero) {
        boolean mover = true;
        if (y == 1 && blanco == true) {
            if (nY >= 2 && nY > y) {
            } else {
                mover = false;
            }
            if (y == 6 && blanco == false) {
                if (nY <= 2 && nY < y) {
                } else  {
                    mover = false;
                }
            } 
            if (y!=1 && blanco == true || y != 6 && blanco ==  false) {
                if (nY <= 1) {
                    mover = false;
                }
            }
   
        }
        return mover;
    }
}