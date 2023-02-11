package lab4p2_equipo7;

import java.util.ArrayList;

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
        ArrayList<int[]> pos = new ArrayList();
        if (blanco == true && y != 0) {
            if (y == 6) {
                for (int i = 1; i <= 2; i++) {
                    if (tablero[y - i][x] == null) {
                        int[] p = new int[2];
                        p[0] = x;
                        p[1] = y - i;
                        pos.add(p);
                    }
                }
            } else {
                if (y - 1 < 7 && tablero[y - 1][x] == null) {
                    int[] p = new int[2];
                    p[0] = x;
                    p[1] = y - 1;
                    pos.add(p);
                }
            }

            if (y - 1 >= 0 && x - 1 >= 0) {
                if (tablero[y - 1][x - 1] != null) {
                    if (((pieza) tablero[y - 1][x - 1]).isBlanco() != blanco) {
                        int[] p = new int[2];
                        p[0] = x - 1;
                        p[1] = y - 1;
                        pos.add(p);
                    }
                }
            }
            if (y - 1 >= 0 && x + 1 < tablero[0].length) {
                if (tablero[y - 1][x + 1] != null) {
                    if (((pieza) tablero[y - 1][x + 1]).isBlanco() != blanco) {
                        int[] p = new int[2];
                        p[0] = x + 1;
                        p[1] = y - 1;
                        pos.add(p);
                    }
                }
            }
        } else if (blanco == false && y != 7) {
            if (y == 1) {
                for (int i = 1; i <= 2; i++) {
                    if (tablero[y + i][x] == null) {
                        int[] p = new int[2];
                        p[0] = x;
                        p[1] = y + i;
                        pos.add(p);
                    }
                }
            } else {
                if (y - 1 < 7 && tablero[y + 1][x] == null) {
                    int[] p = new int[2];
                    p[0] = x;
                    p[1] = y + 1;
                    pos.add(p);
                }
            }

            if (x - 1 >= 0 && y + 1 < tablero.length) {
                if (tablero[y + 1][x - 1] != null) {
                    if (((pieza) tablero[y + 1][x - 1]).isBlanco() != blanco) {
                        int[] p = new int[2];
                        p[0] = x - 1;
                        p[1] = y + 1;
                        pos.add(p);
                    }
                }
            }

            if (x + 1 < tablero[0].length && y + 1 < tablero.length) {
                if (tablero[y + 1][x + 1] != null) {
                    if (((pieza) tablero[y + 1][x + 1]).isBlanco() != blanco) {
                        int[] p = new int[2];
                        p[0] = x + 1;
                        p[1] = y + 1;
                        pos.add(p);
                    }
                }
            }
        }

        for (int[] po : pos) {
            if (po[0] == nX && po[1] == nY) {
                return true;
            }
        }
        return false;

    }
}
