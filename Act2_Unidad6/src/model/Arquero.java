package model;

import java.util.Scanner;

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
  
    @Override
    public void menuPersonaje(Personaje enemigo, Personaje combatiente) {   
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de arquero");
        System.out.println("1. Ataque fisico");
        System.out.println("2. Restablecer flechas");
        System.out.println("3. Disparar flechas");
        System.out.println("4. Volar");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                combatiente.atacar(enemigo, combatiente);
                break;
            case 2:
                System.out.println("Restablecer flechas");  
                break;
            case 3:
                System.out.println("Disparar flechas");
                break;
            case 4:
                System.out.println("Volar");
                break;
        }
    }

}