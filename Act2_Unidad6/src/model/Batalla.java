package model;

import java.util.ArrayList;
import java.util.List;
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
        for (int i = 0; i < combatientes.size(); i++) {
            Personaje combatiente = combatientes.get(i);
            System.out.println(combatiente.getNombre());
            if (i == 0) {
                System.out.println("VS");
            }
        }
    }

    public void getPersonajesSeleccionados(Juego juego, Batalla combatientes, Scanner sc, Guerrero guerrero,
            Arquero arquero, Hechicero hechicero, Asesino asesino, Mago mago) {
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
                        break;
                    case GUERRERO:
                        combatientes.agregarPersonaje(guerrero);
                        break;
                    case ASESINO:
                        combatientes.agregarPersonaje(asesino);
                        break;
                    case ARQUERO:
                        combatientes.agregarPersonaje(arquero);
                        break;
                    case HECHICERO:
                        combatientes.agregarPersonaje(hechicero);
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

}
