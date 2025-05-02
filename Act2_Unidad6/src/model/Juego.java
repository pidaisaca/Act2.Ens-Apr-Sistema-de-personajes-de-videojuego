package model;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Personaje> personajes;
    private List<Personaje> personajes_disponibles;

    public Juego() {
        personajes = new ArrayList<Personaje>();
        personajes_disponibles = new ArrayList<Personaje>();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public void listarPersonajes() {
        for (Personaje personaje : personajes) {
            System.out.println(personaje.toString());
            System.out.print("Tipo de ataque: ");
            personaje.atacarTipo();
            if (personaje instanceof Arquero) {
                Arquero arquero = (Arquero) personaje;
                System.out.println("Habilidades del arquero");
                System.out.print("Disparar flechas: ");
               // arquero.dispararFlechas();
                System.out.print("Restablecer flechas: ");
                arquero.restablecerFlechas();
                System.out.print("Volar: ");
                arquero.volar();
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Guerrero) {
                Guerrero guerrero = (Guerrero) personaje;
                System.out.println("Habilidades del guerrero: ");
                System.out.print("Cargar ataque: ");
                guerrero.cargarAtaque();
                System.out.print("Defender: ");
                guerrero.defender();
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Hechicero) {
                Hechicero hechicero = (Hechicero) personaje;
                System.out.println("Habilidades del hechicero: ");
                System.out.print("Defender: ");
                hechicero.defender();
                System.out.print("Invocar entidad: ");
                hechicero.invocarEntidad();
                System.out.print("Lanzar hechizo: ");
                hechicero.lanzarHechizo();
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Asesino) {
                Asesino asesino = (Asesino) personaje;
                System.out.println("Habilidades del asesino: ");
                System.out.print("Ocultar: ");
                asesino.ocultar();
                System.out.print("Atacar por la espalda: ");
               // asesino.atacarPorLaEspalda();
                System.out.print("Curar: ");
                asesino.curar();
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Mago) {
                Mago mago = (Mago) personaje;
                System.out.println("Habilidades del mago: ");
                System.out.print("Regenerar mana: ");    
                mago.regenerarMana();
                System.out.print("Lanzar hechizo: ");
                mago.lanzarHechizo();
                System.out.print("Curar: ");
                mago.curar();
                System.out.println("");
            }
        }
    }

    public void agregarPersonajeDisponible(Personaje personaje) {
        personajes_disponibles.add(personaje);
    }

    public void eliminarPersonajeDisponible(Personaje personaje) {
        personajes_disponibles.remove(personaje);
    }

    public void listarPersonajesDisponibles() {
        for (Personaje personaje : personajes_disponibles) {
            int i = personajes_disponibles.indexOf(personaje);
            System.out.print(i + 1 + ". ");
            System.out.println(personaje.getNombre());
        }
    }
}