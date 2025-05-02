package model;

import interfaces.*;
import java.util.Scanner;

// Clase Mago
public class Mago extends Magico implements Magica, Curable {
    int mana;
    int manaMax;
    int sabiduria;

    public Mago(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa, int mana, int manaMax,
            int sabiduria) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
        this.mana = mana;
        this.manaMax = manaMax;
        this.sabiduria = sabiduria;
    }

    @Override
    public void atacar(Personaje enemigo) {
        if (this.mana > 10) {
            System.out.println(this.getNombre()+" lanzo un hechizo basico");
            enemigo.setSalud(enemigo.salud -= this.ataque + this.sabiduria - enemigo.getDefensa());
            System.out.println(enemigo.getNombre()+" ha perdido "+ (this.ataque +this.sabiduria - enemigo.getDefensa())+" puntos de salud");
            this.mana -= 10;
        } else{
            System.out.println("No se ha lanzado el hechizo porque no habia mana suficiente");
            this.regenerarMana();
        }
    }


    @Override
    public void lanzarHechizo(Personaje enemigo) {
        if(this.mana > 30){
            System.out.println(this.getNombre()+" lanzo un hechizo avanzado");
            enemigo.setSalud(enemigo.salud -= this.ataque + this.sabiduria);
            System.out.println(enemigo.getNombre()+" ha perdido "+ (this.ataque +this.sabiduria)+" puntos de salud");
            this.mana -= 30;
        } else{
            System.out.println("No se ha lanzado el hechizo porque no habia mana suficiente");
            this.regenerarMana();        }
    }

    public void regenerarMana() {
        mana += (manaMax / 3);
        if (mana > manaMax) {
            mana = manaMax;
        }
        System.out.println(
                this.nombre + " regeneró " + ((manaMax / 3)) + " puntos de mana (mana actual: " + this.mana + ")");
    }

    @Override
    public void curar() {
        this.salud += this.ataque + this.saludMax / 10;
        if (this.salud > this.saludMax) {
            this.salud = this.saludMax;
        }
        System.out.println(
                this.getNombre() + " se sano " + (this.getAtaque() + this.saludMax / 10) + " puntos de salud.");
    }

    @Override
    public void menuPersonaje(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salud : " + this.salud + "/" + this.saludMax);
        System.out.println("Mana : " + this.mana + "/" + this.manaMax);
        System.out.println("------------------------");
        System.out.println("Menu de " + this.nombre);
        System.out.println("1. Ataque magico");
        System.out.println("2. Lanzar hechizo");
        System.out.println("3. Regenerar mana");
        System.out.println("4. Curar");

        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                this.atacar(enemigo);
                break;
            case 2:
                this.lanzarHechizo(enemigo);
                break;
            case 3:
                this.regenerarMana();
                break;
            case 4:
                this.curar();
                break;
        }
    }

}
