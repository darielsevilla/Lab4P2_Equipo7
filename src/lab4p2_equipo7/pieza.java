/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo7;

/**
 *
 * @author HP
 */
public abstract class pieza {
    protected String nombre;
    protected int x;
    protected int y;
    protected boolean blanco;
    
    public pieza() {
    }

    public pieza(String nombre, int x, int y, boolean blanca) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.blanco = blanca;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isBlanco() {
        return blanco;
    }

    public void setBlanco(boolean blanco) {
        this.blanco = blanco;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "pieza{" + "nombre=" + nombre + ", x=" + x + ", y=" + y + '}';
    }
    
    public abstract boolean movimiento(int x, int y, int nX, int nY, Object[][] tablero);
}
