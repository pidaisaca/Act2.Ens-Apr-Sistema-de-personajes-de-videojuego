package model;

import interfaces.*;

public class Asesino extends Fisico implements Movilizable, Curable{
    double sigilo;
    double critico;
    public Asesino(String nombre, int nivel, int salud, int ataque, int defensa, double sigilo, double critico){
        super(nombre, nivel, salud, ataque, defensa);
    }
    void atacarPorLaEspalda(){
        System.out.println("Daño critico garantizado, requiere sigilo");
    }
    void ocultar(){
        System.out.println("Otorga sigilo");
    }
}
