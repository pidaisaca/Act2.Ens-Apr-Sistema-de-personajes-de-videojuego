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

    // Listar los menus de los personajes en funcion de su tipo
    // Usando un instaceof para saber el tipo de personaje 
    public void listarPersonajes() {
        for (Personaje personaje : personajes) {
            System.out.println(personaje.toString());
            System.out.print("Tipo de ataque: ");
            personaje.atacarTipo();
            if (personaje instanceof Arquero) {
                Arquero arquero = (Arquero) personaje;
                System.out.println("Habilidades del arquero");
                System.out.print("Disparar flechas: ");
                System.out.print("Restablecer flechas: ");
                System.out.print("Volar: ");
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Guerrero) {
                Guerrero guerrero = (Guerrero) personaje;
                System.out.println("Habilidades del guerrero: ");
                System.out.print("Cargar ataque: ");
                System.out.print("Defender: ");
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Hechicero) {
                Hechicero hechicero = (Hechicero) personaje;
                System.out.println("Habilidades del hechicero: ");
                System.out.print("Defender: ");
                System.out.print("Invocar entidad: ");
                System.out.print("Lanzar hechizo: ");
                System.out.println("Curar: ");
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Asesino) {
                Asesino asesino = (Asesino) personaje;
                System.out.println("Habilidades del asesino: ");
                System.out.print("Ocultar: ");
                System.out.print("Atacar por la espalda: ");
                System.out.print("Curar: ");
                System.out.println("");
                System.out.println("----------------");
            }
            if (personaje instanceof Mago) {
                Mago mago = (Mago) personaje;
                System.out.println("Habilidades del mago: ");
                System.out.print("Regenerar mana: ");    
                System.out.print("Lanzar hechizo: ");
                System.out.print("Curar: ");
                System.out.println("");
            }
        }
    }

    // Listar los personajes disponibles
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

    // Método para que espere cierto tiempo en la ejecución
    // Usado en la batalla para que la informacion se vea mas clara

    public  void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        } catch(InterruptedException e){
            System.out.println("Error de ejecucion");
            Thread.currentThread().interrupt();
        }
    }
  
}