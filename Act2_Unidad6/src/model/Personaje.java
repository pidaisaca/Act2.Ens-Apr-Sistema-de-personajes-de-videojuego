package model;
import model.Guerrero;
import java.util.Random;

abstract public class Personaje {
    protected Nombre nombre;
    protected int nivel;
    protected int salud;
    protected int saludMax;
    protected int ataque;
    protected int defensa;
    protected int fuerza;
    protected boolean volando;
    protected boolean defendiendo;

    protected Random random = new Random();

    public enum Nombre {
        GUERRERO,
        MAGO,
        HECHICERO,
        ARQUERO,
        ASESINO
    }

    public Personaje(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.saludMax = saludMax;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public void atacar(Personaje enemigo) {
        if (enemigo.isVolando() && random.nextInt(2) == 0) {

            System.out.println("El ataque ha fallado");
            return;
        }
        enemigo.recibirDano(this);
    }

    public abstract void atacarTipo();

    public abstract void menuPersonaje(Personaje enemigo);

    @Override
    public String toString() {
        return "Clase del personaje: " + nombre + ", nivel: " + nivel + ", puntos de salud: " + salud +
                ", valor de ataque: " + ataque + ", valor de defensa: " + defensa;
    }

    public Personaje getPersonaje() {
        return this;
    }

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

    public boolean isVolando() {
        return volando;
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

    public void recibirDano(Personaje atacante) {
        if(defendiendo == true){
            this.salud -= atacante.getAtaque()/2;
            defendiendo = false;
            return;
        }
        this.salud -= atacante.getAtaque()-this.defensa;
        System.out.println(this.getNombre() + " ha perdido " + (atacante.getAtaque()-this.defensa) + " puntos de salud.");

    }

}
