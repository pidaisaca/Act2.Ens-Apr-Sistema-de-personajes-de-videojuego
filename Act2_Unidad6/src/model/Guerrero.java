package model;

import interfaces.*;

public class Guerrero extends Fisico implements Defendible {
    int fuerza;
    int armadura;
    double escudo;

    public Guerrero(String nombre, int nivel, int salud, int ataque, int defensa, int fuerza, int armadura,
            double escudo) {
        super(nombre, nivel, salud, ataque, defensa);
    }

    void cargarAtaque() {
        System.out.println("Aumenta el daño del siguiente ataque");
    }

    @Override
    public void defender() {
        System.out.println("Reduce el daño del siguiente ataque en un 75%(Exclusivo del guerrero)");
    }
}