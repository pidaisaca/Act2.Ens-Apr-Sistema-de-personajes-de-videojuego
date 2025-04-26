package main;
import model.*;
import java.util.List;
import interfaces.*;


class Juego {

    public static void main(String[] args) {
        
        // Implentar la lista de personajes y los objetos
        Guerrero guerrero = new Guerrero("Conan", 30, 200, 150, 50, 25, 30, 35);
        Mago mago = new Mago("Merlin", 70, 250, 50, 20, 500, 50);

        guerrero.atacar();
        guerrero.defender(); //Llamada al metodo defender de la clase Guerrero

        mago.atacar();
        mago.lanzarHechizo(); //Llamada al metodo lanzar hechizo de la clase Mago
        mago.curar();
        mago.lanzarHechizo();
        mago.regenerarMana();
    }
}
