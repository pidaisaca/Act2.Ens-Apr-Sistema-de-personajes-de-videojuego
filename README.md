# Act2.Ens-Apr-Sistema-de-personajes-de-videojuego
Diseñar un sistema de clases para representar personajes de un videojuego, organizando correctamente una jerarquía de clases e interfaces que simulen habilidades y comportamientos. Trabajar en pareja usando Git y GitHub para el control de versiones.

Reparto de tareas:

Daniel:
Estructura, clase abstracta Personaje, Subclases intermedias, Clase Juego

Jose:
Clases Concretas, Interfaces: Curable, Volador, Magico, Defendible, Movilizable

Ideas para probar el combate: Se escoge a un personaje y se enfreta a otro.

Interpretacion de los metodos y atributos especificos de cada clase.

-Guerrero: 

atributos propios:

Fuerza: Aumento del daño fisico

Armadura: Reduce el daño fisico

Escudo: Probabilidad de evitar todo el daño


metodos propios:

cargarAtaque(): Aumenta el daño del siguiente ataque

defender(): Reduce el daño del siguiente ataque en un %


-Mago:

atributos propios:

Mana: recurso necesario para lanzar habilidades

Sabiduria: regeneracion pasiva de mana


metodos propios:

lanzarHechizo(): inflige daño magico

regenerarMana(): regenera una cantidad grande de mana


-Arquero

atributos propios:

agilidad: probabilidad de esquivar

numFlechas: municion necesaria para usar el metodo de disparar Flechas


metodos propios:

reabastecerFlechas() recarga las flechas

dispararFlechas() inflige daño fisico y a distancia


-Hechicero

atributos propios:

Mana: recurso necesario para lanzar habilidades

Concentracion: ?


metodos propios:

invocarEntidad(): efecto tipo daño en el tiempo (la entidad hace un ataque al principio del turno)

defender(): Reduce el daño del siguiente ataque en un %


-Asesino

atributos:

sigilo: probabilidad de obtener un efecto que aumenta la probabilidad de esquivar

critico: probabilidad de daño extra en base a un %


metodos propios:

atacarPorLaEspal0da(): daño critico garantizado, requiere sigilo

ocultar(): otorga sigilo
