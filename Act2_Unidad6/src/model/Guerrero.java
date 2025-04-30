package model;


import java.util.Scanner;


import interfaces.*;

public class Guerrero extends Fisico implements Defendible {
    int fuerza;
    int armadura;
    double escudo;

    public Guerrero(Nombre nombre, int nivel, int salud, int ataque, int defensa, int fuerza, int armadura,
            double escudo) {
        super(nombre, nivel, salud, ataque, defensa);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo = escudo;
    }
  
    void cargarAtaque() {
        System.out.println("Aumenta el daño del siguiente ataque");
    }

    @Override
    public void defender() {
        System.out.println("Reduce el daño del siguiente ataque en un 75%(Exclusivo del guerrero)");
    }

    @Override
    public void menuPersonaje(Personaje enemigo, Personaje combatiente) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de guerrero");
        System.out.println("1. Ataque fisico");
        System.out.println("2. Cargar ataque");
        System.out.println("3. Defender");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                combatiente.atacar(enemigo, combatiente);
                break;
            case 2:
                System.out.println("Cargar ataque");
                break;
            case 3:
                System.out.println("Defender");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

}