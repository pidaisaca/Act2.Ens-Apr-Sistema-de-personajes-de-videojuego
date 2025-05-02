package model;

import java.util.Scanner;

import interfaces.*;

public class Hechicero extends Magico implements Magica, Defendible {
    int mana;
    int concentracion; // reduccion contra el daño magico

    public Hechicero(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa, int mana, int concentracion) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
        this.mana = mana;
        this.concentracion = concentracion;
    }

    void invocarEntidad() {
        System.out.println("invoca una entidad que daña al principio de cada turno");
    }

    @Override
    public void defender() {
        System.out.println("Reduce el daño del siguiente ataque en un %");
    }

    @Override
    public void menuPersonaje(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salud : "+this.salud+"/"+this.saludMax);
        //mana
        System.out.println("------------------------");
        System.out.println("Menu de "+this.nombre);
        System.out.println("1. Ataque magico");
        System.out.println("2. Invocar entidad");
        System.out.println("3. Defender");
        System.out.println("4. Curar");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                this.atacar(enemigo);
                break;
            case 2:
                System.out.println("Invocar entidad");
                break;
            case 3:
                System.out.println("Defender");
                break;
            case 4:
                System.out.println("Curar");
                break;
        }
    }

    @Override
    public void recibirDano(Personaje atacante) {
        if (atacante instanceof Magico && atacante.getAtaque() > this.concentracion) {
            System.out.println(
                    this.getNombre() + " ha perdido " + (atacante.getAtaque() - this.concentracion) + " puntos de salud.");
            this.salud -= atacante.getAtaque() - this.concentracion;
        } else if (atacante instanceof Fisico) {
            super.recibirDano(atacante);
        }
    }
}