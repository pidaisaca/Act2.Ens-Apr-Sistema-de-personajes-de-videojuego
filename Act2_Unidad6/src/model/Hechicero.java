package model;

import java.util.Scanner;
import interfaces.*;

public class Hechicero extends Magico implements Magica, Defendible{
    int mana;
    int concentracion; //atributo aun por definir
    
    public Hechicero(Nombre nombre, int nivel, int salud, int ataque, int defensa, int mana, int concentracion){
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

    @Override
    public void menuPersonaje(Personaje combatiente, Personaje enemigo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de hechicero");
        System.out.println("1. Ataque magico");
        System.out.println("2. Invocar entidad");
        System.out.println("3. Defender");
        System.out.println("4. Curar");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                combatiente.atacar(enemigo, combatiente);
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
}