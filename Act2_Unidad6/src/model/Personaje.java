package model;

abstract public class Personaje {
    private Nombre nombre;
    private int nivel;
    private int salud;
    private int ataque;
    private int defensa;

    public enum Nombre{
        GUERRERO,
        MAGO,
        HECHICERO,
        ARQUERO,
        ASESINO
    }
    public Personaje(Nombre nombre, int nivel, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }
  
    abstract void atacar();

    @Override
    public String toString() {
        return "Clase del personaje: " + nombre + ", nivel: " + nivel + ", puntos de salud: " + salud + 
        ", valor de ataque: " + ataque + ", valor de defensa: " + defensa;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    public Nombre getNombre() {
        return this.nombre;
    }

}
