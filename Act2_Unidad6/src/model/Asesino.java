package model;


import java.util.Scanner;


import interfaces.*;

public class Asesino extends Fisico implements Movilizable, Curable{
    double sigilo;
    double critico;

  
    public Asesino(Nombre nombre, int nivel, int salud, int ataque, int defensa, double sigilo, double critico){
        super(nombre, nivel, salud, ataque, defensa);
        this.sigilo = sigilo;
        this.critico = critico;
    }
    void atacarPorLaEspalda(){
        System.out.println("Daño critico garantizado, requiere sigilo");
    }
    void ocultar(){
        System.out.println("Otorga sigilo");
    }


    @Override
    public void menuPersonaje(Personaje enemigo, Personaje combatiente) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de asesino");
        System.out.println("1. Ataque fisico");
        System.out.println("2. Atacar por la espalda");
        System.out.println("3. Ocultar");
        System.out.println("4. Curar");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                combatiente.atacar(enemigo, combatiente);
                break;
            case 2:
                System.out.println("Atacar por la espalda");
                break;
            case 3:
                System.out.println("Ocultar");
                break;
            case 4:
                System.out.println("Curar");
                break;
        }
    }

}
