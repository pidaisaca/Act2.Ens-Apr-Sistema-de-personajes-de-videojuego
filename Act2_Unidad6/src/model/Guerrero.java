package model;

import java.util.Scanner;

import interfaces.*;

public class Guerrero extends Fisico implements Defendible {
    int fuerza; // atributo que se añade al ataque del guerrero para el daño
    int armadura; // atributo que resta el valor del daño fisico enemigo al daño final al guerrero
    double escudo; //
    boolean defender;

    public Guerrero(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa, int fuerza, int armadura,
            double escudo) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo = escudo;
    }

    public int getFuerza() {
        return fuerza;
    }

    void cargarAtaque() {
        System.out.println("¡" + this.getNombre() + " Aumentó su fuerza!");
        this.fuerza = (fuerza * 2);
        System.out.println("Fuerza Actual: " + this.fuerza);
    }

    @Override
    public void defender() {
        System.out.println("Reduce el daño del siguiente ataque en un 75%(Exclusivo del guerrero)");
        defendiendo = true;
    }

    @Override
    public void menuPersonaje(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salud : "+this.salud+"/"+this.saludMax);
        System.out.println("------------------------");
        System.out.println("Menu de "+this.nombre);
        System.out.println("1. Ataque fisico");
        System.out.println("2. Cargar ataque");
        System.out.println("3. Defender");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                this.atacar(enemigo);
                defendiendo = false;
                break;
            case 2:
                cargarAtaque();
                defendiendo = false;
                break;
            case 3:
                System.out.println("Defender");
                defender();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Ataque de guerrero");
        if (enemigo.isVolando() && random.nextInt(2) == 0) {

            System.out.println("El ataque ha fallado");
            return;
        }

        enemigo.setSalud(enemigo.salud -= this.ataque + this.fuerza-enemigo.getDefensa());
        System.out.println(enemigo.getNombre()+" ha perdido "+(this.ataque+this.fuerza-enemigo.getDefensa())+" puntos de salud");

    }

    // Sobreescritura del metodo recibir daño para el guerrero ya que el atributo
    // armadura le reduce el daño fisico en un valor plano.
    // El guerrero cuenta ademas con un metodo defender propio que reduce el daño en
    // un 75%.
    @Override
    public void recibirDano(Personaje atacante) {
        if (atacante instanceof Fisico && atacante.getAtaque() > this.armadura) {
            if (defendiendo == true) {
                System.out.println(this.nombre + " ha bloqueado el ataque y reducido el daño en un 75%");
                System.out.println(this.getNombre() + " ha perdido " + ((atacante.getAtaque() / 4))
                        + " puntos de salud.");
                this.salud -= atacante.getAtaque() / 4;
                defendiendo = false;
                return;
            }
            System.out.println(
                    this.getNombre() + " ha perdido " + (atacante.getAtaque() - this.armadura) + " puntos de salud.");
            this.salud -= atacante.getAtaque() - this.armadura;
        } else if (atacante instanceof Magico && defendiendo == true) {
            this.salud -= atacante.getAtaque() / 4;
        } else {
            super.recibirDano(atacante);
        }
    }
}
