package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Personaje.Nombre;

public class Batalla {

    private List<Personaje> combatientes;

    public Batalla() {
        combatientes = new ArrayList<Personaje>();
    }

    public void agregarPersonaje(Personaje personaje) {
        combatientes.add(personaje);
    }

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
            } catch (IllegalArgumentException e) {
                System.out.println("Nombre de personaje inválido. Intenta de nuevo.");
            }
        }
    }

    public Personaje getCombatiente1() {
        for (int i = 0; i < combatientes.size(); i++) {
            Personaje combatiente = combatientes.get(i);
            if (i == 0) {
                System.out.println("Combatiente 1: " + combatiente.getNombre());
                return combatiente;
            }
        }
        return null;
    }

    public Personaje getCombatiente2() {
        for (int i = 0; i < combatientes.size(); i++) {
            Personaje combatiente = combatientes.get(i);
            if (i == 1) {
                System.out.println("Combatiente 2: " + combatiente.getNombre());
                return combatiente;
            }
        }
        return null;
    }

    public void iniciarBatallaSoloAtacar(Personaje combatiente1, Personaje combatiente2) {
        while (combatiente1.getSalud() >= 0 && combatiente2.getSalud() >= 0) {
            int turno = new Random().nextInt(2);
            if (turno == 0) {
                System.out.println("Empieza la ronda " + combatiente1.getNombre());
                System.out.println("Turno de " + combatiente1.getNombre());
                combatiente1.atacar(combatiente2, combatiente1);
                System.out.println(combatiente2.getNombre() + " ha perdido " + combatiente1.getAtaque() + " puntos de salud.");
                System.out.println("Turno de " + combatiente2.getNombre());
                combatiente2.atacar(combatiente1, combatiente2);
                System.out.println(combatiente1.getNombre() + " ha perdido " + combatiente2.getAtaque() + " puntos de salud.");
            } else {
                System.out.println("Empieza la ronda " + combatiente2.getNombre()); 
                System.out.println("Turno de " + combatiente2.getNombre());
                combatiente2.atacar(combatiente1, combatiente2);
                System.out.println(combatiente1.getNombre() + " ha perdido " + combatiente2.getAtaque() + " puntos de salud.");
                System.out.println("Turno de " + combatiente1.getNombre());
                combatiente1.atacar(combatiente2, combatiente1);
                System.out.println(combatiente2.getNombre() + " ha perdido " + combatiente1.getAtaque() + " puntos de salud.");
            }
        if (combatiente1.getSalud() <= 0) {
            System.out.println(combatiente2.getNombre() + " ha ganado la batalla.");
        } 
        if (combatiente2.getSalud() <= 0) {
            System.out.println(combatiente1.getNombre() + " ha ganado la batalla.");
        }
    }
    }

    public void iniciarBatalla(Personaje combatiente1, Personaje combatiente2) {
        while (combatiente1.getSalud() >= 0 && combatiente2.getSalud() >= 0) {
            int turno = new Random().nextInt(2);
            if (turno == 0) {
                System.out.println("Empieza la ronda " + combatiente1.getNombre());
                System.out.println("Turno de " + combatiente1.getNombre());
                combatiente1.menuPersonaje(combatiente1, combatiente2);
                System.out.println("Turno de " + combatiente2.getNombre());
                combatiente2.menuPersonaje(combatiente2, combatiente1);
            } else {
                System.out.println("Empieza la ronda " + combatiente2.getNombre()); 
                System.out.println("Turno de " + combatiente2.getNombre());
                combatiente2.menuPersonaje(combatiente2, combatiente1);
                System.out.println("Turno de " + combatiente1.getNombre());
                combatiente1.menuPersonaje(combatiente1, combatiente2);
            }
        if (combatiente1.getSalud() <= 0) {
            System.out.println("EL combatiente " + combatiente1.getNombre() + " ha perdido la batalla.");
            System.out.println(combatiente2.getNombre() + " ha ganado la batalla.");
        } 
        if (combatiente2.getSalud() <= 0) {
            System.out.println("EL combatiente " + combatiente2.getNombre() + " ha perdido la batalla.");   
            System.out.println(combatiente1.getNombre() + " ha ganado la batalla.");
        }
    }
    }
}
