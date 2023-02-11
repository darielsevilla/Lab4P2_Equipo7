/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p2_equipo7;

import java.util.*;

public class Lab4P2_Equipo7 {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<pieza> piezas = new ArrayList();

    public static void main(String[] args) {
        Object[][] tablero = new Object[8][8];
        //piezas blancas
        Rey kB = new Rey(true);
        piezas.add(kB);
        Dama Dblanca = new Dama(true);
        piezas.add(Dblanca);
        Alfil alB1 = new Alfil(2, 7, true);
        piezas.add(alB1);
        Alfil alB2 = new Alfil(5, 7, true);
        piezas.add(alB2);
        Torre Tblanca = new Torre(0, 7, true);
        piezas.add(Tblanca);
        Torre Tblanca2 = new Torre(7, 7, true);
        piezas.add(Tblanca2);
        Caballo c1 = new Caballo(1, 7, true);
        piezas.add(c1);
        Caballo c2 = new Caballo(6, 7, true);
        piezas.add(c2);
        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon(i, 6, true));
        }
        //piezas negras
        Rey kN = new Rey(false);
        piezas.add(kN);
        Dama DNegra = new Dama(false);
        piezas.add(DNegra);
        Alfil alN1 = new Alfil(2, 0, false);
        piezas.add(alN1);
        Alfil alN2 = new Alfil(5, 0, false);
        piezas.add(alN2);
        Torre TNegra = new Torre(0, 0, false);
        piezas.add(TNegra);
        Torre TNegra2 = new Torre(7, 0, false);
        piezas.add(TNegra2);
        Caballo cn1 = new Caballo(1, 0, false);
        piezas.add(cn1);
        Caballo cn2 = new Caballo(6, 0, false);
        piezas.add(cn2);
        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon(i, 1, false));
        }

        for (pieza p : piezas) {
            tablero[p.getY()][p.getX()] = p;
        }
        imprimir(tablero);

        System.out.println("Jugador blancas: ");
        String j1 = leer.nextLine();
        System.out.println("Jugador negro: ");
        String j2 = leer.nextLine();
        String input = "";
        int turno = 0;
        do {
            boolean validation = true;
            do {
                validation = true;
                if (turno == 0) {
                    
                    int plays = 0;
                    if (kB.inJaque(tablero)) {
                        for (pieza p : piezas) {
                            for (int i = 0; i < tablero.length; i++) {
                                for (int j = 0; j < tablero[0].length; j++) {
                                    if (p.movimiento(p.getX(), p.getY(), j, i, tablero)) {
                                        int x = p.getX();
                                        int y = p.getY();
                                        tablero[i][j] = p;
                                        tablero[y][x] = null;
                                        if (!kB.inJaque(tablero)) {
                                            plays++;
                                        }
                                        tablero[y][x] = p;
                                        tablero[i][j] = null;
                                    }
                                }
                            }
                        }
                        if (plays == 0) {
                            System.out.println("Jaque mate");
                            System.exit(0);
                        }
                        System.out.println("plays:"+plays);
                    }
                    
                    System.out.println("Juega " + j1 + ":");

                } else {
                    int plays = 0;
                    if (kN.inJaque(piezas, tablero)) {
                        for (pieza p : piezas) {
                            for (int i = 0; i < tablero.length; i++) {
                                for (int j = 0; j < tablero[0].length; j++) {
                                    if (p.movimiento(p.getX(), p.getY(), j, i, tablero)) {
                                        int x = p.getX();
                                        int y = p.getY();
                                        tablero[i][j] = p;
                                        tablero[y][x] = null;
                                        if (!kN.inJaque(piezas, tablero)) {
                                            plays++;
                                        }
                                        tablero[y][x] = p;
                                        tablero[i][j] = null;
                                    }
                                }
                            }
                        }
                        if (plays == 0) {
                        System.out.println("Jaque mate");
                        break;
                    }
                    }

                    
                    System.out.println("Juega " + j2 + ":");
                }
                //pedir entrada

                input = leer.next();
                if (input.equals("gusbai")) {
                    break;
                }
                //validacion
                if (input.contains("|") && input.contains("-")) {
                    String[] split = input.split("\\|");
                    String[] split2 = split[1].split("-");
                    for (String a : split) {
                        System.out.println(a);
                    }

                    String nombre = split[0];
                    String posInicial = split2[0].toUpperCase();
                    String posNueva = split2[1].toUpperCase();
                    System.out.println(nombre);
                    int[] posIn = new int[2];
                    int[] posFin = new int[2];
                    //columna
                    posIn[0] = ((int) posInicial.charAt(0)) - 65;
                    if(posIn[0] >= 8 || posIn[0] < 0){
                        validation = false;
                        System.out.println("Ingrese valor valido");
                    }
                    //fila
                    posIn[1] = Integer.parseInt(Character.toString(posInicial.charAt(1))) - 1;

                    posFin[0] = ((int) posNueva.charAt(0)) - 65;
                    posFin[1] = Integer.parseInt(Character.toString(posNueva.charAt(1))) - 1;

                    if (posIn[0] <= 8 && posIn[0] >= 0 && posIn[1] <= 8 && posIn[1] >= 0) {
                        if (tablero[posIn[1]][posIn[0]] != null) {
                            if (((pieza) tablero[posIn[1]][posIn[0]]).getNombre().equals(nombre)) {

                                if (turno == 0 && ((pieza) tablero[posIn[1]][posIn[0]]).isBlanco() || turno == 1 && !((pieza) tablero[posIn[1]][posIn[0]]).isBlanco()) {

                                    if (((pieza) tablero[posIn[1]][posIn[0]]).movimiento(posIn[0], posIn[1], posFin[0], posFin[1], tablero)) {

                                        int x = ((pieza) tablero[posIn[1]][posIn[0]]).getX();
                                        int y = ((pieza) tablero[posIn[1]][posIn[0]]).getY();
                                        tablero[posFin[1]][posFin[0]] = ((pieza) tablero[posIn[1]][posIn[0]]);
                                        tablero[posIn[1]][posIn[0]] = null;
                                        if (turno == 0) {
                                            if (kB.inJaque(tablero)) {
                                                tablero[y][x] = ((pieza) tablero[posFin[1]][posFin[0]]);
                                                tablero[posFin[1]][posFin[0]] = null;
                                                System.out.println("Esta en jaque");
                                                validation = false;
                                            }
                                        } else if(turno == 1){
                                            if (kN.inJaque( tablero)) {
                                                tablero[y][x] = ((pieza) tablero[posFin[1]][posFin[0]]);
                                                tablero[posFin[1]][posFin[0]] = null;
                                                System.out.println("Esta en jaque");
                                                validation = false;
                                            }
                                        }
                                    } else {
                                        System.out.println("Movimiento no valido");
                                        validation = false;
                                    }
                                } else {
                                    System.out.println("No es su pieza");
                                    validation = false;
                                }
                            } else {
                                System.out.println("Nombre invalido");
                                validation = false;

                            }
                        } else {
                            System.out.println("Alli no hay una pieza");
                            validation = false;
                        }
                    }
                } else {
                    System.out.println("Ingrese notacion valida");
                    validation = false;
                }
                imprimir(tablero);
                if (validation == true) {
                    if (turno == 0) {
                        turno++;
                    } else {
                        turno--;
                    }
                }
            } while (validation == false);
        } while (!input.equals("gusbai"));
    }

    //Fin del main 
    public static void imprimir(Object[][] tablero) {
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + ((pieza) tablero[i][j]).getNombre() + "]");
                }

            }
            System.out.println("");
        }

    }//Fin metodo imprimir

    public static boolean checkInt(String par) {
        try {
            Integer.parseInt(par);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}//Fin de la clase
