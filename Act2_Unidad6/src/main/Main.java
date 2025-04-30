package main;

import java.util.Scanner;
import model.*;
import model.Personaje.Nombre;

public class Main {

    public static void main(String[] args) {
        Juego juego = new Juego();
        Batalla combatientes = new Batalla();
        Scanner sc = new Scanner(System.in);

        // Crear personajes
        Personaje guerrero = new Guerrero(Nombre.GUERRERO, 10, 150, 20, 15, 20, 10, 0.5);
        Personaje arquero = new Arquero(Nombre.ARQUERO, 10, 125, 20, 10, 20, 10);
        Personaje hechicero = new Hechicero(Nombre.HECHICERO, 10, 100, 20, 15, 20, 10);
        Personaje asesino = new Asesino(Nombre.ASESINO, 10, 100, 25, 10, 20, 0.5);
        Personaje mago = new Mago(Nombre.MAGO, 10, 100, 10, 10, 20, 10);

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
             /*Seleccionar personaje 1
                    Listar personajes disponibles -> GetPersonaje de la lista -> Asignar personaje 1 a variable combatiente1 -> Sacar de la lista a personaje seleccionado -> Lista combatienes meter combatiente
                    Listar personajes disponibles -> Seleccionar personaje 2 -> Asignar personaje 2 a variable combatiente2 -> Sacar de la lista a personaje seleccionado -> Lista combatientes meter combatiente
                    Idealmente restaurar lista de personajes disponibles (ahora o al final de la batalla)
                    Iniciar batalla (menu con opciones de ataque y defensa, además mostrar stats de ambos personajes o por turno)
                        Bucle while con las stats de vida de ambos personajes, si alguno llega a 0 acaba batalla
                            Definir turnos (turno del personaje 1, turno del personaje 2)
                            Turno del personaje 1 -> Mostrar stats del personaje 1, preguntar si desea atacar o habilidad (Ej: guerrero.atacar())
                                Mostrar stats del personaje 1 y menu. El menu se puede mostrar con un instance of guerrero, arquero, hechicero, asesino, mago desde la clase Personaje con un metodo abstracto que crearemos en cada clase como su menu
                                Segun opcion elegida, restar vida al personaje 2 o establecer efecto en el personaje 1 -> (Ej con mago y guerrero: guerrero.atacar() = 20 por lo que mago.GetSalud() -= 20)
                            Turno del personaje 2 -> Mostrar stats del personaje 2, preguntar si desea atacar o habilidad
                                Segun opcion elegida, restar vida al personaje 1 o establecer efecto en el personaje 2 -> (Ej con mago y guerrero: mago.atacar() = 10 por lo que GUERRERO.GetSalud() -= 10)
                                Repetir hasta que alguno de los personajes quede sin salud
                    Mostrar ganador (Aquel cuyo valor de salud sea mayor, si ambos son iguales mostrar empate) -> Variable ganador = (comparar salud de ambos personajes y asignar el mayor -> con un if) // Sacar personaje de la lista de combatientes y mostrarla
                    Preguntar si se desea volver al menu o salir (En caso de salir, opcion = 3 en el switch y en el otro dejar un break para volver al menu)*/
                   
                combatientes.getPersonajesSeleccionados(juego, combatientes, sc, guerrero, arquero, hechicero, asesino, mago); //seleccionar a los personajes
                combatientes.listarCombatientes(); //listar los personajes que se enfrentaran
                Personaje combatiente1 = combatientes.getCombatiente1();
                Personaje combatiente2 = combatientes.getCombatiente2();
                combatientes.iniciarBatalla(combatiente1, combatiente2);

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
/* Posible diseño de las habilidades
 *  
 *  - Guerrero: 
 *      - Cargar ataque: Aumenta el daño del siguiente ataque
 *              1 turno de carga: daño fisico + x (o multiplicador)
 *      - Defender: Reduce el daño del siguiente ataque en un %
 *              1 turno de defensa: daño a recibir - x / valor de defensa sube en x
 * 
 *  - Arquero: 
 *      - Volar: Alza el vuelo y aumenta la evasion contra ataques fisicos cuerpo a cuerpo
 *              1 turno de vuelo: evasion fisica - boolean a comprobar en cada turno
 *      - Disparar flechas: Gasta flechas para infligir daño fisico a distancia
 *              5 cargas
 *              1 turno de disparo: daño fisico + x
 *      - Restaurar flechas: Recupera las flechas para volar y disparar en el turno siguiente
 *              1 turno de restauracion: flechas + x
 * 
 *  - Hechicero:
 *      - Invocar entidad: Efecto tipo daño en el tiempo (la entidad hace un ataque al principio del turno)
 *              1 turno de invocacion: daño fisico extra (definir cant turnos)
 *      - Lanzar hechizo: Lanza un hechizo basico desde la interfaz magica
 *              1 turno de lanzar hechizo: daño magico + x
 * 
 *  - Asesino: 
 *      - Ocultar: Otorga sigilo
 *              Ocultar: aumentar evasión - valor de defensa + x / evitar golpe - boolean
 *              cualquier accion lo elimina
 *      - Atacar por la espalda: Daño critico garantizado, requiere sigilo
 *              1 turno de atacar por la espalda: daño fisico * x (comprobar boolean de sigilo)
 *              y quitar ocultar
 *      - Curar: Lanza un hechizo curativo
 *              1 turno de curar: salud + x
 * 
 *  - Mago: 
 *      - Lanzar hechizo: Lanza un hechizo magico superior exclusivo del mago
 *              1 turno de lanzar hechizo: daño magico + y
 *              Coste de mana: x
 *      - Regenerar mana: Regenera una gran cantidad de mana
 *              1 turno de regenerar mana: mana + y
 *      - Curar: Lanza un hechizo curativo
 *              1 turno de curar: salud + x
 */