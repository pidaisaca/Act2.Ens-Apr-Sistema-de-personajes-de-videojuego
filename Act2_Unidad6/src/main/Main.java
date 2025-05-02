package main;

import java.util.Scanner;
import model.*;
import model.Personaje.Nombre;

public class Main {

    public static void main(String[] args) {
        // Instancias
        Juego juego = new Juego();
        Batalla combatientes = new Batalla();
        Scanner sc = new Scanner(System.in);

        // Crear personajes
        Personaje guerrero = new Guerrero(Nombre.GUERRERO, 10, 150, 150, 30, 15, 20, 10, 0.5);
        Personaje arquero = new Arquero(Nombre.ARQUERO, 10, 125, 125, 25, 10, 20, 10);
        Personaje hechicero = new Hechicero(Nombre.HECHICERO, 10, 100, 100, 30, 15, 100, 100, 10);
        Personaje asesino = new Asesino(Nombre.ASESINO, 10, 100, 100, 45, 10, false, 20);
        Personaje mago = new Mago(Nombre.MAGO, 10, 100, 100, 35, 10, 100, 100, 20);

        // Agregar personajes a listado para la descripcion
        juego.agregarPersonaje(guerrero);
        juego.agregarPersonaje(arquero);
        juego.agregarPersonaje(hechicero);
        juego.agregarPersonaje(asesino);
        juego.agregarPersonaje(mago);

        // Agregar personajes disponibles para la batalla
        juego.agregarPersonajeDisponible(mago);
        juego.agregarPersonajeDisponible(guerrero);
        juego.agregarPersonajeDisponible(arquero);
        juego.agregarPersonajeDisponible(hechicero);
        juego.agregarPersonajeDisponible(asesino);

        do {
            System.out.println("¿Desea hacer otra accion?\n");
            System.out.println("1. Listar combatientes\n");
            System.out.println("2. Iniciar batalla\n");
            System.out.println("3. Salir\n");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    juego.listarPersonajes();
                    break;
                case 2:

                    combatientes.getPersonajesSeleccionados(juego, combatientes, sc, guerrero, arquero, hechicero,
                            asesino, mago); // seleccionar a los personajes
                    combatientes.listarCombatientes(); // listar los personajes que se enfrentaran
                    juego.esperar(1500);
                    Personaje combatiente1 = combatientes.getCombatiente1();
                    Personaje combatiente2 = combatientes.getCombatiente2();
                    combatientes.iniciarBatalla(combatiente1, combatiente2);

                    break;

                case 3:
                    System.out.println("Gracias por jugar!");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

}
/*
 * Posible diseño de las habilidades
 * 
 * - Hechicero:
 * - Invocar entidad: Efecto tipo daño en el tiempo (la entidad hace un ataque
 * al principio del turno)
 * 1 turno de invocacion: daño fisico extra (definir cant turnos)
 * - Lanzar hechizo: Lanza un hechizo basico desde la interfaz magica
 * 1 turno de lanzar hechizo: daño magico + x
 * 
 * - Mago:
 * - Lanzar hechizo: Lanza un hechizo magico superior exclusivo del mago
 * 1 turno de lanzar hechizo: daño magico + y
 * Coste de mana: x
 * - Regenerar mana: Regenera una gran cantidad de mana
 * 1 turno de regenerar mana: mana + y
 * - Curar: Lanza un hechizo curativo
 * 1 turno de curar: salud + x
 */