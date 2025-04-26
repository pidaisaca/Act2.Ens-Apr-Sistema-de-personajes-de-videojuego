package model;

import interfaces.*;

public class Mago extends Magico implements Magica, Curable{
    int mana;
    int sabiduria;
    public Mago(String nombre, int nivel, int salud, int ataque, int defensa, int mana, int sabiduria){
        super(nombre, nivel, salud, ataque, defensa);
    }

    @Override
    public void lanzarHechizo(){
        System.out.println("Lanza un hechizo magico superior exclusivo del mago");
    }
    public void regenerarMana(){
        System.out.println("Regenera una gran cantidad de mana");
    }
}
