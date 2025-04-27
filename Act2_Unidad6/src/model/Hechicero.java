package model;

import interfaces.*;

public class Hechicero extends Magico implements Magica, Defendible{
    int mana;
    int concentracion; //atributo aun por definir
    public Hechicero(String nombre, int nivel, int salud, int ataque, int defensa, int mana, int concentracion){
        super(nombre, nivel, salud, ataque, defensa);
        this.mana = mana;
        this.concentracion = concentracion;
    }
    void invocarEntidad(){
        System.out.println("invoca una entidad que daña al principio de cada turno");
    }
    @Override
    public void defender(){
        System.out.println("Reduce el daño del siguiente ataque en un %");
    }
}