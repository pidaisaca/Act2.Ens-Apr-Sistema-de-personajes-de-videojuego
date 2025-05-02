package model;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import java.util.Scanner;

import model.Personaje.Nombre;

// Clase Batalla
public class Batalla {

    private List<Personaje> combatientes;
    private Random random = new Random();
    Juego batalla = new Juego();

    // Constructor de la batalla
    public Batalla() {
        combatientes = new ArrayList<Personaje>();

    }
    // Agregar personajes a la batalla
    public void agregarPersonaje(Personaje personaje) {

        combatientes.add(personaje);
    }


    // Obtener la lista de combatientes
    public List<Personaje> getListaCombatientes() {
        return combatientes;
    }


    // Limpiar la lista de combatientes
    public void limpiarCombatientes() {
        combatientes.clear();
    }

    // Listar los combatientes
    public void listarCombatientes() {
        System.out.println();
        for (int i = 0; i < combatientes.size(); i++) {
            Personaje combatiente = combatientes.get(i);
            System.out.print(combatiente.getNombre());
            if (i == 0) {
                System.out.print(" /VS/ ");
            }
        }

        System.out.println();

    }

    // Obtener los personajes seleccionados por el usuario. En este metodo se llama al metodo listarPersonajesDisponibles
    // de la clase Juego y se llama al metodo eliminarPersonajeDisponible de la clase Juego
    public void getPersonajesSeleccionados(Juego juego, Batalla combatientes, Scanner sc, Personaje guerrero,
            Personaje arquero, Personaje hechicero, Personaje asesino, Personaje mago) {
        int personajesSeleccionados = 0;

        while (personajesSeleccionados < 2) {
            System.out.println("Personajes");
            juego.listarPersonajesDisponibles();
            System.out.println("Selecciona el personaje " + (personajesSeleccionados + 1) + ":");
            String seleccion = sc.nextLine().toUpperCase();

            try {
                Nombre luchador = Nombre.valueOf(seleccion);

                switch (luchador) {
                    case MAGO:
                        combatientes.agregarPersonaje(mago);
                        juego.eliminarPersonajeDisponible(mago);
                        break;
                    case GUERRERO:
                        combatientes.agregarPersonaje(guerrero);
                        juego.eliminarPersonajeDisponible(guerrero);
                        break;
                    case ASESINO:
                        combatientes.agregarPersonaje(asesino);
                        juego.eliminarPersonajeDisponible(asesino);

                        break;
                    case ARQUERO:
                        combatientes.agregarPersonaje(arquero);
                        juego.eliminarPersonajeDisponible(arquero);

                        break;
                    case HECHICERO:
                        combatientes.agregarPersonaje(hechicero);
                        juego.eliminarPersonajeDisponible(hechicero);

                        break;
                    default:
                        System.out.println("Personaje no válido.");
                        continue;
                }

                personajesSeleccionados++;
                System.out.println("");
            } catch (IllegalArgumentException e) {
                System.out.println("Nombre de personaje inválido. Intenta de nuevo.");
            }
        }
    }


    // Reiniciar la lista de personajes disponibles

    public void reiniciarCombatientes(Juego juego, Batalla combatientes) {
        for (Personaje p : combatientes.getListaCombatientes()) {
            juego.agregarPersonajeDisponible(p);
        }
    }


    // Obtener los combatientes

    public Personaje getCombatiente1() {
        for (int i = 0; i < combatientes.size(); i++) {
            Personaje combatiente = combatientes.get(i);
            if (i == 0) {
                return combatiente;
            }
        }
        return null;
    }

    public Personaje getCombatiente2() {
        for (int i = 0; i < combatientes.size(); i++) {
            Personaje combatiente = combatientes.get(i);
            if (i == 1) {
                return combatiente;
            }
        }
        return null;
    }


    // Iniciar la batalla entre los combatientes

    public void iniciarBatalla(Personaje combatiente1, Personaje combatiente2) {
        int ronda = 1;
        while (combatiente1.getSalud() >= 0 && combatiente2.getSalud() >= 0) {
            System.out.println("------------");
            System.out.println("Turno " + ronda);
            System.out.println("------------");
            batalla.esperar(500);
            int turno = random.nextInt(2);
            if (turno == 0) {
                System.out.println("Empieza la ronda " + combatiente1.getNombre());
                System.out.println("------------");
                System.out.println("Turno de " + combatiente1.getNombre());
                combatiente1.menuPersonaje(combatiente2);
                System.out.println("------------");
                batalla.esperar(1500);
                if (combatiente2.getSalud() <= 0) {
                    System.out.println("EL combatiente " + combatiente2.getNombre() + " ha perdido la batalla.");
                    System.out.println(combatiente1.getNombre() + " ha ganado la batalla.");
                    break;
                }
                System.out.println("Turno de " + combatiente2.getNombre());
                combatiente2.menuPersonaje(combatiente1);
                batalla.esperar(1500);

            } else {
                System.out.println("Empieza la ronda " + combatiente2.getNombre());
                System.out.println("------------");
                System.out.println("Turno de " + combatiente2.getNombre());
                combatiente2.menuPersonaje(combatiente1);
                System.out.println("------------");
                batalla.esperar(1500);
                if (combatiente1.getSalud() <= 0) {
                    System.out.println("EL combatiente " + combatiente1.getNombre() + " ha perdido la batalla.");
                    System.out.println(combatiente2.getNombre() + " ha ganado la batalla.");
                    break;
                }
                System.out.println("Turno de " + combatiente1.getNombre());
                combatiente1.menuPersonaje(combatiente2);
                batalla.esperar(1500);
            }

            ronda++;
            System.out.println("");
        }
    }

}
