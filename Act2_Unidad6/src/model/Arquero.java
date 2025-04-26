package model;

import interfaces.*;

public class Arquero extends Fisico implements Volador, Movilizable{
    double agilidad;
    int numFlechas;
    public Arquero(String nombre, int nivel, int salud, int ataque, int defensa, double agilidad, int numFlechas){
        super(nombre, nivel, salud, ataque, defensa);

    }
    void restablecerFlechas(){
        System.out.println("Restablecer flechas");
    }

    void dispararFlechas(){
        System.out.println("Gasta flechas para infligir daño fisico a distancia");
    }

}