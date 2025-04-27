package main;

import java.util.Scanner;

import model.*;
import model.Personaje.Nombre;
import interfaces.*;

public class Main {

    public static void main(String[] args) {
        Juego juego = new Juego();
        Batalla combatientes = new Batalla();
        Scanner sc = new Scanner(System.in);

        // Crear personajes
        Guerrero guerrero = new Guerrero(Nombre.GUERRERO, 10, 150, 20, 15, 20, 10, 0.5);
        Arquero arquero = new Arquero(Nombre.ARQUERO, 10, 125, 20, 10, 20, 10);
        Hechicero hechicero = new Hechicero(Nombre.HECHICERO, 10, 100, 20, 15, 20, 10);
        Asesino asesino = new Asesino(Nombre.ASESINO, 10, 100, 25, 10, 20, 0.5);
        Mago mago = new Mago(Nombre.MAGO, 10, 100, 10, 10, 20, 10);

        juego.agregarPersonaje(guerrero);
        juego.agregarPersonaje(arquero);
        juego.agregarPersonaje(hechicero);
        juego.agregarPersonaje(asesino);
        juego.agregarPersonaje(mago);

        juego.agregarPersonajeDisponible(mago);
        juego.agregarPersonajeDisponible(guerrero);
        juego.agregarPersonajeDisponible(arquero);
        juego.agregarPersonajeDisponible(hechicero);
        juego.agregarPersonajeDisponible(asesino);

        System.out.println("Bienvenido a la arena de batallas\n");
        System.out.println("Que desea hacer?\n");
        System.out.println("1. Listar combatientes\n");
        System.out.println("2. Iniciar batalla\n");
        System.out.println("3. Salir\n");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                juego.listarPersonajes();
                System.out.println("¿Desea hacer otra accion?\n");
                System.out.println("1. Listar combatientes\n");
                System.out.println("2. Iniciar batalla\n");
                System.out.println("3. Salir\n");
                opcion = sc.nextInt();
                break;
            case 2:
         
                combatientes.getPersonajesSeleccionados(juego, combatientes, sc, guerrero, arquero, hechicero, asesino, mago); //seleccionar a los personajes
                combatientes.listarCombatientes(); //listar los personajes que se enfrentaran
                
                break;

            case 3:
                System.out.println("Gracias por jugar!");
                break;

            default:
                break;
        }
        sc.close();
    }


}
