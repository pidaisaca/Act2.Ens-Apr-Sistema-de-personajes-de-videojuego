package model;

import interfaces.*;
import java.util.Scanner;

// Clase Arquero

public class Arquero extends Fisico implements Volador, Movilizable {
    int agilidad; //atributo que aumenta el daño de disparar flechas
    int numFlechas = 10; //municion requerida para poder lanzar flechas

    public Arquero(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa, int agilidad,
            int numFlechas) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
        this.agilidad = agilidad;
        this.numFlechas = numFlechas;
    }
    public int getAgilidad(){
        return agilidad;

    }

    //Recupera flechas necesarias para la ejecucion del metodo dispararFlecha
    //Si el arquero esta volando aterrizara para recuperar municion
    //La cantidad de flechas recuperadas es aleatoria, pero no excedera el maximo (10)
    void restablecerFlechas() {
        if (volando == true) {
            System.out.println(this.nombre + " aterrizo para recuperar flechas");
            volando = false;
        }
        System.out.print("Flechas recuperadas. Cantidad actual: ");
        numFlechas += random.nextInt(10);
        if (numFlechas > 10) {
            numFlechas = 10;
        }
        System.out.println(numFlechas);
    }
    //El metodo disparar flechas requiere que el arquero tenga municion
    //El daño de este metodo es la suma del ataque del arquero y de su agilidad, y ademas ignora la mitad de la defensa del enemigo
    //En caso de que no tenga municion, ejecutara el metodo para repostar municion
    void dispararFlechas(Personaje enemigo) {
        if(numFlechas > 1){
            System.out.println(this.nombre+" disparó una flecha");
            enemigo.setSalud(enemigo.salud -= (this.ataque+this.agilidad)-(enemigo.defensa*0.5));
            numFlechas -=1;
            System.out.println(enemigo.getNombre()+" recibio "+(this.getAtaque()+this.getAgilidad()-(enemigo.getDefensa()*0.5))+" puntos de daño");
        }else{
            System.out.println("A "+this.nombre+" no le quedan flechas");
            this.restablecerFlechas();
        }
    }

    //Volar es un estado que aumenta en un 50% la probabilidad de que los ataques fallen contra este objetivo
    @Override
    public void volar() {
        System.out.println(this.nombre + " alza el vuelo");
        this.volando = true;
    }

    //Menu de acciones del arquero
    @Override
    public void menuPersonaje(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salud : "+this.salud+"/"+this.saludMax);
        System.out.println("Flechas: " + this.numFlechas+"/10");
        System.out.println("------------------------");
        System.out.println("Menu de "+this.nombre);
        System.out.println("1. Ataque fisico");
        System.out.println("2. Restablecer flechas");
        System.out.println("3. Disparar flechas");
        System.out.println("4. Volar");
        int accion = sc.nextInt();

        switch (accion) {
            case 1:
                if (volando == true) {
                    System.out.println(this.nombre + " aterrizo para atacar");
                    volando = false;
                }
                this.atacar(enemigo);

                break;
            case 2:
                this.restablecerFlechas();
                break;
            case 3:
                this.dispararFlechas(enemigo);
                break;
            case 4:
                this.volar();
                break;
        }
    }

}
