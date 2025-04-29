package model;

import interfaces.*;

public class Arquero extends Fisico implements Volador, Movilizable{
    double agilidad;
    int numFlechas;
    public Arquero(Nombre nombre, int nivel, int salud, int ataque, int defensa, double agilidad, int numFlechas){
        super(nombre, nivel, salud, ataque, defensa);
        this.agilidad = agilidad;
        this.numFlechas = numFlechas;
    }
    void restablecerFlechas(){
        System.out.println("Restablecer flechas");
    }

    void dispararFlechas(){
        System.out.println("Gasta flechas para infligir daño fisico a distancia");
    }
}