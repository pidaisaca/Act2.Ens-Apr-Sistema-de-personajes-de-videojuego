package model;

class Hechicero extends Magico{
    int mana;
    int concentracion; //atributo aun por definir
    public Hechicero(String nombre, int nivel, int salud, int ataque, int defensa){
        super(nombre, nivel, salud, ataque, defensa);
    }
    void invocarEntidad(){
        System.out.println("invoca una entidad que daña al principio de cada turno");
    }
    void defender(){
        System.out.println("Reduce el daño del siguiente ataque en un %");
    }
}