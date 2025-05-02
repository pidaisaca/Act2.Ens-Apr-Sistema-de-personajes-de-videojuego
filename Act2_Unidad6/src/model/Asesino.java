package model;

import interfaces.*;
import java.util.Scanner;


// Clase Asesino

public class Asesino extends Fisico implements Movilizable, Curable {
    boolean sigilo;
    int critico;
    public Asesino(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa, boolean sigilo, int critico) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
        this.sigilo = sigilo;
        this.critico = critico;
    }

    //El metodo atacar por la espalda es un ataque critico 
    // pero requiere que el asesino este en sigilo

    public void atacarPorLaEspalda(Personaje enemigo) {
       if(sigilo == true){
        critico = random.nextInt(critico);
        System.out.println(this.nombre+ " ejecutó un ataque critico por la espalda");
        enemigo.setSalud(enemigo.salud -= this.ataque+critico);
        System.out.println(enemigo.getNombre() + " recibio " + (ataque+critico)+" puntos de daño");
       }else{
        System.out.println(this.nombre+ " no se encontraba en sigilo y ha ejecutado un ataque normal");
        this.atacar(enemigo);
       }

    }
    // El metodo ocultar hace que el asesino se camufla.
    //Esto hace que el metodo atacarPorLaEspalda haga daño adicional
    void ocultar() {
        System.out.println(this.nombre+" se camufla entre las sombras");
        sigilo = true;
    }


    //El metodo curar de asesino sana una cantidad igual a su ataque + un 5% de su salud maxima
    public void curar(){
        this.salud += this.ataque+this.saludMax/20;
        if (this.salud > this.saludMax) {
        this.salud = this.saludMax;    
        }
        System.out.println(this.getNombre() + " se sano " + (this.getAtaque()+this.saludMax/20) + " puntos de salud.");
    }

    //El metodo menuPersonaje es el menu de acciones del asesino
    @Override
    public void menuPersonaje(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salud : "+this.salud+"/"+this.saludMax);
        System.out.println("------------------------");
        System.out.println("Menu de "+this.nombre);
        System.out.println("1. Ataque fisico");
        System.out.println("2. Atacar por la espalda");
        System.out.println("3. Ocultar");
        System.out.println("4. Curar");
        int accion = sc.nextInt();

        switch (accion) {

            case 2:
                this.atacarPorLaEspalda(enemigo);
                sigilo = false;
                break;
            case 3:
                this.ocultar();
                break;
            case 4:
                this.curar();
                break;
            case 1:
            default:
                this.atacar(enemigo);
                sigilo = false;
                break;
        } sc.close();
    }

}
