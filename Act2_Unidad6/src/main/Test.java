package main;

import model.*;
import model.Personaje.Nombre;

class Test {

    public static void main(String[] args) {

        // Implentar la lista de personajes y los objetos
        Personaje guerrero = new Guerrero(Nombre.GUERRERO, 10, 150, 20, 15, 20, 10, 0.5);
        Arquero arquero = new Arquero(Nombre.ARQUERO, 10, 125, 20, 10, 20, 10);
        Hechicero hechicero = new Hechicero(Nombre.HECHICERO, 10, 100, 20, 15, 20, 10);
        Asesino asesino = new Asesino(Nombre.ASESINO, 10, 100, 25, 10, 20, 0.5); 
        Mago mago = new Mago(Nombre.MAGO, 10, 100, 10, 10, 20, 10);

        ((Guerrero)guerrero).defender(); // Llamada al metodo defender de la clase Guerrero
        
        mago.lanzarHechizo(); // Llamada al metodo lanzar hechizo de la clase Mago
        mago.curar();
        mago.lanzarHechizo();
        mago.regenerarMana();

        mago.menuPersonaje();
    }
}
