package model;

import interfaces.*;


import java.util.Scanner;


public class Mago extends Magico implements Magica, Curable{
    int mana;
    int sabiduria;
    public Mago(Nombre nombre, int nivel, int salud, int ataque, int defensa, int mana, int sabiduria){
        super(nombre, nivel, salud, ataque, defensa);
        this.mana = mana;
        this.sabiduria = sabiduria;
    }

    @Override
    public void lanzarHechizo(){
        System.out.println("Lanza un hechizo magico superior exclusivo del mago");
    }
    public void regenerarMana(){
        System.out.println("Regenera una gran cantidad de mana");
    }


    @Override
    public void menuPersonaje(Personaje enemigo, Personaje combatiente) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de mago");
        System.out.println("1. Ataque magico");
        System.out.println("2. Lanzar hechizo");
        System.out.println("3. Regenerar mana");
        System.out.println("4. Curar");

        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                combatiente.atacar(enemigo, combatiente);
                break;
            case 2:
                System.out.println("Lanzar hechizo");
                break;
            case 3:
                System.out.println("Regenerar mana");
                break;
            case 4:
                System.out.println("Curar");
                break;
        }
    }

}
