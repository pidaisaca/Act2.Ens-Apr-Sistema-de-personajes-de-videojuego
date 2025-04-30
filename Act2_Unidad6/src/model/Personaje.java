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


    public Personaje() {}
  
    public abstract void atacar(Personaje personaje, Personaje personaje2);

    public abstract void menuPersonaje(Personaje personaje, Personaje personaje2);


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


    public Personaje getPersonaje() {
        return this;
    }
=======

    
    public Nombre getNombre() {
        return this.nombre;
    }


    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }



}
