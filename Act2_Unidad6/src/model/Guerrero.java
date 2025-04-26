package model;
class Guerrero extends Fisico{
    int fuerza;
    int armadura;
    double escudo;

     Guerrero(String nombre, int nivel, int salud, int ataque, int defensa){
        super(nombre, nivel, salud, ataque, defensa);
    }
    void cargarAtaque(){
        System.out.println("Aumenta el daño del siguiente ataque");
    }

    void defender(){
        System.out.println("Reduce el daño del siguiente ataque en un %");
    }
}