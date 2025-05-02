package model;

import interfaces.*;
import java.util.Scanner;

public class Hechicero extends Magico implements Magica, Defendible, Curable {
    int mana;
    int manaMax;
    int concentracion; // reduccion contra el daño magico

    public Hechicero(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa, int mana, int manaMax,
            int concentracion) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
        this.mana = mana;
        this.manaMax = manaMax;
        this.concentracion = concentracion;
    }

    // Metodo invocarEntidad que no pudimos terminar :(
    void invocarEntidad(Personaje enemigo) {
        System.out.println("Placeholder, en su lugar se llama al metodo lanzarHechizo");
        this.lanzarHechizo(enemigo);
    }

    // Metodo lanzarHechizo
    @Override
    public void lanzarHechizo(Personaje enemigo) {
        if (this.mana > 20) {
            System.out.println(this.getNombre() + " lanzo un hechizo avanzado");
            enemigo.setSalud(enemigo.salud -= this.ataque + this.concentracion);
            System.out.println(enemigo.getNombre() + " ha perdido "
                    + (this.ataque + this.concentracion - enemigo.getDefensa()) + " puntos de salud");
            this.mana -= 20;
            defendiendo = false;
        } else {
            System.out.println("No se ha lanzado el hechizo porque no habia mana suficiente y en su lugar "
                    + this.getNombre() + " se ha defendido");
            this.defender();
        }
    }

    @Override
    public void defender() {
        System.out.println(
                "Reduce el daño del siguiente ataque en un 50% y regenera algo de mana(exclusivo del Hechicero)");
        defendiendo = true;
        System.out.println(this.getNombre() + " recupero: " + (mana * 1.2) + " puntos de mana");
        this.mana += mana * 1.2;
    }

    @Override
    public void curar() {
        if (this.mana > 10) {
            this.salud += this.ataque + this.saludMax / 5;
            if (this.salud > this.saludMax) {
                this.salud = this.saludMax;
            }
            System.out.println(
                    this.getNombre() + " se sano " + (this.getAtaque() + this.saludMax / 5) + " puntos de salud.");
                    defendiendo = false;
        } else {
            System.out.println("No se ha lanzado el hechizo porque no habia mana suficiente y en su lugar "
                    + this.getNombre() + " se ha defendido");
            this.defender();
        }

    }

    // Menu de acciones del hechicero
    @Override
    public void menuPersonaje(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salud : " + this.salud + "/" + this.saludMax);
        // mana
        System.out.println("------------------------");
        System.out.println("Menu de " + this.nombre);
        System.out.println("1. Ataque magico");
        System.out.println("2. Invocar entidad");
        System.out.println("3. Defender");
        System.out.println("4. Curar");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                this.atacar(enemigo);
                defendiendo = false;
                break;
            case 2:
                lanzarHechizo(enemigo);
                break;
            case 3:
                this.defender();
                break;
            case 4:
                this.curar();
                break;
        }
    }

    // Metodo recibirDano del hechicero, el cual recibe menos danio si el atacante es magico
    @Override
    public void recibirDano(Personaje atacante) {
        if (atacante instanceof Magico && atacante.getAtaque() > this.concentracion) {
            if (defendiendo == true) {
                System.out.println(this.nombre + " ha bloqueado el ataque y reducido el daño en un 50%");
                System.out.println(
                        this.getNombre() + " ha perdido " + ((atacante.getAtaque() / 2)) + " puntos de salud.");
                this.salud -= atacante.getAtaque() / 4;
                defendiendo = false;
                return;
            }
            System.out.println(this.getNombre() + " ha perdido " + (atacante.getAtaque() - this.concentracion)
                    + " puntos de salud.");
            this.salud -= atacante.getAtaque() - this.concentracion;
        } else if (atacante instanceof Fisico && defendiendo == true) {
            this.salud -= atacante.getAtaque() / 2;

        } else {

            super.recibirDano(atacante);
        }
    }

}