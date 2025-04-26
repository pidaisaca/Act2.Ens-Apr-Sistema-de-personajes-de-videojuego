package model;

abstract class Personaje {
    private String nombre;
    private int nivel;
    private int salud;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, int nivel, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    abstract void atacar();

    @Override
    public String toString() {
        return "Nombre del personaje: " + nombre + ", nivel: " + nivel + ", puntos de salud: " + salud + 
        " valor de ataque" + ataque + ", valor de defensa: " + defensa;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    //toString(), equals(), hashCode()

}
